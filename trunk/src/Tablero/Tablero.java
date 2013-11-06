package Tablero;

import java.util.ArrayList;

import Excepciones.NumeroNegativoException;
import Excepciones.PosicionInvalidaException;
import Obstaculos.ControlPolicial;
import Obstaculos.Obstaculo;
import Obstaculos.Piquete;
import Obstaculos.Pozo;
import Vehiculos.Vehiculo;

public class Tablero{
	
	private Casillero[][] mapa;
	private int filas;
	private int columnas;
	private int sorpresasYObstaculos;
	private ArrayList<Obstaculo> coleccionDeObjetosYSorpresas;
	

	public Tablero(int numFilas,int numColumnas, int sorpresasYObstaculosTotal){
		this.filas = numFilas;
		this.columnas = numColumnas;
		this.sorpresasYObstaculos = sorpresasYObstaculosTotal;		

		this.mapa = new Casillero[filas][columnas];
		this.inicializarCasilleros();
		
		this.inicializarColeccionDeObjetosYSorpresas();
		this.ponerObstaculosYSorpresas();

				
	}

	private void inicializarCasilleros(){
		for (int i=0; i<this.filas;i++){
			for (int j=0; j<this.columnas;j++){
				mapa[i][j] = new Casillero();
			}
		}
	}
	
	
	private void inicializarColeccionDeObjetosYSorpresas(){
		this.coleccionDeObjetosYSorpresas = new ArrayList<Obstaculo>();
		this.coleccionDeObjetosYSorpresas.add(new ControlPolicial());
		this.coleccionDeObjetosYSorpresas.add(new Pozo());
		this.coleccionDeObjetosYSorpresas.add( new Piquete());	
	}
		
	private int chequearPositividadDelNumero(int numero) throws NumeroNegativoException{
		if(numero >= 0){
			return numero;
		}else{
			throw new NumeroNegativoException();
		}
	}
	
	private void ponerObstaculosYSorpresas(){
		for(int i=0; i<this.sorpresasYObstaculos;i++){
			this.colocarSorpresaUObstaculo();		
		}
	}

	private void colocarSorpresaUObstaculo(){
		int ColumnaRandom;	
		int FilaRandom;
		
		ColumnaRandom = (int) ( Math.random() * (this.columnas-1));
		FilaRandom = (int) ( Math.random() * (this.filas-1));
		while (this.mapa[FilaRandom][ColumnaRandom].estaOcupado()){
			ColumnaRandom = (int) ( Math.random() * (this.columnas-1));
			FilaRandom = (int) ( Math.random() * (this.filas-1));
			
		}
		this.mapa[FilaRandom][ColumnaRandom].ponerObstaculoOSorpresa(this.elegirUnObstaculoOSorpresa());
	}

	private Obstaculo elegirUnObstaculoOSorpresa(){
		int posicionRandom = (int)Math.random()*(this.coleccionDeObjetosYSorpresas.size()-1);
		return this.coleccionDeObjetosYSorpresas.get(posicionRandom);	
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
		this.mapa[fila][columna].ponerVehiculo(unVehiculo);
	}
	
	public Vehiculo getVehiculoEn(int fila, int columna) throws PosicionInvalidaException{
		if( !this.posicionValida(fila, columna) ){
			throw new PosicionInvalidaException();
		}
		return this.mapa[fila][columna].getVehiculoEnCasillero();
	}

}