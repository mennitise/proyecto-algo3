package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Tablero.Esquina;
import Vehiculos.Vehiculo;

public class EstrategiaSur implements EstrategiaDeMovimiento {

	@Override
	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina)
			throws MovimientoFisicamenteInvalidoException {
		if(unaEsquina.tieneCalleAlSur()){
			try{
				unaEsquina.getCalleSur().procesarVehiculo(unVehiculo);
				unVehiculo.moverseAlSur();
			}catch(PasoImpedidoException e){
				//Implementar
			}
		}else{
			throw new MovimientoFisicamenteInvalidoException();
		}
	}

}
