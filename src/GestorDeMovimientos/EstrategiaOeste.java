package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Tablero.Esquina;
import Vehiculos.Vehiculo;


public class EstrategiaOeste implements EstrategiaDeMovimiento {
	@Override
	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina)
			throws MovimientoFisicamenteInvalidoException {
		if(unaEsquina.tieneCalleAlOeste()){
			try{
				unaEsquina.getCalleOeste().procesarVehiculo(unVehiculo);
				unVehiculo.moverseAlOeste();
			}catch(PasoImpedidoException e){
				//Implementar
			}
		}else{
			throw new MovimientoFisicamenteInvalidoException();
		}

	}

}
