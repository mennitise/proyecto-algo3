package JuegoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Excepciones.StringVacioException;
import GestorDeMovimientos.EstrategiaEste;
import GestorDeMovimientos.EstrategiaSur;
import GestorDeMovimientos.GestorDeMovimientos;
import Niveles.Nivel;
import Niveles.NivelFacil;
import Juego.Partida;
import Jugador.Jugador;
import Vehiculos.Moto;

public class PartidaTest {

	private Partida unaPartida;
	private Jugador unJugador;
	private GestorDeMovimientos unGestor;
	private Nivel unNivel;
	
	private void inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor(){
		try {
			this.unJugador = new Jugador("Pepe", new Moto());
		} catch (StringVacioException e) {
			// No ingresa aca.
		}
		this.unNivel = new NivelFacil();
		this.unaPartida = new Partida(unJugador, this.unNivel);	
		this.unGestor = new GestorDeMovimientos(unJugador, this.unaPartida.getTablero());
	}
	
	
	
	@Test
	public void testPartidaCrear() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		assertTrue(this.unaPartida != null);
	}
	
	@Test
	public void testPartidaGuardaElJugadorCorrecto() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		assertTrue(this.unaPartida.getNombreJugador() == "Pepe");
	}
	
	@Test
	public void testPartidaInicializoLaPosicionDelVehiculo() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		assertTrue(this.unaPartida.getPosicionJugador() != null);
	}
	
	@Test
	public void testPartidaInicializoLaPosicionDelVehiculoCorrectamente() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		assertTrue(this.unaPartida.getPosicionJugador().esIgual(this.unNivel.getPosicionInicialDelVehiculo()));
	}
	
	@Test
	public void testJugadorTiene0Movimientos() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		assertTrue(this.unaPartida.getCantidadDeMovimientosDelJugador() == 0);
	}
	
	@Test
	public void testNoGanaAlInicio() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		assertTrue(!this.unaPartida.ganoLaPartida());
	}
	
	@Test
	public void testNoGanaConUnMovimiento() throws PasoImpedidoException {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		try {
			this.unGestor.moverVehiculo(new EstrategiaEste());
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(!this.unaPartida.ganoLaPartida());
	}
	
	/* @Test
	public void testGanasAlLlegarAlfinal() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		boolean ganoAntes = false;
		boolean ganoEnElMomentoCorrecto = false;
		
		for(int i=1;i<=8;i++){	
			try {
				this.unGestor.moverVehiculo(new EstrategiaEste());
			} catch (MovimientoFisicamenteInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.unaPartida.ganoLaPartida()){
				ganoAntes = true;
			}
		}
		
		try {
			this.unGestor.moverVehiculo(new EstrategiaEste());
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.unaPartida.ganoLaPartida()){
			ganoEnElMomentoCorrecto = true;
		}
		assertTrue(!ganoAntes);
		assertTrue(ganoEnElMomentoCorrecto);
	}
	*/
	
	@Test
	public void testNopierdeAlInicio() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		assertTrue(!this.unaPartida.perdioLaPartida());
	}
	
	@Test
	public void testNoPierdeConUnMovimiento() throws PasoImpedidoException {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
		try {
			this.unGestor.moverVehiculo(new EstrategiaSur());
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(!this.unaPartida.perdioLaPartida());
	}
	
//	@Test
//	public void testPierdeAlRealizarMasMovimientosDeLosPermitidos() {
//		this.inicializarPartidaConJugadorPepeConMotoYNivelFacilYGestor();
//		
//		/* Se moverá de este a oeste y viceversa sucesivamente  *
//		 * en esa calle hay un Piquete que le suma 2 movimentos *
//		 * mas el movimiento en si serán 3 movimentos asignados *
//		 *  por cada movimiento físico, por lo tanto en cada    * 
//		 *           iteracion sumara 6 movimientos.            *
//		 *    (6 * 6 = 36) siendo 35 en limite de movimientos   */
//		for(int i = 1; i <= 6; i++){
//			try {
//				this.unGestor.moverVehiculo(new EstrategiaEste());
//			} catch (MovimientoFisicamenteInvalidoException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			try {
//				this.unGestor.moverVehiculo(new EstrategiaOeste());
//			} catch (MovimientoFisicamenteInvalidoException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		assertTrue(this.unaPartida.perdioLaPartida());
//	}
}
