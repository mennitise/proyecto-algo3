package GestorDeMovimientos;

import Tablero.Esquina;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Vehiculo;
import Excepciones.MovimientoFisicamenteInvalidoException;

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
		Posicion laPosicion = this.vehiculo.getPosicion(); 
		Esquina laEsquina = tablero.getEsquinaEn(laPosicion);
		try {
			unaEstrategia.realizarMovimiento(this.vehiculo, laEsquina);
		} catch (MovimientoFisicamenteInvalidoException e) {
			//IMPLEMENTAR
		}
	}
}
