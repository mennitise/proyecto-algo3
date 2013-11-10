package GestorDeMovimientosTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Excepciones.MovimientoFisicamenteInvalidoException;
import GestorDeMovimientos.EstrategiaNorte;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Moto;

public class EstrategiaNorteTest {
	@Test
	public void testEstrategiaNorteMantuvoLaPosicionColumna(){
		EstrategiaNorte unaEstrategia = new EstrategiaNorte();
		Tablero unTablero = new Tablero(4,4);
		Posicion unaPosicion = new Posicion(1,1);
		Moto unaMoto = new Moto(unaPosicion);
		try {
			unaEstrategia.realizarMovimiento(unaMoto, unTablero.getEsquinaEn(unaPosicion));
		} catch (MovimientoFisicamenteInvalidoException e) {
			//no va a entrar aca
		}
		assertTrue(unaMoto.getPosicion().getColumna()==1);
	}
	
	@Test
	public void testEstrategiaNorteCambioPosicionFila(){
		EstrategiaNorte unaEstrategia = new EstrategiaNorte();
		Tablero unTablero = new Tablero(4,4);
		Posicion unaPosicion = new Posicion(1,1);
		Moto unaMoto = new Moto(unaPosicion);
		try {
			unaEstrategia.realizarMovimiento(unaMoto, unTablero.getEsquinaEn(unaPosicion));
		} catch (MovimientoFisicamenteInvalidoException e) {
			//no va a entrar aca
		}
		assertTrue(unaMoto.getPosicion().getFila()==0);
	}
}
