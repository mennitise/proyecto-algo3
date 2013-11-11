package Obstaculos;

import java.util.Random;

import Excepciones.NumeroNegativoException;
import Excepciones.PasoImpedidoException;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class ControlPolicial extends Obstaculo{ 
	
	private double probabilidadDeFrenarALaMoto = 0.8;
	private double probabilidadDeFrenarAlAuto = 0.5;
	private double probabilidadDeFrenarALaCuatroXCuatro = 0.3;
	
	public ControlPolicial(){
		super();
		this.cantidadDeMovimientosAPenalizar = 2;
	}
	
	private void DetenerAlvehiculo(Vehiculo unVehiculo){
		try {
			unVehiculo.getConductor().sumarMovimientos(this.cantidadDeMovimientosAPenalizar);
		} catch (NumeroNegativoException e) {
			// No entra Nunca porque this.cantidadDeMovimientosAPenalizar es siempre 2
		};
	}
	
	@Override
	public void interactuarCon(Moto unaMoto) {
		Random rn = new Random();
		if(rn.nextDouble() < this.probabilidadDeFrenarALaMoto){
			this.DetenerAlvehiculo(unaMoto);
		}
	}

	@Override
	public void interactuarCon(Auto unAuto) throws PasoImpedidoException {
		Random rn = new Random();
		if(rn.nextDouble() < this.probabilidadDeFrenarAlAuto){
			this.DetenerAlvehiculo(unAuto);
		}
	}

	@Override
	public void interactuarCon(CuatroXCuatro unaCuatroXCuatro)throws PasoImpedidoException {
		Random rn = new Random();
		if(rn.nextDouble() < this.probabilidadDeFrenarALaCuatroXCuatro){
			this.DetenerAlvehiculo(unaCuatroXCuatro);
		}
	}
	
}

