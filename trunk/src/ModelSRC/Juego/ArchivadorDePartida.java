package Juego;

import java.io.FileWriter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import Excepciones.NoExistePartidaGuardadaException;

public class ArchivadorDePartida {

	public static void guardar(Partida unaPartida, String pathArchivo) {
		try {
	        
			Element root = unaPartida.serializarXML();
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
	
	public static Partida cargar(String pathArchivo) throws NoExistePartidaGuardadaException {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(pathArchivo);
	        
			return Partida.cargarDesdeXML(document.getRootElement());
			
		} catch(Exception e) {
			throw new NoExistePartidaGuardadaException();
		}
	}

}
