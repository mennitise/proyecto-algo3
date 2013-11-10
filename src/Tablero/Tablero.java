package Tablero;

import Excepciones.PosicionInvalidaException;
import Obstaculos.ControlPolicial;
import Obstaculos.Obstaculo;
import Obstaculos.Piquete;
import Obstaculos.Pozo;
import Vehiculos.Vehiculo;

public class Tablero{
	
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

	public void inicializarEsquinas(){
		for (int i=0; i<this.filas; i++){
			for (int j=0; j<this.columnas; j++){
				esquinas[i][j] = new Esquina();
			}
		}
	}
	
	private void unirEsquinas(){
		for (int i=0; i<this.filas-1; i++){
			for (int j=0; j<this.columnas-1; j++){
				this.unirHorizontalmente(esquinas[i][j], esquinas[i][j+1]);
				this.unirVerticalmente(esquinas[i][j], esquinas[i+1][j]);
			}
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
	
	public boolean posicionValida(int fila, int columna){
		if( (fila < 0) || (columna < 0) || (fila >= this.filas) || (columna >= this.columnas)){
			return false;
		}
		return true;
	}
	
	public boolean posicionValida(Posicion unaPosicion){
		return this.posicionValida(unaPosicion.getFila(), unaPosicion.getColumna());
	}
		
	public Esquina getEsquinaEn(int fila, int columna){
		return this.esquinas[fila][columna];
	}
	
	public Esquina getEsquinaEn(Posicion unaPosicion){
		return this.esquinas[unaPosicion.getFila()][unaPosicion.getColumna()];
	}
	
	public boolean esquinaEnPosicionTieneCalleOeste(int fila, int columna){
		return this.esquinas[fila][columna].tieneCalleAlOeste();
	}
	
	public boolean esquinaEnPosicionTieneCalleEste(int fila, int columna){
		return this.esquinas[fila][columna].tieneCalleAlEste();
	}
	
	public boolean esquinaEnPosicionTieneCalleNorte(int fila, int columna){
		return this.esquinas[fila][columna].tieneCalleAlNorte();
	}
	
	public boolean esquinaEnPosicionTieneCalleSur(int fila, int columna){
		return this.esquinas[fila][columna].tieneCalleAlSur();
	}

}