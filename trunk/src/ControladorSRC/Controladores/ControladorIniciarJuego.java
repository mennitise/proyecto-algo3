package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Vista.MapaJuegoVista;
import Vista.VentanaPedirNivelVista;
import Vista.VentanaPedirVehiculoVista;
import Archivadores.ArchivadorDeJugadores;
import Excepciones.CanceloJuegoException;
import Excepciones.JugadorNoCargadoException;
import Excepciones.NivelInvalidoException;
import Excepciones.NoExistePartidaGuardadaException;
import Excepciones.NombreInvalidoException;
import Excepciones.PartidaEnJuegoException;
import Excepciones.VehiculoInvalidoException;
import Juego.DatoJugador;
import Juego.Juego;

public class ControladorIniciarJuego {
	
	private Juego juegoActual;
	private MapaJuegoVista mapaJuegoActual;
	
	public ControladorIniciarJuego(Juego unJuego, MapaJuegoVista unMapa){
		this.juegoActual = unJuego;
		this.mapaJuegoActual = unMapa;
	}
	
	private class EscuchaBotonNuevoJuego implements ActionListener
	{
		private String nombreDelJugador;
		
		EscuchaBotonNuevoJuego(String nombreDelJugador){
			this.nombreDelJugador = nombreDelJugador;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			cargarJuego(this.nombreDelJugador);
			
		}
	}
	
	public ActionListener getListenerBotonNuevoJuego(String nombreDelJugador){
		return new EscuchaBotonNuevoJuego(nombreDelJugador);
	}
	
	
	private class EscuchaBotonCargarPartida implements ActionListener
	{	
		String nombreDelJugador;
		EscuchaBotonCargarPartida(String nombre){
			nombreDelJugador = nombre;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			cargarPartidaExistente(nombreDelJugador);
		}
	}
	
	public ActionListener getListenerBotonCargarPartida(String nombre){
		return new EscuchaBotonCargarPartida(nombre);
	}

	private class EscuchaBotonVerPuntajes implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
			
			Hashtable unHashDatosJugadores = ArchivadorDeJugadores.cargarListaDeDatosDeJugadores(Juego.getNombreArchivoDeJugadores());
			Enumeration datosJugador = unHashDatosJugadores.elements(); 
			
					
			ArrayList<DatoJugador> listaDeJugadores = new ArrayList<DatoJugador>();
			while(datosJugador.hasMoreElements()){
				DatoJugador datoJugadorActual = (DatoJugador)datosJugador.nextElement();
				listaDeJugadores.add(datoJugadorActual);
				
			}
			
			this.ordenarLista(listaDeJugadores);
		
