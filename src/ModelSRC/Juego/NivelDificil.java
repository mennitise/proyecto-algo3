package Juego;

import org.jdom.Element;

import Tablero.Posicion;

public class NivelDificil extends Nivel {
	
	public NivelDificil(){
		super();
		this.posicionInicialVehiculo = Posicion.obtenerRandomDentroDelRadio(12);
		this.posicionLlegada = this.obtenerPosicionADistanciaXDe(this.posicionInicialVehiculo, 4);
		this.laCantidadMaximaDeMovimientos = 40;
		this.factorDePuntaje = 3;
		this.pathArchivoTablero = "TableroNivelDificil.xml";
	}

	private NivelDificil(Posicion posicionLlegada){
		super();
		this.posicionInicialVehiculo = Posicion.obtenerRandomDentroDelRadio(12);
		this.posicionLlegada = posicionLlegada;
		this.laCantidadMaximaDeMovimientos = 40;
		this.factorDePuntaje = 3;
		this.pathArchivoTablero = "TableroNivelDificil.xml";
	}
	
	private Posicion obtenerPosicionADistanciaXDe(Posicion unaPos, int x){
		
		Posicion posicion = Posicion.obtenerRandomDentroDelRadio(12); 
		while( unaPos.distanciaA(posicion) < x ){
			posicion = Posicion.obtenerRandomDentroDelRadio(12);
		}
		return posicion;
	}
	
	// Serialización
	
	@Override
	public Element serializarXML(){
		// Solo se serializará para saber que nivel debe ser, ya que no tiene estado.
		Element element = new Element("nivelDificil");
		Element elementPosicion = posicionLlegada.serializarXML();
		element.getChildren().add(elementPosicion);
		return element;
	}
	
	public static Nivel cargarDesdeXML(Element element) {
		Element elementPosicion = (Element)element.getChildren().get(0);
		Posicion llegada = Posicion.cargarDesdeXML(elementPosicion);
		return new NivelDificil(llegada);
	}
}