package GestorDeMovimientosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.PosicionInvalidaException;
import GestorDeMovimientos.GestorDeMovimientos;
import Tablero.Tablero;

public class GestorDeMovimientosTest {

	private GestorDeMovimientos unGestor;
	
	private void inicializarGestor(){
		Tablero unTablero = new Tablero(4,4,0);
		int filaOrigen     = 1; 
		int columnaOrigen  = 1;
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
	
	

}
