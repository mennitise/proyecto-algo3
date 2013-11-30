package Juego;

import org.jdom.Element;

import Archivadores.ArchivadorDeTablero;
import Tablero.Posicion;
import Tablero.Tablero;

public abstract class Nivel {

	protected Posicion posicionInicialVehiculo;
	protected Posicion posicionLlegada;
	protected int laCantidadMaximaDeMovimientos;
	protected int factorDePuntaje;
	String pathArchivoTablero = "TableroNivelDificil.xml";
	
	public Nivel(){
		this.posicionInicialVehiculo = null;
		this.posicionLlegada = null;
		this.laCantidadMaximaDeMovimientos = 0;
		this.factorDePuntaje = 0;
	}
	
	public Tablero inicializarTablero() {
		return ArchivadorDeTablero.cargar(pathArchivoTablero);
	}

	public Posicion getPosicionInicialDelVehiculo() {
		return this.posicionInicialVehiculo.getCopiaDePosicion();
	}
	
	public Posicion getPosicionDeLaLlegada() {
		return this.posicionLlegada.getCopiaDePosicion();
	}

	public int getCantidadMaximaDeMovimientos() {
		return this.laCantidadMaximaDeMovimientos;
	}

	// Serialización
	
	public abstract Element serializarXML();
	
	public static Nivel cargarDesdeXML(Element element) {
		String nombreNivel = element.getName();
		if (nombreNivel.equals("nivelFacil")) {
			return NivelFacil.cargarDesdeXML(element);
		}
		if (nombreNivel.equals("nivelMedio")) {
			return NivelMedio.cargarDesdeXML(element);
		}
		if (nombreNivel.equals("nivelDificil")) {
			return NivelDificil.cargarDesdeXML(element);
		}
		return null;
	}
	
	public int calcularPuntaje(int cantidadDeMovimientos) {
		return this.factorDePuntaje * (this.laCantidadMaximaDeMovimientos - cantidadDeMovimientos);
	}
}
