package Tablero;

import org.jdom.Attribute;
import org.jdom.Element;

public class Posicion{

	private int fila;
	private int columna;
	
	public Posicion(int laFila, int laColumna){
		this.fila = laFila;
		this.columna = laColumna;
	}
	
	public int getColumna(){
		return this.columna;
	}
	
	public int getFila(){
		return this.fila;
	}
	
	public void moverAlOeste(){
		this.columna -= 1;
	}
	
	public void moverAlEste(){
		this.columna += 1;
	}
	
	public void moverAlNorte(){
		this.fila -= 1;
	}
	
	public void moverAlSur(){
		this.fila += 1;
	}

	public boolean esIgual(Posicion posicionFinal) {
		return ( ( this.columna == posicionFinal.getColumna() ) & (this.fila == posicionFinal.getFila()) );
	}
	
	// Serialización 
	
	public static Posicion cargarDesdeXML(Element element) {
		int fila    = Integer.parseInt(element.getAttributeValue("fila"));
		int columna = Integer.parseInt(element.getAttributeValue("columna"));
		return new Posicion(fila,columna);
	}
	
	public Element serializarXML() {
		Element element = new Element("posicion");
		Attribute attFila    = new Attribute("fila",((Integer)this.fila).toString());
		Attribute attColumna = new Attribute("columna",((Integer)this.columna).toString());
		element.getAttributes().add(attFila);
		element.getAttributes().add(attColumna);
		return element;
	}
}
