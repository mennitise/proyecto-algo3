package TableroTest;

import static org.junit.Assert.*;
import org.junit.Test;

import Tablero.Posicion;

public class PosicionTest {

	@Test
	public void testPosicionGuardaBienX() {
		Posicion unaPosicion = new Posicion(44,2);
		assertTrue(unaPosicion.getFila() == 44);
	}
	
	@Test
	public void testPosicionGuardaBienY() {
		Posicion unaPosicion = new Posicion(44,2);
		assertTrue(unaPosicion.getColumna() == 2);
	}
	
	@Test
	public void testMoverAlSur() {
		Posicion unaPosicion = new Posicion(44,2);
		unaPosicion.moverAlSur();
		assertTrue(unaPosicion.getFila() == 45);
	}
	
	@Test
	public void testMoverAlNorte() {
		Posicion unaPosicion = new Posicion(44,2);
		unaPosicion.moverAlNorte();
		assertTrue(unaPosicion.getFila() == 43);
	}
	
	@Test
	public void testMoverAlEste() {
		Posicion unaPosicion = new Posicion(44,2);
		unaPosicion.moverAlEste();
		assertTrue(unaPosicion.getColumna() == 3);
	}
	
	@Test
	public void testMoverAlOeste() {
		Posicion unaPosicion = new Posicion(44,2);
		unaPosicion.moverAlOeste();
		assertTrue(unaPosicion.getColumna() == 1);
	}
	
	@Test
	public void testPosicionesDeberianSerIguales() {
		Posicion unaPosicion = new Posicion(1,2);
		Posicion otraPosicion = new Posicion(1,2);
		assertTrue(unaPosicion.esIgual(otraPosicion));
	}
	@Test
	public void testPosicionesDeberianSerDistintas01() {
		Posicion unaPosicion = new Posicion(1,1);
		Posicion otraPosicion = new Posicion(1,2);
		assertTrue(!unaPosicion.esIgual(otraPosicion));
	}
	@Test
	public void testPosicionesDeberianSerDistintas02() {
		Posicion unaPosicion = new Posicion(2,2);
		Posicion otraPosicion = new Posicion(1,2);
		assertTrue(!unaPosicion.esIgual(otraPosicion));
	}
	@Test
	public void testPosicionesDeberianSerDistintas03() {
		Posicion unaPosicion = new Posicion(3,8);
		Posicion otraPosicion = new Posicion(1,2);
		assertTrue(!unaPosicion.esIgual(otraPosicion));
	}
}
