package Juego;

import java.util.Observable;
import org.jdom.Element;
import GestorDeMovimientos.GestorDeMovimientos;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.Tablero;

public class Partida extends Observable{
	
	private Jugador unJugador;
	private Tablero unTablero;
	private Nivel   unNivel;
	private GestorDeMovimientos unGestor;
	
	public Partida(Jugador jugador, Nivel unNivel){
		this.unJugador = jugador;
		this.unNivel = unNivel;
		this.unJugador.getVehiculo().setPosicion(this.unNivel.getPosicionInicialDelVehiculo());
		this.unTablero = this.unNivel.inicializarTablero();
		this.unGestor = new GestorDeMovimientos(this.unJugador, unTablero);
	}
	
	public Partida(Jugador jugador, Nivel unNivel, Tablero unTablero){
		this.unJugador = jugador;
		this.unNivel = unNivel;
		this.unTablero = unTablero;
		this.unGestor = new GestorDeMovimientos(this.unJugador, this.unTablero);
	}

	public String getNombreJugador() {
		return this.unJugador.getNombre();
	}
	
	public Posicion getPosicionDeLlegada(){
		return this.unNivel.getPosicionDeLaLlegada();
	}
	
	public Posicion getPosicionJugador(){
		return this.unJugador.getVehiculo().getPosicion();
	}
	
	public int getCantidadDeMovimientosDelJugador(){
		return this.unJugador.getCantidadDeMovimientos();
	}
	
	public Tablero getTablero(){
		return this.unTablero;
	}

	public GestorDeMovimientos getGestorDeMovimientos(){
		return this.unGestor;
	}
	
	public int getCantidadDeMovimientosMaximaEnNivelActual(){
		return this.unNivel.getCantidadMaximaDeMovimientos();
	}
	
	public boolean ganoLaPartida() {
		Posicion posicionJugador = this.unJugador.getVehiculo().getPosicion();
		Posicion posicionFinal = this.unNivel.getPosicionDeLaLlegada();
		boolean ganoLaPartida = posicionJugador.esIgual(posicionFinal);
		if (ganoLaPartida){
			setChanged();
			notifyObservers();
		}
		
		return ganoLaPartida;
	}
	
	public boolean perdioLaPartida() {
		return (this.unJugador.getCantidadDeMovimientos()>this.unNivel.getCantidadMaximaDeMovimientos());
	}

	public int calcularPuntaje(int cantidadDeMovimientos) {
		return this.unNivel.calcularPuntaje(cantidadDeMovimientos);
	}
	
	// Serialización
	
	public Element serializarXML(){
		
		Element element = new Element("partida");
		Element elementJugador = this.unJugador.serializarXML();
		Element elementNivel = this.unNivel.serializarXML();
		Element elementTablero = this.unTablero.serializarXML();
		element.getChildren().add(elementJugador);
		element.getChildren().add(elementNivel);
		element.getChildren().add(elementTablero);
		return element;
	}
	
	public static Partida cargarDesdeXML(Element element) {
		
		Element elementJugador = (Element)element.getChildren().get(0);
		Jugador unJugador = Jugador.cargarDesdeXML(elementJugador);
		Element elementNivel = (Element)element.getChildren().get(1);
		Nivel unNivel = Nivel.cargarDesdeXML(elementNivel);
		Element elementTablero = (Element)element.getChildren().get(2);
		Tablero unTablero = Tablero.cargarDesdeXML(elementTablero);
		return new Partida(unJugador, unNivel, unTablero);
	}
}
