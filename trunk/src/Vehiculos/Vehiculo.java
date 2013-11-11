package Vehiculos;

import Jugador.Jugador;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Tablero.Posicion;
import Excepciones.PasoImpedidoException;

public abstract class Vehiculo {
	
	private Posicion posicionActual;
	private Jugador elConductor;
	
	public Vehiculo(Posicion unaPosicion){
		this.posicionActual = unaPosicion;
	}
	
	public Vehiculo(Posicion unaPosicion, Jugador unConductor){
		this.posicionActual = unaPosicion;
		this.elConductor = unConductor;
	}
	
	public Posicion getPosicion(){
		return this.posicionActual;
	}
	
	public void setConductor(Jugador unConductor){
		this.elConductor = unConductor;
	}
	
	public Jugador getConductor(){
		return this.elConductor;
	}
	
	public void moverseAlEste() {
		this.posicionActual.moverAlEste();
	}
	
	public void moverseAlSur() {
		this.posicionActual.moverAlSur();
	}
	
	public void moverseAlNorte() {
		this.posicionActual.moverAlNorte();
	}
	
	public void moverseAlOeste() {
		this.posicionActual.moverAlOeste();
	}
	
	public abstract void interactuarCon(Obstaculo obstaculo) throws PasoImpedidoException;
	
	public abstract void interactuarCon(Sorpresa unaSorpresa);
	
}
