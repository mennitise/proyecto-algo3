package GestorDeMovimientosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.StringVacioException;
import GestorDeMovimientos.EstrategiaEste;
import GestorDeMovimientos.EstrategiaNorte;
import GestorDeMovimientos.EstrategiaOeste;
import GestorDeMovimientos.EstrategiaSur;
import GestorDeMovimientos.GestorDeMovimientos;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Moto;

public class GestorDeMovimientosTest {

	private GestorDeMovimientos unGestor;
	private EstrategiaSur unaEstrategiaSur; 
	private EstrategiaNorte unaEstrategiaNorte; 
	private EstrategiaOeste unaEstrategiaOeste; 
	private EstrategiaEste unaEstrategiaEste; 

	private void inicializarGestor(){
		Tablero unTablero = new Tablero(4,4);
		Moto unaMoto = new Moto(new Posicion(1,1));
		try {
			unaMoto.setConductor(new Jugador("pepe",unaMoto));
		} catch (StringVacioException e) {
			//No entra nunca aca
		}
		this.unGestor = new GestorDeMovimientos(unaMoto,unTablero);
	}
	
	private void inicializarEstrategias(){
		this.unaEstrategiaSur = new EstrategiaSur(); 
		this.unaEstrategiaNorte = new EstrategiaNorte(); 
		this.unaEstrategiaOeste = new EstrategiaOeste(); 
		this.unaEstrategiaEste = new EstrategiaEste(); 
	}
	
	@Test
	public void testSeColocaBienLaPosicionInicial(){
		this.inicializarGestor();
		Posicion posicionActual = new Posicion(1,1);
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.esIgual(posicionActual));
	}
	
	@Test
	public void testMovimientoHaciaElSurLaPosicionColumnaSeMantiene(){
		this.inicializarGestor();
		this.inicializarEstrategias();
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getColumna()==1);
	}
	
	@Test
	public void testMovimientoHaciaElSurLaPosicionFilaCambia(){
		this.inicializarGestor();
		this.inicializarEstrategias();
		this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getFila()==2);
	}
	
	@Test
	public void testMovimientoHaciaElNorteLaPosicionColumnaSeMantiene(){
		this.inicializarGestor();
		this.inicializarEstrategias();
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getColumna()==1);
	}
	
	@Test
	public void testMovimientoHaciaElNorteLaPosicionFilaCambia(){
		this.inicializarGestor();
		this.inicializarEstrategias();
		this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getFila()==0);
	}
	
	@Test
	public void testMovimientoHaciaElEsteLaPosicionColumnaCambia(){
		this.inicializarGestor();
		this.inicializarEstrategias();
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getColumna()==2);
	}
	
	@Test
	public void testMovimientoHaciaElEsteLaPosicionFilaSeMantiene(){
		this.inicializarGestor();
		this.inicializarEstrategias();
		this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getFila()==1);
	}
	
	@Test
	public void testMovimientoHaciaElOesteLaPosicionColumnaCambia(){
		this.inicializarGestor();
		this.inicializarEstrategias();
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getColumna()==0);
	}
	
	@Test
	public void testMovimientoHaciaElOesteLaPosicionFilaSeMantiene(){
		this.inicializarGestor();
		this.inicializarEstrategias();
		this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getFila()==1);
	}

}
