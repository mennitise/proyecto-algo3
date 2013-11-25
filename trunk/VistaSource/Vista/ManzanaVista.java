package Vista;
import java.awt.Color;

import javax.swing.JButton;

public class ManzanaVista {
	private int tamanioManzanaHorizontal;
	private int tamanioManzanaVertical;
	
	public ManzanaVista(int tamanioManzanaHorizontal, int tamanioManzanaVertical) {
		
		this.tamanioManzanaVertical = tamanioManzanaVertical;
		this.tamanioManzanaHorizontal = tamanioManzanaHorizontal;
	}

	public void ponerManzana(VentanaVista ventanaDestino, int fila, int columna) {
		JButton boton=new JButton("");
        boton.setBounds(fila,columna,this.tamanioManzanaHorizontal,this.tamanioManzanaVertical);
        boton.setBackground(Color.black);
        ventanaDestino.add(boton);
	
	}
	
	
}
