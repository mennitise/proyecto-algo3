package Tablero;

import java.util.ArrayList;

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
	
	public void Tablero(){
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
		unaEsquina.ponerCalleHaciaDerecha(unaCalle);
		otraEsquina.ponerCalleHaciaIzquierda(unaCalle);
	}
	
	private void unirVerticalmente(Esquina unaEsquina, Esquina otraEsquina){
		Calle unaCalle = new Calle(unaEsquina, otraEsquina);
		unaEsquina.ponerCalleHaciaAbajo(unaCalle);
		otraEsquina.ponerCalleHaciaArriba(unaCalle);
	}
		
	public int getFilas(){
		return this.filas;
	}
	
	public int getColumnas(){
		return this.columnas;
	}
	
	public boolean posicionValida(int fila, int columna){
		if( (fila < 0) || (columna < 0) || (fila > this.filas) || (columna > this.columnas)){
			return false;
		}
		return true;
	}
	
	public void colocarVehiculoEn(Vehiculo unVehiculo,int fila, int columna) throws PosicionInvalidaException{
		if( !this.posicionValida(fila, columna) ){
			throw new PosicionInvalidaException();
		}
		this.esquinas[fila][columna].ponerVehiculo(unVehiculo);
	}
	
	public Vehiculo getVehiculoEn(int fila, int columna) throws PosicionInvalidaException{
		if( !this.posicionValida(fila, columna) ){
			throw new PosicionInvalidaException();
		}
		return this.esquinas[fila][columna].getVehiculoEnEsquina();
	}
	
	public Vehiculo quitarVehiculoEn(int fila, int columna) throws PosicionInvalidaException{
		if( !this.posicionValida(fila, columna) ){
			throw new PosicionInvalidaException();
		}
		return esquinas[fila][columna].quitarVehiculo();
	}
	
	public Esquina getEsquinaEn(int posX, int posY){
		return this.esquinas[posX][posY];
	}

}