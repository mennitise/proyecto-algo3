package Vista;

import java.awt.Color;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import GestorDeMovimientos.GestorDeMovimientos;
import Tablero.Posicion;
import Vehiculos.Vehiculo;

public class VehiculoVista implements Observer {
	private Vehiculo vehiculoActual;
	private JButton botonRepresentativo;
	private MapaVista mapaDestino;
	private GestorDeMovimientos gestor;
	
	public VehiculoVista(Vehiculo unVehiculo, MapaVista mapa, GestorDeMovimientos gestor){
		this.vehiculoActual = unVehiculo;		
		this.botonRepresentativo = new JButton("");
		this.botonRepresentativo.setSize(10,10);
		this.botonRepresentativo.setBackground(Color.red);
		this.mapaDestino = mapa;
		this.gestor = gestor;
		this.gestor.addObserver(this);
	}
	
	public void dibujarVehiculo(){
		this.mapaDestino.localizarVehiculoEnMapa(this.botonRepresentativo, this.vehiculoActual);
	}

	@Override
	public void update(Observable arg0, Object arg1) {	
		this.dibujarVehiculo();
	
	}
}
