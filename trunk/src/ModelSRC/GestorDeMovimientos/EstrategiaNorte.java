package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Excepciones.PasoImpedidoException;
import Tablero.Esquina;
import Tablero.Posicion;
import Vehiculos.Vehiculo;

public class EstrategiaNorte implements EstrategiaDeMovimiento{

	@Override
	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina) throws MovimientoFisicamenteInvalidoException, PasoImpedidoException {
		boolean puedePasar = true;
		if(unaEsquina.tieneCalleAlNorte()){
			try{
				unaEsquina.getCalleNorte().procesarVehiculo(unVehiculo);
			}catch(PasoImpedidoException e){
				puedePasar = false;
				throw new PasoImpedidoException();
				//Terminar de implementarImplementar				
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
		posicion.moverAlNorte();
	}
	

}
