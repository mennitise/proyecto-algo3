package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Controladores.ControladorDeMovimientos;
import Excepciones.StringVacioException;
import GestorDeMovimientos.GestorDeMovimientos;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Auto;
import Vehiculos.Vehiculo;

public class MapaJuegoVista extends JPanel implements Observer  {
	
	private int squareX;
    private int squareY;
    private int squareW = 230;
    private int squareH = 230;
    private int radio;
    private GestorDeMovimientos unGestor;
    private JPanel panelDeBotones;    
    private JFrame frame;
    private JLabel coche;

	public MapaJuegoVista(ControladorDeMovimientos controlador, GestorDeMovimientos unGestor) {
		this.unGestor = unGestor;
    	this.unGestor.addObserver(this); //Las acciones que realice el gestor se veran reflejadas en esta Vista     

        this.panelDeBotones = new PanelDeControlMovimientos(controlador);
    	this.setBackground(Color.black);
    	this.radio = -115;	        
    	this.setBorder(BorderFactory.createLineBorder(Color.gray));
        this.squareX = -115 + (this.unGestor.getVehiculoEnPosicionActual().getPosicion().getColumna()+1)*50 + this.unGestor.getVehiculoEnPosicionActual().getPosicion().getColumna()*10+5 ;
        this.squareY = -115 +(this.unGestor.getVehiculoEnPosicionActual().getPosicion().getFila()+1)*50 + this.unGestor.getVehiculoEnPosicionActual().getPosicion().getFila()*10+5 ;
        
        this.crearYAbrirFrame();

        this.setBounds(0, 0,500, 500);

        this.setVisible(true);

        
    	coche = new JLabel(new ImageIcon("src/imagenes/Auto.png")); //Pruebo con la imagen de un auto
	SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        
        }
        
    });
	
	}
	
    private void moveSquare(int x, int y) { //Se encarga de mover el circulo de vision
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
            squareX= this.radio + (y+1)*50 + y*10+5 ;
            squareY=this.radio + (x+1)*50 + x*10+5;
            
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
        } 
    }
    
	public Dimension getPreferredSize() {
		return new Dimension(400,400);
	}

	protected void paintComponent(Graphics g) {
		
		
		super.paintComponent(g);

		g.setColor(Color.WHITE);
 
		g.fillOval(squareX, squareY ,squareW,squareH);

		g.setColor(Color.black);
		
		coche.setBounds(squareX + 90, squareY+90, 50,50);
		this.add(coche);
		
		this.dibujarManzanas(g);
        
        g.setColor(Color.black);
        g.drawString("CP",30,30);
        
       	}

	private void dibujarManzanas(Graphics g) {
		for (int i=0; i<=5;i++){
			for (int j=0; j<=5;j++){
				int fila = j * 60;
		        int columna = i * 60;
		        g.drawRect(fila,columna,50,50);
		        }
		}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int fila = this.unGestor.getVehiculoEnPosicionActual().getPosicion().getFila();
		int columna = this.unGestor.getVehiculoEnPosicionActual().getPosicion().getColumna();
		moveSquare(fila,columna);
		
	}  
			
	private void crearYAbrirFrame(){
		this.frame = new JFrame();
        this.frame.setLayout(null);
        this.frame.add(this);
        this.frame.add(panelDeBotones);
        this.frame.setSize(800,600);
        this.frame.setVisible(true);
        this.panelDeBotones.setBounds(500,0,300,200);
        JPanel panelDeInformacionJugador = (new PanelDeInformacionVista(this.unGestor)).getPanel();
        panelDeInformacionJugador.setBounds(600,50,100,400);
        this.frame.add(panelDeInformacionJugador);
	}
	
}

