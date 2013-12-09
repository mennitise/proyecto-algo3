package Juego;

import org.jdom.Element;
import Tablero.Posicion;

public class NivelFacil extends Nivel {

	public NivelFacil(){
		super();
		this.posicionInicialVehiculo = Posicion.obtenerRandomDentroDelRadio(6);
		this.posicionLlegada = this.obtenerPosicionADistanciaXDe(this.posicionInicialVehiculo, 2);
		this.laCantidadMaximaDeMovimientos = 32;
		this.factorDePuntaje = 1;
		this.pathArchivoTablero = "TableroNivelFacil.xml";
	}
	
	private NivelFacil(Posicion posicionLlegada){
		super();
		this.posicionInicialVehiculo = Posicion.obtenerRandomDentroDelRadio(6);
		this.posicionLlegada = posicionLlegada;
		this.laCantidadMaximaDeMovimientos = 32;
		this.factorDePuntaje = 1;
		this.pathArchivoTablero = "TableroNivelFacil.xml";
	}
	
	private Posicion obtenerPosicionADistanciaXDe(Posicion unaPos, int x){
		
		Posicion posicion = Posicion.obtenerRandomDentroDelRadio(6); 
		while( unaPos.distanciaA(posicion) < x ){
			posicion = Posicion.obtenerRandomDentroDelRadio(6);
		}
		return posicion;
	}
	
	// Serialización
	
	@Override
	public Element serializarXML(){
		// Solo se serializará para saber que nivel debe ser, ya que no tiene estado.
		Element element = new Element("nivelFacil");
		Element elementPosicion = posicionLlegada.serializarXML();
		element.getChildren().add(elementPosicion);
		return element;
	}
	
	public static Nivel cargarDesdeXML(Element element) {
		Element elementPosicion = (Element)element.getChildren().get(0);
		Posicion llegada = Posicion.cargarDesdeXML(elementPosicion);
		return new NivelFacil(llegada);
	}
}
