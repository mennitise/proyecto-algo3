package Vista;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import Controladores.ControladorMenuPrincipal;

public class PanelInicial extends JPanel implements Observer {
	private JButton botonJugadorNuevo;
	private JButton botonJugadorExistente;


	public PanelInicial(ControladorMenuPrincipal control){
		
		this.botonJugadorNuevo = new JButton ("Jugador Nuevo");			
		this.botonJugadorExistente = new JButton ("Jugador Existente");
		this.botonJugadorNuevo.addActionListener(control.getListenerBotonJugadorNuevo());
		this.botonJugadorExistente.addActionListener(control.getListenerBotonJugadorExistente());
		this.botonJugadorExistente.setVisible(true);
		this.botonJugadorNuevo.setVisible(true);
		this.setLayout(new GridLayout(2,1));
		this.setSize(250,250);		
		this.add(this.botonJugadorNuevo);
		this.add(this.botonJugadorExistente);
		this.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (this.isVisible()){
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}
	}
	
}