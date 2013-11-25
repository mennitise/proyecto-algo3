package Vista;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.ControladorDeMovimientos;
import Excepciones.StringVacioException;
import GestorDeMovimientos.GestorDeMovimientos;
import Juego.Juego;
import Jugador.Jugador;
import Obstaculos.ControlPolicial;
import Obstaculos.Piquete;
import Sorpresas.Sorpresa;
import Sorpresas.SorpresaCambioDeVehiculo;
import Sorpresas.SorpresaDesfavorable;
import Sorpresas.SorpresaFavorable;
import Tablero.Calle;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Auto;
import Vehiculos.Vehiculo;

public class VentanaVista extends JFrame implements Observer{
	private int pixelesHorizontales;
	private int pixelesVerticales;
	private Point puntoInicialMapa;
	private JButton botonSubir;
	private JButton botonBajar;
	private JButton botonIzquierda;
	private JButton botonDerecha;
	private ControladorDeMovimientos control;
	private GestorDeMovimientos gestor;

	
	public VentanaVista(GestorDeMovimientos gestor, ControladorDeMovimientos control){
		this.gestor = gestor;
		this.gestor.addObserver(this);
		this.pixelesHorizontales = 800;
		this.pixelesVerticales = 800;
		this.puntoInicialMapa = new Point(200 , 0);
		this.control = control;
		this.botonSubir = new JButton("S");
		this.botonBajar = new JButton("B");
		this.botonDerecha = new JButton("D");
		this.botonIzquierda = new JButton ("I");

		botonSubir.setBounds(665,0,50,50);
		botonBajar.setBounds(665,55,50,50);
		botonIzquierda.setBounds(610,55,50,50);
		botonDerecha.setBounds(720,55,50,50);

		
		setLayout(null); 
		this.setBounds(0,0,this.pixelesHorizontales,this.pixelesVerticales);	
		this.getContentPane().setBackground(Color.gray);
				
		 
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
	
	public static void main(String[] ar) throws StringVacioException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
      
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		 
		
	}


	
}
