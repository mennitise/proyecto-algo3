package JugadorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.NumeroNegativoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Vehiculos.Vehiculo;

public class JugadorTest {

	private Jugador unJugador;
	
	private void crearJugadorPepe(){
		try {
			this.unJugador = new Jugador("Pepe",new Vehiculo());
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
		try {
			this.unJugador = new Jugador("",new Vehiculo());
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
