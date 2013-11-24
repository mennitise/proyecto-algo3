package Vista;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Controladores.ControladorDeMovimientos;
import Excepciones.StringVacioException;
import GestorDeMovimientos.GestorDeMovimientos;
import Juego.Juego;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Auto;
import Vehiculos.Vehiculo;

public class VentanaVista extends JFrame{
	private int pixelesHorizontales;
	private int pixelesVerticales;
	private Point puntoInicialMapa;
	private JButton botonSubir;
	private JButton botonBajar;
	private ControladorDeMovimientos control;
	private GestorDeMovimientos gestor;
	
	VentanaVista(GestorDeMovimientos gestor, ControladorDeMovimientos control){
		setLayout(null);
		this.pixelesHorizontales = 800;
		this.pixelesVerticales = 800;
		this.puntoInicialMapa = new Point(200 , 0);
		this.setBounds(0,0,this.pixelesHorizontales,this.pixelesVerticales);
		this.control = control;
		this.gestor = gestor;
		
		
		botonSubir = new JButton("Subir");
		botonSubir.setBounds(650,400,100,100);
		add(botonSubir);
		botonSubir.setVisible(true);
		
		botonBajar = new JButton("Bajar");
		botonBajar.setBounds(650,500,100,100);
		add(botonBajar);
		
		botonSubir.addActionListener(control.getListenerBotonSubir());
		botonBajar.addActionListener(control.getListenerBotonBajar());			

	}
	
	public int getPixelesHorizontales() {
		return this.pixelesHorizontales;
	}

	public int getPixelesVerticales() {
		return this.pixelesVerticales;
	}

	public Point getPuntoInicialMapa() {
		return this.puntoInicialMapa;
	}
	

	public static void main(String[] ar) throws StringVacioException{
		Vehiculo unVehiculo = new Auto(new Posicion(2,2));
		Jugador unJugador = new Jugador("Juan", unVehiculo);
		Tablero tablero = new Tablero(5,5);
		GestorDeMovimientos gestor = new GestorDeMovimientos(unVehiculo,tablero);
        ControladorDeMovimientos control = new ControladorDeMovimientos(gestor);
		
        VentanaVista ventanaVista = new VentanaVista(gestor, control);        
		MapaVista mapa = new MapaVista(ventanaVista, 5, 5,gestor);
		mapa.dibujarMapaConDeterminadaCantidadDePixeles(600, 600);
		VehiculoVista vehiculoVista = new VehiculoVista(unVehiculo,mapa,gestor);
        vehiculoVista.dibujarVehiculo();

        ventanaVista.setVisible(true);
    
      
	}


	
}
