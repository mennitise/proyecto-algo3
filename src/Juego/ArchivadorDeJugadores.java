package Juego;
import java.io.FileWriter;
import java.util.ArrayList;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


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
	
	
	
	public static ArrayList<DatoJugador> cargarListaDeDatosDeJugadores(String nombreDeArchivoListaJugadores) {
		
		ArrayList<DatoJugador> datos = new ArrayList<DatoJugador>();
		
		// Carga lista de datos de jugadores
		
		return datos;
	}
	
	
}
