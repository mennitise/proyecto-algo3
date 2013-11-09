package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Tablero.Esquina;
import Vehiculos.Vehiculo;

public class EstrategiaEste implements EstrategiaDeMovimiento {

	@Override
	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina)
			throws MovimientoFisicamenteInvalidoException {
		if(unaEsquina.tieneCalleAlEste()){
			try{
				unaEsquina.getCalleEste().procesarVehiculo(unVehiculo);
				unVehiculo.moverseAlEste();
			}catch(PasoImpedidoException e){
				//Implementar
			}
		}else{
			throw new MovimientoFisicamenteInvalidoException();
		}
	}

}
