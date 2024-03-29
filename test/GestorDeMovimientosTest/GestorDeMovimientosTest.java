package GestorDeMovimientosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
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
		this.unGestor = new GestorDeMovimientos(unaMoto.getConductor(),unTablero);
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
	public void testMovimientoHaciaElSurLaPosicionColumnaSeMantiene() throws PasoImpedidoException{
		this.inicializarGestor();
		this.inicializarEstrategias();
		try {
			this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getColumna()==1);
	}
	
	@Test
	public void testMovimientoHaciaElSurLaPosicionFilaCambia() throws PasoImpedidoException{
		this.inicializarGestor();
		this.inicializarEstrategias();
		try {
			this.unGestor.moverVehiculo(this.unaEstrategiaSur);
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getFila()==2);
	}
	
	@Test
	public void testMovimientoHaciaElNorteLaPosicionColumnaSeMantiene() throws PasoImpedidoException{
		this.inicializarGestor();
		this.inicializarEstrategias();
		try {
			this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getColumna()==1);
	}
	
	@Test
	public void testMovimientoHaciaElNorteLaPosicionFilaCambia() throws PasoImpedidoException{
		this.inicializarGestor();
		this.inicializarEstrategias();
		try {
			this.unGestor.moverVehiculo(this.unaEstrategiaNorte);
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getFila()==0);
	}
	
	@Test
	public void testMovimientoHaciaElEsteLaPosicionColumnaCambia() throws PasoImpedidoException{
		this.inicializarGestor();
		this.inicializarEstrategias();
		try {
			this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getColumna()==2);
	}
	
	@Test
	public void testMovimientoHaciaElEsteLaPosicionFilaSeMantiene() throws PasoImpedidoException{
		this.inicializarGestor();
		this.inicializarEstrategias();
		try {
			this.unGestor.moverVehiculo(this.unaEstrategiaEste);
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getFila()==1);
	}
	
	@Test
	public void testMovimientoHaciaElOesteLaPosicionColumnaCambia() throws PasoImpedidoException{
		this.inicializarGestor();
		this.inicializarEstrategias();
		try {
			this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getColumna()==0);
	}
	
	@Test
	public void testMovimientoHaciaElOesteLaPosicionFilaSeMantiene() throws PasoImpedidoException{
		this.inicializarGestor();
		this.inicializarEstrategias();
		try {
			this.unGestor.moverVehiculo(this.unaEstrategiaOeste);
		} catch (MovimientoFisicamenteInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Posicion laPosicion = this.unGestor.getPosicionActual();
		assertTrue(laPosicion.getFila()==1);
	}

}
