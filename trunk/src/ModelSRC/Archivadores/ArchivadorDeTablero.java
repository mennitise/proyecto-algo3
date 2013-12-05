package Archivadores;

import java.io.FileWriter;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;
import Tablero.Tablero;

public class ArchivadorDeTablero {

	public static void guardar(Tablero unTablero, String pathArchivo) {
		try {
	        
			Element root = unTablero.serializarXML();
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

	public static Tablero cargar(String pathArchivo){
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(pathArchivo);
	        
			return Tablero.cargarDesdeXML(document.getRootElement());
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}