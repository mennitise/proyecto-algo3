package PruebasDeIntegracion;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Excepciones.NumeroNegativoException;
import Excepciones.StringVacioException;
import GestorDeMovimientos.EstrategiaEste;
import GestorDeMovimientos.EstrategiaNorte;
import GestorDeMovimientos.EstrategiaOeste;
import GestorDeMovimientos.EstrategiaSur;
import GestorDeMovimientos.GestorDeMovimientos;
import Jugador.Jugador;
import Obstaculos.Obstaculo;
import Obstaculos.Piquete;
import Obstaculos.Pozo;
import Sorpresas.Sorpresa;
import Sorpresas.SorpresaCambioDeVehiculo;
import Sorpresas.SorpresaDesfavorable;
import Sorpresas.SorpresaFavorable;
import Tablero.Esquina;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

public class IntegracionJugabilidadTableroTest {
	private Jugador unJugador;
	private Esquina esquinaInicial;
	private EstrategiaSur unaEstrategiaSur; 
	private EstrategiaNorte unaEstrategiaNorte; 
	private EstrategiaOeste unaEstrategiaOeste; 
	private EstrategiaEste unaEstrategiaEste;
	private GestorDeMovimientos unGestor;
	private Tablero unTablero;
	private Posicion unaPosicion;
	private SorpresaCambioDeVehiculo unaSorpresaCambioDeVehiculo;
	private SorpresaFavorable unaSorpresaFavorable;
	private SorpresaDesfavorable unaSorpresaDesfavorable;
	
