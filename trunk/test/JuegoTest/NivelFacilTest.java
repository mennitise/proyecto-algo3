package JuegoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Juego.NivelFacil;
import Tablero.Posicion;
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
		Posicion posicionVehiculo = new Posicion(5,0);
		assertTrue( unNivel.getPosicionInicialDelVehiculo().esIgual(posicionVehiculo) );
	}

	/*
	@Test
	public void testNivelFacilSeInicializaBienConPosicionDeLlegada() {
		NivelFacil unNivel = new NivelFacil();
		Posicion posicionLlegada = new Posicion(5,9);
		assertTrue( unNivel.getPosicionDeLaLlegada().esIgual(posicionLlegada) );
		
	}
	*/
	
	@Test
	public void testNivelFacilSeInicializaBienLasMedidasDelTablero() {
		NivelFacil unNivel = new NivelFacil();
		Tablero unTablero = unNivel.inicializarTablero();
		assertTrue( unTablero.getColumnas() == 10 );
		assertTrue( unTablero.getFilas()    == 10 );
	}
}
