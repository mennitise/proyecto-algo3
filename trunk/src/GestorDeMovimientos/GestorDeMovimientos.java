package GestorDeMovimientos;

import Tablero.Tablero;
import Excepciones.PosicionInvalidaException;

public class GestorDeMovimientos {

	private int filaActual;
	private int columnaActual;
	
	public GestorDeMovimientos(int filaOrigen, int columnaOrigen, Tablero tablero) throws PosicionInvalidaException {
		
		if( (filaOrigen < 0) || (columnaOrigen < 0) || (filaOrigen > tablero.getFilas()) || (columnaOrigen > tablero.getColumnas())){
			
			throw new PosicionInvalidaException();
		} else{
			
			this.filaActual    = filaOrigen;
			this.columnaActual = columnaOrigen;
		}
		
		
	}

	public boolean esPosibleMoverseA(int filaDestino, int columnaDestino) {
		
		 int distanciaHorizontal = Math.abs(filaDestino - filaActual);
		 int distanciaVertical   = Math.abs(columnaDestino - columnaActual);
		 
		 if( ( distanciaHorizontal == 0 ) || ( distanciaHorizontal == 2 ) ){
			 if( ( distanciaVertical == 0 ) || ( distanciaVertical == 2 ) ){
				 return true;
			 }
		 }
		 return false;
	}

}
