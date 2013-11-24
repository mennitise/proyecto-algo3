package VehiculosTest;

import static org.junit.Assert.*;

import org.junit.Test;



import Excepciones.StringVacioException;
import GestorDeMovimientos.EstrategiaEste;
import GestorDeMovimientos.EstrategiaNorte;
import GestorDeMovimientos.EstrategiaOeste;
import GestorDeMovimientos.EstrategiaSur;
import Jugador.Jugador;
import Tablero.Posicion;
import Vehiculos.Auto;

public class AutoTest {
	
	private Auto unAuto;
	private Posicion unaPos;
	private Jugador conductor;
	private EstrategiaSur unaEstrategiaSur; 
	private EstrategiaNorte unaEstrategiaNorte; 
	private EstrategiaOeste unaEstrategiaOeste; 
	private EstrategiaEste unaEstrategiaEste;
	
	private void inicializarEstrategias() {
		this.unaEstrategiaSur = new EstrategiaSur(); 
		this.unaEstrategiaNorte = new EstrategiaNorte(); 
		this.unaEstrategiaOeste = new EstrategiaOeste(); 
		this.unaEstrategiaEste = new EstrategiaEste();
	}
	
	private void inicializarAuto(){
		this.unAuto = new Auto();
	}
	
	private void inicializarAutoConPosicion(){
		this.unaPos    = new Posicion(1,1);
		this.unAuto    = new Auto(this.unaPos);
	}

	private void inicializarAutoConPosicionYJugador(){
		this.unaPos = new Posicion(1,1);
		try {
			this.conductor = new Jugador("Pepe", null);
		} catch (StringVacioException e) {
			// No ingresa.
		}
		this.unAuto    = new Auto(this.unaPos, this.conductor);
		this.conductor.setVehiculo(this.unAuto); 
	}
	
	
	@Test
	public void testAutoInicializarSinPosicionNoTienePosicion() {
		this.inicializarAuto();
		assertTrue(this.unAuto.getPosicion() == null);
	}

	@Test
	public void testAutoInicializarSinConductorNoTieneConductor() {
		this.inicializarAuto();
		assertTrue(this.unAuto.getConductor() == null);
	}
	
	@Test
	public void testAutoInicializarConPosicionYSinJugadorTienePosicion() {
		this.inicializarAutoConPosicion();
		assertTrue(this.unAuto.getPosicion() == this.unaPos);
	}

	@Test
	public void testAutoInicializarConPosicionYConJugadorTienePosicion() {
		this.inicializarAutoConPosicionYJugador();
		assertTrue(this.unAuto.getPosicion() == this.unaPos);
	}
	
	@Test
	public void testAutoInicializarSinPosicionYAgregarPosicionDespuesTienePosicion() {
		this.inicializarAuto();
		this.unaPos = new Posicion(2,2);
		this.unAuto.setPosicion(unaPos);
		assertTrue(this.unAuto.getPosicion() == unaPos);
	}
	
	@Test
	public void testAutoInicializarSinConductorYAgregarConductorDespuesTieneConductor() {
		this.inicializarAuto();
		try {
			this.conductor = new Jugador("Pepe", this.unAuto);
		} catch (StringVacioException e) {
			// No ingresa.
		}
		this.unAuto.setConductor(this.conductor);
		assertTrue(this.unAuto.getConductor() == this.conductor);
	}
	
	@Test
	public void testAutoSeMueveAlOeste() {
		this.inicializarAutoConPosicion();
		this.inicializarEstrategias();
		Posicion posicionDestino = new Posicion(this.unAuto.getPosicion().getFila(), this.unAuto.getPosicion().getColumna() - 1);
		this.unAuto.mover(this.unaEstrategiaOeste);
		assertTrue(this.unAuto.getPosicion().esIgual(posicionDestino));
	}
	
	@Test
	public void testAutoSeMueveAlEste() {
		this.inicializarAutoConPosicion();
		this.inicializarEstrategias();
		Posicion posicionDestino = new Posicion(this.unAuto.getPosicion().getFila(), this.unAuto.getPosicion().getColumna() + 1);
		this.unAuto.mover(this.unaEstrategiaEste);
		assertTrue(this.unAuto.getPosicion().esIgual(posicionDestino));
	}
	
	@Test
	public void testAutoSeMueveAlSur() {
		this.inicializarAutoConPosicion();
		this.inicializarEstrategias();
		Posicion posicionDestino = new Posicion(this.unAuto.getPosicion().getFila() + 1, this.unAuto.getPosicion().getColumna());
		this.unAuto.mover(this.unaEstrategiaSur);
		assertTrue(this.unAuto.getPosicion().esIgual(posicionDestino));
	}
	
	@Test
	public void testAutoSeMueveAlNorte() {
		this.inicializarAutoConPosicion();
		this.inicializarEstrategias();
		Posicion posicionDestino = new Posicion(this.unAuto.getPosicion().getFila() - 1, this.unAuto.getPosicion().getColumna());
		this.unAuto.mover(this.unaEstrategiaNorte);
		assertTrue(this.unAuto.getPosicion().esIgual(posicionDestino));
	}
	
}
