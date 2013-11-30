package Tablero;

import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import org.jdom.Attribute;
import org.jdom.Element;

import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class Tablero extends Observable{
	
	private Esquina[][] esquinas;
	private int filas;
	private int columnas;
	
	public Tablero(){
		this.filas = 0;
		this.columnas = 0;
	}
	
	public Tablero(int numFilas,int numColumnas){
		this.filas = numFilas;
		this.columnas = numColumnas;		
		this.esquinas = new Esquina[filas][columnas];
		this.inicializarEsquinas();	
		this.unirEsquinas();			
	}

	private void inicializarEsquinas(){
		for (int i=0; i<this.filas; i++){
			for (int j=0; j<this.columnas; j++){
				esquinas[i][j] = new Esquina();
			}
		}
	}
	
	private void unirEsquinas(){
		//Uno el contenido central
		for (int i=0; i<this.filas-1; i++){
			for (int j=0; j<this.columnas-1; j++){
				this.unirHorizontalmente(esquinas[i][j], esquinas[i][j+1]);
				this.unirVerticalmente(esquinas[i][j], esquinas[i+1][j]);
			}
		}
		
		//Uno el borde Derecho del tablero
		for (int i=0; i<this.filas-1; i++){
			this.unirVerticalmente(esquinas[i][this.columnas-1],esquinas[i+1][this.columnas-1]);
		}
		
		//Uno el Borde Izquierdo Del Tablero
		for (int i=0; i<this.columnas-1; i++){
			this.unirHorizontalmente(esquinas[this.filas-1][i],esquinas[this.filas-1][i+1]);
		}
		
	}
	

	private void unirHorizontalmente(Esquina unaEsquina, Esquina otraEsquina){
		Calle unaCalle = new Calle(unaEsquina,otraEsquina);
		unaEsquina.ponerCalleHaciaElEste(unaCalle);
		otraEsquina.ponerCalleHaciaElOeste(unaCalle);
	}
	
	private void unirVerticalmente(Esquina unaEsquina, Esquina otraEsquina){
		Calle unaCalle = new Calle(unaEsquina, otraEsquina);
		unaEsquina.ponerCalleHaciaElSur(unaCalle);
		otraEsquina.ponerCalleHaciaElNorte(unaCalle);
	}
		
	public int getFilas(){
		return this.filas;
	}
	
	public int getColumnas(){
		return this.columnas;
	}
	
	private boolean posicionValida(int fila, int columna){
		if( (fila < 0) || (columna < 0) || (fila >= this.filas) || (columna >= this.columnas)){
			return false;
		}
		return true;
	}
	
	public boolean posicionValida(Posicion unaPosicion){
		return this.posicionValida(unaPosicion.getFila(), unaPosicion.getColumna());
	}

	public Esquina getEsquinaEn(Posicion unaPosicion){
		return this.esquinas[unaPosicion.getFila()][unaPosicion.getColumna()];
	}
	
	public boolean esquinaEnPosicionTieneCalleOeste(Posicion unaPosicion){
		return this.esquinas[unaPosicion.getFila()][unaPosicion.getColumna()].tieneCalleAlOeste();
	}
	
	public boolean esquinaEnPosicionTieneCalleEste(Posicion unaPosicion){
		return this.esquinas[unaPosicion.getFila()][unaPosicion.getColumna()].tieneCalleAlEste();
	}
	
	public boolean esquinaEnPosicionTieneCalleNorte(Posicion unaPosicion){
		return this.esquinas[unaPosicion.getFila()][unaPosicion.getColumna()].tieneCalleAlNorte();
	}
	
	public boolean esquinaEnPosicionTieneCalleSur(Posicion unaPosicion){
		return this.esquinas[unaPosicion.getFila()][unaPosicion.getColumna()].tieneCalleAlSur();
	}
	

	// Serialización
	
	private void agregarSorpresasYObstaculosANodoCalle(Element elementoCalle, Calle unaCalle){
		if (unaCalle.tieneAlgunaSorpresa()){
			elementoCalle.getChildren().add(unaCalle.getSorpresas().get(0).serializarXML());
		}
		if (unaCalle.tieneAlgunObstaculo()){
			elementoCalle.getChildren().add(unaCalle.getObstaculos().get(0).serializarXML());
		}
		
	}
	
	public Element serializarXML(){
		Element element = new Element("Tablero");
		Attribute attFilas    = new Attribute("Filas",((Integer)this.filas).toString());
		Attribute attColumnas = new Attribute("Columnas",((Integer)this.columnas).toString());
		element.getAttributes().add(attFilas);
		element.getAttributes().add(attColumnas);
		for ( int i=0 ; i<this.filas ; i++ ){
			for ( int j=0 ; j<this.columnas ; j++ ){
				Posicion unaPosicion = new Posicion(i,j);
				Element elementPosicionEsquina = unaPosicion.serializarXML();
				element.getChildren().add(elementPosicionEsquina);
				Esquina unaEsquina = this.getEsquinaEn(unaPosicion);
				if (unaEsquina.tieneCalleAlEste()){
					Element elementCalleEste = new Element("CalleEste");
					elementPosicionEsquina.getChildren().add(elementCalleEste);
					this.agregarSorpresasYObstaculosANodoCalle(elementCalleEste, unaEsquina.getCalleEste());
				}
				if (unaEsquina.tieneCalleAlSur()){
					Element elementCalleSur = new Element("CalleSur");
					elementPosicionEsquina.getChildren().add(elementCalleSur);
					this.agregarSorpresasYObstaculosANodoCalle(elementCalleSur, unaEsquina.getCalleSur());
				}
			}
		}
		return element;
	}
	
	public static Tablero cargarDesdeXML(Element element) {
		int filas =  Integer.parseInt( element.getAttributeValue("Filas") );
		int columnas =  Integer.parseInt( element.getAttributeValue("Columnas") );
		Tablero unTablero = new Tablero(filas,columnas);
		List posicionesDeEsquinas = element.getChildren();
		Iterator unIter = posicionesDeEsquinas.iterator();
		while(unIter.hasNext()){
			Element elementPosicionEsquina = (Element) unIter.next();
			Posicion laPosicion = Posicion.cargarDesdeXML(elementPosicionEsquina);
			Esquina unaEsquina = unTablero.getEsquinaEn(laPosicion);
			if (unaEsquina.tieneCalleAlEste()){
				 List lasCosasEnCalle = elementPosicionEsquina.getChild("CalleEste").getChildren();
				 Calle calleEste = unaEsquina.getCalleEste();
				 colocarSorpresasYObstaculosEnCalleXML(lasCosasEnCalle, calleEste);
			}
			if (unaEsquina.tieneCalleAlSur()){
				 List lasCosasEnCalle = elementPosicionEsquina.getChild("CalleSur").getChildren();
				 Calle calleSur = unaEsquina.getCalleSur();
				 colocarSorpresasYObstaculosEnCalleXML(lasCosasEnCalle, calleSur);
			}
		}
		return unTablero;
	}

	private static void colocarSorpresasYObstaculosEnCalleXML(List lasCosasEnCalle, Calle unaCalle) {
		Iterator iterCosasEnCalle = lasCosasEnCalle.iterator();
		while(iterCosasEnCalle.hasNext()){
			Element element = (Element) iterCosasEnCalle.next();
			String nombre = element.getName();
			if(nombre.contains("Obstaculo")){
				Obstaculo unObstaculo = Obstaculo.cargarDesdeXML(element);
				unaCalle.agregarObstaculo(unObstaculo);
			}else if(nombre.contains("Sorpresa")){
				Sorpresa unaSorpresa = Sorpresa.cargarDesdeXML(element);
				unaCalle.agregarSorpresa(unaSorpresa);
			}
		}		
	}

}