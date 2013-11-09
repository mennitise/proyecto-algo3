package Vehiculos;

import Obstaculos.Obstaculo;
import Tablero.Posicion;
import Excepciones.ProbabilidadNoValidaException;

public abstract class Vehiculo {
	
	private Posicion posicionActual;
	
	public Vehiculo(Posicion unaPosicion){
		this.posicionActual = unaPosicion;
	}
	
	public Posicion getPosicion(){
		return this.posicionActual;
	}
	
	public abstract void interactuarCon(Obstaculo obstaculo);
}
