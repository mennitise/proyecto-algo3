package Vista;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Tablero.Tablero;


public class VentanaVista extends JFrame {
	private int pixelesHorizontales;
	private int pixelesVerticales;
	private Point puntoInicialMapa;
	
	VentanaVista(){
		setLayout(null);
		this.pixelesHorizontales = 800;
		this.pixelesVerticales = 600;
		this.puntoInicialMapa = new Point(200 , 0);
		this.setBounds(0,0,this.pixelesHorizontales,this.pixelesVerticales);
	}
	
	public int getPixelesHorizontales() {
		return this.pixelesHorizontales;
	}

	public int getPixelesVerticales() {
		return this.pixelesVerticales;
	}

	public Point getPuntoInicialMapa() {
		return this.puntoInicialMapa;
	}
	
	
	public static void main(String[] ar){
        VentanaVista ventanaVista = new VentanaVista();
    	MapaVista mapa = new MapaVista(ventanaVista, 10, 10);
        mapa.dibujarMapa();
        ventanaVista.setVisible(true);
	}
	
}
