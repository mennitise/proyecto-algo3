package Juego;

import org.jdom.Element;
import Tablero.Posicion;

public class NivelMedio extends Nivel{
	
	public NivelMedio(){
		super();
		this.posicionInicialVehiculo = new Posicion(5,0);
		this.posicionLlegada = new Posicion(5,8);
		this.laCantidadMaximaDeMovimientos = 15;
		this.factorDePuntaje = 2;
		this.pathArchivoTablero = "TableroNivelMedio.xml";
	}
	
	@Override
	public Element serializarXML(){
		// Solo se serializará para saber que nivel debe ser, ya que no tiene estado.
		Element element = new Element("nivelMedio");
		return element;
	}
	
	public static Nivel cargarDesdeXML(Element element) {
		return new NivelMedio();
	}
}
