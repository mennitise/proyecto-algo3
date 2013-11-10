package ObstaculoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.NumeroNegativoException;
import Excepciones.PasoImpedidoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Obstaculos.Piquete;
import Obstaculos.Pozo;
import Tablero.Posicion;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class PozoTest {

	private Pozo unPozo;
	private Jugador unJugador;
	
	private void crearJugadorPepeConAuto(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Auto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	
	private void crearJugadorPepeConCuatroXCuatro(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new CuatroXCuatro(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	
	private void crearJugadorPepeConMoto(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Moto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	
	private void crearPozo(){
		this.unPozo = new Pozo();		
	}
	
	@Test
	public void testPozoDeberiaPenalizarCorrectamenteAUnAuto(){
		this.crearJugadorPepeConAuto();
		this.crearPozo();
		this.unPozo.interactuarCon((Auto)this.unJugador.getVehiculo());
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	
	@Test
	public void testPozoDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.crearJugadorPepeConMoto();
		this.crearPozo();
		this.unPozo.interactuarCon((Moto)this.unJugador.getVehiculo());
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	
	@Test
	public void testPozoNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.crearJugadorPepeConCuatroXCuatro();
		this.crearPozo();
		this.unPozo.interactuarCon((CuatroXCuatro)this.unJugador.getVehiculo());
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	
}
