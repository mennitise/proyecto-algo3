package GestorDeMovimientosTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Excepciones.StringVacioException;
import GestorDeMovimientos.EstrategiaEste;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Moto;

public class EstrategiaEsteTest {

	private Moto unaMoto;
	private Posicion unaPosicion;
	
	@Test
	public void testEstrategiaEsteMantuvoLaPosicionFila() throws PasoImpedidoException{
		EstrategiaEste unaEstrategia = new EstrategiaEste();
		Tablero unTablero = new Tablero(4,4);
		this.inicializarJugadorConMotoYPosicion11();
		try {
			unaEstrategia.realizarMovimiento(unaMoto, unTablero.getEsquinaEn(this.unaPosicion));
		} catch (MovimientoFisicamenteInvalidoException e) {
			//no va a entrar aca
		}
		assertTrue(unaMoto.getPosicion().getFila()==1);
	}
	
	@Test
	public void testEstrategiaEsteCambioPosicionColumna() throws PasoImpedidoException{
		EstrategiaEste unaEstrategia = new EstrategiaEste();
		Tablero unTablero = new Tablero(4,4);
		this.inicializarJugadorConMotoYPosicion11();
		try {
			unaEstrategia.realizarMovimiento(unaMoto, unTablero.getEsquinaEn(this.unaPosicion));
		} catch (MovimientoFisicamenteInvalidoException e) {
			//no va a entrar aca
		}
		assertTrue(unaMoto.getPosicion().getColumna()==2);
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
