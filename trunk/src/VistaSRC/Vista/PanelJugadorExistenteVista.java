package Vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.ControladorMenuPrincipal;
import Juego.Juego;

public class PanelJugadorExistenteVista extends JPanel{
	private JButton botonJuegoNuevo;
	private JButton botonCargarPartida;
	private JButton botonVerPuntajes;
	private JButton botonVolverMenuPrincipal;
	private Juego juego;
	private JLabel etiquetaNombre;
	private ControladorMenuPrincipal controladorMenuPrincipal;
	private String nombreDelJugador;
	
	PanelJugadorExistenteVista(){
		
	}
	PanelJugadorExistenteVista(Juego unJuego, ControladorMenuPrincipal unControlador, String nombreDelJugador){
		this.juego = unJuego;
		this.nombreDelJugador = nombreDelJugador;
		this.controladorMenuPrincipal = unControlador;
		this.setLayout(null);
		this.configurarYAgregarBotones();
		
	}

	private void configurarYAgregarBotones(){
		this.setLayout(new GridLayout(4,1));
		this.botonCargarPartida = new JButton("Cargar Partida");
		this.botonCargarPartida.addActionListener(this.controladorMenuPrincipal.getListenerBotonCargarPartida(this.nombreDelJugador));
		this.botonJuegoNuevo = new JButton("Juego Nuevo");
		this.botonJuegoNuevo.addActionListener(this.controladorMenuPrincipal.getListenerBotonNuevoJuego(this.nombreDelJugador));
		this.botonVerPuntajes = new JButton("Ver Puntajes");
		this.botonVerPuntajes.addActionListener(this.controladorMenuPrincipal.getListenerBotonVerPuntajes());
		this.etiquetaNombre = new JLabel("Bienvenido " + this.nombreDelJugador);
		this.etiquetaNombre.setBackground(Color.blue);
		this.add(this.etiquetaNombre);
		this.add(this.botonJuegoNuevo);
		this.add(this.botonCargarPartida);
		this.add(this.botonVerPuntajes);
		this.setSize(300,400);
	}

	public static void main (String[] args){
		JFrame unFrame = new JFrame();
		unFrame.setLayout(null);
	}
}


