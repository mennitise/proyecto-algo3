package Juego;

import Jugador.Jugador;
import Tablero.Tablero;

public class Partida {
	
	Jugador unJugador;
	Tablero unTablero;
	Nivel   nivel;
	
	public Partida(Jugador jugador, Nivel unNivel){
		
		this.unJugador = jugador;
		this.nivel = unNivel;
		this.unTablero = this.nivel.inicializarTablero();
	}

	public String getNombreJugador() {
		return this.unJugador.getNombre();
	}

}
