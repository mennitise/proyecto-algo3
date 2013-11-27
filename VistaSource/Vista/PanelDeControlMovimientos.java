package Vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDeControlMovimientos extends JFrame {
	JButton botonArriba;
	JButton botonAbajo;
	JButton botonDerecha;
	JButton botonIzquierda;
	JPanel panel;

	PanelDeControlMovimientos(){
		this.botonArriba = new JButton();
		this.botonAbajo = new JButton();
		this.botonDerecha = new JButton();
		this.botonIzquierda = new JButton();
		
		this.panel = new JPanel(new BorderLayout(2, 3));//espacio entre las regiones, horizontal y vertical
		 
	        this.panel.add(this.botonArriba, BorderLayout.NORTH);//boton al panel norte
	        this.panel.add(this.botonIzquierda, BorderLayout.WEST); //boton a la region oeste
	        this.panel.add(this.botonDerecha, BorderLayout.EAST); //boton a la region centro    
	        //this.panel.add(this.botonAbajo, BorderLayout.CENTER); //boton a la region centro    
	        this.setBounds(620, 620, 100, 100);
	        this.panel.setVisible(true);
	
	}

	JPanel getPanel(){
		return this.panel;
	}
	

}