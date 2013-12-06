package GestorDeMovimientosTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Excepciones.StringVacioException;
import GestorDeMovimientos.EstrategiaSur;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Moto;

public class EstrategiaSurTest {
	private Moto unaMoto;
	private Posicion unaPosicion;
	
	@Test
	public void testEstrategiaSurMantuvoLaPosicionColumna() throws PasoImpedidoException{
		EstrategiaSur unaEstrategia = new EstrategiaSur();
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
	public void testEstrategiaSurCambioPosicionFila() throws PasoImpedidoException{
		EstrategiaSur unaEstrategia = new EstrategiaSur();
		Tablero unTablero = new Tablero(4,4);
		this.inicializarJugadorConMotoYPosicion11();
		try {
			unaEstrategia.realizarMovimiento(unaMoto, unTablero.getEsquinaEn(unaPosicion));
		} catch (MovimientoFisicamenteInvalidoException e) {
			//no va a entrar aca
		}
		assertTrue(unaMoto.getPosicion().getFila()==2);
	}
	
	private void inicializarJugadorConMotoYPosicion11(){
		this.unaPosicion = new Posicion(1,1);
		this.unaMoto = new Moto(unaPosicion);
		
		try {
			this.unaMoto.setConductor(new Jugador("pepe",this.unaMoto));
		} catch (StringVacioException e) {
			//no va a entrar aca
			e.printStackTrace();
		}
	}
}
