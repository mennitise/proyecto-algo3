package Juego;

import org.jdom.Element;
import Tablero.Posicion;

public class NivelDificil extends Nivel {
	
	public NivelDificil(){
		super();
		this.posicionInicialVehiculo = new Posicion(0,0);
		this.posicionLlegada = new Posicion(9,9);
		this.laCantidadMaximaDeMovimientos = 40;
		this.factorDePuntaje = 3;
		this.pathArchivoTablero = "TableroNivelDificil.xml";
	}
	
	@Override
	public Element serializarXML(){
		// Solo se serializará para saber que nivel debe ser, ya que no tiene estado.
		Element element = new Element("nivelDificil");
		return element;
	}
	
	public static Nivel cargarDesdeXML(Element element) {
		return new NivelDificil();
	}
}