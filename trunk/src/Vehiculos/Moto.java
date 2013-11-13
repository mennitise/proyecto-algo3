package Vehiculos;

import Jugador.Jugador;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Tablero.Posicion;

public class Moto extends Vehiculo {

	public Moto() {
		super();
	}
	public Moto(Posicion unaPosicion) {
		super(unaPosicion);
	}
	public Moto(Posicion unaPosicion, Jugador unConductor){
		super(unaPosicion, unConductor);
	}
	
	public void interactuarCon(Obstaculo obstaculo){
		obstaculo.interactuarCon(this);
	}

	@Override
	public void interactuarCon(Sorpresa unaSorpresa) {
		unaSorpresa.interactuarCon(this);
	}

}
