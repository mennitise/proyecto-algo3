package Vehiculos;

import org.jdom.Element;

import Excepciones.PasoImpedidoException;
import Jugador.Jugador;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Tablero.Posicion;

public class CuatroXCuatro extends Vehiculo{

	public CuatroXCuatro() {
		super();
	}
	public CuatroXCuatro(Posicion unaPosicion) {
		super(unaPosicion);
	}
	public CuatroXCuatro(Posicion unaPosicion, Jugador unConductor){
		super(unaPosicion, unConductor);
	}

	@Override
	public void interactuarCon(Obstaculo obstaculo) throws PasoImpedidoException {
		obstaculo.interactuarCon(this);
	}
	
	@Override
	public void interactuarCon(Sorpresa unaSorpresa) {
		unaSorpresa.interactuarCon(this);
	}

	// Serialización
	
	@Override
	public Element serializarXML() {
		Element element = new Element("cuatroxcuatro");
		Element elementPosicion = posicionActual.serializarXML();
		element.getChildren().add(elementPosicion);
		return element;
	}
	
	public static Vehiculo cargarDesdeXML(Element element){
		Element elementPosicion = (Element)element.getChildren().get(0);
		Posicion unaPosicion = Posicion.cargarDesdeXML(elementPosicion);
		return new CuatroXCuatro(unaPosicion);
	}
}
