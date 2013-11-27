package Juego;

import java.util.ArrayList;
import java.util.Hashtable;

import Excepciones.JugadorCargadoException;
import Excepciones.JugadorNoCargadoException;
import Excepciones.NivelInvalidoException;
import Excepciones.NoExistePartidaGuardadaException;
import Excepciones.NombreInvalidoException;
import Excepciones.NumeroDeNivelInvalidoException;
import Excepciones.VehiculoInvalidoException;
import Excepciones.PartidaEnJuegoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;

public class Juego {

	private ArrayList<Nivel> niveles;
	private Partida partidaActual;
	private Jugador unJugador;
	private int cantidadDeVehiculosDisponibles;
	
	private Hashtable datosDeJugadoresExistentes;
	private String nombreDeArchivoListaJugadores = "JugadoresExistentes.xml";
	
	public Juego(){
		this.inicializarNiveles();
		this.unJugador = null;
		this.partidaActual = null;
		this.cantidadDeVehiculosDisponibles = 3;
		// Cargar lista de jugadores anteriores
		this.datosDeJugadoresExistentes = this.cargarJugadoresExistentes();
	}
	
	private Hashtable cargarJugadoresExistentes(){
		try{
			return ArchivadorDeJugadores.cargarListaDeDatosDeJugadores(this.nombreDeArchivoListaJugadores);
		}catch(Exception e){
			return new Hashtable();
		}
	}
	
	private void inicializarNiveles(){
		this.niveles = new ArrayList<Nivel>();
		this.niveles.add(new NivelFacil());
	}
	
	public void asignarPuntaje(){
		int puntaje = partidaActual.calcularPuntaje(unJugador.getCantidadDeMovimientos());
		((DatoJugador) this.datosDeJugadoresExistentes.get(this.unJugador.getNombre())).asignarPuntaje(puntaje);
	}
	
	public boolean hayJugadorActivo(){
		return (unJugador != null);
	}
	
	public boolean hayPartidaActiva(){
		return (partidaActual != null);
	}
	
	public void guardarPartida(){
		String pathArchivo = ((DatoJugador) this.datosDeJugadoresExistentes.get(this.unJugador.getNombre())).getNombreArchivoPartida(); 
		ArchivadorDePartida.guardar(this.partidaActual, pathArchivo);
	}
	
	public void cargarPartida() throws NoExistePartidaGuardadaException{
		// Verificar que el jugador tenga una partida guardada
		DatoJugador datos = (DatoJugador) this.datosDeJugadoresExistentes.get(this.unJugador.getNombre());
		this.partidaActual = ArchivadorDePartida.cargar(datos.getNombreArchivoPartida());
	}

	public void guardarListaDeJugadoresExistentes(){
		// Guarda en archivo los jugadores existentes hasta el momento.
		String pathArchivo = ((DatoJugador) this.datosDeJugadoresExistentes.get(this.unJugador.getNombre())).getNombreArchivoPartida(); 
		ArchivadorDeJugadores.guardarListaDeDatosDeJugadores(this.datosDeJugadoresExistentes, pathArchivo);
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
		
		// Agrego dato de nuevo jugador existente.
		DatoJugador dato = new DatoJugador(nombreJugador);
		this.datosDeJugadoresExistentes.put(nombreJugador, dato);
		
	}

	public void iniciarPartida(int numeroNivel, int numeroVehiculo) 
			throws PartidaEnJuegoException, NivelInvalidoException, VehiculoInvalidoException, JugadorNoCargadoException{

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
			throw new NivelInvalidoException();
		}
		
		// Verifica número de Vehiculo. 
		if( (numeroVehiculo < 1) || (numeroVehiculo > this.cantidadDeVehiculosDisponibles)){
			throw new VehiculoInvalidoException();
		}
		
		Nivel unNivel = this.niveles.get(numeroNivel - 1);
		Vehiculo unVehiculo = this.getVehiculo(numeroVehiculo);
		this.unJugador.setVehiculo(unVehiculo);
		this.partidaActual = new Partida(this.unJugador, unNivel);
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
	
	private Vehiculo getVehiculo(int numeroVehiculo) {
		
		Vehiculo unVehiculo;
		switch(numeroVehiculo){
		case 1:
			unVehiculo = new Auto();
			break;
		case 2:
			unVehiculo = new Moto();
			break;
		default:
			// El número del vehículo se verifica antes de ingresar acá
			// por lo que siempre será válido
			unVehiculo = new CuatroXCuatro();
			break;
		}
		return unVehiculo;
	}

}
