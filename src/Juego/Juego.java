package Juego;

import java.util.ArrayList;

import Excepciones.JugadorCargadoException;
import Excepciones.JugadorNoCargadoException;
import Excepciones.NombreInvalidoException;
import Excepciones.NumeroDeNivelInvalidoException;
import Excepciones.NumeroDeVehiculoInvalidoException;
import Excepciones.PartidaEnJuegoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Tablero.Posicion;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class Juego {

	private ArrayList<Nivel> niveles;
	private Partida partidaActual;
	private Jugador unJugador;
	private int cantidadDeVehiculosDisponibles;
	
	public Juego(){
		this.inicializarNiveles();
		this.unJugador = null;
		this.partidaActual = null;
		this.cantidadDeVehiculosDisponibles = 3;
	}

	private void inicializarNiveles(){
		this.niveles = new ArrayList<Nivel>();
		this.niveles.add(new NivelFacil());
	}
	
	public boolean hayJugadorActivo(){
		return (unJugador != null);
	}
	
	public boolean hayPartidaActiva(){
		return (partidaActual != null);
	}
	
	public void setJugador(String nombreJugador) 
			throws NombreInvalidoException, JugadorCargadoException{
		
		if(this.hayJugadorActivo()){
			throw new JugadorCargadoException();
		}
		
		// Intenta crear un jugador sin vehículo.
		try {
			this.unJugador = new Jugador(nombreJugador, null);
		} catch (StringVacioException e) {
			throw new NombreInvalidoException();
		}
	}

	public void iniciarPartida(int numeroNivel, int numeroVehiculo) 
			throws PartidaEnJuegoException, NumeroDeNivelInvalidoException, NumeroDeVehiculoInvalidoException, JugadorNoCargadoException{

		// Verifica que no haya una partida en juego.
		if(this.hayPartidaActiva()){
			throw new PartidaEnJuegoException();
		}
		
		// Verifica que haya un jugador inicializado.
		if(!this.hayJugadorActivo()){
			throw new JugadorNoCargadoException();
		}

		// Verifica número de nivel.
		if( (numeroNivel < 1) || (numeroNivel > niveles.size())){
			throw new NumeroDeNivelInvalidoException();
		}
		
		// Verifica número de Vehiculo. 
		if( (numeroNivel < 1) || (numeroNivel > this.cantidadDeVehiculosDisponibles)){
			throw new NumeroDeVehiculoInvalidoException();
		}
		
		Nivel unNivel = this.niveles.get(numeroNivel - 1);
		this.partidaActual = new Partida(this.unJugador, unNivel);
		Posicion posicionVehiculo = unNivel.posicionInicialDelVehiculo();
		Vehiculo unVehiculo = this.getVehiculo(numeroVehiculo,posicionVehiculo);
		this.unJugador.setVehiculo(unVehiculo);
	}

	public ArrayList<String> getListaNombreNivelesConNumero() {
		
		// Devuelve una lista con los nombres de los niveles
		// y el número correspondiente a cada uno.
		
		ArrayList<String> listaNiveles = new ArrayList<String>();
		listaNiveles.add("1. Nivel Facil");
		
		return listaNiveles;
	}
	
	public ArrayList<String> getListaNombresNumeradosVehiculosDisponibles(){
		
		// Devuelve una lista con los nombres de los vehículos disponibles
		// con el número correspondiente a cada uno.
		
		ArrayList<String> listaVehiculos = new ArrayList<String>();
		listaVehiculos.add("1. Auto");
		listaVehiculos.add("2. Moto");
		listaVehiculos.add("3. 4x4");
				
		return listaVehiculos;
	}
	
	private Vehiculo getVehiculo(int numeroVehiculo, Posicion posicionVehiculo) {
		
		Vehiculo unVehiculo;
		switch(numeroVehiculo){
		case 1:
			unVehiculo = new Auto(posicionVehiculo);
			break;
		case 2:
			unVehiculo = new Moto(posicionVehiculo);
			break;
		default:
			// El número del vehículo se verifica antes de ingresar acá
			// por lo que siempre será válido
			unVehiculo = new CuatroXCuatro(posicionVehiculo);
			break;
		}
		return unVehiculo;
	}

}
