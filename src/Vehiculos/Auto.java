package Vehiculos;

import Excepciones.PasoImpedidoException;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Tablero.Posicion;

public class Auto extends Vehiculo {

	public Auto(Posicion unaPosicion) {
		super(unaPosicion);
	}
	
	@Override
	public void interactuarCon(Obstaculo obstaculo) throws PasoImpedidoException{
		obstaculo.interactuarCon(this);
	}

	@Override
	public void interactuarCon(Sorpresa unaSorpresa) {
		unaSorpresa.interactuarCon(this);
	}
	
}
