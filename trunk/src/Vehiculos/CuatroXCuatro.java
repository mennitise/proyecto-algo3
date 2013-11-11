package Vehiculos;

import Excepciones.PasoImpedidoException;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Tablero.Posicion;

public class CuatroXCuatro extends Vehiculo{

	public CuatroXCuatro(Posicion unaPosicion) {
		super(unaPosicion);
	}

	@Override
	public void interactuarCon(Obstaculo obstaculo) throws PasoImpedidoException {
		obstaculo.interactuarCon(this);
	}
	
	@Override
	public void interactuarCon(Sorpresa unaSorpresa) {
		unaSorpresa.interactuarCon(this);
	}

}
