package Obstaculos;

import org.jdom.Element;

import Excepciones.NumeroNegativoException;
import Excepciones.PasoImpedidoException;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

public abstract class Obstaculo {
	protected int cantidadDeMovimientosAPenalizar;
	
	public Obstaculo(){
		this.cantidadDeMovimientosAPenalizar = 0;
	}
	
	public Obstaculo(int movimientosAPenalizar) throws NumeroNegativoException{
		if(movimientosAPenalizar >= 0){
			this.cantidadDeMovimientosAPenalizar = movimientosAPenalizar;
		}else{
			throw new NumeroNegativoException();
		}
	}

	public abstract void interactuarCon(Moto unaMoto);
	public abstract void interactuarCon(Auto unAuto) throws PasoImpedidoException;
	public abstract void interactuarCon(CuatroXCuatro unaCuatroXCuatro)throws PasoImpedidoException;

	// Serialización
	
	public abstract Element serializarXML();
	
	public static Obstaculo cargarDesdeXML(Element element) {
		String nombreObstaculo = element.getName();
		if (nombreObstaculo.equals("ObstaculoPiquete")) {
			return Piquete.cargarDesdeXML(element);
		}
		if (nombreObstaculo.equals("ObstaculoPozo")) {
			return Pozo.cargarDesdeXML(element);
		}
		if (nombreObstaculo.equals("ObstaculoControlPolicial")) {
			return ControlPolicial.cargarDesdeXML(element);
		}
		return null;
	}
}