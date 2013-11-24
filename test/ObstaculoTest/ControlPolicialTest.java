package ObstaculoTest;

import static org.junit.Assert.*;
import Excepciones.PasoImpedidoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Obstaculos.ControlPolicial;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

import org.junit.Test;

public class ControlPolicialTest {

	@Test
	public void testControlPolicialComprobarPorcentajeParaElAuto(){

		Auto unAuto = new Auto();
		Jugador unJugador = null;
		try {
			unJugador = new Jugador("Pepe", null);
		} catch (StringVacioException e1) {
			// No ingresa.
		}
		unAuto.setConductor(unJugador);

		ControlPolicial unControl = new ControlPolicial();
		
		for(int i = 0; i < 1000; i++){
			try {
				unControl.interactuarCon(unAuto);
			} catch (PasoImpedidoException e2) {
				// No ingresa. 
			}
		}
		
		// Deberán ser aproximadamente 1000 penalizaciones.
		int penalizacionesMinimas = 900;
		int penalizacionesMaximas = 1100;
		
		assertTrue(unJugador.getCantidadDeMovimientos() > penalizacionesMinimas);
		assertTrue(unJugador.getCantidadDeMovimientos() < penalizacionesMaximas);
	}
	
	@Test
	public void testControlPolicialComprobarPorcentajeParaLaMoto(){

		Moto unaMoto = new Moto();
		Jugador unJugador = null;
		try {
			unJugador = new Jugador("Pepe", null);
		} catch (StringVacioException e1) {
			// No ingresa.
		}
		unaMoto.setConductor(unJugador);

		ControlPolicial unControl = new ControlPolicial();
		
		for(int i = 0; i < 1000; i++){
			unControl.interactuarCon(unaMoto);
		}
		
		// Deberán ser aproximadamente 1600 penalizaciones.
		int penalizacionesMinimas = 1500;
		int penalizacionesMaximas = 1700;
		
		assertTrue(unJugador.getCantidadDeMovimientos() > penalizacionesMinimas);
		assertTrue(unJugador.getCantidadDeMovimientos() < penalizacionesMaximas);
	}
	
	@Test
	public void testControlPolicialComprobarPorcentajeParaLaCuatroXCuatro(){

		CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro();
		Jugador unJugador = null;
		try {
			unJugador = new Jugador("Pepe", null);
		} catch (StringVacioException e1) {
			// No ingresa.
		}
		unaCuatroXCuatro.setConductor(unJugador);

		ControlPolicial unControl = new ControlPolicial();
		
		for(int i = 0; i < 1000; i++){
			try {
				unControl.interactuarCon(unaCuatroXCuatro);
			} catch (PasoImpedidoException e) {
				// No ingresa.
			}
		}
		
		// Deberán ser aproximadamente 600 penalizaciones.
		int penalizacionesMinimas = 500;
		int penalizacionesMaximas = 700;
		
		assertTrue(unJugador.getCantidadDeMovimientos() > penalizacionesMinimas);
		assertTrue(unJugador.getCantidadDeMovimientos() < penalizacionesMaximas);
	}

}
