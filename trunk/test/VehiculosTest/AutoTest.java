package VehiculosTest;

import static org.junit.Assert.*;

import org.junit.Test;


import Excepciones.StringVacioException;
import Jugador.Jugador;
import Tablero.Posicion;
import Vehiculos.Auto;

public class AutoTest {
	
	private Auto unAuto;
	private Posicion unaPos;
	private Jugador conductor;
	
	
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
		this.unAuto.moverseAlOeste();
		assertTrue(this.unAuto.getPosicion().getFila()    == 1 );
		assertTrue(this.unAuto.getPosicion().getColumna() == 0 );
	}
	
	@Test
	public void testAutoSeMueveAlEste() {
		this.inicializarAutoConPosicion();
		this.unAuto.moverseAlEste();
		assertTrue(this.unAuto.getPosicion().getFila()    == 1 );
		assertTrue(this.unAuto.getPosicion().getColumna() == 2 );
	}
	
	@Test
	public void testAutoSeMueveAlSur() {
		this.inicializarAutoConPosicion();
		this.unAuto.moverseAlSur();
		assertTrue(this.unAuto.getPosicion().getFila()    == 2 );
		assertTrue(this.unAuto.getPosicion().getColumna() == 1 );
	}
	
	@Test
	public void testAutoSeMueveAlNorte() {
		this.inicializarAutoConPosicion();
		this.unAuto.moverseAlNorte();
		assertTrue(this.unAuto.getPosicion().getFila()    == 0 );
		assertTrue(this.unAuto.getPosicion().getColumna() == 1 );
	}
	
}
