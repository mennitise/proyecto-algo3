package Obstaculos;

import Excepciones.NumeroNegativoException;
import Excepciones.PasoImpedidoException;
import Jugador.Jugador;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

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
	
	public void penalizarA(Jugador unJugador){
		try {
			unJugador.sumarMovimientos(this.cantidadDeMovimientosAPenalizar);
		} catch (NumeroNegativoException e) {
			// nunca entra porque el atributo cantidadDeMovimientosAPenalizar 
			// de esta clase es siempre >= 0
		}
	}

	public abstract void interactuarCon(Moto unaMoto);
	public abstract void interactuarCon(Auto unAuto) throws PasoImpedidoException;
	public abstract void interactuarCon(CuatroXCuatro vehiculo)throws PasoImpedidoException;

}