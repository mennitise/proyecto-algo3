package JuegoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.StringVacioException;
import Excepciones.TerminoLaPartidaException;
import Juego.NivelFacil;
import Juego.Partida;
import Jugador.Jugador;
import Vehiculos.Moto;

public class PartidaTest {

	private Partida unaPartida;
	
	private void inicializarPartidaConJugadorPepeConMotoYNivelFacil(){
		Jugador unJugador = null;
		
		try {
			unJugador = new Jugador("Pepe", new Moto());
		} catch (StringVacioException e) {
			// No ingresa aca.
		}
		
		this.unaPartida = new Partida(unJugador, new NivelFacil());
		
	}
	
	@Test
	public void testPartidaCrear() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacil();
		assertTrue(this.unaPartida != null);
	}
	
	@Test
	public void testPartidaGuardaElJugadorCorrecto() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacil();
		assertTrue(this.unaPartida.getNombreJugador() == "Pepe");
	}
	
	@Test
	public void testPartidaInicializoLaPosicionDelVehiculo() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacil();
		assertTrue(this.unaPartida.getPosicionJugador() != null);
	}
	
	@Test
	public void testPartidaInicializoLaPosicionDelVehiculoCorrectamente() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacil();
		NivelFacil nivelAux = new NivelFacil(); 
		assertTrue(this.unaPartida.getPosicionJugador().esIgual(nivelAux.getPosicionInicialDelVehiculo()));
	}
	
	@Test
	public void testJugadorTiene0Movimientos() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacil();
		assertTrue(this.unaPartida.getCantidadDeMovimientosDelJugador() == 0);
	}
	
	@Test
	public void testMovimientoAlSurNoGana() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacil();
		boolean gano = false; 
		try {
			this.unaPartida.moverHaciaElSur();
		} catch (TerminoLaPartidaException e) {
			gano = true;
		}
		assertTrue(!gano);
	}
	
	@Test
	public void testGanasAlLlegarAlfinal() {
		this.inicializarPartidaConJugadorPepeConMotoYNivelFacil();
		boolean ganoAntes = false;
		boolean ganoEnElMomentoCorrecto = false;
		
		for(int i=1;i<=8;i++){	
			try {
				this.unaPartida.moverHaciaElEste();
			} catch (TerminoLaPartidaException e) {
				ganoAntes = true;
			}
		}
		
		try {
			this.unaPartida.moverHaciaElEste();
		} catch (TerminoLaPartidaException e) {
			ganoEnElMomentoCorrecto = true;
		}
		assertTrue(!ganoAntes);
		assertTrue(ganoEnElMomentoCorrecto);
	}
	
	
}
