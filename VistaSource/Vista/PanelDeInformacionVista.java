package Vista;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;
import GestorDeMovimientos.GestorDeMovimientos;

public class PanelDeInformacionVista implements Observer{
	
	private VentanaVista ventanaDestino;
	private JPanel panel;
	private GestorDeMovimientos gestor;
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JLabel etiqueta3;
	
	public PanelDeInformacionVista(VentanaVista unaVentana, GestorDeMovimientos unGestor){
		this.ventanaDestino = unaVentana;
		this.gestor = unGestor;
		this.gestor.addObserver(this);
		
		this.panel = new JPanel(new GridLayout(3,1,10,10));
	       
		this.etiqueta1 =  new JLabel("Nombre:"+ this.gestor.getVehiculoEnPosicionActual().getConductor().getNombre());
	    this.etiqueta2 = new JLabel("Puntaje:" + Integer.toString(this.gestor.getVehiculoEnPosicionActual().getConductor().getCantidadDeMovimientos()));
	    this.etiqueta3 = new JLabel(new ImageIcon(((new ImageIcon("src/imagenes/Auto.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)))	;
	    this.asignarImagenVehiculo();
	    //Configuracion del Panel
	    panel.setBounds(0, 0, 100, 400);
	    panel.add(this.etiqueta1);
	    panel.add(this.etiqueta2);
	    panel.add(this.etiqueta3);
	    panel.setBounds(650,200,100,300);
	    panel.setVisible(true);
	     
	    this.ventanaDestino.add(panel);
	
	}

	private void asignarImagenVehiculo(){
		Vehiculo unVehiculo = this.gestor.getVehiculoEnPosicionActual();
		if (unVehiculo.getClass() == Auto.class){
			this.etiqueta3.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/Auto.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
			}
		
		if (unVehiculo.getClass() == Moto.class){
			this.etiqueta3.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/Moto.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
			}
		
		if (unVehiculo.getClass() == CuatroXCuatro.class){
			this.etiqueta3.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/4x4.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
			}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		this.etiqueta1.setText("Nombre:"+ this.gestor.getVehiculoEnPosicionActual().getConductor().getNombre());
	    this.etiqueta2.setText("Puntaje:" + Integer.toString(this.gestor.getVehiculoEnPosicionActual().getConductor().getCantidadDeMovimientos()));
	    this.asignarImagenVehiculo();
	}

	public void setVisible(boolean b) {
		this.panel.setVisible(b);
		
	}
	
	
	
	
}