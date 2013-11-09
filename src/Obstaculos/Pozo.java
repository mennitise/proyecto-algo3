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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interactuarCon(Auto unAuto) throws PasoImpedidoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interactuarCon(CuatroXCuatro vehiculo) {
		// TODO Auto-generated method stub
		
	}
	
}
