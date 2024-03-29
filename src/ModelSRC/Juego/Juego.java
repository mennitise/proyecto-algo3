package Juego;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;
import Archivadores.ArchivadorDeJugadores;
import Archivadores.ArchivadorDePartida;
import Excepciones.JugadorNoCargadoException;
import Excepciones.NivelInvalidoException;
import Excepciones.NoExistePartidaGuardadaException;
import Excepciones.NombreInvalidoException;
import Excepciones.VehiculoInvalidoException;
import Excepciones.PartidaEnJuegoException;
import Excepciones.StringVacioException;
import Jugador.Jugador;
import Niveles.Nivel;
import Niveles.NivelDificil;
import Niveles.NivelFacil;
import Niveles.NivelMedio;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;
import Vista.VentanaPrincipal;

public class Juego extends Observable {

	private ArrayList<Nivel> niveles;
	private Partida partidaActual;
	private Jugador unJugador;
	private int cantidadDeVehiculosDisponibles;
	
	private Hashtable datosDeJugadoresExistentes;
	private static String nombreDeArchivoListaJugadores = "JugadoresExistentes.xml";
	
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
		this.niveles.add(new NivelMedio());
		this.niveles.add(new NivelDificil());
	}
	
	public static String getNombreArchivoDeJugadores(){
		return nombreDeArchivoListaJugadores;
	}
	
	public void asignarPuntaje(){
		int puntaje = partidaActual.calcularPuntaje(unJugador.getCantidadDeMovimientos());
		((DatoJugador) this.datosDeJugadoresExistentes.get(this.unJugador.getNombre())).asignarPuntaje(puntaje);
	}
	
	public int obtenerPuntaje(){

		int puntaje = partidaActual.calcularPuntaje(unJugador.getCantidadDeMovimientos());
		return puntaje;
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
		this.partidaActual = null;
		setChanged();
		notifyObservers();
	}
	
	public Partida getPartida(){
		return this.partidaActual;
	}
	
	public void cargarPartida() throws NoExistePartidaGuardadaException{
		// Verificar que el jugador tenga una partida guardada
		DatoJugador datos = (DatoJugador) this.datosDeJugadoresExistentes.get(this.unJugador.getNombre());
		this.partidaActual = ArchivadorDePartida.cargar(datos.getNombreArchivoPartida());
		setChanged();
		notifyObservers();
	}
	

	public void guardarListaDeJugadoresExistentes(){
		// Guarda en archivo los jugadores existentes hasta el momento.
		ArchivadorDeJugadores.guardarListaDeDatosDeJugadores(this.datosDeJugadoresExistentes, this.nombreDeArchivoListaJugadores);
	}
	
	public void setJugador(String nombreJugador) 
			throws NombreInvalidoException{
		
				
		// Intenta crear un jugador sin veh�culo.
		try {
			this.unJugador = new Jugador(nombreJugador, null);
		} catch (StringVacioException e) {
			throw new NombreInvalidoException();
		}
		
		// Agrego dato de nuevo jugador existente.
		DatoJugador dato = new DatoJugador(nombreJugador);
		this.datosDeJugadoresExistentes.put(nombreJugador, dato);
		
	}

	public void setJugador(Jugador unJug){
		this.unJugador = unJug;
	}
	
	private Nivel obtenerNivelNumero(int numeroNivel){
		if( numeroNivel == 2){
			return new NivelMedio();
		}
		if( numeroNivel == 3){
			return new NivelDificil();
		}
		return new NivelFacil();
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

		// Verifica n�mero de nivel.
		if( (numeroNivel < 1) || (numeroNivel > niveles.size())){
			throw new NivelInvalidoException();
		}
		
		// Verifica n�mero de Vehiculo. 
		if( (numeroVehiculo < 1) || (numeroVehiculo > this.cantidadDeVehiculosDisponibles)){
			throw new VehiculoInvalidoException();
		}
		
		Nivel unNivel = this.obtenerNivelNumero(numeroNivel);
		
		Vehiculo unVehiculo = this.getVehiculo(numeroVehiculo);
		this.unJugador.setVehiculo(unVehiculo);
		this.partidaActual = new Partida(this.unJugador, unNivel);
		setChanged();
		notifyObservers();
	}
	
	public void nuevaPartida(int numeroNivel, int numeroVehiculo) throws NivelInvalidoException, VehiculoInvalidoException{
		// Verifica n�mero de nivel.
				if( (numeroNivel < 1) || (numeroNivel > niveles.size())){
					throw new NivelInvalidoException();
				}
				
				// Verifica n�mero de Vehiculo. 
				if( (numeroVehiculo < 1) || (numeroVehiculo > this.cantidadDeVehiculosDisponibles)){
					throw new VehiculoInvalidoException();
				}
				
				Nivel unNivel = this.obtenerNivelNumero(numeroNivel);
				Vehiculo unVehiculo = this.getVehiculo(numeroVehiculo);
				this.unJugador.setVehiculo(unVehiculo);
				this.partidaActual = new Partida(this.unJugador, unNivel);
				setChanged();
				notifyObservers();
	}

	public ArrayList<String> getListaNombreNivelesConNumero() {
		
		// Devuelve una lista con los nombres de los niveles
		// y el n�mero correspondiente a cada uno.
		
		ArrayList<String> listaNiveles = new ArrayList<String>();
		listaNiveles.add("1. Nivel Facil");
		
		return listaNiveles;
	}
	
	public ArrayList<String> getListaNombresNumeradosVehiculosDisponibles(){
		
		// Devuelve una lista con los nombres de los veh�culos disponibles
		// con el n�mero correspondiente a cada uno.
		
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
			// El n�mero del veh�culo se verifica antes de ingresar ac�
			// por lo que siempre ser� v�lido
			unVehiculo = new CuatroXCuatro();
			break;
		}
		return unVehiculo;
	}

	public boolean terminoLaPartida() {
		return (this.getPartida().ganoLaPartida()|| this.getPartida().perdioLaPartida());
	}

	
	public static void main(String[] args){
		VentanaPrincipal ventana = new VentanaPrincipal();
	}
	
}

