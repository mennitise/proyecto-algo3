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
	private JButton botonJugadorExistente;
	private JButton botonPuntajes;
	private GestorDeMovimientos gestor;
	
	
	
	MenuPrincipalVista(ControladorMenuPrincipal control){
		this.setLayout(null);
		this.setBounds(100, 100, 200, 120);
		this.crearPanelInicial();
		
		//le agrego el control al boton
		this.botonJugadorNuevo.addActionListener(control.getListenerBotonJugadorNuevo());
		this.botonJugadorExistente.addActionListener(control.getListenerBotonJugadorExistente());
		this.add(panelInicial);
		this.setVisible(true);	
	}
	
	private void crearPanelInicial(){
		this.botonJugadorExistente = new JButton ("Jugador Existente");
		this.botonJugadorNuevo = new JButton("Jugador Nuevo");
		this.panelInicial = new JPanel();
		this.panelInicial.setSize(200,200);		
		this.panelInicial.add(this.botonJugadorNuevo);
		this.panelInicial.add(this.botonJugadorExistente);
		this.panelInicial.setVisible(true);
		
	}
	
	public static void main(String[] ar){
		ControladorMenuPrincipal control = new ControladorMenuPrincipal();
		MenuPrincipalVista menu = new MenuPrincipalVista(control);
	}

	
}

