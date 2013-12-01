package JuegoTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import Excepciones.JugadorNoCargadoException;
import Excepciones.NombreInvalidoException;
import Excepciones.NivelInvalidoException;
import Excepciones.VehiculoInvalidoException;
import Excepciones.PartidaEnJuegoException;
import Juego.Juego;

public class JuegoTest {

	private Juego unJuego;
	
	private void inicializarJuegoConJugador(){
		this.unJuego = new Juego();
		
		try {
			this.unJuego.setJugador("Pepe");
		} catch (NombreInvalidoException e) {
			// No ingresa aqu� porque fu� bien inicializado.
		}
		
	}
	
	private void inicializarJuegoConJugadorYPartida(){
		this.unJuego = new Juego();
		
		try {
			this.unJuego.setJugador("Pepe");
		} catch (NombreInvalidoException e1) {
			// No ingresa aqu� porque fu� bien inicializado.
		}
		
		try {
			this.unJuego.iniciarPartida(1, 1);
		} catch (PartidaEnJuegoException e) {
			// No ingresa aqu� porque fu� bien inicializado.
		} catch (NivelInvalidoException e) {
			// No ingresa aqu� porque fu� bien inicializado.
		} catch (VehiculoInvalidoException e) {
			// No ingresa aqu� porque fu� bien inicializado.
		} catch (JugadorNoCargadoException e) {
			// No ingresa aqu� porque fu� bien inicializado.
		}
		
	}
	
	private ArrayList<String> listaConNombresDeNivelesNumerados(){
		// Devuelve la lista que deber� devolver el m�todo
		// getListaNombreNivelesConNumero
		
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("1. Nivel Facil");
		return lista;
	}

	private ArrayList<String> listaConNombresDeVehiculosNumerados(){
		// Devuelve la lista que deber� devolver el m�todo
		// getListaNombresNumeradosVehiculosDisponibles.
		
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("1. Auto");
		lista.add("2. Moto");
		lista.add("3. 4x4");
		return lista;
	}
	
	@Test
	public void testJuegoSeInicializa() {
		Juego unJuego = new Juego();
		assertTrue( unJuego != null);
	}

	@Test
	public void testJuegoSeInicializaSinJugadorActivo(){
		Juego unJuego = new Juego();
		assertTrue( !unJuego.hayJugadorActivo() );
	}
	
	@Test
	public void testJuegoSeInicializaSinPartidaActiva(){
		Juego unJuego = new Juego();
		assertTrue( !unJuego.hayPartidaActiva() );
	}
	
	@Test
	public void testJuegoLuegoDeInicializarJugadorTieneJugadorActivo(){
		this.inicializarJuegoConJugador();
		assertTrue( unJuego.hayJugadorActivo() );
	}
	
	@Test
	public void testJuegoLuegoDeInicializarPartidaTienePartidaActiva(){
		this.inicializarJuegoConJugadorYPartida();
		assertTrue( unJuego.hayPartidaActiva() );
	}
	
	@Test
	public void testJuegoLuegoDeInicializarJugadorYPartidaTieneJugadorActivo(){
		this.inicializarJuegoConJugadorYPartida();
		assertTrue( unJuego.hayJugadorActivo() );
	}
	
	@Test
	public void testJuegoLuegoDeInicializarJugadorNoTienePartidaActiva(){
		this.inicializarJuegoConJugador();
		assertTrue( !unJuego.hayPartidaActiva() );
	}
	
	@Test
	public void testJuegoDevuelveBienListaDeNombresDeNivelesYNumerados(){
		Juego unJuego = new Juego();
		ArrayList<String> lista1 = unJuego.getListaNombreNivelesConNumero();
		ArrayList<String> lista2 = this.listaConNombresDeNivelesNumerados();
		assertEquals(lista1, lista2);
	}
	
	@Test
	public void testJuegoDevuelveBienListaDeNombresDeVehiculosYNumerados(){
		Juego unJuego = new Juego();
		ArrayList<String> lista1 = unJuego.getListaNombresNumeradosVehiculosDisponibles();
		ArrayList<String> lista2 = this.listaConNombresDeVehiculosNumerados();
		assertEquals(lista1, lista2);
	}

	
}
