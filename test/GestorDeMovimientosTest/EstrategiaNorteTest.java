package GestorDeMovimientosTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.StringVacioException;
import GestorDeMovimientos.EstrategiaNorte;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Moto;

public class EstrategiaNorteTest {
	
	private Moto unaMoto;
	private Posicion unaPosicion;
	
	@Test
	public void testEstrategiaNorteMantuvoLaPosicionColumna(){
		EstrategiaNorte unaEstrategia = new EstrategiaNorte();
		Tablero unTablero = new Tablero(4,4);
		this.inicializarJugadorConMotoYPosicion11();
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
		this.inicializarJugadorConMotoYPosicion11();
		try {
			unaEstrategia.realizarMovimiento(unaMoto, unTablero.getEsquinaEn(unaPosicion));
		} catch (MovimientoFisicamenteInvalidoException e) {
			//no va a entrar aca
		}
		assertTrue(unaMoto.getPosicion().getFila()==0);
	}
	
	private void inicializarJugadorConMotoYPosicion11(){
		this.unaPosicion = new Posicion(1,1);
		this.unaMoto = new Moto(unaPosicion);
		try {
			Jugador unJug = new Jugador("pepe",this.unaMoto);
		} catch (StringVacioException e) {
			//no va a entrar aca
			e.printStackTrace();
		}
	}
}
