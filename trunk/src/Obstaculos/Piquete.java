package Obstaculos;

import Excepciones.PasoImpedidoException;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

public class Piquete extends Obstaculo {
	
	public Piquete(){
		super();
		this.cantidadDeMovimientosAPenalizar = 2;			
	}

	public void interactuarCon(Auto auto) throws PasoImpedidoException {
		throw new PasoImpedidoException();
	}

	public void interactuarCon(Moto unaMoto) {
		
	}

	@Override
	public void interactuarCon(CuatroXCuatro vehiculo) {
		
	}


}
