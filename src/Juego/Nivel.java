package Juego;

import Tablero.Posicion;
import Tablero.Tablero;

public abstract class Nivel {

	public abstract Tablero inicializarTablero();

	public abstract Posicion posicionInicialDelVehiculo();
	
	public abstract Posicion posicionDeLaLlegada();
}