			this.mostrarVentanaDePuntajes(listaDeJugadores);		
			
		}

		private void ordenarLista (ArrayList<DatoJugador> listaDeJugadores){
			Collections.sort(listaDeJugadores, new Comparator<DatoJugador>(){
			    public int compare(DatoJugador d1, DatoJugador d2) {
			        if (d1.getPuntaje()<d2.getPuntaje()){
			        	return 1;
			        } else if (d1.getPuntaje()== d2.getPuntaje()){
			        	return 0;
			        }
			        return -1;
			    }
			});
		}
	

		private void mostrarVentanaDePuntajes(ArrayList<DatoJugador> listaDeJugadores){
			String unstring = "";
			if (listaDeJugadores.size() == 0){
				unstring = "No hay puntajes existentes";
			} else {
				for (int i=0; i<listaDeJugadores.size(); i++){
					unstring = unstring + listaDeJugadores.get(i).getNombre() + ": "+ listaDeJugadores.get(i).getPuntaje() + System.getProperty("line.separator");		
				}
			}
			JOptionPane.showMessageDialog(null,	unstring ,"Puntajes",JOptionPane.WARNING_MESSAGE);
		}	
	
	}

	public ActionListener getListenerBotonVerPuntajes() {
		return new EscuchaBotonVerPuntajes();
	}
			
	private void cargarJuego(String nombreDelJugador){
		int nivel = 0;
		int vehiculo = 0;
		
		if ((nombreDelJugador != null) && (nivel != -1) && (vehiculo != -1)) {
				try {
					juegoActual.setJugador(nombreDelJugador);
					nivel = VentanaPedirNivelVista.pedirNivel();
					vehiculo = VentanaPedirVehiculoVista.pedirVehiculo();
					juegoActual.iniciarPartida(nivel, vehiculo);
					mapaJuegoActual.inicializarCon(juegoActual);
				
				} catch (NombreInvalidoException e1) {
					JOptionPane.showMessageDialog(null,"Nombre Invalido","Aviso",JOptionPane.WARNING_MESSAGE);
				} catch (PartidaEnJuegoException e1) {
						try {
							juegoActual.nuevaPartida(nivel, vehiculo);
							mapaJuegoActual.inicializarCon(juegoActual);

						} catch (NivelInvalidoException e){
							
						} catch (VehiculoInvalidoException e2) {
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				} catch (NivelInvalidoException e1) {}
				catch (VehiculoInvalidoException e1) {}
				catch (JugadorNoCargadoException e1) {}
				catch (InterruptedException e1) {} 
				catch (CanceloJuegoException e1) {}
			
		}
		
	}
	
	private void cargarPartidaExistente(String nombreDelJugador){
		
		try {
			juegoActual.setJugador(nombreDelJugador);
			juegoActual.cargarPartida();
			juegoActual.setJugador(juegoActual.getPartida().getGestorDeMovimientos().getVehiculoEnPosicionActual().getConductor());
			mapaJuegoActual.inicializarCon( juegoActual);	
		} catch (NoExistePartidaGuardadaException e1) {
			JOptionPane.showMessageDialog(null,"Lo lamento. No tienes una partida guardada","Aviso",JOptionPane.WARNING_MESSAGE);
		} catch (NombreInvalidoException e1) {} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
		private DatoJugador pedirJugador(){
			Hashtable unHashDatosJugadores = ArchivadorDeJugadores.cargarListaDeDatosDeJugadores(Juego.getNombreArchivoDeJugadores());
			Enumeration datosJugador = unHashDatosJugadores.elements(); 
			int cantidadDeJugadores = unHashDatosJugadores.size();
			String unstring = "";
			Object[] nombresDeLosJugadores = new Object[cantidadDeJugadores];
			
			if(!datosJugador.hasMoreElements()){
				unstring = "NO HAY NINGUN JUGADOR CREADO";
				JOptionPane.showMessageDialog(null,	unstring ,"Jugadores Creados",JOptionPane.WARNING_MESSAGE);
				return null;
			}
			
			int posicion = 0;
			while(datosJugador.hasMoreElements()){
				DatoJugador datoJugadorActual = (DatoJugador)datosJugador.nextElement();
				nombresDeLosJugadores[posicion]  = datoJugadorActual.getNombre();
				posicion++;
			}
			
			String jugadorElegido = (String)JOptionPane.showInputDialog(
                    new JFrame(),
                    "Elegir Jugador",
                    "Jugador",
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon(),
                    nombresDeLosJugadores,
                    "Jugador");

			if (jugadorElegido == null){
				return null;	
			}else{
				return (DatoJugador)unHashDatosJugadores.get(jugadorElegido);
			}
		}

		
		
		protected String pedirOpcion() throws CanceloJuegoException{
			Object[] posibilidades = {"Nuevo Juego", "Cargar Partida", "Ver Puntajes"};
			String opcionElegida = (String)JOptionPane.showInputDialog(
			                    new JFrame(),
			                    "Elegir una opcion",
			                    "Opcion",
			                    JOptionPane.PLAIN_MESSAGE,
			                    new ImageIcon(),
			                    posibilidades,
			                    "Nuevo Juego");

		if (opcionElegida == null){
			throw new CanceloJuegoException();
		}else{
			
			if (opcionElegida.equals("Nuevo Juego")) return "Nuevo Juego";
			if (opcionElegida.equals("Cargar Partida")) return "Cargar Partida";
			if (opcionElegida.equals("Ver Puntajes")) return "Ver Puntajes";
		}

		return "Nuevo Juego";

		}
	
		
		
	
		

	
}

