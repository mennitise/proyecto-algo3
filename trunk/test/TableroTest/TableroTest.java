package TableroTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Tablero.Posicion;
import Tablero.Tablero;

public class TableroTest {
	private Tablero unTablero;
	private Posicion unaPosicion;
	
	private void inicializarTableroDe4x6(){
		this.unTablero = new Tablero (4,6);
	}
	private void inicializarPosicionCon(int fila,int columna){
		this.unaPosicion = new Posicion(fila,columna);
	}
	
	@Test
 	public void testTableroDevuelveBienLasFilas() {
		this.inicializarTableroDe4x6();
		assertTrue(unTablero.getFilas()==4);
	}
	@Test
	public void testTableroDevuelveBienLasColumnas() {
		this.inicializarTableroDe4x6();
		assertTrue(unTablero.getColumnas()==6);
	}
	
	@Test
	public void testTableroRevisaPosicionValidaEnELCentro() {
		this.inicializarTableroDe4x6();
		assertTrue(unTablero.posicionValida(2,1));
	}
	@Test
	public void testTableroRevisaPosicionValidaEnELCentro2() {
		this.inicializarTableroDe4x6();
		this.inicializarPosicionCon(2, 1);
		assertTrue(unTablero.posicionValida(this.unaPosicion));
	}
	@Test
	public void testTableroRevisaPosicionValidaEsquinaSuperiorIzquierda() {
		this.inicializarTableroDe4x6();
		assertTrue(unTablero.posicionValida(0,0));
	}
	@Test
	public void testTableroRevisaPosicionValidaEsquinaSuperiorIzquierda2() {
		this.inicializarTableroDe4x6();
		this.inicializarPosicionCon(0,0);
		assertTrue(unTablero.posicionValida(this.unaPosicion));
	}
	@Test
	public void testTableroRevisaPosicionValidaEsquinaSuperiorDerecha() {
		this.inicializarTableroDe4x6();
		assertTrue(unTablero.posicionValida(3,5));
	}
	@Test
	public void testTableroRevisaPosicionValidaEsquinaSuperiorDerecha2() {
		this.inicializarTableroDe4x6();
		this.inicializarPosicionCon(3, 5);
		assertTrue(unTablero.posicionValida(this.unaPosicion));
	}
	@Test
	public void testTableroRevisaPosicionValidaEsquinainferiorIzquierda() {
		this.inicializarTableroDe4x6();
		assertTrue(unTablero.posicionValida(3,0));
	}
	@Test
	public void testTableroRevisaPosicionValidaEsquinainferiorIzquierda2() {
		this.inicializarTableroDe4x6();
		this.inicializarPosicionCon(3, 0);
		assertTrue(unTablero.posicionValida(this.unaPosicion));
	}
	@Test
	public void testTableroRevisaPosicionValidaEsquinainferiorDerecha() {
		this.inicializarTableroDe4x6();
		assertTrue(unTablero.posicionValida(3,5));
	}
	@Test
	public void testTableroRevisaPosicionValidaEsquinainferiorDerecha2() {
		this.inicializarTableroDe4x6();
		this.inicializarPosicionCon(3, 5);
		assertTrue(unTablero.posicionValida(this.unaPosicion));
	}

	@Test
	public void testTableroRevisaPosicionFueraDeRangoBordeIzquierdo() {
		this.inicializarTableroDe4x6();
		assertTrue(!unTablero.posicionValida(1,-1));
	}
	@Test
	public void testTableroRevisaPosicionFueraDeRangoBordeIzquierdo2() {
		this.inicializarTableroDe4x6();
		this.inicializarPosicionCon(1,-1);
		assertTrue(!unTablero.posicionValida(this.unaPosicion));
	}
	@Test
	public void testTableroRevisaPosicionFueraDeRangoBordeDerecho() {
		this.inicializarTableroDe4x6();
		assertTrue(!unTablero.posicionValida(2,6));
	}
	@Test
	public void testTableroRevisaPosicionFueraDeRangoBordeDerecho2() {
		this.inicializarTableroDe4x6();
		this.inicializarPosicionCon(2, 6);
		assertTrue(!unTablero.posicionValida(this.unaPosicion));
	}
	@Test
	public void testTableroRevisaPosicionFueraDeRangoBordeSuperior() {
		this.inicializarTableroDe4x6();
		assertTrue(!unTablero.posicionValida(-1,5));
	}
	@Test
	public void testTableroRevisaPosicionFueraDeRangoBordeSuperior2() {
		this.inicializarTableroDe4x6();
		this.inicializarPosicionCon(-1, 5);
		assertTrue(!unTablero.posicionValida(this.unaPosicion));
	}
	public void testTableroRevisaPosicionFueraDeRangoBordeInferior() {
		this.inicializarTableroDe4x6();
		assertTrue(!unTablero.posicionValida(4,5));
	}
	@Test
	public void testTableroRevisaPosicionFueraDeRangoBordeInferior2() {
		this.inicializarTableroDe4x6();
		this.inicializarPosicionCon(4, 5);
		assertTrue(!unTablero.posicionValida(this.unaPosicion));
	}

}