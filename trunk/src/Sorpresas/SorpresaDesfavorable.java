package Sorpresas;

import org.jdom.Element;

import Excepciones.NumeroNegativoException;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class SorpresaDesfavorable extends Sorpresa {
	private double fraccionDeMovimientos;
	
	public SorpresaDesfavorable(){
		this.fraccionDeMovimientos = 0.25;
	}
	
	private void aplicarA(Vehiculo unVehiculo){
		double numeroDeMovimientos = unVehiculo.getConductor().getCantidadDeMovimientos();
		double movimientosASumarSinRedondear = numeroDeMovimientos * this.fraccionDeMovimientos;
		int movimientosASumar = this.redondearCorrectamente(movimientosASumarSinRedondear);
		try {
			unVehiculo.getConductor().sumarMovimientos(this.redondearCorrectamente(movimientosASumar));
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
		Element element = new Element("SorpresaDesfavorable");
		return element;
	}
	
	public static Sorpresa cargarDesdeXML(Element element){
		return new SorpresaDesfavorable();
	}
	
}
