package Vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controladores.ControladorDeMovimientos;

public class PanelDeControlMovimientos extends JPanel {
	JButton botonArriba;
	JButton botonAbajo;
	JButton botonDerecha;
	JButton botonIzquierda;
	

	public PanelDeControlMovimientos(ControladorDeMovimientos control){
		this.botonArriba = new JButton("S");
		this.botonArriba.addActionListener(control.getListenerBotonSubir());
        this.botonArriba.setBounds(110,200,80,40);
        this.botonAbajo = new JButton("B");
        this.botonAbajo.addActionListener(control.getListenerBotonBajar());
        this.botonAbajo.setBounds(110,50,80,40);
        this.botonDerecha = new JButton("D");
        this.botonDerecha.addActionListener(control.getListenerBotonDerecha());
        this.botonDerecha.setBounds(20, 50, 80, 40);
        this.botonIzquierda = new JButton("I");
        this.botonIzquierda.addActionListener(control.getListenerBotonIzquierda());
        this.botonIzquierda.setBounds(120, 50, 80, 40);
        this.botonArriba.setBounds(0,0,50,50);
		this.botonAbajo.setBounds(11,55,50,50);
		this.botonIzquierda.setBounds(0,55,50,50);
		this.botonDerecha.setBounds(0,55,50,50);
		
		
		this.setSize(300, 200);
	    this.add(this.botonArriba);//boton al panel norte
	    this.add(this.botonIzquierda); //boton a la region oeste
	    this.add(this.botonDerecha); //boton a la region centro    
	    this.add(this.botonAbajo); //boton a la region centro    
	    this.setVisible(true);
	   
	}

	

}