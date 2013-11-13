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
import Vehiculos.Vehiculo;

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
		this.unJugador.getVehiculo().setPosicion(this.unNivel.posicionInicialDelVehiculo());
		this.unTablero = this.unNivel.inicializarTablero();
		this.unGestor = new GestorDeMovimientos(this.unJugador.getVehiculo(), unTablero);
		this.unaEstrategiaSur = new EstrategiaSur(); 
		this.unaEstrategiaNorte = new EstrategiaNorte(); 
		this.unaEstrategiaOeste = new EstrategiaOeste(); 
		this.unaEstrategiaEste = new EstrategiaEste(); 
	}

	public String getNombreJugador() {
		return this.unJugador.getNombre();
	}
	
	public void moverHaciaElSur() throws TerminoLaPartidaException{
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		if( this.terminoLaPartida() ) throw new TerminoLaPartidaException();
	}
	public void moverHaciaElNorte() throws TerminoLaPartidaException{
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		if( this.terminoLaPartida() ) throw new TerminoLaPartidaException();
	}
	public void moverHaciaElEste() throws TerminoLaPartidaException{
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		if( this.terminoLaPartida() ) throw new TerminoLaPartidaException();
	}
	public void moverHaciaElOeste() throws TerminoLaPartidaException{
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		if( this.terminoLaPartida() ) throw new TerminoLaPartidaException();
	}
	
	public Posicion getPosicionJugador(){
		return this.unJugador.getVehiculo().getPosicion();
	}
	
	public int getCantidadDeMovimientosDelJugador(){
		return this.unJugador.getCantidadDeMovimientos();
	}

	private boolean terminoLaPartida() {
		Posicion posicionJugador = this.unJugador.getVehiculo().getPosicion();
		Posicion posicionFinal = this.unNivel.posicionDeLaLlegada();
		if(posicionJugador.esIgual(posicionFinal)){
			return true;
		}else{
			return false;
		}
	}

}
