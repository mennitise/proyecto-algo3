package SorpresaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.NumeroNegativoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Sorpresas.SorpresaFavorable;
import Tablero.Posicion;
import Vehiculos.Auto;

public class SorpresaFavorableTest {
	private Jugador unJugador;
	private SorpresaFavorable unaSorpresaFavorable; 
	
	@Test
	public void testDeberiaRestar0MovimientosCuandoJugadorTiene0Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(0);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testDeberiaRestar0MovimientosCuandoJugadorTiene1Movimiento() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(1);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() -1 == 0);
	}
	@Test
	public void testDeberiaRestar0MovimientosCuandoJugadorTiene2Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(2);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() -2 == 0);
	}
	@Test
	public void testDeberiaRestar1MovimientoCuandoJugadorTiene3Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(3);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() -3 == -1);
	}
	@Test
	public void testDeberiaRestar1MovimientoCuandoJugadorTiene4Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(4);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 4 == -1);
	}
	@Test
	public void testDeberiaRestar1MovimientoCuandoJugadorTiene5Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(5);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 5 == -1);
	}
	@Test
	public void testDeberiaRestar1MovimientoCuandoJugadorTiene6Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(6);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 6 == -1);
	}
	@Test
	public void testDeberiaRestar1MovimientoCuandoJugadorTiene7Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(7);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 7 == -1);
	}
	@Test
	public void testDeberiaRestar2MovimientosCuandoJugadorTiene8Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(8);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 8 == -2);
	}
	@Test
	public void testDeberiaRestar2MovimientosCuandoJugadorTiene9Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(9);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 9 == -2);
	}
	@Test
	public void testDeberiaRestar42MovimientosCuandoJugadorTiene208Movimientos() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(208);
		this.inicializarSorpresaFavorable();
		this.unJugador.getVehiculo().interactuarCon(this.unaSorpresaFavorable);
		assertTrue(this.unJugador.getCantidadDeMovimientos() - 208 == -42);
	}
	
	
	
	private void inicializarSorpresaFavorable(){
		this.unaSorpresaFavorable = new SorpresaFavorable();
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
