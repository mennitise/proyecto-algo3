package ObstaculoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.PasoImpedidoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Obstaculos.Piquete;
import Tablero.Posicion;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

public class PiqueteTest {
	
	private Jugador unJugador;
	private Piquete unPiquete;
	
	private void crearJugadorPepeConAuto(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Auto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	
	private void crearJugadorPepeConCuatroXCuatro(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new CuatroXCuatro(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	
	private void crearJugadorPepeConMoto(){
		Posicion unaPosicion = new Posicion(1,2);
		try {
			this.unJugador = new Jugador("Pepe",new Moto(unaPosicion));
		} catch (StringVacioException e) {
			// No va a entrar nunca aca
		}
	}
	
	private void crearPiquete(){
		this.unPiquete = new Piquete();		
	}
	
	@Test
	public void testPiqueteNoDeberiaDejarPasarAlAuto(){
		this.crearJugadorPepeConAuto();
		this.crearPiquete();
		boolean lanzoException = false;
		try {
			this.unPiquete.interactuarCon((Auto)this.unJugador.getVehiculo());
		} catch (PasoImpedidoException e) {
			lanzoException = true; 
		}
		assertTrue(lanzoException);
	}
	
	@Test
	public void testPiqueteNoDeberiaDejarPasarALaCuatroXCuatro(){
		this.crearJugadorPepeConCuatroXCuatro();
		this.crearPiquete();
		boolean lanzoException = false;
		try {
			this.unPiquete.interactuarCon((CuatroXCuatro)this.unJugador.getVehiculo());
		} catch (PasoImpedidoException e) {
			lanzoException = true; 
		}
		assertTrue(lanzoException);
	}
	
	@Test
	public void testPiqueteNoDeberiaPenalizarAlAuto(){
		this.crearJugadorPepeConAuto();
		this.crearPiquete();
		try {
			this.unPiquete.interactuarCon((Auto)this.unJugador.getVehiculo());
		} catch (PasoImpedidoException e) {
			//Va a entrar pero en este test no importa 
		}
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	
	@Test
	public void testPiqueteNoDeberiaPenalizarALaCuatroXCuatro(){
		this.crearJugadorPepeConCuatroXCuatro();
		this.crearPiquete();
		try {
			this.unPiquete.interactuarCon((CuatroXCuatro)this.unJugador.getVehiculo());
		} catch (PasoImpedidoException e) {
			//Va a entrar pero en este test no importa 
		}
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 0);
	}
	
	@Test
	public void testPiqueteDeberiaPenalizarALaMoto(){
		this.crearJugadorPepeConMoto();
		this.crearPiquete();
		this.unPiquete.interactuarCon((Moto)this.unJugador.getVehiculo());
		assertTrue(this.unJugador.getCantidadDeMovimientos() == 2);
	}
	
	
}
