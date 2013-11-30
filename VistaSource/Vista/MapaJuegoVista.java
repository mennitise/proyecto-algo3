package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Controladores.ControladorDeFlechas;
import Controladores.ControladorDeMovimientos;
import GestorDeMovimientos.GestorDeMovimientos;
import Juego.Juego;
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
	private VehiculoVista vehiculoVista;
	private SorpresaVista sorpresaVista;
	private ObstaculoVista obstaculoVista;
    
	//Otros
    private GestorDeMovimientos unGestor;
   // private JPanel panelDeBotones;    


    private Juego juego;
	private Object controlador;
	
	public MapaJuegoVista(){
    	
	}
	
	public void inicializarCon(ControladorDeMovimientos controlador, Juego unJuego) throws InterruptedException {
		this.juego = unJuego;
		this.unGestor = unJuego.getPartida().getGestorDeMovimientos();
		this.unGestor.addObserver(this); //Las acciones que realice el gestor se veran reflejadas en esta Vista     
	    this.esquinasHorizontales = unJuego.getPartida().getTablero().getColumnas();
    	this.esquinasVerticales = unJuego.getPartida().getTablero().getFilas();
    	this.tamanioManzanaHorizontal = this.calcularTamanioManzanaHorizontal(this.tamanioPanel);
    	this.tamanioManzanaVertical = this.calcularTamanioManzanaVertical(this.tamanioPanel);
    	
    	
    	// this.panelDeBotones = new PanelDeControlMovimientos(controlador);
    	this.setBackground(Color.black);
    	this.calcularRadio();	        
    	this.setBorder(BorderFactory.createLineBorder(Color.gray));

//        this.crearYAbrirFrame();

        this.setBounds(0, 0,600, 600);

        this.setVisible(true);

        this.calcularCentroImagenDelVehiculo();
        this.calcularEsquinaSuperiorDelCirculo();
        this.calcularEsquinaSuperiorImagenDelVehiculo();

    	this.vehiculoVista = new VehiculoVista(this.unGestor.getVehiculoEnPosicionActual(),this.tamanioManzanaHorizontal,this.anchoCalle);
    	this.sorpresaVista = new SorpresaVista(this.tamanioManzanaHorizontal,this.anchoCalle,this.juego.getPartida().getTablero());
    	this.obstaculoVista = new ObstaculoVista(this.tamanioManzanaHorizontal,this.anchoCalle,this.juego.getPartida().getTablero());
    	
    //	ControladorDeFlechas unListener = new ControladorDeFlechas(this.unGestor, this);
//    	this.addKeyListener(unListener);
//    	this.setFocusable(true);
//    	this.addKeyListener(unListener);
//    	
//    	this.frame.setFocusable(true);
//    	
    	 
    	
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
			
		this.ponerPosicionDeLlegada(g);
		
		g.setColor(Color.black);
		
		this.dibujarManzanas(g);
		
		this.vehiculoVista.actualizarImagenDelVehiculo(this.unGestor.getVehiculoEnPosicionActual(), g, this);
		
		Posicion unaCopiaPosicion = this.unGestor.getPosicionActual().getCopiaDePosicion();
		unaCopiaPosicion.moverAlNorte();
		unaCopiaPosicion.moverAlOeste();
		Posicion posicionIteracion;
		for(int i=0; i<3 ; i++){
			posicionIteracion = unaCopiaPosicion.getCopiaDePosicion();
			for(int j=0; j<3 ; j++){
				if(this.juego.getPartida().getTablero().posicionValida(posicionIteracion)){
					this.sorpresaVista.actualizarSorpresas(g, posicionIteracion, this);
					this.obstaculoVista.actualizarObstaculos(g, posicionIteracion, this);
				}
				posicionIteracion.moverAlEste();
			}
			unaCopiaPosicion.moverAlSur();
		}	
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int fila = this.unGestor.getVehiculoEnPosicionActual().getPosicion().getFila();
		int columna = this.unGestor.getVehiculoEnPosicionActual().getPosicion().getColumna();
		moveSquare(fila,columna);
		if(this.juego.getPartida().perdioLaPartida()){
			this.juego.asignarPuntaje();
			this.juego.getPartida().getPosicionDeLlegada();
			this.juego.guardarListaDeJugadoresExistentes();
			JOptionPane.showMessageDialog(null,"Ouch! Perdiste!!" ,"Game Over",JOptionPane.WARNING_MESSAGE);
		} else if (this.juego.getPartida().ganoLaPartida()){
			this.juego.asignarPuntaje();
			this.juego.guardarListaDeJugadoresExistentes();
			int puntaje = this.juego.obtenerPuntaje();
			JOptionPane.showMessageDialog(null,"Ganaste la partida con " + puntaje + " puntos","Felicitaciones",JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
	public void setControlador(ControladorDeMovimientos unControlador){
		this.controlador = unControlador;
	}
	
	public void setJuegoActual(Juego juegoActual){
		this.juego = juegoActual;
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
	
//	private void crearYAbrirFrame(){
//		this.frame = new JFrame();
//        this.frame.setLayout(null);
//        this.frame.add(this);
//        Juego unJuego = null;
//       // this.frame.add(new MenuPrincipalVista(new ControladorMenuPrincipal(unJuego)));
//     //   this.frame.add(panelDeBotones);
//        this.frame.setSize(800,600);
//        this.frame.setVisible(true);
//      //  this.panelDeBotones.setBounds(600,0,180,200);
//        JPanel panelDeInformacionJugador = new PanelDeInformacionVista(this.juego);
//        panelDeInformacionJugador.setBounds(600,0,200,500);
//        this.frame.add(panelDeInformacionJugador);
//        
//       
//	}
		
	private int calcularTamanioManzanaHorizontal(int cantidadHorizontal){
		return (cantidadHorizontal - this.anchoCalle*this.esquinasHorizontales)/(this.esquinasHorizontales+1);		
	}
	
	private int calcularTamanioManzanaVertical(int cantidadVertical){;
		return (cantidadVertical - this.anchoCalle*this.esquinasVerticales)/(this.esquinasVerticales+1);			
	}
	
	private void ponerPosicionDeLlegada(Graphics g){
		
		int filaPixelPosicionLlegada =  (-1)*this.radio/4 + (this.juego.getPartida().getPosicionDeLlegada().getFila()+1)*tamanioManzanaHorizontal
				+ this.juego.getPartida().getPosicionDeLlegada().getFila()*this.anchoCalle+this.anchoCalle/2 ;
		int columnaPixelPosicionLlegada =  (-1)*this.radio/4 + (this.juego.getPartida().getPosicionDeLlegada().getColumna()+1)*tamanioManzanaVertical 
				+ this.juego.getPartida().getPosicionDeLlegada().getColumna()*this.anchoCalle+this.anchoCalle/2;

		g.fillOval(columnaPixelPosicionLlegada, filaPixelPosicionLlegada , this.radio/2, this.radio/2);
	
		
		//Para la bandera adquieren nuevos valores porque es una imagen cuadrada, no circular como arriba
		filaPixelPosicionLlegada = (this.juego.getPartida().getPosicionDeLlegada().getFila()+1)*tamanioManzanaHorizontal
				+ this.juego.getPartida().getPosicionDeLlegada().getFila()*this.anchoCalle;
		columnaPixelPosicionLlegada = (this.juego.getPartida().getPosicionDeLlegada().getColumna()+1)*tamanioManzanaVertical 
				+ this.juego.getPartida().getPosicionDeLlegada().getColumna()*this.anchoCalle;
		
		Image img1 = Toolkit.getDefaultToolkit().getImage("src/imagenes/bandera.png");
		g.drawImage(img1,columnaPixelPosicionLlegada, filaPixelPosicionLlegada,this);
	}
	
	private void calcularRadio(){
		this.radio = (int)(2*this.tamanioManzanaHorizontal + 2*this.anchoCalle);
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

