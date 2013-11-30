package Sorpresas;

import org.jdom.Element;

import Excepciones.NumeroNegativoException;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class SorpresaFavorable extends Sorpresa {
	
	private double fraccionDeMovimientos;
	
	public SorpresaFavorable(){
		this.fraccionDeMovimientos = 0.2;
	}
	private void aplicarA(Vehiculo unVehiculo){
		double numeroDeMovimientos = unVehiculo.getConductor().getCantidadDeMovimientos();
		double movimientosARestarSinRedondear = numeroDeMovimientos * this.fraccionDeMovimientos;
		int movimientosARestar = this.redondearCorrectamente(movimientosARestarSinRedondear);
		try {
			unVehiculo.getConductor().quitarMovimientos(movimientosARestar);
		} catch (NumeroNegativoException e) {
			//Nunca entra porque movimientosARestar es siempre positivo 
		}
	}
	@Override
	public void interactuarCon(Moto unaMoto) {
		this.aplicarA(unaMoto);
	}

	@Override
	public void interactuarCon(Auto unAuto) {
		this.aplicarA(unAuto);
	}

	@Override
	public void interactuarCon(CuatroXCuatro unaCuatroXCuatro) {
		this.aplicarA(unaCuatroXCuatro);
	}
	
	
	//SERIALIZACION
	
	@Override
	public Element serializarXML() {
		Element element = new Element("SorpresaFavorable");
		return element;
	}
	
	public static Sorpresa cargarDesdeXML(Element element){
		return new SorpresaFavorable();
	}

}
