package Tablero;

public class Posicion {

	private int fila;
	private int columna;
	
	public Posicion(int laFila, int laColumna){
		this.fila = laFila;
		this.columna = laColumna;
	}
	
	public int getColumna(){
		return this.columna;
	}
	
	public int getFila(){
		return this.fila;
	}
	
	public void moverAlOeste(){
		this.columna -= 1;
	}
	
	public void moverAlEste(){
		this.columna += 1;
	}
	
	public void moverAlNorte(){
		this.fila -= 1;
	}
	
	public void moverAlSur(){
		this.fila += 1;
	}

	public boolean esIgual(Posicion posicionFinal) {
		return ( ( this.columna == posicionFinal.getColumna() ) & (this.fila == posicionFinal.getFila()) );
	}
	
}
