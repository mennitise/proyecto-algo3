package Vista;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import Obstaculos.ControlPolicial;
import Obstaculos.Obstaculo;
import Obstaculos.Piquete;
import Obstaculos.Pozo;
import Sorpresas.Sorpresa;
import Sorpresas.SorpresaCambioDeVehiculo;
import Sorpresas.SorpresaDesfavorable;
import Sorpresas.SorpresaFavorable;

public class ObstaculoVista implements Observer{
	
	private VentanaVista ventanaDestino;
	private ArrayList<JLabel> etiquetasRepresentativas;
	
	public ObstaculoVista(VentanaVista unaVentana){
		this.etiquetasRepresentativas = new ArrayList<JLabel>();	
		this.ventanaDestino = unaVentana;
	}
	
	public void dibujarSorpresaEn(Obstaculo unObstaculo, int fila, int columna){
		
		JLabel etiqueta=new JLabel();
		this.etiquetasRepresentativas.add(etiqueta);
		etiqueta.setBounds(fila,columna,20,10);
		if (unObstaculo.getClass() == Piquete.class ) {
			etiqueta.setText("Pi");
		}
		if (unObstaculo.getClass() == ControlPolicial.class ) {
			etiqueta.setText("CP");
		}
		if (unObstaculo.getClass() == Pozo.class ) {
			etiqueta.setText("Po");
		}
		this.ventanaDestino.add(etiqueta);      
    
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
