package Vehiculos;

import Obstaculos.Obstaculo;
import Tablero.Posicion;

public class Moto extends Vehiculo {

	public Moto(Posicion unaPosicion) {
		super(unaPosicion);
		// TODO Auto-generated constructor stub
	}
	
	public void interactuarCon(Obstaculo obstaculo){
		obstaculo.interactuarCon(this);
	}

}
