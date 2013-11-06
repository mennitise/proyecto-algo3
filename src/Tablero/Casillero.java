package Tablero;

import Obstaculos.Obstaculo;
import Vehiculos.Vehiculo;

public class Casillero {
	
	private Obstaculo contenido;
	private Vehiculo unVehiculo;
	
	public Casillero(){
		this.contenido  = null;
		this.unVehiculo = null;
	}
	
	public boolean estaOcupado() {
		return (!this.estaVacio());
	}

	public boolean estaVacio() {
		return (this.contenido == null);
	}
	
	public void ponerObstaculoOSorpresa(Obstaculo unObstaculo) {
		this.contenido = unObstaculo;
		
	}
	
	public void ponerVehiculo(Vehiculo unVehiculo){
		this.unVehiculo = unVehiculo;
	}
	
	public boolean hayUnVehiculo(){
		return (this.unVehiculo != null);
	}
	
	public Vehiculo getVehiculoEnCasillero(){
		return unVehiculo;
	}

	public Vehiculo quitarVehiculo(){
		if (!this.hayUnVehiculo()){
			return null;
		}
		Vehiculo unVehiculo = this.unVehiculo;
		this.unVehiculo = null;
		return unVehiculo;
	}
}
