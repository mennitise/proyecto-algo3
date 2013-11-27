package Juego;

import org.jdom.Attribute;
import org.jdom.Element;

import GestorDeMovimientos.EstrategiaEste;
import GestorDeMovimientos.EstrategiaNorte;
import GestorDeMovimientos.EstrategiaOeste;
import GestorDeMovimientos.EstrategiaSur;
import GestorDeMovimientos.GestorDeMovimientos;
import Jugador.Jugador;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Vehiculo;

public class Partida {
	
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

	public String getNombreJugador() {
		return this.unJugador.getNombre();
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
		return posicionJugador.esIgual(posicionFinal);
	}
	
	public boolean perdioLaPartida() {
		return (this.unJugador.getCantidadDeMovimientos()>this.unNivel.getCantidadMaximaDeMovimientos());
	}

	// Serialización
	
	public Element serializarXML(){
		
		Element element = new Element("partida");
		Element elementJugador = this.unJugador.serializarXML();
		Element elementNivel = this.unNivel.serializarXML();
		element.getChildren().add(elementJugador);
		element.getChildren().add(elementNivel);
		return element;
	}
	
	public static Partida cargarDesdeXML(Element element) {
		
		Element elementJugador = (Element)element.getChildren().get(0);
		Jugador unJugador = Jugador.cargarDesdeXML(elementJugador);
		Element elementNivel = (Element)element.getChildren().get(1);
		Nivel unNivel = Nivel.cargarDesdeXML(elementNivel);
		return Partida.cargarPartidaExistente(unJugador,unNivel);
	}

	private static Partida cargarPartidaExistente(Jugador unJugador,Nivel unNivel) {
		
		Posicion copiaPosicion = unJugador.getVehiculo().getPosicion().getCopiaDePosicion();
		Partida unaPartida = new Partida(unJugador, unNivel);
		unJugador.getVehiculo().setPosicion(copiaPosicion);
		return unaPartida;
	}

	
	public int calcularPuntaje(int cantidadDeMovimientos) {
		return this.unNivel.calcularPuntaje(cantidadDeMovimientos);
	}
	
	
}
