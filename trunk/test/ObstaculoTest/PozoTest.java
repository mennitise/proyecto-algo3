package ObstaculoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.NumeroNegativoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Obstaculos.Pozo;
import Vehiculos.Vehiculo;

public class PozoTest {

	private Pozo unPozo;
	private Jugador unJugador;
	
	private void crearJugadorPepe(){
		try {
			this.unJugador = new Jugador("Pepe",new Vehiculo());
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	
	private void crearPozo(){
		this.unPozo = new Pozo();		
	}
	
	@Test
	public void testDeberiaPenalizarCorrectamente01(){
		this.crearJugadorPepe();
		this.crearPozo();
		this.unPozo.penalizarA(this.unJugador);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	
	
}
