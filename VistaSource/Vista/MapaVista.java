package Vista;
import java.awt.Color;

import javax.swing.JButton;

import Tablero.Tablero;

public class MapaVista { 
	private int esquinasHorizontales;
	private int esquinasVerticales;
	private int anchoCalle;
	private VentanaVista ventanaDestino;
	
	MapaVista(VentanaVista unaVentana, int esquinasHorizontales, int esquinasVerticales){
		this.esquinasHorizontales = esquinasHorizontales;
		this.esquinasVerticales = esquinasVerticales;
		this.anchoCalle = 20;
		this.ventanaDestino = unaVentana;
	}

	public void dibujarMapa(){
		int tamanioManzanaHorizontal = this.calcularTamanioManzanaHorizontal();
		int tamanioManzanaVertical = this.calcularTamanioManzanaVertical();

		for (int i=0; i<=this.esquinasVerticales;i++){
			for (int j=0; j<=this.esquinasHorizontales;j++){
				int fila = (int)this.ventanaDestino.getPuntoInicialMapa().getX() + j * (tamanioManzanaHorizontal + this.anchoCalle);
		        int columna = (int)this.ventanaDestino.getPuntoInicialMapa().getY() + i * (tamanioManzanaVertical + this.anchoCalle);
		        ManzanaVista manzana = new ManzanaVista (tamanioManzanaHorizontal,tamanioManzanaVertical);
		        manzana.ponerManzana(ventanaDestino,fila,columna);
		        }
		}
		
	}
	
	private int calcularTamanioManzanaHorizontal(){
		int pixelesHorizontales = this.ventanaDestino.getPixelesHorizontales() - (int)this.ventanaDestino.getPuntoInicialMapa().getX();
		return ((pixelesHorizontales)/(this.esquinasHorizontales+1))-(this.anchoCalle);		
	}
	
	private int calcularTamanioManzanaVertical(){
		int pixelesVerticales = this.ventanaDestino.getPixelesVerticales() - (int)this.ventanaDestino.getPuntoInicialMapa().getY();
		return ((pixelesVerticales)/(this.esquinasVerticales+1))-(this.anchoCalle);		
	}
		

}