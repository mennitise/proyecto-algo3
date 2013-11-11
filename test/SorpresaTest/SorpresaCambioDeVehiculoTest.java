package SorpresaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.StringVacioException;
import Jugador.Jugador;
import Sorpresas.SorpresaCambioDeVehiculo;
import Tablero.Posicion;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

public class SorpresaCambioDeVehiculoTest {
	private Jugador unJugador;
	private SorpresaCambioDeVehiculo unaSorpresaCambioDeVehiculo;
	
	@Test
	public void testDeberiaCambiarLaMotoPorUnAuto() {
		this.inicializarJugadorPepeConMoto();
		this.inicializarSorpresaCambioDeVehiculo();
		this.unJugador.getVehiculo().interactuarCon(unaSorpresaCambioDeVehiculo);
		assertTrue(this.unJugador.getVehiculo().getClass() == Auto.class);
	}
	@Test
	public void testDeberiaCambiarElAutoPorUnaCuatroXCuatro() {
		this.inicializarJugadorPepeConAuto();
		this.inicializarSorpresaCambioDeVehiculo();
		this.unJugador.getVehiculo().interactuarCon(unaSorpresaCambioDeVehiculo);
		assertTrue(this.unJugador.getVehiculo().getClass() == CuatroXCuatro.class);
	}
	@Test
	public void testDeberiaCambiarLaCuatroXCuatroPorUnaMoto() {
		this.inicializarJugadorPepeConCuatroXCuatro();
		this.inicializarSorpresaCambioDeVehiculo();
		this.unJugador.getVehiculo().interactuarCon(unaSorpresaCambioDeVehiculo);
		assertTrue(this.unJugador.getVehiculo().getClass() == Moto.class);
	}
	
	private void inicializarJugadorPepeConAuto(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Auto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	private void inicializarJugadorPepeConMoto(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Moto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	private void inicializarJugadorPepeConCuatroXCuatro(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new CuatroXCuatro(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	private void inicializarSorpresaCambioDeVehiculo(){
		unaSorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
	}
	
}
