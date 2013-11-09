package TableroTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.PosicionInvalidaException;
import Tablero.Tablero;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class TableroTest {

	@Test
	public void testTableroDevuelveBienLasFilas() {
		Tablero unTablero = new Tablero (4,4);
		
		assertTrue(unTablero.getFilas()==4);
	}

	@Test
	public void testTableroDevuelveBienLasColumnas() {
		Tablero unTablero = new Tablero (4,2);
		
		assertTrue(unTablero.getColumnas()==2);
	}
	
	@Test
	public void testTableroRevisaPosicion() {
		Tablero unTablero = new Tablero (4,2);
		
		assertTrue(unTablero.posicionValida(2, 1));
	}
}