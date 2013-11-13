package JuegoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Juego.NivelFacil;
import Tablero.Tablero;

public class NivelFacilTest {

	@Test
	public void testNivelFacilSeInicializa() {
		NivelFacil unNivel = new NivelFacil();
		assertTrue( unNivel != null );
	}
	
	@Test
	public void testNivelFacilSeInicializaBienConPosicionInicialDelVehiculo() {
		NivelFacil unNivel = new NivelFacil();
		assertTrue( unNivel.getPosicionInicialDelVehiculo().getColumna() == 0 );
		assertTrue( unNivel.getPosicionInicialDelVehiculo().getFila() == 5 );
	}

	@Test
	public void testNivelFacilSeInicializaBienConPosicionDeLlegada() {
		NivelFacil unNivel = new NivelFacil();
		assertTrue( unNivel.getPosicionDeLaLlegada().getColumna() == 9 );
		assertTrue( unNivel.getPosicionDeLaLlegada().getFila() == 5 );
	}
	
	@Test
	public void testNivelFacilSeInicializaBienLasMedidasDelTablero() {
		NivelFacil unNivel = new NivelFacil();
		Tablero unTablero = unNivel.inicializarTablero();
		assertTrue( unTablero.getColumnas() == 10 );
		assertTrue( unTablero.getFilas()    == 10 );
	}
}
