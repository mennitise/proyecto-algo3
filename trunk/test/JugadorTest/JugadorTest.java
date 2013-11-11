package JugadorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.NumeroNegativoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Tablero.Posicion;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;

public class JugadorTest {

	private Jugador unJugador;
	
	private void crearJugadorPepe(){
		Posicion unaPosicion = new Posicion(0,1);
		try {
			this.unJugador = new Jugador("Pepe",new CuatroXCuatro(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	
	private void agregarMovimientos(int num){
		try {
			this.unJugador.sumarMovimientos(num);
		} catch (NumeroNegativoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void quitarMovimientos(int num){
		try {
			this.unJugador.quitarMovimientos(num);
		} catch (NumeroNegativoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeberiaCrearseConNombre(){
		this.crearJugadorPepe();
		assertTrue(this.unJugador.getNombre().equals("Pepe"));
	}
	
	@Test
	public void testDeberiaCrearseConCantidadDeMovimientosCero(){
		this.crearJugadorPepe();
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	
	@Test
	public void testDeberiaSumarMovimientos(){
		this.crearJugadorPepe();
		this.agregarMovimientos(5);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 5);
	}
	
	@Test
	public void testDeberiaSumarUnMovimiento(){
		this.crearJugadorPepe();
		this.unJugador.sumarUnMovimiento();
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
	}
	
	@Test
	public void testDeberiaQuitarMovimientos(){
		this.crearJugadorPepe();
		this.agregarMovimientos(5);
		this.quitarMovimientos(2);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	
	@Test
	public void testQuitarMovimientosDeberiaQuedarEnCeroComoMinimo(){
		this.crearJugadorPepe();
		this.agregarMovimientos(5);
		this.quitarMovimientos(8);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	
	@Test
	public void testDeberiaCambiarElNombre(){
		this.crearJugadorPepe();
		try {
			this.unJugador.setNombre("Nacho");
		} catch (StringVacioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(this.unJugador.getNombre().equals("Nacho"));
	}
	
	@Test
	public void testDeberiaDevolverElNombreCorrecto(){
		this.crearJugadorPepe();
		assertTrue(this.unJugador.getNombre().equals("Pepe"));
	}

	@Test
	public void testDeberiaLanzarStringVacioExceptionAlCrearJugadorSinNombre(){
		boolean lanzoExcepcion = false;
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("",new Auto(unaPosicion));
		} catch (StringVacioException e) {
			lanzoExcepcion = true;
		}
		assertTrue(lanzoExcepcion);
	}
	
	@Test
	public void testDeberiaLanzarStringVacioExceptionAlCambiarNombreAStringVacio(){
		boolean lanzoExcepcion = false;
		this.crearJugadorPepe();
		try {
			this.unJugador.setNombre("");
		} catch (StringVacioException e) {
			lanzoExcepcion = true;
		}
		assertTrue(lanzoExcepcion);
	}
	
	@Test
	public void testDeberiaLanzarNumeroNegativoExceptionAlAgregarMovimientosNegativos(){
		boolean lanzoExcepcion = false;
		this.crearJugadorPepe();
		try {
			this.unJugador.sumarMovimientos(-4);
		} catch (NumeroNegativoException e) {
			lanzoExcepcion = true;
		}
		assertTrue(lanzoExcepcion);
	}
	
	@Test
	public void testDeberiaLanzarNumeroNegativoExceptionAlQuitarMovimientosNegativos(){
		boolean lanzoExcepcion = false;
		this.crearJugadorPepe();
		try {
			this.unJugador.quitarMovimientos(-4);
		} catch (NumeroNegativoException e) {
			lanzoExcepcion = true;
		}
		assertTrue(lanzoExcepcion);
	}
	

}
