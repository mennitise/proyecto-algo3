package GestorDeMovimientos;

import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Vehiculo;
import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PosicionInvalidaException;

public class GestorDeMovimientos {

	private Vehiculo vehiculo;
	private Tablero tablero;
	
	public GestorDeMovimientos(Vehiculo unVehiculo, Tablero tablero) {
		
		this.vehiculo = unVehiculo;
		this.tablero  = tablero;
	}


	public Posicion getPosicionActual() {
		return this.vehiculo.getPosicion();
	}

	public Vehiculo getVehiculoEnPosicionActual() {
		return this.vehiculo;
	}

	public void moverVehiculo(EstrategiaDeMovimiento unaEstrategia){
		//Activar la estrategia recibida.
	}
}
