package Juego;

import java.util.ArrayList;

import org.jdom.Element;

public class DatoJugador {
	private String nombre;
	private int puntaje;
	private String nombreDeArchivoDeUltimaPartidaGuardada;
	
	public DatoJugador(String unNombre){
		this.nombre  = unNombre;
		this.puntaje = 0;
		this.nombreDeArchivoDeUltimaPartidaGuardada = unNombre + ".xml";
	}

	// Serializacion
	
	public Element serializarXML(){
		// Serializa un DatoJugador();
		return null;
	}
	
	public static DatoJugador cargarDesdeXML(Element element){
		// Desserializa un DatoJugador();
		return null;
	}
	

}
