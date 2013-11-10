package PruebasDeIntegracion;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
	
	
	@Test
	public void testCruzarCalleAlEsteConPozoDeberiaPenalizarCorrectamenteAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlEste(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 3);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testCruzarCalleAlEsteConPozoDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlEste(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 3);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testCruzarCalleAlEsteConPozoNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlEste(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 3);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testCruzarCalleAlOesteConPozoDeberiaPenalizarCorrectamenteAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlOeste(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 1);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testCruzarCalleAlOesteConPozoDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlOeste(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 1);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testCruzarCalleAlOesteConPozoNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlOeste(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 1);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testCruzarCalleAlNorteConPozoDeberiaPenalizarCorrectamenteAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlNorte(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 0);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testCruzarCalleAlNorteConPozoDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlNorte(unPozo);
		unGestor.moverVehiculo(unaEstrategiaNorte);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 0);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testCruzarCalleAlNorteConPozoNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlNorte(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 0);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testCruzarCalleAlSurConPozoDeberiaPenalizarCorrectamenteAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlSur(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 2);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testCruzarCalleAlSurConPozoDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlSur(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 2);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 3);
	}
	@Test
	public void testCruzarCalleAlSurConPozoNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Pozo unPozo = new Pozo();
		this.colocarObstaculoAlSur(unPozo);
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 2);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}

	
	
	
	@Test
	public void testNoDeberiaCruzarCalleAlEsteConPiqueteNoDeberiaPenalizarAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlEste(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testCruzarCalleAlEsteConPiqueteDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlEste(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 3);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 2);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlEsteConPiqueteNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlEste(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlOesteConPiqueteNoDeberiaPenalizarAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlOeste(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testCruzarCalleAlOesteConPiqueteDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlOeste(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 1);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 2);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlOesteConPiqueteNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlOeste(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlNorteConPiqueteNoDeberiaPenalizarAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlNorte(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	@Test
	public void testCruzarCalleAlNorteConPiqueteDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlNorte(unPiquete);
		unGestor.moverVehiculo(unaEstrategiaNorte);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 0);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 2);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlNorteConPiqueteNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlNorte(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}	
	@Test
	public void testNoDeberiaCruzarCalleAlSurConPiqueteNoDeberiaPenalizarAUnAuto(){
		this.inicializarJugadorPepeConAuto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlSur(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}	
	@Test
	public void testCruzarCalleAlSurConPiqueteDeberiaPenalizarCorrectamenteAUnaMoto(){
		this.inicializarJugadorPepeConMoto();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlSur(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 2);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 2);
	}
	@Test
	public void testNoDeberiaCruzarCalleAlSurConPiqueteNoDeberiaPenalizarAUnaCuatroXCuatro(){
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarEstrategias();
		this.inicializarGestor();
		Piquete unPiquete = new Piquete();
		this.colocarObstaculoAlSur(unPiquete);
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getColumna() == 2);
		assertTrue(this.unJugador.getVehiculo().getPosicion().getFila() == 1);
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
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
	private void inicializarGestor(){
		this.unTablero = new Tablero(4,4);
		//unJugador ya debe estar inicializado
		this.unGestor = new GestorDeMovimientos(unJugador.getVehiculo(),unTablero);
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

}
