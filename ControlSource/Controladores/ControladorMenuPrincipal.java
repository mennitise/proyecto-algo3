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
import Excepciones.JugadorCargadoException;
import Excepciones.JugadorNoCargadoException;
import Excepciones.NivelInvalidoException;
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
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
				DatoJugador unDatoDeJugador = this.pedirJugador();
				if (unDatoDeJugador!= null){
					try {				
						Juego juego = new Juego();
						juego.setJugador(unDatoDeJugador.getNombre());
						try {
							juego.iniciarPartida(1, 1);
						} catch (PartidaEnJuegoException | NivelInvalidoException
								| VehiculoInvalidoException
								| JugadorNoCargadoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						ControladorDeMovimientos control = new ControladorDeMovimientos(juego.getPartida().getGestorDeMovimientos());					
						try {
							MapaJuegoVista mapa = new MapaJuegoVista(control,juego);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
									        
					}catch (NombreInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					
				}
				
		}
		
	}

	public ActionListener getListenerBotonJugadorExistente() {
		return new EscuchaBotonJugadorExistente();
	}
	
	private class EscuchaBotonJugadorNuevo implements ActionListener{	
	
		
		
		private int pedirVehiculo(){
		 
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
			JOptionPane.showMessageDialog(null,"Se elige Auto por Default","Aviso",JOptionPane.WARNING_MESSAGE);
			return 1;
		}else{
		
			switch (autoElegido){
				case "Auto": return 1;
				case "CuatroXCuatro": return 3;
				case "Moto": return 2;
			};
		}

		return 1;
		}
		
		private int pedirNivel(){

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
			JOptionPane.showMessageDialog(null,"Se elige Nivel Facil por Default","Aviso",JOptionPane.WARNING_MESSAGE);
			return 1;
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
			
						
			//Solo se ejecuta esta Pieza cuando el nombre es valido, es para que no se salga del menu
			if ((nombre != null) && !(nombre.equals(""))) {
				int nivel = this.pedirNivel();
				int vehiculo = this.pedirVehiculo();

				try {
					//juegoActual = new Juego();
					juegoActual.setJugador(nombre);
					try {
						juegoActual.iniciarPartida(nivel, vehiculo);
					} catch (PartidaEnJuegoException | NivelInvalidoException
							| VehiculoInvalidoException
							| JugadorNoCargadoException e1) {
						try {
							juegoActual.nuevaPartida(nivel, vehiculo);

						} catch (NivelInvalidoException
								| VehiculoInvalidoException e2) {
							// TODO Auto-generated catch block
						}
					}
					System.out.println(juegoActual);
					ControladorDeMovimientos control = new ControladorDeMovimientos(juegoActual.getPartida().getGestorDeMovimientos());					
					try {
						MapaJuegoVista mapa = new MapaJuegoVista(control,juegoActual);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
								        
				}catch (NombreInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
}

