package Obstaculos;

import org.jdom.Element;

import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Excepciones.NumeroNegativoException;

public class Pozo extends Obstaculo {
	
	public Pozo() {
		super();
		this.cantidadDeMovimientosAPenalizar = 3;
	}

	@Override
	public void interactuarCon(Moto unaMoto) {
		try {
			unaMoto.getConductor().sumarMovimientos(this.cantidadDeMovimientosAPenalizar);
		} catch (NumeroNegativoException e) {
			// No entra Nunca porque this.cantidadDeMovimientosAPenalizar es siempre 3
		};
	}

	@Override
	public void interactuarCon(Auto unAuto) {
		try {
			unAuto.getConductor().sumarMovimientos(this.cantidadDeMovimientosAPenalizar);
		} catch (NumeroNegativoException e) {
			// No entra Nunca porque this.cantidadDeMovimientosAPenalizar es siempre 3
		};
	}

	@Override
	public void interactuarCon(CuatroXCuatro unaCuatroXCuatro) {
		//No Les hace nada
	}
	
	//SERIALIZACION
	
	@Override
	public Element serializarXML() {
		Element element = new Element("ObstaculoPozo");
		return element;
	}
	
	public static Obstaculo cargarDesdeXML(Element element){
		return new Pozo();
	}

}
