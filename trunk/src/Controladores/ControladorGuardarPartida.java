package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Juego.Juego;

public class ControladorGuardarPartida {
	private Juego juegoActual;
	
	public ControladorGuardarPartida(Juego unJuego){
		this.juegoActual = unJuego;
	}
	
	private class EscuchaBotonGuardarPartida implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {				
				juegoActual.guardarListaDeJugadoresExistentes();
				juegoActual.guardarPartida();
		}
	}
		
	public ActionListener getListenerBotonGuardarPartida() {
		return new EscuchaBotonGuardarPartida();
	}
}
