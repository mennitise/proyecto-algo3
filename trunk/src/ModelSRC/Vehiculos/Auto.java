package Vehiculos;

import org.jdom.Attribute;
import org.jdom.Element;

import Excepciones.PasoImpedidoException;
import Jugador.Jugador;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Tablero.Posicion;

public class Auto extends Vehiculo {

	public Auto() {
		super();
	}
	public Auto(Posicion unaPosicion) {
		super(unaPosicion);
	}
	public Auto(Posicion unaPosicion, Jugador unConductor){
		super(unaPosicion, unConductor);
	}
	
	@Override
	public void interactuarCon(Obstaculo obstaculo) throws PasoImpedidoException{
		obstaculo.interactuarCon(this);
	}

	@Override
	public void interactuarCon(Sorpresa unaSorpresa) {
		unaSorpresa.interactuarCon(this);
	}
	
	// Serialización
	
	@Override
	public Element serializarXML() {
		Element element = new Element("auto");
		Element elementPosicion = posicionActual.serializarXML();
		element.getChildren().add(elementPosicion);
		return element;
	}
	
	public static Vehiculo cargarDesdeXML(Element element){
		Element elementPosicion = (Element)element.getChildren().get(0);
		Posicion unaPosicion = Posicion.cargarDesdeXML(elementPosicion);
		return new Auto(unaPosicion);
	}
}