	@Test
	public void testCruzarCalleAlEsteConPozoDeberiaPenalizarCorrectamenteAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlEste(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() + 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 3 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 4);
	}
	@Test
	public void testCruzarCalleAlEsteConPozoDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlEste(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() + 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 3 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 4);
	}
	@Test
	public void testCruzarCalleAlEsteConPozoNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlEste(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() + 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
	}
	@Test
	public void testCruzarCalleAlOesteConPozoDeberiaPenalizarCorrectamenteAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlOeste(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() - 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 3 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 4);
	}
	@Test
	public void testCruzarCalleAlOesteConPozoDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlOeste(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() - 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 3 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3 + 1);
	}
	@Test
	public void testCruzarCalleAlOesteConPozoNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlOeste(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() - 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
	}
	@Test
	public void testCruzarCalleAlNorteConPozoDeberiaPenalizarCorrectamenteAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlNorte(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() - 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 3 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 4);
	}
	@Test
	public void testCruzarCalleAlNorteConPozoDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlNorte(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() - 1, this.unGestor.getPosicionActual().getColumna());
		unGestor.moverVehiculo(unaEstrategiaNorte);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 3 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 4);
	}
	@Test
	public void testCruzarCalleAlNorteConPozoNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlNorte(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() - 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
	}
	@Test
	public void testCruzarCalleAlSurConPozoDeberiaPenalizarCorrectamenteAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlSur(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());	
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 3 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 4);
	}
	@Test
	public void testCruzarCalleAlSurConPozoDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlSur(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 3 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 4);
	}
	@Test
	public void testCruzarCalleAlSurConPozoNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlSur(unPozo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
	}

	@Test
	public void testLasCallesNoTienenManoYContramano(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Posicion posicionInicial = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionInicial));
	}
	
	@Test
	public void testVehiculoTomaPrimeroSorpresaYLuegoObstaculo(){
		this.inicializarJugadorPepeConAutoYTantosMovimientos(10);
		this.inicializarEstrategias();
		this.inicializarGestor();
		Posicion posicionInicial = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlEste(unPiquete);
		this.inicializarSorpresas();
		this.colocarSorpresaAlEste(this.unaSorpresaFavorable);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		
		
		// Tomo la sorpresa y le resto 2 movimientos
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 8);
		
		// Luego se encontro con el ControlPolicial y no logro pasar
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionInicial));
	}
	
	
	@Test
	public void testNoDeberiaCruzarCalleAlEsteConPiqueteNoDeberiaPenalizarAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlEste(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testCruzarCalleAlEsteConPiqueteDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlEste(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() + 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 2 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlEsteConPiqueteNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlEste(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlOesteConPiqueteNoDeberiaPenalizarAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlOeste(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testCruzarCalleAlOesteConPiqueteDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlOeste(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() - 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 2 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlOesteConPiqueteNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlOeste(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlNorteConPiqueteNoDeberiaPenalizarAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlNorte(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testCruzarCalleAlNorteConPiqueteDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlNorte(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() - 1, this.unGestor.getPosicionActual().getColumna());
		unGestor.moverVehiculo(unaEstrategiaNorte);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		//2 movimientos de penalizacion y 1 del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlNorteConPiqueteNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlNorte(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}	
	@Test
	public void testNoDeberiaCruzarCalleAlSurConPiqueteNoDeberiaPenalizarAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlSur(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}	
	@Test
	public void testCruzarCalleAlSurConPiqueteDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlSur(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		// 2 movimientos de penalizacion, 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlSurConPiqueteNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlSur(unPiquete);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	

	
	
	
	@Test
	public void testDeberiaCambiarLaMotoPorUnAutoYAvanzarHaciaElSur() {
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlSur(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == Auto.class);
	}
	@Test
	public void testDeberiaCambiarLaMotoPorUnAutoYAvanzarHaciaElNorte() {
		this.inicializarJugadorPepeConMoto();
		this.inicializarSorpresas();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlNorte(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() - 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == Auto.class);
	}
	@Test
	public void testDeberiaCambiarLaMotoPorUnAutoYAvanzarHaciaElEste() {
		this.inicializarJugadorPepeConMoto();
		this.inicializarSorpresas();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlEste(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() + 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == Auto.class);
	}
	@Test
	public void testDeberiaCambiarLaMotoPorUnAutoYAvanzarHaciaElOeste() {
		this.inicializarJugadorPepeConMoto();
		this.inicializarSorpresas();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlOeste(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() - 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == Auto.class);
	}
	
	@Test
	public void testDeberiaCambiarElAutoPorUnaCuatroXCuatroYAvanzarHaciaElSur() {
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlSur(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == CuatroXCuatro.class);
	}
	@Test
	public void testDeberiaCambiarElAutoPorUnaCuatroXCuatroYAvanzarHaciaElNorte() {
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlNorte(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() - 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == CuatroXCuatro.class);
	}
	@Test
	public void testDeberiaCambiarElAutoPorUnaCuatroXCuatroYAvanzarHaciaElEste() {
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlEste(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() + 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == CuatroXCuatro.class);
	}
	@Test
	public void testDeberiaCambiarElAutoPorUnaCuatroXCuatroYAvanzarHaciaElOeste() {
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlOeste(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() - 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == CuatroXCuatro.class);
	}
		
	@Test
	public void testDeberiaCambiarLaCuatroXCuatroPorUnaMotoYAvanzarHaciaElSur() {
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlSur(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == Moto.class);
	}
	@Test
	public void testDeberiaCambiarLaCuatroXCuatroPorUnaMotoYAvanzarHaciaElNorte() {
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlNorte(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() - 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == Moto.class);
	}
	@Test
	public void testDeberiaCambiarLaCuatroXCuatroPorUnaMotoYAvanzarHaciaElEste() {
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlEste(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() + 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == Moto.class);
	}
	@Test
	public void testDeberiaCambiarLaCuatroXCuatroPorUnaMotoYAvanzarHaciaElOeste() {
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlOeste(this.unaSorpresaCambioDeVehiculo);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila(), this.unGestor.getPosicionActual().getColumna() - 1);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
		assertTrue(this.unJugador.getVehiculo().getClass() == Moto.class);
	}
	
	
	
	
	@Test
	public void testDeberiaAplicarSorpresaFavorableAUnAutoCon0MovimientosYAvanzarHaciaElSur() {
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlSur(this.unaSorpresaFavorable);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		//solo se suma el movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
	}	
	@Test
	public void testDeberiaAplicarSorpresaFavorableAUnAutoCon3MovimientosYAvanzarHaciaElSur() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(3);
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlSur(this.unaSorpresaFavorable);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		//se le resto 1 movimiento y sele suma 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testDeberiaAplicarSorpresaFavorableAUnAutoCon8MovimientosYAvanzarHaciaElSur() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(7);
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlSur(this.unaSorpresaFavorable);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		//se le resto 2 movimiento y sele suma 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 7);
	}
	
	@Test
	public void testDeberiaAplicarSorpresaDesfavorableAUnAutoCon0MovimientosYAvanzarHaciaElSur() {
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlSur(this.unaSorpresaDesfavorable);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		//solo se suma el movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 1);
	}	
	@Test
	public void testDeberiaAplicarSorpresaDesfavorableAUnAutoCon2MovimientosYAvanzarHaciaElSur() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(2);
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlSur(this.unaSorpresaDesfavorable);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		//se le sumo 1 movimiento y sele suma 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 4);
	}
	@Test
	public void testDeberiaAplicarSorpresaDesfavorableAUnAutoCon6MovimientosYAvanzarHaciaElSur() {
		this.inicializarJugadorPepeConAutoYTantosMovimientos(6);
		this.inicializarEstrategias();
		this.inicializarGestor();
		this.inicializarSorpresas();
		this.colocarSorpresaAlSur(this.unaSorpresaDesfavorable);
		Posicion posicionDestino = new Posicion(this.unGestor.getPosicionActual().getFila() + 1, this.unGestor.getPosicionActual().getColumna());
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unGestor.getPosicionActual().esIgual(posicionDestino));
		//se le sumo 2 movimientos y se le suma 1 mov del movimiento en si
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 9);
	}
	
	
	
	
	
	private void inicializarJugadorPepeConAuto(){
		this.unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Auto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	private void inicializarJugadorPepeConMoto(){
		this.unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Moto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	private void inicializarJugadorPepeConCuatroXCuatro(){
		this.unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new CuatroXCuatro(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}	
	private void inicializarJugadorPepeConAutoYTantosMovimientos(int numMovimientos){
		this.unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Auto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
		try {
			this.unJugador.sumarMovimientos(numMovimientos);
		} catch (NumeroNegativoException e) {
			assertTrue(false);
		}
	}
	private void inicializarGestor(){
		this.unTablero = new Tablero(4,4);
		//unJugador ya debe estar inicializado
		this.unGestor = new GestorDeMovimientos(unJugador,unTablero);
	}
	
	private void colocarSorpresaAlEste(Sorpresa unaSorpresa) {
		this.esquinaInicial = this.unTablero.getEsquinaEn(this.unaPosicion);
		this.esquinaInicial.getCalleEste().agregarSorpresa(unaSorpresa);
	}
	private void colocarSorpresaAlOeste(Sorpresa unaSorpresa) {
		this.esquinaInicial = this.unTablero.getEsquinaEn(this.unaPosicion);
		this.esquinaInicial.getCalleOeste().agregarSorpresa(unaSorpresa);
	}
	private void colocarSorpresaAlNorte(Sorpresa unaSorpresa) {
		this.esquinaInicial = this.unTablero.getEsquinaEn(this.unaPosicion);
		this.esquinaInicial.getCalleNorte().agregarSorpresa(unaSorpresa);
	}
	private void colocarSorpresaAlSur(Sorpresa unaSorpresa) {
		this.esquinaInicial = this.unTablero.getEsquinaEn(this.unaPosicion);
		this.esquinaInicial.getCalleSur().agregarSorpresa(unaSorpresa);
	}
	
	private void colocarObstaculoAlEste(Obstaculo unObstaculo) {
		this.esquinaInicial = this.unTablero.getEsquinaEn(this.unaPosicion);
		this.esquinaInicial.getCalleEste().agregarObstaculo(unObstaculo);
	}
	private void colocarObstaculoAlOeste(Obstaculo unObstaculo) {
		this.esquinaInicial = this.unTablero.getEsquinaEn(this.unaPosicion);
		this.esquinaInicial.getCalleOeste().agregarObstaculo(unObstaculo);
	}
	private void colocarObstaculoAlNorte(Obstaculo unObstaculo) {
		this.esquinaInicial = this.unTablero.getEsquinaEn(this.unaPosicion);
		this.esquinaInicial.getCalleNorte().agregarObstaculo(unObstaculo);
	}
	private void colocarObstaculoAlSur(Obstaculo unObstaculo) {
		this.esquinaInicial = this.unTablero.getEsquinaEn(this.unaPosicion);
		this.esquinaInicial.getCalleSur().agregarObstaculo(unObstaculo);
	}
	
	private void inicializarEstrategias() {
		this.unaEstrategiaSur = new EstrategiaSur(); 
		this.unaEstrategiaNorte = new EstrategiaNorte(); 
		this.unaEstrategiaOeste = new EstrategiaOeste(); 
		this.unaEstrategiaEste = new EstrategiaEste();
	}
	private void inicializarSorpresas(){
		this.unaSorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		this.unaSorpresaFavorable = new SorpresaFavorable();
		this.unaSorpresaDesfavorable = new SorpresaDesfavorable();
		
	}
}
