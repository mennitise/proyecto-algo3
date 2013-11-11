package Vehiculos;

import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Tablero.Posicion;

public class Moto extends Vehiculo {

	public Moto(Posicion unaPosicion) {
		super(unaPosicion);
	}
	
	public void interactuarCon(Obstaculo obstaculo){
		obstaculo.interactuarCon(this);
	}

	@Override
	public void interactuarCon(Sorpresa unaSorpresa) {
		unaSorpresa.interactuarCon(this);
	}

}
