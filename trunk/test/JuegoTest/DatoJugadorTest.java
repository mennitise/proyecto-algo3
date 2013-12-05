package JuegoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Juego.DatoJugador;

public class DatoJugadorTest {

	@Test
	public void testCrearDatoJugador() {
		
		DatoJugador dato = new DatoJugador("Pepe");
		assertTrue(dato != null);
	}

}
