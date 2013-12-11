package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
				JOptionPane.showMessageDialog(null,"Su partida ha sido guardada con exito","Aviso",JOptionPane.WARNING_MESSAGE);

		}
	}
		
	public ActionListener getListenerBotonGuardarPartida() {
		return new EscuchaBotonGuardarPartida();
	}
}
