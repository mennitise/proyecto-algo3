package GestorDeMovimientos;

import Tablero.Esquina;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Vehiculo;
import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
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

	public void moverVehiculo(EstrategiaDeMovimiento unaEstrategia) throws MovimientoFisicamenteInvalidoException, PasoImpedidoException{
		Posicion laPosicion = this.jugador.getVehiculo().getPosicion(); 
		Esquina laEsquina = tablero.getEsquinaEn(laPosicion);
		this.ActualizarObservadores(); //Quiero que actualice observadores por si aqui abajo se lanza la excepcion y no se vuelven a actualizar
		unaEstrategia.realizarMovimiento(this.jugador.getVehiculo(), laEsquina);
		this.ActualizarObservadores();
	}
	
	public void ActualizarObservadores()
	
	{
		setChanged();
		notifyObservers();		
	}
}
