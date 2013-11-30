package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Vista.MapaJuegoVista;
import Vista.PanelInicial;
import Excepciones.CanceloJuegoException;
import Excepciones.JugadorCargadoException;
import Excepciones.JugadorNoCargadoException;
import Excepciones.NivelInvalidoException;
import Excepciones.NoExistePartidaGuardadaException;
import Excepciones.NombreInvalidoException;
import Excepciones.PartidaEnJuegoException;
import Excepciones.VehiculoInvalidoException;
import GestorDeMovimientos.GestorDeMovimientos;
import Juego.ArchivadorDeJugadores;
import Juego.DatoJugador;
import Juego.Juego;
import Jugador.Jugador;

public class ControladorMenuPrincipal {
	
	private Juego juegoActual;
	
	public ControladorMenuPrincipal(Juego unJuego){
		this.juegoActual = unJuego;
	}
	
	
	private class EscuchaBotonJugadorExistente implements ActionListener{

		private DatoJugador pedirJugador(){
			Hashtable unHashDatosJugadores = ArchivadorDeJugadores.cargarListaDeDatosDeJugadores(Juego.getNombreArchivoDeJugadores());
			Enumeration datosJugador = unHashDatosJugadores.elements(); 
			int cantidadDeJugadores = unHashDatosJugadores.size();
			String unstring = "";
			Object[] nombresDeLosJugadores = new Object[cantidadDeJugadores];
			
			if(!datosJugador.hasMoreElements()){
				unstring = "NO HAY NINGUN JUGADOR CREADO";
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
				//IMPLEMENTAR
			}else{
				return (DatoJugador)unHashDatosJugadores.get(jugadorElegido);
				
			}

		}
		
		private String pedirOpcion() throws CanceloJuegoException{
			Object[] posibilidades = {"Nuevo Juego", "Cargar Partida"};
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
		
			switch (opcionElegida){
				case "Nuevo Juego": return "Nuevo Juego";
				case "Cargar Partida": return "Cargar Partida";
				};
		}

		return "Nuevo Juego";

		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
				
