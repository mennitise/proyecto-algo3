package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Tablero.Esquina;
import Tablero.Posicion;
import Vehiculos.Vehiculo;

public class EstrategiaSur implements EstrategiaDeMovimiento {

	@Override
	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina)
			throws MovimientoFisicamenteInvalidoException, PasoImpedidoException {
		boolean puedePasar = true;
		if(unaEsquina.tieneCalleAlSur()){
			try{
				unaEsquina.getCalleSur().procesarVehiculo(unVehiculo);
			}catch(PasoImpedidoException e){
				puedePasar = false;
				throw new PasoImpedidoException();
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
		posicion.moverAlSur();
	}

}
