package Juego;

import org.jdom.Element;
import Tablero.Posicion;

public class NivelFacil extends Nivel {
	
	
	public NivelFacil(){
		super();
		this.posicionInicialVehiculo = new Posicion(0,0);
		this.posicionLlegada = new Posicion(5,5);
		this.laCantidadMaximaDeMovimientos = 32;
		this.factorDePuntaje = 1;
		this.pathArchivoTablero = "TableroNivelFacil.xml";
	}
	
	// Serialización
	
	@Override
	public Element serializarXML(){
		// Solo se serializará para saber que nivel debe ser, ya que no tiene estado.
		Element element = new Element("nivelFacil");
		return element;
	}
	
	public static Nivel cargarDesdeXML(Element element) {
		return new NivelFacil();
	}
	
}
