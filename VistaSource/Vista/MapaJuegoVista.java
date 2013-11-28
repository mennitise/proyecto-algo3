package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Controladores.ControladorDeMovimientos;
import GestorDeMovimientos.GestorDeMovimientos;
import Juego.Juego;
import Obstaculos.ControlPolicial;
import Obstaculos.Obstaculo;
import Obstaculos.Piquete;
import Obstaculos.Pozo;
import Sorpresas.Sorpresa;
import Sorpresas.SorpresaCambioDeVehiculo;
import Sorpresas.SorpresaDesfavorable;
import Sorpresas.SorpresaFavorable;
import Tablero.Calle;
import Tablero.Esquina;
import Tablero.Posicion;

public class MapaJuegoVista extends JPanel implements Observer  {
    
	//Manejo de medidas
	private int radio;
    private int filaPixel; 
    private int columnaPixel;
    private int filaPixelVehiculo;
    private int columnaPixelVehiculo;
    private int filaPixelCirculo;
    private int columnaPixelCirculo;
    private int tamanioManzanaHorizontal;
    private int tamanioManzanaVertical;
	private int esquinasVerticales;
	private int esquinasHorizontales;
	private int anchoCalle = 20;
	private int tamanioPanel = 600;
    
	//Otros
    private GestorDeMovimientos unGestor;
    private JPanel panelDeBotones;    
    private JFrame frame;
    private JLabel coche;
    private Juego juego;

	
	public MapaJuegoVista(ControladorDeMovimientos controlador, Juego unJuego) {
		this.juego = unJuego;
		this.unGestor = unJuego.getPartida().getGestorDeMovimientos();
		this.unGestor.addObserver(this); //Las acciones que realice el gestor se veran reflejadas en esta Vista     
	    this.esquinasHorizontales = unJuego.getPartida().getTablero().getColumnas();
    	this.esquinasVerticales = unJuego.getPartida().getTablero().getFilas();
    	this.tamanioManzanaHorizontal = this.calcularTamanioManzanaHorizontal(this.tamanioPanel);
    	this.tamanioManzanaVertical = this.calcularTamanioManzanaVertical(this.tamanioPanel);
    	
    	
        this.panelDeBotones = new PanelDeControlMovimientos(controlador);
    	this.setBackground(Color.black);
    	this.calcularRadio();	        
    	this.setBorder(BorderFactory.createLineBorder(Color.gray));

        this.crearYAbrirFrame();

        this.setBounds(0, 0,600, 600);

        this.setVisible(true);

        this.calcularCentroImagenDelVehiculo();
        this.calcularEsquinaSuperiorDelCirculo();
        this.calcularEsquinaSuperiorImagenDelVehiculo();
    	coche = new JLabel(); 
    	this.add(coche);

	SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        
        }
        
    });
	
	}
	    
	public Dimension getPreferredSize() {
		return new Dimension(this.tamanioPanel,this.tamanioPanel);
	}

	protected void paintComponent(Graphics g) {
				
		super.paintComponent(g);

		g.setColor(Color.WHITE);
 
		g.fillOval(this.columnaPixelCirculo, this.filaPixelCirculo ,2*this.radio,2*this.radio);

		
		int filaPixelPosicionLlegada =  (-1)*this.radio/2 + (this.juego.getPartida().getPosicionDeLlegada().getFila()+1)*tamanioManzanaHorizontal
									+ this.juego.getPartida().getPosicionDeLlegada().getFila()*this.anchoCalle+this.anchoCalle/2 ;
		int columnaPixelPosicionLlegada =  (-1)*this.radio/2 + (this.juego.getPartida().getPosicionDeLlegada().getColumna()+1)*tamanioManzanaVertical 
									+ this.juego.getPartida().getPosicionDeLlegada().getColumna()*this.anchoCalle+this.anchoCalle/2;
		
		g.fillOval(columnaPixelPosicionLlegada, filaPixelPosicionLlegada , this.radio, this.radio);
		
		g.setColor(Color.black);
		

        VehiculoVista unaVista = new VehiculoVista(this.unGestor.getVehiculoEnPosicionActual(),this.coche);
		
        coche.setBounds(this.columnaPixelVehiculo, this.filaPixelVehiculo, 2*this.anchoCalle, 2*this.anchoCalle);
		
		this.add(coche);
		
		this.dibujarManzanas(g);
		
		this.ponerSorpresasYObstaculosHorizontales(g);
		
		this.ponerSorpresasYObstaculosVerticales(g);
	
		
}

	@Override
	public void update(Observable arg0, Object arg1) {
		int fila = this.unGestor.getVehiculoEnPosicionActual().getPosicion().getFila();
		int columna = this.unGestor.getVehiculoEnPosicionActual().getPosicion().getColumna();
		moveSquare(fila,columna);
		
		if (this.juego.getPartida().ganoLaPartida()){
			this.juego.asignarPuntaje();
			this.juego.guardarListaDeJugadoresExistentes();
			int puntaje = this.juego.obtenerPuntaje();
			JOptionPane.showMessageDialog(null,"Ganaste la partida con " + puntaje + " puntos","Aviso",JOptionPane.WARNING_MESSAGE);
			this.frame.dispose();
		} else if(this.juego.getPartida().perdioLaPartida()){
			this.juego.asignarPuntaje();
			this.juego.getPartida().getPosicionDeLlegada();
			this.juego.guardarListaDeJugadoresExistentes();
			JOptionPane.showMessageDialog(null,"Ouch! Perdiste!!" ,"Aviso",JOptionPane.WARNING_MESSAGE);
			this.frame.dispose();
		}
		
	}  
	
	private void moveSquare(int x, int y) { //Se encarga de mover el circulo de vision
	        int OFFSET = 1;
	        if ((this.columnaPixelCirculo!=x) || (this.filaPixelCirculo!=y)) {
	            repaint(this.columnaPixelCirculo,this.filaPixelCirculo,2*this.radio+OFFSET,2*this.radio+OFFSET);
	            this.columnaPixelCirculo= (-1)*this.radio + (y+1)*tamanioManzanaHorizontal + y*this.anchoCalle+this.anchoCalle/2 ;
	            this.filaPixelCirculo=(-1)*this.radio + (x+1)*tamanioManzanaVertical + x*this.anchoCalle+this.anchoCalle/2;
	            this.calcularCentroImagenDelVehiculo();
	            this.calcularEsquinaSuperiorImagenDelVehiculo();
	            repaint(this.columnaPixelCirculo,this.filaPixelCirculo,2*this.radio+OFFSET,2*this.radio+OFFSET);
	        } 
	    }

	private void dibujarManzanas(Graphics g) {
		for (int i=0; i<=this.esquinasVerticales;i++){
			for (int j=0; j<=this.esquinasHorizontales;j++){
				int fila = j * (tamanioManzanaHorizontal + this.anchoCalle);
		        int columna = i * (tamanioManzanaVertical + this.anchoCalle);
		        g.drawRect(fila,columna,tamanioManzanaVertical, tamanioManzanaVertical);
		        }
		}
		
	}
	
	private void crearYAbrirFrame(){
		this.frame = new JFrame();
        this.frame.setLayout(null);
        this.frame.add(this);
        this.frame.add(panelDeBotones);
        this.frame.setSize(800,600);
        this.frame.setVisible(true);
        this.panelDeBotones.setBounds(600,0,180,200);
        JPanel panelDeInformacionJugador = (new PanelDeInformacionVista(this.unGestor)).getPanel();
        panelDeInformacionJugador.setBounds(600,200,200,300);
        this.frame.add(panelDeInformacionJugador);
	}
		
	private int calcularTamanioManzanaHorizontal(int cantidadHorizontal){
		return (cantidadHorizontal - this.anchoCalle*this.esquinasHorizontales)/(this.esquinasHorizontales+1);		
	}
	
	private int calcularTamanioManzanaVertical(int cantidadVertical){;
		return (cantidadVertical - this.anchoCalle*this.esquinasVerticales)/(this.esquinasVerticales+1);			
	}
	
	private void calcularRadio(){
		this.radio = 2*this.tamanioManzanaHorizontal+ 2*this.anchoCalle;
	}

	private void ponerSorpresasYObstaculosHorizontales(Graphics g){
		for (int i=0; i<=this.esquinasVerticales-1;i++){
			for (int j=0; j<=this.esquinasHorizontales-1;j++){
				Posicion unaPosicion = new Posicion(i,j);
				Esquina unaEsquina = this.juego.getPartida().getTablero().getEsquinaEn(unaPosicion);
				int pixelHorizontal = (j+1)*this.tamanioManzanaHorizontal+ this.anchoCalle*j+this.anchoCalle+this.tamanioManzanaHorizontal/2 ;
				int pixelVertical = (i+1)*this.tamanioManzanaVertical + this.anchoCalle*i+10;
				if (unaEsquina.tieneCalleAlEste()){
					Calle unaCalle = unaEsquina.getCalleEste();
					if ((unaCalle.getSorpresas()!=null)&&(unaCalle.getSorpresas().size()!=0)){
						Sorpresa primerSorpresa = unaEsquina.getCalleEste().getSorpresas().get(0);						
						this.dibujarSorpresaEn(primerSorpresa, pixelHorizontal, pixelVertical, g);
					
					}
					
					if((unaCalle.getObstaculos()!=null)&&(unaCalle.getObstaculos().size()!=0)){
						Obstaculo unObstaculo  = unaEsquina.getCalleEste().getObstaculos().get(0);
						pixelVertical += this.anchoCalle/2;
						this.dibujarObstaculosEn(unObstaculo, pixelHorizontal, pixelVertical,g);
					
					}
				
					
				}	
				
			}
		}
	}
	
	private void ponerSorpresasYObstaculosVerticales(Graphics g){
		for (int i=0; i<=this.esquinasVerticales-1;i++){
			for (int j=0; j<=this.esquinasHorizontales-1;j++){
				Posicion unaPosicion = new Posicion(i,j);
				Esquina unaEsquina = this.juego.getPartida().getTablero().getEsquinaEn(unaPosicion);
				int pixelHorizontal = (j+1)*this.tamanioManzanaVertical+ this.anchoCalle*j;
				int pixelVertical = (i+1)*this.tamanioManzanaHorizontal + this.anchoCalle*i +this.anchoCalle+this.tamanioManzanaHorizontal/2;
				
				if (unaEsquina.tieneCalleAlSur()){
					Calle unaCalle = unaEsquina.getCalleSur();
					if ((unaCalle.getSorpresas()!=null)&&(unaCalle.getSorpresas().size()!=0)){
						Sorpresa primerSorpresa = unaEsquina.getCalleSur().getSorpresas().get(0);
						this.dibujarSorpresaEn(primerSorpresa, pixelHorizontal, pixelVertical,g);
					
					}
					
					if((unaCalle.getObstaculos()!=null)&&(unaCalle.getObstaculos().size()!=0)){
						Obstaculo unObstaculo  = unaEsquina.getCalleSur().getObstaculos().get(0);
						pixelHorizontal += this.anchoCalle/2;
						this.dibujarObstaculosEn(unObstaculo, pixelHorizontal, pixelVertical,g);
					
					}
						
				}
			}
		}
		
	}
	
	private void dibujarSorpresaEn(Sorpresa unaSorpresa, int fila, int columna, Graphics g){
	
        if (unaSorpresa.getClass() == SorpresaFavorable.class ) {
        	g.drawString("SF",fila,columna);
        }
        if (unaSorpresa.getClass() == SorpresaDesfavorable.class ) {
        	g.drawString("SD",fila,columna);
        }
        if (unaSorpresa.getClass() == SorpresaCambioDeVehiculo.class ) {
        	g.drawString("SV",fila,columna);
        }
     

	}
	
	private void dibujarObstaculosEn(Obstaculo unObstaculo, int fila, int columna, Graphics g){
		

		if (unObstaculo.getClass() == Piquete.class ) {
			g.drawString("Pi", fila, columna);
			
		}
		if (unObstaculo.getClass() == ControlPolicial.class ) {
			g.drawString("C",fila,columna);
		}
		if (unObstaculo.getClass() == Pozo.class ) {
			g.drawString("Po",fila,columna);
		}
			
	}

	private void calcularCentroImagenDelVehiculo(){
		//(filaPixel,columnaPixel) determina la posicion del centro del circulo y de la imagen del auto;
		
		int filaActual = this.unGestor.getPosicionActual().getFila();
		int columnaActual = this.unGestor.getPosicionActual().getColumna();
		this.filaPixel = (filaActual + 1) * this.tamanioManzanaVertical + filaActual*this.anchoCalle + this.anchoCalle/2;
		this.columnaPixel  = (columnaActual + 1) * this.tamanioManzanaHorizontal + columnaActual*this.anchoCalle +this.anchoCalle/2;
	}
	
	private void calcularEsquinaSuperiorImagenDelVehiculo(){
		//(filaPixelVehiculo, columnaPixelVehiculo) determina la posicion de la esquina superior de la imagen del auto
		this.filaPixelVehiculo = this.filaPixel - this.anchoCalle;
		this.columnaPixelVehiculo = this.columnaPixel - this.anchoCalle;
	}
	
	private void calcularEsquinaSuperiorDelCirculo(){
		this.filaPixelCirculo = this.filaPixel - this.radio;
		this.columnaPixelCirculo = this.columnaPixel - this.radio;
		}
}

