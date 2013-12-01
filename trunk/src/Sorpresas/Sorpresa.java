package Sorpresas;

import org.jdom.*;

import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

public abstract class Sorpresa {
	
	protected int redondearCorrectamente(double d){
		//considera el redondeo por modulo(sin perder el signo de d)
	    double dAbs = Math.abs(d);
	    int i = (int) dAbs;
	    double result = dAbs - (double) i;
	    if(result<0.5){
	        return d<0 ? -i : i;            
	    }else{
	        return d<0 ? -(i+1) : i+1;          
	    }
	}
	
	public abstract void interactuarCon(Moto unaMoto);
	public abstract void interactuarCon(Auto unAuto);
	public abstract void interactuarCon(CuatroXCuatro unaCuatroXCuatro);
	
	// Serialización
	
	public abstract Element serializarXML();
	
	public static Sorpresa cargarDesdeXML(Element element) {
		String nombreSorpresa = element.getName();
		if (nombreSorpresa.equals("SorpresaFavorable")) {
			return SorpresaFavorable.cargarDesdeXML(element);
		}
		if (nombreSorpresa.equals("SorpresaDesfavorable")) {
			return SorpresaDesfavorable.cargarDesdeXML(element);
		}
		if (nombreSorpresa.equals("SorpresaCambioDeVehiculo")) {
			return SorpresaCambioDeVehiculo.cargarDesdeXML(element);
		}
		return null;
	}

}
