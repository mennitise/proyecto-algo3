package Obstaculos;

import Excepciones.NumeroNegativoException;
import Jugador.Jugador;

public class Obstaculo {
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
	
}
