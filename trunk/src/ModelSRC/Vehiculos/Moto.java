package Vehiculos;

import org.jdom.Element;

import Jugador.Jugador;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Tablero.Posicion;

public class Moto extends Vehiculo {

	public Moto() {
		super();
	}
	public Moto(Posicion unaPosicion) {
		super(unaPosicion);
	}
	public Moto(Posicion unaPosicion, Jugador unConductor){
		super(unaPosicion, unConductor);
	}
	
	public void interactuarCon(Obstaculo obstaculo){
		obstaculo.interactuarCon(this);
	}

	@Override
	public void interactuarCon(Sorpresa unaSorpresa) {
		unaSorpresa.interactuarCon(this);
	}

	// Serialización
	
	@Override
	public Element serializarXML() {
		Element element = new Element("moto");
		Element elementPosicion = posicionActual.serializarXML();
		element.getChildren().add(elementPosicion);
		return element;
	}
	
	public static Vehiculo cargarDesdeXML(Element element){
		Element elementPosicion = (Element)element.getChildren().get(0);
		Posicion unaPosicion = Posicion.cargarDesdeXML(elementPosicion);
		return new Moto(unaPosicion);
	}
}
