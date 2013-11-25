package Sorpresas;

import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

public class SorpresaCambioDeVehiculo extends Sorpresa{

	@Override
	public void interactuarCon(Moto unaMoto) {
		//cambio la moto por un auto
		Auto unAuto = new Auto(unaMoto.getPosicion()); 
		unaMoto.getConductor().setVehiculo(unAuto);
	}

	@Override
	public void interactuarCon(Auto unAuto) {
		//cambio el auto por una CuatroXCuatro 
		CuatroXCuatro unaCuatroXCuatro = new CuatroXCuatro(unAuto.getPosicion()); 
		unAuto.getConductor().setVehiculo(unaCuatroXCuatro);
	}

	@Override
	public void interactuarCon(CuatroXCuatro unaCuatroXCuatro) {
		//cambio la CuatroXCuatro por una moto  
		Moto unaMoto = new Moto(unaCuatroXCuatro.getPosicion()); 
		unaCuatroXCuatro.getConductor().setVehiculo(unaMoto);
		
	}

}
