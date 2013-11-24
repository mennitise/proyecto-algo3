package Controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import GestorDeMovimientos.EstrategiaEste;
import GestorDeMovimientos.EstrategiaNorte;
import GestorDeMovimientos.EstrategiaOeste;
import GestorDeMovimientos.EstrategiaSur;
import GestorDeMovimientos.GestorDeMovimientos;
import Vehiculos.Vehiculo;

public class ControladorDeMovimientos  {
	
	private GestorDeMovimientos gestor;
	
	public ControladorDeMovimientos(GestorDeMovimientos unGestor)
	{
		this.gestor = unGestor;
	}
	
	private class EscuchaBotonSubir implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
		gestor.moverVehiculo(new EstrategiaNorte());
		gestor.ActualizarObservadores();
		}
	}
	
	public ActionListener getListenerBotonSubir() {
		return new EscuchaBotonSubir();
	}
	
	private class EscuchaBotonBajar implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{
		gestor.moverVehiculo(new EstrategiaSur());
		gestor.ActualizarObservadores();
		}
	}

	public ActionListener getListenerBotonBajar() {
		return new EscuchaBotonBajar();
	}
	
	private class EscuchaBotonIzquierda implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{
		gestor.moverVehiculo(new EstrategiaOeste());
		gestor.ActualizarObservadores();
		}
	}
	
	public ActionListener getListenerBotonIzquierda() {
		return new EscuchaBotonIzquierda();
	}

	private class EscuchaBotonDerecha implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{
		gestor.moverVehiculo(new EstrategiaEste());
		gestor.ActualizarObservadores();
		}
	}

	
	public ActionListener getListenerBotonDerecha() {
		return new EscuchaBotonDerecha();
	}



}