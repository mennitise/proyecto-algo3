package Juego;

import Obstaculos.ControlPolicial;
import Obstaculos.Piquete;
import Obstaculos.Pozo;
import Sorpresas.SorpresaCambioDeVehiculo;
import Sorpresas.SorpresaDesfavorable;
import Sorpresas.SorpresaFavorable;
import Tablero.Calle;
import Tablero.Esquina;
import Tablero.Posicion;
import Tablero.Tablero;

public class NivelFacil extends Nivel {

	private Posicion posicionInicialVehiculo;
	private Posicion posicionLlegada;
	private Esquina esquina; // Usado para inicializar el tablero.
	private Calle calleADer; // Usado para inicializar el tablero.
	private Calle calleAbaj; // Usado para inicializar el tablero.
	
	public NivelFacil(){
		super();
		this.posicionInicialVehiculo = new Posicion(5,0);
		this.posicionLlegada = new Posicion(5,9);
	}
	
	public void getEsquinaConCalles(Tablero unTablero, Posicion unaPos){
		this.esquina = unTablero.getEsquinaEn(unaPos);
		this.calleADer = this.esquina.getCalleEste();
		this.calleAbaj = this.esquina.getCalleSur();
	}
	
	private void inicializarFila(Tablero tablero, Posicion unaPos){
		// Esquina en x,0
		getEsquinaConCalles(tablero, unaPos);
		
		calleADer.agregarObstaculo(new Piquete());
		calleAbaj.agregarSorpresa(new SorpresaCambioDeVehiculo());
		
		// Esquina en x,1
		unaPos.moverAlEste();
		getEsquinaConCalles(tablero, unaPos);
		
		calleADer.agregarObstaculo(new Pozo());
		calleAbaj.agregarObstaculo(new ControlPolicial());
		
		// Esquina en x,2
		unaPos.moverAlEste();
		getEsquinaConCalles(tablero, unaPos);
		
		calleADer.agregarSorpresa(new SorpresaFavorable());
		calleAbaj.agregarSorpresa(new SorpresaDesfavorable());
		
		// Esquina en x,3
		unaPos.moverAlEste();
		getEsquinaConCalles(tablero, unaPos);
		
		calleADer.agregarSorpresa(new SorpresaFavorable());
		calleADer.agregarObstaculo(new Piquete());
		calleAbaj.agregarObstaculo(new Pozo());

		// Esquina en x,4
		unaPos.moverAlEste();
		getEsquinaConCalles(tablero, unaPos);
		
		calleADer.agregarObstaculo(new ControlPolicial());
		calleAbaj.agregarSorpresa(new SorpresaCambioDeVehiculo());
		
		// Esquina en x,5
		unaPos.moverAlEste();
		getEsquinaConCalles(tablero, unaPos);
		
		calleADer.agregarSorpresa(new SorpresaFavorable());
		calleAbaj.agregarSorpresa(new SorpresaDesfavorable());
		
		
		// Esquina en x,6
		unaPos.moverAlEste();
		getEsquinaConCalles(tablero, unaPos);
		
		calleADer.agregarObstaculo(new Pozo());
		calleAbaj.agregarObstaculo(new Pozo());
		
		// Esquina en x,7
		unaPos.moverAlEste();
		getEsquinaConCalles(tablero, unaPos);
		
		calleADer.agregarSorpresa(new SorpresaFavorable());
		calleAbaj.agregarObstaculo(new Piquete());
		
		// Esquina en x,8
		unaPos.moverAlEste();
		getEsquinaConCalles(tablero, unaPos);

		calleADer.agregarObstaculo(new Piquete());
		calleAbaj.agregarSorpresa(new SorpresaCambioDeVehiculo());
	}
	
	@Override
	public Tablero inicializarTablero() {
		
		Tablero tablero = new Tablero(10,10);
		
		Posicion unaPos = new Posicion(0,0); 
		this.inicializarFila(tablero, unaPos);
		
		unaPos = new Posicion(1,0);
		this.inicializarFila(tablero, unaPos);
		
		unaPos = new Posicion(2,0);
		this.inicializarFila(tablero, unaPos);
		
		unaPos = new Posicion(3,0);
		this.inicializarFila(tablero, unaPos);
		
		unaPos = new Posicion(4,0);
		this.inicializarFila(tablero, unaPos);
		
		unaPos = new Posicion(5,0);
		this.inicializarFila(tablero, unaPos);
		
		unaPos = new Posicion(6,0);
		this.inicializarFila(tablero, unaPos);
		
		unaPos = new Posicion(7,0);
		this.inicializarFila(tablero, unaPos);
		
		unaPos = new Posicion(8,0);
		this.inicializarFila(tablero, unaPos);
		
		return tablero;
	}

	@Override
	public Posicion getPosicionInicialDelVehiculo() {
		int fila    = this.posicionInicialVehiculo.getFila();
		int columna = this.posicionInicialVehiculo.getColumna();
		return new Posicion(fila,columna);
	}
	
	@Override
	public Posicion getPosicionDeLaLlegada() {
		int fila    = this.posicionLlegada.getFila();
		int columna = this.posicionLlegada.getColumna();
		return new Posicion(fila,columna);
	}

}
