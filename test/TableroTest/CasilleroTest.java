package TableroTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Obstaculos.ControlPolicial;
import Tablero.Casillero;
import Vehiculos.Vehiculo;

public class CasilleroTest {

	@Test
	public void testCasilleroSeInicializaEnVacio() {
		Casillero casillero = new Casillero();
		
		assertTrue(casillero.estaVacio());
	}

	@Test
	public void testCasilleroOcupado() {
		Casillero casillero = new Casillero();
		ControlPolicial unControlPolicial= new ControlPolicial();
		
		casillero.ponerObstaculoOSorpresa(unControlPolicial);

		assertTrue(casillero.estaOcupado());
	}
	
	@Test
	public void testCasilleroGuardaVehiculo() {
		Casillero casillero = new Casillero();
		Vehiculo unVehiculo = new Vehiculo();
		
		casillero.ponerVehiculo(unVehiculo);
		assertTrue(casillero.hayUnVehiculo());
	}
	
	@Test
	public void testCasilleroDevuelveVehiculoGuardadoEnEl() {
		Casillero casillero = new Casillero();
		Vehiculo unVehiculo = new Vehiculo();
		
		casillero.ponerVehiculo(unVehiculo);
		assertTrue(casillero.getVehiculoEnCasillero() == unVehiculo);
	}
	
	@Test
	public void testCasilleroQuitarUnVehiculoDevuelveVehiculo() {
		Casillero casillero = new Casillero();
		Vehiculo unVehiculo = new Vehiculo();
		
		casillero.ponerVehiculo(unVehiculo);
		assertTrue(casillero.quitarVehiculo() == unVehiculo);
	}
	
	@Test
	public void testCasilleroQuitarUnVehiculoDeCasilleroSinVehiculoDevuelveNull() {
		Casillero casillero = new Casillero();
		assertTrue(casillero.quitarVehiculo() == null);
	}
	
}
