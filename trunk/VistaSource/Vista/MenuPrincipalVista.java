package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controladores.ControladorDeMovimientos;
import Controladores.ControladorMenuPrincipal;
import GestorDeMovimientos.GestorDeMovimientos;

public class MenuPrincipalVista extends JFrame    {
	private JPanel panelInicial;
	private JButton botonJugadorNuevo;
	private JButton botonVerPuntajes;
	private JButton botonJugadorExistente;
	private GestorDeMovimientos gestor;
	
	
	MenuPrincipalVista(ControladorMenuPrincipal control){
		this.setLayout(null);
		this.setBounds(100, 100, 200, 300);
		this.crearPanelInicial();
		
		//le agrego el control al boton
		this.botonJugadorNuevo.addActionListener(control.getListenerBotonJugadorNuevo());
		this.botonVerPuntajes.addActionListener(control.getListenerBotonVerPuntajes());
		this.botonJugadorExistente.addActionListener(control.getListenerBotonJugadorExistente());
		this.add(panelInicial);
		this.setVisible(true);	
	}
	
	private void crearPanelInicial(){
		this.botonJugadorNuevo = new JButton ("Jugador Nuevo");
		this.botonVerPuntajes = new JButton("Ver Puntajes");
		this.botonJugadorExistente = new JButton ("JugadorExistente");
		this.panelInicial = new JPanel();
		this.panelInicial.setSize(200,300);		
		this.panelInicial.add(this.botonJugadorNuevo);
		this.panelInicial.add(this.botonVerPuntajes);
		this.panelInicial.add(this.botonJugadorExistente);
		this.panelInicial.setVisible(true);
		
	}
	
	public static void main(String[] ar){
//		ControladorMenuPrincipal control = new ControladorMenuPrincipal();
//		MenuPrincipalVista menu = new MenuPrincipalVista(control);
		

	}

	
}

