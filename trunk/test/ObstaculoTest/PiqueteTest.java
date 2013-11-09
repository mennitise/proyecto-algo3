package ObstaculoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.StringVacioException;
import Jugador.Jugador;
import Obstaculos.Piquete;
import Obstaculos.Pozo;
import Tablero.Posicion;
import Vehiculos.Auto;
import Vehiculos.Vehiculo;

public class PiqueteTest {
	
	private Jugador unJugador;
	private Piquete unPiquete;
	
	private void crearJugadorPepe(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Auto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	
	private void crearPiquete(){
		this.unPiquete = new Piquete();		
	}
	
	@Test
	public void testDeberiaPenalizarCorrectamente01(){
		this.crearJugadorPepe();
		this.crearPiquete();
		this.unPiquete.penalizarA(this.unJugador);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 2);
	}
	
	
}
