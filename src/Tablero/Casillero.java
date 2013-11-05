package Tablero;

import Obstaculos.Obstaculo;

public class Casillero {
	
	private Obstaculo contenido;
	
	public Casillero(){
		this.contenido = null;
	}
	
	public boolean estaOcupado() {
		return (!this.estaVacio());
	}

	public boolean estaVacio() {
		return (this.contenido == null);
	}
	public void ponerObstaculoOSorpresa(Obstaculo unObstaculo) {
		this.contenido = unObstaculo;
		
	}

}
