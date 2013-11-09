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
	
}
