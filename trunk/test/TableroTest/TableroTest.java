package TableroTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Excepciones.PosicionInvalidaException;
import Tablero.Tablero;
import Vehiculos.Vehiculo;

public class TableroTest {

	@Test
	public void testTableroDevuelveBienLasFilas() {
		Tablero unTablero = new Tablero (4,4);
		
		assertTrue(unTablero.getFilas()==4);
	}

	@Test
	public void testTableroDevuelveBienLasColumnas() {
		Tablero unTablero = new Tablero (4,2);
		
		assertTrue(unTablero.getColumnas()==2);
	}
	
	@Test
	public void testTableroRevisaPosicion() {
		Tablero unTablero = new Tablero (4,2);
		
		assertTrue(unTablero.posicionValida(2, 1));
	}
	
	@Test
	public void testTableroColocaVehiculoEnPosicion() {
		Tablero unTablero = new Tablero (4,2);
		Vehiculo unVehiculo = new Vehiculo();
		Vehiculo vehiculoResultado = null;
		
		try{
			unTablero.colocarVehiculoEn(unVehiculo,1,1);
		
		} catch (PosicionInvalidaException e) {
			//No entra aquí, los parámetros son correctos
		}
		
		try{
			vehiculoResultado = unTablero.getVehiculoEn(1,1);
		}catch (PosicionInvalidaException e){
			//No entra aquí, los parámetros son correctos
		}
		assertTrue( vehiculoResultado == unVehiculo );
	}

}
