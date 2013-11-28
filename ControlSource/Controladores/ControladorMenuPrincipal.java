package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Vista.MapaJuegoVista;
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
	private GestorDeMovimientos gestor;
	
	public ControladorMenuPrincipal(){
		this.gestor = null;	
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
				/*case "CuatroXCuatro": IMPLEMENTAR   ; break;
				case "Moto": unNivel = IMPLEMENTAR ; break;*/
			};
		}
			
			return 1;	
			
		}
		
		public void actionPerformed(ActionEvent e){	
			 
			
			String nombre = new String("");			
			nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
							
			int nivel = this.pedirNivel();
			int vehiculo = this.pedirVehiculo();
			
			//Solo se ejecuta esta Pieza cuando el nombre es valido, es para que no se salga del menu
			if ((nombre != null) && !(nombre.equals(""))) {
				try {
					
					
					Juego juego = new Juego();
					juego.setJugador(nombre);
					try {
						juego.iniciarPartida(nivel, vehiculo);
					} catch (PartidaEnJuegoException | NivelInvalidoException
							| VehiculoInvalidoException
							| JugadorNoCargadoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					ControladorDeMovimientos control = new ControladorDeMovimientos(juego.getPartida().getGestorDeMovimientos());					
					MapaJuegoVista mapa = new MapaJuegoVista(control,juego);
								        
				}catch (NombreInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JugadorCargadoException e1) {
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

