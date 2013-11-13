package VehiculosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.StringVacioException;
import Jugador.Jugador;
import Tablero.Posicion;
import Vehiculos.Moto;

public class MotoTest {

	private Moto unaMoto;
	private Posicion unaPos;
	private Jugador conductor;
	
	
	private void inicializarMoto(){
		this.unaMoto = new Moto();
	}
	
	private void inicializarMotoConPosicion(){
		this.unaPos    = new Posicion(1,1);
		this.unaMoto = new Moto(this.unaPos);
	}

	private void inicializarMotoConPosicionYJugador(){
		this.unaPos = new Posicion(1,1);
		try {
			this.conductor = new Jugador("Pepe", null);
		} catch (StringVacioException e) {
			// No ingresa.
		}
		this.unaMoto    = new Moto(this.unaPos, this.conductor);
		this.conductor.setVehiculo(this.unaMoto); 
	}
	
	
	@Test
	public void testMotoInicializarSinPosicionNoTienePosicion() {
		this.inicializarMoto();
		assertTrue(this.unaMoto.getPosicion() == null);
	}

	@Test
	public void testMotoInicializarSinConductorNoTieneConductor() {
		this.inicializarMoto();
		assertTrue(this.unaMoto.getConductor() == null);
	}
	
	@Test
	public void testMotoInicializarConPosicionYSinJugadorTienePosicion() {
		this.inicializarMotoConPosicion();
		assertTrue(this.unaMoto.getPosicion() == this.unaPos);
	}

	@Test
	public void testMotoInicializarConPosicionYConJugadorTienePosicion() {
		this.inicializarMotoConPosicionYJugador();
		assertTrue(this.unaMoto.getPosicion() == this.unaPos);
	}
	
	@Test
	public void testMotoInicializarSinPosicionYAgregarPosicionDespuesTienePosicion() {
		this.inicializarMoto();
		this.unaPos = new Posicion(2,2);
		this.unaMoto.setPosicion(unaPos);
		assertTrue(this.unaMoto.getPosicion() == unaPos);
	}
	
	@Test
	public void testMotoInicializarSinConductorYAgregarConductorDespuesTieneConductor() {
		this.inicializarMoto();
		try {
			this.conductor = new Jugador("Pepe", this.unaMoto);
		} catch (StringVacioException e) {
			// No ingresa.
		}
		this.unaMoto.setConductor(this.conductor);
		assertTrue(this.unaMoto.getConductor() == this.conductor);
	}
	
	@Test
	public void testMotoSeMueveAlOeste() {
		this.inicializarMotoConPosicion();
		this.unaMoto.moverseAlOeste();
		assertTrue(this.unaMoto.getPosicion().getFila()    == 1 );
		assertTrue(this.unaMoto.getPosicion().getColumna() == 0 );
	}
	
	@Test
	public void testMotoSeMueveAlEste() {
		this.inicializarMotoConPosicion();
		this.unaMoto.moverseAlEste();
		assertTrue(this.unaMoto.getPosicion().getFila()    == 1 );
		assertTrue(this.unaMoto.getPosicion().getColumna() == 2 );
	}
	
	@Test
	public void testMotoSeMueveAlSur() {
		this.inicializarMotoConPosicion();
		this.unaMoto.moverseAlSur();
		assertTrue(this.unaMoto.getPosicion().getFila()    == 2 );
		assertTrue(this.unaMoto.getPosicion().getColumna() == 1 );
	}
	
	@Test
	public void testMotoSeMueveAlNorte() {
		this.inicializarMotoConPosicion();
		this.unaMoto.moverseAlNorte();
		assertTrue(this.unaMoto.getPosicion().getFila()    == 0 );
		assertTrue(this.unaMoto.getPosicion().getColumna() == 1 );
	}
	


}
