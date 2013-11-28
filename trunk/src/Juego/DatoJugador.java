package Juego;

import org.jdom.Attribute;
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

	public void setPuntuacion(int unaPuntuacion){
		this.puntaje = unaPuntuacion;
	}
	
	// Serializacion
	
	public Element serializarXML(){
		
		Element element = new Element("datoJugador");
		Attribute attNombre = new Attribute("nombre",this.nombre);
		Attribute attPuntaje = new Attribute("puntaje",((Integer)this.puntaje).toString());
		element.getAttributes().add(attNombre);
		element.getAttributes().add(attPuntaje);
		
		return element;
	}

	public static DatoJugador cargarDesdeXML(Element element){
		
		String nombre = (String)element.getAttributeValue("nombre");
		int puntaje   = Integer.parseInt(element.getAttributeValue("puntaje"));
		DatoJugador unDato = new DatoJugador(nombre);
		unDato.setPuntuacion(puntaje);
		return unDato;
	}

	public String getNombreArchivoPartida() {
		return this.nombreDeArchivoDeUltimaPartidaGuardada;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void asignarPuntaje(int unPuntaje) {
		this.puntaje += unPuntaje;
	}

	public int getPuntaje() {
		return this.puntaje;
	}

}
