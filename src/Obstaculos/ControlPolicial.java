package Obstaculos;

import Excepciones.PasoImpedidoException;
import Jugador.Jugador;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class ControlPolicial extends Obstaculo{ 

	public ControlPolicial(){
		super();
		this.cantidadDeMovimientosAPenalizar = 2;
	}
	
	@Override
	public void interactuarCon(Moto unaMoto) {
		
	}

	@Override
	public void interactuarCon(Auto unAuto) throws PasoImpedidoException {
		
	}

	@Override
	public void interactuarCon(CuatroXCuatro vehiculo) {
		
	}
	
	
	
}

