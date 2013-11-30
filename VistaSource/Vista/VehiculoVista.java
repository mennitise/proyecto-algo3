package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GestorDeMovimientos.GestorDeMovimientos;
import Tablero.Posicion;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class VehiculoVista {
	private int tamanioManzana;
	private int anchoCalle;
	private int posicionHorizontalDeLaImagen;
	private int posicionVerticalDeLaImagen;
	
	
	public VehiculoVista(Vehiculo unVehiculo, int unTamanioManzana, int unAnchoCalle){
	
		this.anchoCalle = unAnchoCalle;
		this.tamanioManzana = unTamanioManzana;
	
	}
	
	public void actualizarImagenDelVehiculo(Vehiculo vehiculo, Graphics g, JPanel panelQueContieneEstaVista){
		this.calcularPosiciones(vehiculo.getPosicion().getFila(), vehiculo.getPosicion().getColumna());
		if (vehiculo.getClass() == Auto.class){
			System.out.println("llego aca");
			Image img1 = Toolkit.getDefaultToolkit().getImage("src/imagenes/Auto-20x20p.png");
			g.drawImage(img1,posicionHorizontalDeLaImagen,posicionVerticalDeLaImagen, panelQueContieneEstaVista);
		}
		
		if (vehiculo.getClass() == Moto.class){
			Image img1 = Toolkit.getDefaultToolkit().getImage("src/imagenes/Moto-20x20p.png");
			g.drawImage(img1,posicionHorizontalDeLaImagen,posicionVerticalDeLaImagen,panelQueContieneEstaVista);
			}
		
		if (vehiculo.getClass() == CuatroXCuatro.class){
			Image img1 = Toolkit.getDefaultToolkit().getImage("src/imagenes/4x4-20x20p.png");
			g.drawImage(img1,posicionHorizontalDeLaImagen,posicionVerticalDeLaImagen, panelQueContieneEstaVista);
			}
		
		
	}
	
	private void calcularPosiciones(int fila, int columna){
		this.posicionHorizontalDeLaImagen = (columna+1)*this.tamanioManzana + (columna)*this.anchoCalle;
		this.posicionVerticalDeLaImagen = (fila+1)*this.tamanioManzana + (fila)*this.anchoCalle;
	}
	
	
}
