package ObstaculoTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Excepciones.NumeroNegativoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Obstaculos.Obstaculo;
import Vehiculos.Vehiculo;

public class ObstaculoTest {
	
	private Jugador unJugador;
	private Obstaculo unObstaculo;
	
	private void crearObstaculoDesfavorableConCincoMovimientosDePenalizacion(){
		try {
			this.unObstaculo = new Obstaculo(5);
		} catch (NumeroNegativoException e) {
			// No va a entrar nunca aca porque usamos el 5
		}
	}
	
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
	
	@Test
	public void testDeberiaPenalizarCorrectamente01(){
		this.crearJugadorPepe();
		this.crearObstaculoDesfavorableConCincoMovimientosDePenalizacion();
		this.unObstaculo.penalizarA(this.unJugador);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 5);
	}
	
	@Test
	public void testDeberiaPenalizarCorrectamente02(){
		this.crearJugadorPepe();
		this.crearObstaculoDesfavorableConCincoMovimientosDePenalizacion();
		this.agregarMovimientos(3);
		this.unObstaculo.penalizarA(this.unJugador);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 8);
	}
	
	@Test
	public void testDeberiaLanzarNumeroNegativoExceptionAlCrearObstaculoConCantidadDeMovimientosDePenlizacionNegativo(){
		boolean lanzoExcepcion = false;
		try {
			this.unObstaculo = new Obstaculo(-5);
		} catch (NumeroNegativoException e) {
			lanzoExcepcion = true;
		}
		assertTrue(lanzoExcepcion);
	}
}
