package Vista;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;

import Sorpresas.Sorpresa;
import Sorpresas.SorpresaCambioDeVehiculo;
import Sorpresas.SorpresaDesfavorable;
import Sorpresas.SorpresaFavorable;
import Tablero.Tablero;

public class SorpresaVista implements Observer {
	
	private VentanaVista ventanaDestino;

	private ArrayList<JLabel> etiquetasRepresentativas;
	
	SorpresaVista(VentanaVista unaVentana){
		this.etiquetasRepresentativas = new ArrayList<JLabel>();	
		this.ventanaDestino = unaVentana;
		
	}
	
	public void dibujarSorpresaEn(Sorpresa unaSorpresa, int fila, int columna){
		JLabel etiqueta=new JLabel();
		this.etiquetasRepresentativas.add(etiqueta);
        etiqueta.setBounds(fila,columna,20,10);
        if (unaSorpresa.getClass() == SorpresaFavorable.class ) {
        	etiqueta.setText("SF");
        }
        if (unaSorpresa.getClass() == SorpresaDesfavorable.class ) {
        	etiqueta.setText("SD");
        }
        if (unaSorpresa.getClass() == SorpresaCambioDeVehiculo.class ) {
        	etiqueta.setText("SV");
        }
        this.ventanaDestino.add(etiqueta);      

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
