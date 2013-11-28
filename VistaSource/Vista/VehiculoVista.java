package Vista;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import GestorDeMovimientos.GestorDeMovimientos;
import Tablero.Posicion;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class VehiculoVista {
	
	public VehiculoVista(Vehiculo unVehiculo, JLabel etiquetaRepresentativa){
		this.actualizarImagenDelVehiculo(unVehiculo, etiquetaRepresentativa);
	}
	
	

	private void actualizarImagenDelVehiculo(Vehiculo unVehiculo, JLabel etiquetaRepresentativa){
		if (unVehiculo.getClass() == Auto.class){
			etiquetaRepresentativa.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/Auto.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
			}
		
		if (unVehiculo.getClass() == Moto.class){
			etiquetaRepresentativa.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/Moto.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
			}
		
		if (unVehiculo.getClass() == CuatroXCuatro.class){
			etiquetaRepresentativa.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/4x4.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
			}
		
	}
	
	
}
