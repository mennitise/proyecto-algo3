package GestorDeMovimientos;

import Tablero.Tablero;
import Vehiculos.Vehiculo;
import Excepciones.PosicionInvalidaException;

public class GestorDeMovimientos {

	private int filaActual;
	private int columnaActual;
	private Tablero tablero;
	
	public GestorDeMovimientos(int filaOrigen, int columnaOrigen, Tablero tablero) throws PosicionInvalidaException {
		
		if( !tablero.posicionValida(filaOrigen, columnaOrigen) ){
			
			throw new PosicionInvalidaException();
		} else{
			
			this.filaActual    = filaOrigen;
			this.columnaActual = columnaOrigen;
			this.tablero       = tablero;
		}
	}

	public boolean esPosibleMoverseA(int filaDestino, int columnaDestino) {
		 
		if(!tablero.posicionValida(filaDestino, columnaDestino)){
			return false;
		}
		
		 int distanciaHorizontal = Math.abs(filaDestino - filaActual);
		 int distanciaVertical   = Math.abs(columnaDestino - columnaActual);
		 
		 if( ( distanciaHorizontal == 0 ) || ( distanciaHorizontal == 2 ) ){
			 if( ( distanciaVertical == 0 ) || ( distanciaVertical == 2 ) ){
				 return true;
			 }
		 }
		 return false;
	}

	public int getFilaActual() {
		return filaActual;
	}

	public int getColumnaActual() {
		return columnaActual;
	}

	public void moverVehiculoEnPosicionActualA(int fila, int columna) throws PosicionInvalidaException{
		
		if( !tablero.posicionValida(fila, columna) || !this.esPosibleMoverseA(fila, columna)){
			throw new PosicionInvalidaException();
		}
		Vehiculo vehiculo = tablero.quitarVehiculoEn(filaActual, columnaActual);
		
		// Acá faltaría agregar penalizar si hay obstáculo o dar sorpresa si la hay.
		
		tablero.colocarVehiculoEn(vehiculo, fila, columna);
		filaActual    = fila;
		columnaActual = columna;
	}

	public Vehiculo getVehiculoEnPosicionActual() {
		try{
			return tablero.getVehiculoEn(filaActual, columnaActual);
		}catch(PosicionInvalidaException e){
			return null;
		}
	}
}
