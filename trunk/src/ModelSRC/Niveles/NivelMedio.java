package Niveles;

import org.jdom.Element;

import Tablero.Posicion;

public class NivelMedio extends Nivel{
	
	public NivelMedio(){
		super();
		this.posicionInicialVehiculo = Posicion.obtenerRandomDentroDelRadio(9);
		this.posicionLlegada = this.obtenerPosicionADistanciaXDe(this.posicionInicialVehiculo, 3);
		this.laCantidadMaximaDeMovimientos = 15;
		this.factorDePuntaje = 2;
		this.pathArchivoTablero = "TableroNivelMedio.xml";
	}

	private NivelMedio(Posicion posicionLlegada){
		super();
		this.posicionInicialVehiculo = Posicion.obtenerRandomDentroDelRadio(9);
		this.posicionLlegada = posicionLlegada;
		this.laCantidadMaximaDeMovimientos = 15;
		this.factorDePuntaje = 2;
		this.pathArchivoTablero = "TableroNivelMedio.xml";
	}
	
private Posicion obtenerPosicionADistanciaXDe(Posicion unaPos, int x){
		
		Posicion posicion = Posicion.obtenerRandomDentroDelRadio(9); 
		int numeroDeIteraciones = 0; //es para controlar que el ciclo no busque muchas veces
		while( (unaPos.distanciaA(posicion) < x ) && (numeroDeIteraciones <20 )){
			posicion = Posicion.obtenerRandomDentroDelRadio(9);
			numeroDeIteraciones++;
		}		
		if ((numeroDeIteraciones >= 20) && (this.posicionLlegada.esIgual(this.posicionInicialVehiculo))){
			this.buscarPosicionDeLlegadaDistintaALaInicial(posicion);
		}
		return posicion;
	}
	
	
	private void buscarPosicionDeLlegadaDistintaALaInicial(Posicion unaPosicion){
		while (unaPosicion.esIgual(this.posicionInicialVehiculo)){
			unaPosicion = Posicion.obtenerRandomDentroDelRadio(9);
		}
	}	
	// Serialización
	
	@Override
	public Element serializarXML(){
		// Solo se serializará para saber que nivel debe ser, ya que no tiene estado.
		Element element = new Element("nivelMedio");
		Element elementPosicion = posicionLlegada.serializarXML();
		element.getChildren().add(elementPosicion);
		return element;
	}
	
	public static Nivel cargarDesdeXML(Element element) {
		Element elementPosicion = (Element)element.getChildren().get(0);
		Posicion llegada = Posicion.cargarDesdeXML(elementPosicion);
		return new NivelMedio(llegada);
	}
}
