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
import Sorpresas.SorpresaFavorable;
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
	private JButton botonIzquierda;
	private JButton botonDerecha;
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
		
		
		botonSubir = new JButton("S");
		botonBajar = new JButton("B");
		botonDerecha = new JButton("D");
		botonIzquierda = new JButton ("I");

		botonSubir.setBounds(665,0,50,50);
		botonBajar.setBounds(665,55,50,50);
		botonIzquierda.setBounds(610,55,50,50);
		botonDerecha.setBounds(720,55,50,50);
		
		add(botonSubir);
		add(botonBajar);		
		add(botonIzquierda);
		add(botonDerecha);
		
		botonSubir.addActionListener(control.getListenerBotonSubir());
		botonBajar.addActionListener(control.getListenerBotonBajar());			
		botonDerecha.addActionListener(control.getListenerBotonDerecha());	
		botonIzquierda.addActionListener(control.getListenerBotonIzquierda());
		
		
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
		Vehiculo unVehiculo = new Auto(new Posicion(0,0));
		Jugador unJugador = new Jugador("Juan", unVehiculo);
		Tablero tablero = new Tablero(3,3);
		GestorDeMovimientos gestor = new GestorDeMovimientos(unVehiculo,tablero);
        ControladorDeMovimientos control = new ControladorDeMovimientos(gestor);
		tablero.getEsquinaEn(new Posicion(0,0)).getCalleEste().agregarSorpresa(new SorpresaFavorable());
		tablero.getEsquinaEn(new Posicion(0,1)).getCalleEste().agregarSorpresa(new SorpresaFavorable());
        
		VentanaVista ventanaVista = new VentanaVista(gestor, control);        
        MapaVista mapa = new MapaVista(ventanaVista, tablero,gestor);
		mapa.dibujarMapaConDeterminadaCantidadDePixeles(600, 600);
		VehiculoVista vehiculoVista = new VehiculoVista(unVehiculo,mapa,gestor);
        vehiculoVista.dibujarVehiculo();

        ventanaVista.setVisible(true);
    
      
	}


	
}
