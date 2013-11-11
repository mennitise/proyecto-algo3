package SorpresaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.NumeroNegativoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Sorpresas.SorpresaDesfavorable;
import Tablero.Posicion;
import Vehiculos.Auto;

public class SorpresaDesfavorableTest {
	private Jugador unJugador;
	private SorpresaDesfavorable unaSorpresaDesfavorable; 
	
	@Test
	public void testDeberiaSumar0MovimientosCuandoJugadorTiene0Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(0);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testDeberiaSumar0MovimientosCuandoJugadorTiene1Movimiento() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(1);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() -1 == 0);
	}
	@Test
	public void testDeberiaSumar1MovimientosCuandoJugadorTiene2Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(2);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() -2 == 1);
	}
	@Test
	public void testDeberiaSumar1MovimientosCuandoJugadorTiene3Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(3);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() -3 == 1);
	}
	@Test
	public void testDeberiaSumar1MovimientosCuandoJugadorTiene4Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(4);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 4 == 1);
	}
	@Test
	public void testDeberiaSumar1MovimientosCuandoJugadorTiene5Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(5);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 5 == 1);
	}
	@Test
	public void testDeberiaSumar2MovimientosCuandoJugadorTiene6Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(6);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 6 == 2);
	}
	@Test
	public void testDeberiaSumar2MovimientosCuandoJugadorTiene7Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(7);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 7 == 2);
	}
	@Test
	public void testDeberiaSumar2MovimientosCuandoJugadorTiene8Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(8);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 8 == 2);
	}
	@Test
	public void testDeberiaSumar2MovimientosCuandoJugadorTiene9Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(9);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 9 == 2);
	}
	@Test
	public void testDeberiaSumar42MovimientosCuandoJugadorTiene169Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(169);
		this.inicializarSorpresaDesfavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaDesfavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 169 == 42);
	}
	
	
	
	private void inicializarSorpresaDesfavorable(){
		this.unaSorpresaDesfavorable = new SorpresaDesfavorable();
	}
	private void inicializarJugadorPepeConAutoYTantosMovimientos(int numMovimientos){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Auto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
		try {
			this.unJugador.sumarMovimientos(numMovimientos);
		} catch (NumeroNegativoException e) {
			assertTrue(false);
		}
	}
	
}
