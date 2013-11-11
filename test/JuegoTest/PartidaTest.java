package JuegoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.StringVacioException;
import Juego.NivelFacil;
import Juego.Partida;
import Jugador.Jugador;

public class PartidaTest {

	private Partida unaPartida;
	
	private void inicializarPartida(){
		
		Jugador unJugador = null;
		
		try {
			unJugador = new Jugador("Pepe", null);
		} catch (StringVacioException e) {
			// No ingresa aquí.
		}
		
		this.unaPartida = new Partida(unJugador, new NivelFacil());
		
	}
	
	@Test
	public void testPartidaCrear() {
		this.inicializarPartida();
		assertTrue(unaPartida != null);
	}
	
	@Test
	public void testPartidaGuardaElJugadorCorrecto() {
		this.inicializarPartida();
		assertTrue(unaPartida.getNombreJugador() == "Pepe");
	}
	
}
