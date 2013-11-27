package Vista;
import java.awt.Color;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import Controladores.ControladorDeMovimientos;
import GestorDeMovimientos.GestorDeMovimientos;

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
		this.pixelesVerticales = 620;
		this.puntoInicialMapa = new Point(200 , 0);
		this.control = control;
		this.crearYPosicionarBotones();		
		setLayout(null); 
		this.setBounds(0,0,this.pixelesHorizontales,this.pixelesVerticales);	
		this.getContentPane().setBackground(Color.black);
				
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
	
	private void crearYPosicionarBotones(){
		this.botonSubir = new JButton("S");
		this.botonBajar = new JButton("B");
		this.botonDerecha = new JButton("D");
		this.botonIzquierda = new JButton ("I");
		this.botonSubir.setBounds(665,0,50,50);
		this.botonBajar.setBounds(665,55,50,50);
		this.botonIzquierda.setBounds(610,55,50,50);
		this.botonDerecha.setBounds(720,55,50,50);
	}
		
	@Override
	public void update(Observable arg0, Object arg1) {
					
		}
}


