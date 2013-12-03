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
	
	@Test
	public void testDatoJugadorGuardaBienPuntaje() {
		
		DatoJugador dato = new DatoJugador("Pepe");
		dato.asignarPuntaje(30);
		assertTrue( dato.getPuntaje() == 30 );
	}
	
	@Test
	public void testDatoJugadorAsignaBienPuntaje() {
		
		DatoJugador dato = new DatoJugador("Pepe");
		dato.setPuntuacion(10);
		dato.asignarPuntaje(10);
		assertTrue( dato.getPuntaje() == 20 );
	}

}
