package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Tablero.Tablero;
import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;
import Vista.MapaVista;
import Vista.PanelDeInformacionVista;
import Vista.VehiculoVista;
import Vista.VentanaVista;
import Excepciones.StringVacioException;
import GestorDeMovimientos.GestorDeMovimientos;
import Juego.Nivel;
import Juego.NivelFacil;
import Jugador.Jugador;

public class ControladorMenuPrincipal {
	private GestorDeMovimientos gestor;
	
	public ControladorMenuPrincipal(){
		this.gestor = null;	
	}
	

	
	private class EscuchaBotonJugadorNuevo implements ActionListener{	
	
		 private Vehiculo pedirVehiculo(){
		 
			
			Vehiculo unVehiculo = null;
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
			unVehiculo = new Auto();
		}else{
		
			switch (autoElegido){
				case "Auto": unVehiculo = new Auto();  break;
				case "CuatroXCuatro": unVehiculo = new CuatroXCuatro(); break;
				case "Moto": unVehiculo = new Moto(); break;
			};
		}
			
			return unVehiculo;	
		}
		
		private Nivel pedirNivel(){

			Nivel unNivel = null;
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
			unNivel = new NivelFacil();
		}else{
		
			switch (nivelElegido){
				case "Facil": unNivel = new NivelFacil();  break;
				/*case "CuatroXCuatro": IMPLEMENTAR   ; break;
				case "Moto": unNivel = IMPLEMENTAR ; break;*/
			};
		}
			
			return unNivel;	
			
		}
		
		public void actionPerformed(ActionEvent e){	
			 
			Jugador unJugador = null;
			String nombre = new String("");
			
			nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
							
			Nivel nivel = null;
			
			//Solo se ejecuta esta Pieza cuando el nombre es valido, es para que no se salga del menu
			if ((nombre != null) && !(nombre.equals(""))) {
				try {
					Vehiculo unVehiculo = new Auto();
					unVehiculo = this.pedirVehiculo();				
					nivel = this.pedirNivel();
					unVehiculo.setPosicion(nivel.getPosicionInicialDelVehiculo());
					
					unJugador = new Jugador(nombre, unVehiculo);
					Tablero tablero = nivel.inicializarTablero();
					GestorDeMovimientos gestor = new GestorDeMovimientos(unJugador,tablero);
					ControladorDeMovimientos control = new ControladorDeMovimientos(gestor);

					VentanaVista ventanaVista = new VentanaVista(gestor, control);        
					ventanaVista.setVisible(true);
			        
					PanelDeInformacionVista panel = new PanelDeInformacionVista(ventanaVista,gestor);
			        MapaVista mapa = new MapaVista(ventanaVista, tablero,gestor);
					mapa.dibujarMapaConDeterminadaCantidadDePixeles(600, 600);
					
					VehiculoVista vehiculoVista = new VehiculoVista(unVehiculo,mapa,gestor);
			        vehiculoVista.dibujarVehiculo();
			        
				}catch (StringVacioException e1) {
					//No va a entrar Nunca
				}
			}
		}	
	
	}
		
	
	public ActionListener getListenerBotonJugadorNuevo() {
		return new EscuchaBotonJugadorNuevo();
	}

	private class EscuchaBotonJugadorExistente implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
		//Implementar
		}
	}
	
	public ActionListener getListenerBotonJugadorExistente() {
		return new EscuchaBotonJugadorExistente();
	}
}

