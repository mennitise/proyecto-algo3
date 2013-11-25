package Juego;

import Tablero.Posicion;
import Tablero.Tablero;

public abstract class Nivel {

	public abstract Tablero inicializarTablero();

	public abstract Posicion getPosicionInicialDelVehiculo();
	
	public abstract Posicion getPosicionDeLaLlegada();
	
	public abstract int getCantidadMaximaDeMovimientos();
}
