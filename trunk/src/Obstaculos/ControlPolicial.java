package Obstaculos;

import Jugador.Jugador;

public class ControlPolicial extends Obstaculo{ 
	
	

	public ControlPolicial(){
		super();
		this.cantidadDeMovimientosAPenalizar = 2;
	}
	
	public void penalizarA(Jugador unJugador){
		
		double probabilidad = unJugador.getProbabilidadDeSerDetenidoPorControlPolicial();		
		double numeroRandom = Math.random();
	
		if (numeroRandom<probabilidad){
			super.penalizarA(unJugador);
		}
	}
	
}

