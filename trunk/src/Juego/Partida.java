package Juego;

import Excepciones.TerminoLaPartidaException;
import GestorDeMovimientos.EstrategiaEste;
import GestorDeMovimientos.EstrategiaNorte;
import GestorDeMovimientos.EstrategiaOeste;
import GestorDeMovimientos.EstrategiaSur;
import GestorDeMovimientos.GestorDeMovimientos;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.Tablero;

public class Partida {
	
	private Jugador unJugador;
	private Tablero unTablero;
	private Nivel   unNivel;
	private EstrategiaSur unaEstrategiaSur; 
	private EstrategiaNorte unaEstrategiaNorte; 
	private EstrategiaOeste unaEstrategiaOeste; 
	private EstrategiaEste unaEstrategiaEste;
	private GestorDeMovimientos unGestor;
	
	public Partida(Jugador jugador, Nivel unNivel){
		this.unJugador = jugador;
		this.unNivel = unNivel;
		this.unJugador.getVehiculo().setPosicion(this.unNivel.getPosicionInicialDelVehiculo());
		this.unTablero = this.unNivel.inicializarTablero();
		this.unGestor = new GestorDeMovimientos(this.unJugador, unTablero);
		this.unaEstrategiaSur = new EstrategiaSur(); 
		this.unaEstrategiaNorte = new EstrategiaNorte(); 
		this.unaEstrategiaOeste = new EstrategiaOeste(); 
		this.unaEstrategiaEste = new EstrategiaEste(); 
	}

	public String getNombreJugador() {
		return this.unJugador.getNombre();
	}
	
	public Posicion getPosicionJugador(){
		return this.unJugador.getVehiculo().getPosicion();
	}
	
	public int getCantidadDeMovimientosDelJugador(){
		return this.unJugador.getCantidadDeMovimientos();
	}
	
	public Tablero getTablero(){
		return this.unTablero;
	}

	public int getCantidadDeMovimientosMaximaEnNivelActual(){
		return this.unNivel.getCantidadMaximaDeMovimientos();
	}
	
	public boolean ganoLaPartida() {
		Posicion posicionJugador = this.unJugador.getVehiculo().getPosicion();
		Posicion posicionFinal = this.unNivel.getPosicionDeLaLlegada();
		return posicionJugador.esIgual(posicionFinal);
	}
	
	public boolean perdioLaPartida() {
		return (this.unJugador.getCantidadDeMovimientos()>this.unNivel.getCantidadMaximaDeMovimientos());
	}

}
