package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEleccionAutos {

	public ActionListener getListenerBotonNuevoAuto() {
		return new EscuchaBotonNuevoAuto();
	}

	private class EscuchaBotonNuevoAuto implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
			
		}
	}
	
	public ActionListener getListenerBotonNuevoCuatroXCuatro() {
		// TODO Auto-generated method stub
		return new EscuchaBotonNuevoCuatroXCuatro();
	}
	
	private class EscuchaBotonNuevoCuatroXCuatro implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
			
		}
	}

	private class EscuchaBotonNuevaMoto implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	
			
		}
	}
	public ActionListener getListenerBotonNuevaMoto() {
		// TODO Auto-generated method stub
		return new EscuchaBotonNuevaMoto();
	}

}
