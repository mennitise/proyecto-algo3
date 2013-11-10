package Vehiculos;

import Excepciones.PasoImpedidoException;
import Obstaculos.Obstaculo;
import Tablero.Posicion;

public class Auto extends Vehiculo {

	public Auto(Posicion unaPosicion) {
		super(unaPosicion);
		// TODO Auto-generated constructor stub
	}
	
	public void interactuarCon(Obstaculo obstaculo) throws PasoImpedidoException{
		obstaculo.interactuarCon(this);
	}

}
