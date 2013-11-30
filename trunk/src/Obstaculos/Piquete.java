package Obstaculos;

import org.jdom.Element;

import Excepciones.NumeroNegativoException;
import Excepciones.PasoImpedidoException;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;

public class Piquete extends Obstaculo {
	
	public Piquete(){
		super();
		this.cantidadDeMovimientosAPenalizar = 2;			
	}
	
	@Override
	public void interactuarCon(Moto unaMoto) {
		try {
			unaMoto.getConductor().sumarMovimientos(this.cantidadDeMovimientosAPenalizar);
		} catch (NumeroNegativoException e) {
			// No entra Nunca porque this.cantidadDeMovimientosAPenalizar es siempre 2
		};
	}
	@Override
	public void interactuarCon(Auto auto) throws PasoImpedidoException {
		throw new PasoImpedidoException();
	}

	@Override
	public void interactuarCon(CuatroXCuatro unaCuatroXCuatro) throws PasoImpedidoException {
		throw new PasoImpedidoException();
	}

	
	//SERIALIZACION
	
	@Override
	public Element serializarXML() {
		Element element = new Element("ObstaculoPiquete");
		return element;
	}
	
	public static Obstaculo cargarDesdeXML(Element element){
		return new Piquete();
	}

}
