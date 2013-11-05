package TableroTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Tablero.Tablero;

public class TableroTest {

	@Test
	public void testTableroDevuelveBienLasFilas() {
		Tablero unTablero = new Tablero (4,4,0);
		
		assertTrue(unTablero.getFilas()==4);
	}

	@Test
	public void testTableroDevuelveBienLasColumnas() {
		Tablero unTablero = new Tablero (4,2,0);
		
		assertTrue(unTablero.getColumnas()==2);
	}
	
	

	
}
