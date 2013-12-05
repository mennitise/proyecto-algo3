package Controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import Excepciones.MovimientoFisicamenteInvalidoException;
import GestorDeMovimientos.EstrategiaEste;
import GestorDeMovimientos.EstrategiaNorte;
import GestorDeMovimientos.EstrategiaOeste;
import GestorDeMovimientos.EstrategiaSur;
import GestorDeMovimientos.GestorDeMovimientos;

public class ControladorDeFlechas implements KeyListener {

	GestorDeMovimientos gestor;
	JFrame frameDeJuego;
	
	public ControladorDeFlechas(GestorDeMovimientos unGestor, JFrame unFrame){
		this.gestor = unGestor;
		this.frameDeJuego = unFrame;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			try {
				this.gestor.moverVehiculo(new EstrategiaNorte());
			} catch (MovimientoFisicamenteInvalidoException e1) {
				this.vibrar();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			try {
				this.gestor.moverVehiculo(new EstrategiaSur());
			} catch (MovimientoFisicamenteInvalidoException e1) {
				this.vibrar();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			try {
				this.gestor.moverVehiculo(new EstrategiaEste());
			
			} catch (MovimientoFisicamenteInvalidoException e1) {
				this.vibrar();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			try {
				this.gestor.moverVehiculo(new EstrategiaOeste());
			} catch (MovimientoFisicamenteInvalidoException e1) {
				this.vibrar();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
			
	
	
	}

	private void vibrar(){
		final int originalX = this.frameDeJuego.getLocationOnScreen().x; 
        final int originalY = this.frameDeJuego.getLocationOnScreen().y; 
        for(int i = 0; i < 20; i++) { 
          try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          this.frameDeJuego.setLocation(originalX, originalY + 5); 
          try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          this.frameDeJuego.setLocation(originalX, originalY - 5);
          try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          this.frameDeJuego.setLocation(originalX + 5, originalY);
          try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          this.frameDeJuego.setLocation(originalX, originalY); 
        }
   	
	}
	

}
