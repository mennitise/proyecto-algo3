package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Tablero.Esquina;
import Tablero.Posicion;
import Vehiculos.Vehiculo;

public class EstrategiaNorte implements EstrategiaDeMovimiento{

	@Override
	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina) throws MovimientoFisicamenteInvalidoException {
		if(unaEsquina.tieneCalleAlNorte()){
			try{
				unaEsquina.getCalleNorte().procesarVehiculo(unVehiculo);
				unVehiculo.moverseAlNorte();
			}catch(PasoImpedidoException e){
				//Implementar
			}
		}else{
			throw new MovimientoFisicamenteInvalidoException();
		}
	}

}
