package Juego;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import Jugador.Jugador;



public class ArchivadorDeJugadores {

	public static void guardar(DatoJugador unDatoJugador, String pathArchivo) {
		try {
	        
			Element root = unDatoJugador.serializarXML();
			Document document = new Document(root);

			XMLOutputter outputter = new XMLOutputter();
			outputter.setFormat(Format.getPrettyFormat());
	        
	        FileWriter writer = new FileWriter(pathArchivo);
	        outputter.output(document,writer);
	        writer.close();
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public static DatoJugador cargar(String pathArchivo) {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(pathArchivo);
	        
			return DatoJugador.cargarDesdeXML(document.getRootElement());
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	// Serializacion

	private Element serializarListaDeJugadoresXML(Hashtable jugadores){
		
		Element element = new Element("listaDeJugadores");
		Enumeration datosJugador= jugadores.elements(); 
		while(datosJugador.hasMoreElements()){
			Element elementJugador = ((DatoJugador)datosJugador.nextElement()).serializarXML();
			element.getChildren().add(elementJugador);
		}
		return element;
	}

	private Hashtable cargarListaDeJugadoresDesdeXML(Element element){
		Hashtable jugadores = new Hashtable();
		List listaElementJugador = element.getChildren();
		Iterator iter = listaElementJugador.iterator();
		
		while(iter.hasNext()){
			DatoJugador unJugador = DatoJugador.cargarDesdeXML( (Element)iter.next() );
			jugadores.put(unJugador.getNombre(), unJugador);
		}
		return jugadores;
	}

	public static Hashtable cargarListaDeDatosDeJugadores(String nombreDeArchivoListaJugadores) {
			
		Element element = null;
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(nombreDeArchivoListaJugadores);
			element = document.getRootElement();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		ArchivadorDeJugadores arch = new ArchivadorDeJugadores();
		return arch.cargarListaDeJugadoresDesdeXML(element);
	}

	public static void guardarListaDeDatosDeJugadores(Hashtable listaDeJugadores, String nombreDeArchivoListaJugadores){

		ArchivadorDeJugadores arch = new ArchivadorDeJugadores();
		try {
			
			Element root = arch.serializarListaDeJugadoresXML(listaDeJugadores);
			Document document = new Document(root);

			XMLOutputter outputter = new XMLOutputter();
			outputter.setFormat(Format.getPrettyFormat());
	        
	        FileWriter writer = new FileWriter(nombreDeArchivoListaJugadores);
	        outputter.output(document,writer);
	        writer.close();
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}