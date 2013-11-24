package Tablero;

import java.util.Observable;

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

}