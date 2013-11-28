package Controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Observable;

import javax.swing.JOptionPane;

import Excepciones.MovimientoFisicamenteInvalidoException;
import GestorDeMovimientos.EstrategiaEste;
import GestorDeMovimientos.EstrategiaNorte;
import GestorDeMovimientos.EstrategiaOeste;
import GestorDeMovimientos.EstrategiaSur;
import GestorDeMovimientos.GestorDeMovimientos;
import Juego.Juego;
import Vehiculos.Vehiculo;

public class ControladorDeMovimientos   {
	
	private GestorDeMovimientos gestor;
	private Juego juego;
	
	public ControladorDeMovimientos(GestorDeMovimientos unGestor)
	{
		this.gestor = unGestor;
	}
	
	private class EscuchaBotonSubir implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
		try {
			gestor.moverVehiculo(new EstrategiaNorte());
		} catch (MovimientoFisicamenteInvalidoException e1) {
			JOptionPane.showMessageDialog(null,"Movimiento Invalido","Aviso",JOptionPane.WARNING_MESSAGE);
		}
		}
	}
	
	public ActionListener getListenerBotonSubir() {
		return new EscuchaBotonSubir();
	}
	
	private class EscuchaBotonBajar implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{
		try {
			gestor.moverVehiculo(new EstrategiaSur());
		} catch (MovimientoFisicamenteInvalidoException e1) {
			JOptionPane.showMessageDialog(null,"Movimiento Invalido","Aviso",JOptionPane.WARNING_MESSAGE);
		}
		
		}
	}

	public ActionListener getListenerBotonBajar() {
		return new EscuchaBotonBajar();
	}
	
	private class EscuchaBotonIzquierda implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{
			try {
				gestor.moverVehiculo(new EstrategiaOeste());
			} catch (MovimientoFisicamenteInvalidoException e1) {
				JOptionPane.showMessageDialog(null,"Movimiento Invalido","Aviso",JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}
	
	public ActionListener getListenerBotonIzquierda() {
		return new EscuchaBotonIzquierda();
	}

	private class EscuchaBotonDerecha implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{
		try {
			gestor.moverVehiculo(new EstrategiaEste());
		} catch (MovimientoFisicamenteInvalidoException e1) {
			JOptionPane.showMessageDialog(null,"Movimiento Invalido","Aviso",JOptionPane.WARNING_MESSAGE);
		}
		}
	}
	
	public ActionListener getListenerBotonDerecha() {
		return new EscuchaBotonDerecha();
	}

}