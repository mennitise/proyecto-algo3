package GestorDeMovimientos;

import Tablero.Esquina;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Vehiculo;
import Excepciones.MovimientoFisicamenteInvalidoException;
import Jugador.Jugador;

public class GestorDeMovimientos extends java.util.Observable {

	private Tablero tablero;
	private Jugador jugador;
	
	public GestorDeMovimientos(Jugador unJugador, Tablero tablero){
		this.jugador = unJugador;
		this.tablero = tablero;
	}

	public Posicion getPosicionActual() {
		return this.jugador.getVehiculo().getPosicion();
	}

	public Vehiculo getVehiculoEnPosicionActual() {
		return this.jugador.getVehiculo();
	}

	public void moverVehiculo(EstrategiaDeMovimiento unaEstrategia){
		Posicion laPosicion = this.jugador.getVehiculo().getPosicion(); 
		Esquina laEsquina = tablero.getEsquinaEn(laPosicion);
		try {
			unaEstrategia.realizarMovimiento(this.jugador.getVehiculo(), laEsquina);
			this.ActualizarObservadores();
		} catch (MovimientoFisicamenteInvalidoException e) {
			//IMPLEMENTAR
		}
		
	}
	
	public void ActualizarObservadores()
	
	{
		setChanged();
		notifyObservers();		
	}
}