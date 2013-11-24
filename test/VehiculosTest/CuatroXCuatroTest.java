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
import Vehiculos.CuatroXCuatro;

public class CuatroXCuatroTest {

	private CuatroXCuatro unaCuatroXCuatro;
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
	
	private void inicializarCuatroXCuatro(){
		this.unaCuatroXCuatro = new CuatroXCuatro();
	}
	
	private void inicializarCuatroXCuatroConPosicion(){
		this.unaPos    = new Posicion(1,1);
		this.unaCuatroXCuatro = new CuatroXCuatro(this.unaPos);
	}

	private void inicializarCuatroXCuatroConPosicionYJugador(){
		this.unaPos = new Posicion(1,1);
		try {
			this.conductor = new Jugador("Pepe", null);
		} catch (StringVacioException e) {
			// No ingresa.
		}
		this.unaCuatroXCuatro    = new CuatroXCuatro(this.unaPos, this.conductor);
		this.conductor.setVehiculo(this.unaCuatroXCuatro); 
	}
	
	
	@Test
	public void testCuatroXCuatroInicializarSinPosicionNoTienePosicion() {
		this.inicializarCuatroXCuatro();
		assertTrue(this.unaCuatroXCuatro.getPosicion() == null);
	}

	@Test
	public void testCuatroXCuatroInicializarSinConductorNoTieneConductor() {
		this.inicializarCuatroXCuatro();
		assertTrue(this.unaCuatroXCuatro.getConductor() == null);
	}
	
	@Test
	public void testCuatroXCuatroInicializarConPosicionYSinJugadorTienePosicion() {
		this.inicializarCuatroXCuatroConPosicion();
		assertTrue(this.unaCuatroXCuatro.getPosicion() == this.unaPos);
	}

	@Test
	public void testCuatroXCuatroInicializarConPosicionYConJugadorTienePosicion() {
		this.inicializarCuatroXCuatroConPosicionYJugador();
		assertTrue(this.unaCuatroXCuatro.getPosicion() == this.unaPos);
	}
	
	@Test
	public void testCuatroXCuatroInicializarSinPosicionYAgregarPosicionDespuesTienePosicion() {
		this.inicializarCuatroXCuatro();
		this.unaPos = new Posicion(2,2);
		this.unaCuatroXCuatro.setPosicion(unaPos);
		assertTrue(this.unaCuatroXCuatro.getPosicion() == unaPos);
	}
	
	@Test
	public void testCuatroXCuatroInicializarSinConductorYAgregarConductorDespuesTieneConductor() {
		this.inicializarCuatroXCuatro();
		try {
			this.conductor = new Jugador("Pepe", this.unaCuatroXCuatro);
		} catch (StringVacioException e) {
			// No ingresa.
		}
		this.unaCuatroXCuatro.setConductor(this.conductor);
		assertTrue(this.unaCuatroXCuatro.getConductor() == this.conductor);
	}
	
	@Test
	public void testCuatroXCuatroSeMueveAlOeste() {
		this.inicializarCuatroXCuatroConPosicion();
		this.inicializarEstrategias();
		Posicion posicionDestino = new Posicion(this.unaCuatroXCuatro.getPosicion().getFila(), this.unaCuatroXCuatro.getPosicion().getColumna() - 1);
		this.unaCuatroXCuatro.mover(this.unaEstrategiaOeste);
		assertTrue(this.unaCuatroXCuatro.getPosicion().esIgual(posicionDestino));
	}
	
	@Test
	public void testCuatroXCuatroSeMueveAlEste() {
		this.inicializarCuatroXCuatroConPosicion();
		this.inicializarEstrategias();
		Posicion posicionDestino = new Posicion(this.unaCuatroXCuatro.getPosicion().getFila(), this.unaCuatroXCuatro.getPosicion().getColumna() + 1);
		this.unaCuatroXCuatro.mover(this.unaEstrategiaEste);
		assertTrue(this.unaCuatroXCuatro.getPosicion().esIgual(posicionDestino));
	}
	
	@Test
	public void testCuatroXCuatroSeMueveAlSur() {
		this.inicializarCuatroXCuatroConPosicion();
		this.inicializarEstrategias();
		Posicion posicionDestino = new Posicion(this.unaCuatroXCuatro.getPosicion().getFila() + 1, this.unaCuatroXCuatro.getPosicion().getColumna());
		this.unaCuatroXCuatro.mover(this.unaEstrategiaSur);
		assertTrue(this.unaCuatroXCuatro.getPosicion().esIgual(posicionDestino));
	}
	
	@Test
	public void testCuatroXCuatroSeMueveAlNorte() {
		this.inicializarCuatroXCuatroConPosicion();
		this.inicializarEstrategias();
		Posicion posicionDestino = new Posicion(this.unaCuatroXCuatro.getPosicion().getFila() - 1, this.unaCuatroXCuatro.getPosicion().getColumna());
		this.unaCuatroXCuatro.mover(this.unaEstrategiaNorte);
		assertTrue(this.unaCuatroXCuatro.getPosicion().esIgual(posicionDestino));
	}
	


}
