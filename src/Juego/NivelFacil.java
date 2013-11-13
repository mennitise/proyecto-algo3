package Juego;

import Tablero.Posicion;
import Tablero.Tablero;

public class NivelFacil extends Nivel {

	private Posicion posicionInicialVehiculo;
	private Posicion posicionLlegada;
	
	public NivelFacil(){
		super();
		this.posicionInicialVehiculo = new Posicion(5,0);
		this.posicionLlegada = new Posicion(5,9);
	}
	
	@Override
	public Tablero inicializarTablero() {
		
		Tablero tableroUno = new Tablero(10,10);
		
		// Inicializarlo
		
		return tableroUno;
	}

	@Override
	public Posicion posicionInicialDelVehiculo() {
		int fila    = this.posicionInicialVehiculo.getFila();
		int columna = this.posicionInicialVehiculo.getColumna();
		return new Posicion(fila,columna);
	}

	@Override
	public Posicion posicionDeLaLlegada() {
		int fila    = this.posicionLlegada.getFila();
		int columna = this.posicionLlegada.getColumna();
		return new Posicion(fila,columna);
	}

}
