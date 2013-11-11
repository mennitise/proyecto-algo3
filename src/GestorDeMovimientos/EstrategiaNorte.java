package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Tablero.Esquina;
import Vehiculos.Vehiculo;

public class EstrategiaNorte implements EstrategiaDeMovimiento{

	@Override
	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina) throws MovimientoFisicamenteInvalidoException {
		boolean puedePasar = true;
		if(unaEsquina.tieneCalleAlNorte()){
			try{
				unaEsquina.getCalleNorte().procesarVehiculo(unVehiculo);
			}catch(PasoImpedidoException e){
				puedePasar = false;
				//Terminar de implementarImplementar				
			}
			if(puedePasar) unVehiculo.moverseAlNorte();
		}else{
			throw new MovimientoFisicamenteInvalidoException();
		}
	}

}
