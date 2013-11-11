package Obstaculos;

import Excepciones.NumeroNegativoException;
import Excepciones.PasoImpedidoException;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

public abstract class Obstaculo {
	protected int cantidadDeMovimientosAPenalizar;
	
	public Obstaculo(){
		this.cantidadDeMovimientosAPenalizar = 0;
	}
	
	public Obstaculo(int movimientosAPenalizar) throws NumeroNegativoException{
		if(movimientosAPenalizar >= 0){
			this.cantidadDeMovimientosAPenalizar = movimientosAPenalizar;
		}else{
			throw new NumeroNegativoException();
		}
	}


	public abstract void interactuarCon(Moto unaMoto);
	public abstract void interactuarCon(Auto unAuto) throws PasoImpedidoException;
	public abstract void interactuarCon(CuatroXCuatro unaCuatroXCuatro)throws PasoImpedidoException;

}