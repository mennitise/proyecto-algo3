package Juego;

import org.jdom.Element;
import Tablero.Posicion;
import Tablero.Tablero;

public abstract class Nivel {

	protected Posicion posicionInicialVehiculo;
	protected Posicion posicionLlegada;
	protected int laCantidadMaximaDeMovimientos;
	
	public abstract Tablero inicializarTablero();

	public abstract Posicion getPosicionInicialDelVehiculo();
	
	public abstract Posicion getPosicionDeLaLlegada();
	
	public abstract int getCantidadMaximaDeMovimientos();
	
	// Serialización
	
	public abstract Element serializarXML();
	
	public static Nivel cargarDesdeXML(Element element) {
		String nombreNivel = element.getName();
		if (nombreNivel.equals("nivelFacil")) {
			return NivelFacil.cargarDesdeXML(element);
		}
		return null;
	}
}
