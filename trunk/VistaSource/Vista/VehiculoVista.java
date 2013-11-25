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

public class VehiculoVista implements Observer {
	private Vehiculo vehiculoActual;
	private MapaVista mapaDestino;
	private GestorDeMovimientos gestor;
	private JLabel etiquetaRepresentativa;
	public VehiculoVista(Vehiculo unVehiculo, MapaVista mapa, GestorDeMovimientos gestor){
		this.vehiculoActual = unVehiculo;		
		this.etiquetaRepresentativa= new JLabel();
		this.etiquetaRepresentativa.setSize(10,10);
		this.etiquetaRepresentativa.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/Auto.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)))	;
		this.mapaDestino = mapa;
		this.gestor = gestor;
		this.gestor.addObserver(this);
	}
	
	public void dibujarVehiculo(){
		this.actualizarImagenDelVehiculo();
		this.mapaDestino.localizarVehiculoEnMapa(etiquetaRepresentativa, this.vehiculoActual);
	}

	private void actualizarImagenDelVehiculo(){
		Vehiculo unVehiculo = this.gestor.getVehiculoEnPosicionActual();
		if (unVehiculo.getClass() == Auto.class){
			this.etiquetaRepresentativa.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/Auto.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
			}
		
		if (unVehiculo.getClass() == Moto.class){
			this.etiquetaRepresentativa.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/Moto.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
			}
		
		if (unVehiculo.getClass() == CuatroXCuatro.class){
			this.etiquetaRepresentativa.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/4x4.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
			}
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {	

		this.actualizarImagenDelVehiculo();
		this.dibujarVehiculo();
	
	}
}
