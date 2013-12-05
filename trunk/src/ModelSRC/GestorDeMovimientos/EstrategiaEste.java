package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Tablero.Esquina;
import Tablero.Posicion;
import Vehiculos.Vehiculo;

public class EstrategiaEste implements EstrategiaDeMovimiento {

	@Override
	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina)
			throws MovimientoFisicamenteInvalidoException {
		boolean puedePasar = true;
		if(unaEsquina.tieneCalleAlEste()){
			try{
				unaEsquina.getCalleEste().procesarVehiculo(unVehiculo);
			}catch(PasoImpedidoException e){
				puedePasar = false;
				//Implementar
			}
			if(puedePasar){ 
				unVehiculo.mover(this);
				unVehiculo.getConductor().sumarUnMovimiento();
			}
		}else{
			throw new MovimientoFisicamenteInvalidoException();
		}
	}

	@Override
	public void moverPosicion(Posicion posicion) {
		posicion.moverAlEste();
	}

}
