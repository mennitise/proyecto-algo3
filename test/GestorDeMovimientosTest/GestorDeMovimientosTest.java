package GestorDeMovimientosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.PosicionInvalidaException;
import GestorDeMovimientos.GestorDeMovimientos;
import Tablero.Tablero;
import Vehiculos.Vehiculo;

public class GestorDeMovimientosTest {

	private GestorDeMovimientos unGestor;
	
	private void inicializarGestor(){
		Tablero unTablero = new Tablero(4,4);
		Vehiculo unVehiculo = new Vehiculo();
		int filaOrigen     = 1; 
		int columnaOrigen  = 1;
		
		try {
			unTablero.colocarVehiculoEn(unVehiculo, filaOrigen, columnaOrigen);
		} catch (PosicionInvalidaException e){
			// No ingresa, ya que los parámetros fueron bien inicializados.
		}
		
		try {
			this.unGestor = new GestorDeMovimientos(filaOrigen, columnaOrigen, unTablero);
		} catch (PosicionInvalidaException e){
			// No ingresa, ya que los parámetros fueron bien inicializados.
		}
		
	}
		
	@Test
	public void testGestorDeMovimientosEsPosibleMoverseA() {
		inicializarGestor();
		assertTrue( this.unGestor.esPosibleMoverseA(1,3) );
	}

	@Test
	public void testGestorDeMovimientosMoverVehiculo() {
		inicializarGestor();
		try{
			this.unGestor.moverVehiculoEnPosicionActualA(1,3);
		}catch(PosicionInvalidaException e){
			// No ingresa, ya que los parámetros fueron bien inicializados.
		}
		int filaActual    = this.unGestor.getFilaActual();
		int columnaActual = this.unGestor.getColumnaActual();
		assertTrue( (filaActual == 1) && (columnaActual == 3) );
	}
	
	@Test
	public void testGestorDeMovimientosMoverVehiculoMueveElVehiculo(){
		Tablero unTablero = new Tablero(4,4);
		Vehiculo unVehiculo = new Vehiculo();
		int filaOrigen     = 1; 
		int columnaOrigen  = 1;
		
		try {
			unTablero.colocarVehiculoEn(unVehiculo, filaOrigen, columnaOrigen);
		} catch (PosicionInvalidaException e){
			// No ingresa, ya que los parámetros fueron bien inicializados.
		}
		
		try {
			this.unGestor = new GestorDeMovimientos(filaOrigen, columnaOrigen, unTablero);
		} catch (PosicionInvalidaException e){
			// No ingresa, ya que los parámetros fueron bien inicializados.
		}
		
		try{
			this.unGestor.moverVehiculoEnPosicionActualA(1,3);
		}catch(PosicionInvalidaException e){
			// No ingresa, ya que los parámetros fueron bien inicializados.
		}
		
		assertTrue(unVehiculo == this.unGestor.getVehiculoEnPosicionActual());
	}

}
