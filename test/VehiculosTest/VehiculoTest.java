package VehiculosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.ProbabilidadNoValidaException;
import Vehiculos.Vehiculo;

public class VehiculoTest {

	private Vehiculo unVehiculo;
	
	private void crearVehiculoConProbabilidadCeroPuntoUno(){
		try {
			this.unVehiculo = new Vehiculo(0.1);
		} catch (ProbabilidadNoValidaException e) {
			//Aca no entra Nunca porque la probabilidad esta entre 0 y 1	
		}
		
	}
	
	@Test
	public void testDeberiaInicializarseConUnaProbabilidadCero(){
		
		this.unVehiculo = new Vehiculo();
		assertTrue(unVehiculo.getProbabilidadDeSerDetenidoPorControlPolicial() == 0 );
		
	}

	@Test
	public void testDeberiaInicializarseConUnaProbabilidadCeroPuntoUno(){
		
		this.crearVehiculoConProbabilidadCeroPuntoUno();
		assertTrue(unVehiculo.getProbabilidadDeSerDetenidoPorControlPolicial() ==  0.1 );
		
	}
}
