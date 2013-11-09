package Obstaculos;

import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Excepciones.NumeroNegativoException;
import Excepciones.PasoImpedidoException;

public class Pozo extends Obstaculo {
	
	public Pozo() {
		super();
		this.cantidadDeMovimientosAPenalizar = 3;
	}

	@Override
	public void interactuarCon(Moto unaMoto) {
		try {
			unaMoto.getConductor().sumarMovimientos(this.cantidadDeMovimientosAPenalizar);
		} catch (NumeroNegativoException e) {
			// No entra Nunca porque this.cantidadDeMovimientosAPenalizar es siempre 3
		};
	}

	@Override
	public void interactuarCon(Auto unAuto) throws PasoImpedidoException {
		try {
			unAuto.getConductor().sumarMovimientos(this.cantidadDeMovimientosAPenalizar);
		} catch (NumeroNegativoException e) {
			// No entra Nunca porque this.cantidadDeMovimientosAPenalizar es siempre 2
		};
	}

	@Override
	public void interactuarCon(CuatroXCuatro unaCuatroXCuatro) {
		//No Les hace nada
	}
	
}
