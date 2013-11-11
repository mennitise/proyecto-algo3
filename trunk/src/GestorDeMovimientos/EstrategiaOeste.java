package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Tablero.Esquina;
import Vehiculos.Vehiculo;


public class EstrategiaOeste implements EstrategiaDeMovimiento {
	@Override
	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina)
			throws MovimientoFisicamenteInvalidoException {
		boolean puedePasar = true;
		if(unaEsquina.tieneCalleAlOeste()){
			try{
				unaEsquina.getCalleOeste().procesarVehiculo(unVehiculo);
			}catch(PasoImpedidoException e){
				puedePasar = false;
				//Implementar
			}
			if(puedePasar){ 
				unVehiculo.moverseAlOeste();
				unVehiculo.getConductor().sumarUnMovimiento();
			}
		}else{
			throw new MovimientoFisicamenteInvalidoException();
		}

	}

}
