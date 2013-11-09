package Vehiculos;

import Excepciones.PasoImpedidoException;
import Obstaculos.Obstaculo;
import Tablero.Posicion;

public class CuatroXCuatro extends Vehiculo{

	public CuatroXCuatro(Posicion unaPosicion) {
		super(unaPosicion);
	}

	public void interactuarCon(Obstaculo obstaculo) {
		try {
			obstaculo.interactuarCon(this);
		} catch (PasoImpedidoException e) {
			// Implementar
		}
	}

}