			String opcionElegida;
				try {
					opcionElegida = this.pedirOpcion();
					if (opcionElegida == "Nuevo Juego"){
						(new EscuchaBotonJugadorNuevo()).actionPerformed(e);;
					}
				} catch (CanceloJuegoException e) {
					
				}
				
				
		}
		
	}

	public ActionListener getListenerBotonJugadorExistente() {
		return new EscuchaBotonJugadorExistente();
	}
	
	private class EscuchaBotonJugadorNuevo implements ActionListener{	
	
		
		
		private int pedirVehiculo() throws CanceloJuegoException{
		 
			Object[] posibilidades = {"Auto", "CuatroXCuatro", "Moto"};
			String autoElegido = (String)JOptionPane.showInputDialog(
			                    new JFrame(),
			                    "Elegir Vehiculo",
			                    "Vehiculo",
			                    JOptionPane.PLAIN_MESSAGE,
			                    new ImageIcon(),
			                    posibilidades,
			                    "Auto");

		if (autoElegido == null){
			throw new CanceloJuegoException();
		}else{
		
			switch (autoElegido){
				case "Auto": return 1;
				case "CuatroXCuatro": return 3;
				case "Moto": return 2;
			};
		}

		return 1;
		}
		
		private int pedirNivel() throws CanceloJuegoException{
			Object[] posibilidades = {"Facil", "Intermedio", "Dificil"};
			String nivelElegido = (String)JOptionPane.showInputDialog(
			                    new JFrame(),
			                    "Elegir Nivel",
			                    "Nivel",
			                    JOptionPane.PLAIN_MESSAGE,
			                    new ImageIcon(),
			                    posibilidades,
			                    "Facil");

			if (nivelElegido == null){
				throw new CanceloJuegoException(); //significa que cancelo el juego
			}else{
			
				switch (nivelElegido){
					case "Facil": return 1;
					case "Intermedio": return 2;
					case "Dificil": return 3;
				};
			}
				
			return 1;	
			
		}
		
		public void actionPerformed(ActionEvent e){	
			 
			
			String nombre = new String("");			
			nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
			
			int nivel = 0;
			int vehiculo = 0;
			ControladorDeMovimientos control = null; //se inicializa si se puede crear el juego, sino no...
			
			if ((nombre != null) && (nivel != -1) && (vehiculo != -1)) {
					try {
						juegoActual.setJugador(nombre);
						nivel = this.pedirNivel();
						vehiculo = this.pedirVehiculo();
						juegoActual.iniciarPartida(nivel, vehiculo);
						
						control = new ControladorDeMovimientos (juegoActual.getPartida().getGestorDeMovimientos());
						MapaJuegoVista mapa = new MapaJuegoVista(control,juegoActual);
					} catch (NombreInvalidoException e1) {
						JOptionPane.showMessageDialog(null,"Nombre Invalido","Aviso",JOptionPane.WARNING_MESSAGE);
					} catch (PartidaEnJuegoException e1) {
							try {
								juegoActual.nuevaPartida(nivel, vehiculo);
								control = new ControladorDeMovimientos (juegoActual.getPartida().getGestorDeMovimientos());
							} catch (NivelInvalidoException
									| VehiculoInvalidoException e2) {}
						
					} catch (NivelInvalidoException e1) {}
					catch (VehiculoInvalidoException e1) {}
					catch (JugadorNoCargadoException e1) {}
					catch (InterruptedException e1) {} 
					catch (CanceloJuegoException e1) {}
				
			}
						
			//Solo se ejecuta esta Pieza cuando el nombre es valido, es para que no se salga del menu
//			
//			if ((nombre != null)) {
//				int nivel = 1;
//				int vehiculo = 1;
//				ControladorDeMovimientos control = null;
//				try {
//					//juegoActual = new Juego();
//					juegoActual.setJugador(nombre);
//					try {
//						try {
//							nivel = this.pedirNivel();
//							vehiculo = this.pedirVehiculo();
//							juegoActual.iniciarPartida(nivel, vehiculo);
//							control = new ControladorDeMovimientos(juegoActual.getPartida().getGestorDeMovimientos());
//							try {
//								MapaJuegoVista mapa = new MapaJuegoVista(control,juegoActual);
//							} catch (InterruptedException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//
//						} catch (CanceloJuegoException e1) {}
//					} catch (PartidaEnJuegoException | NivelInvalidoException| VehiculoInvalidoException| JugadorNoCargadoException e1) {
//						try {
//							juegoActual.nuevaPartida(nivel, vehiculo);
//							control = new ControladorDeMovimientos(juegoActual.getPartida().getGestorDeMovimientos());
//							try {
//								MapaJuegoVista mapa = new MapaJuegoVista(control,juegoActual);
//							} catch (InterruptedException e2) {
//								// TODO Auto-generated catch block
//								e2.printStackTrace();
//							}
//
//						} catch (NivelInvalidoException| VehiculoInvalidoException e2) {
//						}
//					}
//								        
//				}catch (NombreInvalidoException e1) {
//					JOptionPane.showMessageDialog(null,"Nombre Invalido","Aviso",JOptionPane.WARNING_MESSAGE);
//				}
//			}

		}	
	
	}
		
	public ActionListener getListenerBotonJugadorNuevo() {
		return new EscuchaBotonJugadorNuevo();
	}

	private class EscuchaBotonVerPuntajes implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
			Hashtable unHashDatosJugadores = ArchivadorDeJugadores.cargarListaDeDatosDeJugadores(Juego.getNombreArchivoDeJugadores());
			Enumeration datosJugador = unHashDatosJugadores.elements(); 
			String unstring = "";
			
			if(!datosJugador.hasMoreElements()){
				unstring = "NO HAY NINGUN JUGADOR CREADO";
			}
			
			while(datosJugador.hasMoreElements()){
				DatoJugador datoJugadorActual = (DatoJugador)datosJugador.nextElement();
				unstring = unstring + datoJugadorActual.getNombre() + ": "+ datoJugadorActual.getPuntaje() + System.getProperty("line.separator") ;
			}
			
			JOptionPane.showMessageDialog(null,	unstring ,"Puntajes",JOptionPane.WARNING_MESSAGE);
			
		}
	}
	
	public ActionListener getListenerBotonVerPuntajes() {
		return new EscuchaBotonVerPuntajes();
	}

	private class EscuchaBotonGuardarPartida implements ActionListener{
				
		@Override
		public void actionPerformed(ActionEvent arg0) {				
				juegoActual.guardarPartida();
		
		}
	}
		
	public ActionListener getListenerBotonGuardarPartida() {
			return new EscuchaBotonGuardarPartida();

		}

	private class EscuchaBotonCargarPartida implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				juegoActual.setJugador("JuanLaura");
				juegoActual.cargarPartida();
				System.out.println("Carga la partida");
				ControladorDeMovimientos control = new ControladorDeMovimientos (juegoActual.getPartida().getGestorDeMovimientos());
				MapaJuegoVista mapa = new MapaJuegoVista(control,juegoActual);
			} catch (NoExistePartidaGuardadaException e1) {
			} catch (NombreInvalidoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public ActionListener getListenerBotonCargarPartida(){
		return new EscuchaBotonCargarPartida();
	}

	
}

