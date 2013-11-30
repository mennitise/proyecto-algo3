package Vista;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Vehiculos.Auto;
import Vehiculos.CuatroXCuatro;
import Vehiculos.Moto;
import Vehiculos.Vehiculo;
import Controladores.ControladorGuardarPartida;
import Controladores.ControladorMenuPrincipal;
import GestorDeMovimientos.GestorDeMovimientos;
import Juego.Juego;

public class PanelDeInformacionVista extends JPanel implements Observer{

	private GestorDeMovimientos gestor;
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JLabel etiqueta3;
	private JButton botonGuardar;
	private JLabel cantidadMaximaDeMovimientos;
	
	public PanelDeInformacionVista(Juego unJuego){
		
		this.gestor = unJuego.getPartida().getGestorDeMovimientos();
		this.gestor.addObserver(this);
		this.setLayout(new GridLayout(5,1));
		
		this.etiqueta1 =  new JLabel("Nombre: "+ this.gestor.getVehiculoEnPosicionActual().getConductor().getNombre());
		this.etiqueta2 = new JLabel("Movimientos: " + Integer.toString(this.gestor.getVehiculoEnPosicionActual().getConductor().getCantidadDeMovimientos()));
	    this.etiqueta3 = new JLabel(new ImageIcon(((new ImageIcon("src/imagenes/Auto.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)))	;
	    this.botonGuardar = new JButton ("Guardar Partida");
	    this.botonGuardar.addActionListener((new ControladorGuardarPartida(unJuego)).getListenerBotonGuardarPartida());
	   
	    this.cantidadMaximaDeMovimientos = new JLabel ("Cantidad Maxima: " + unJuego.getPartida().getCantidadDeMovimientosMaximaEnNivelActual());
	    this.asignarImagenVehiculo();
	    //Configuracion del Panel
	    this.setSize(100, 400);
	    this.add(this.etiqueta1);
	    this.add(this.cantidadMaximaDeMovimientos);
	    this.add(this.etiqueta2);
	    this.add(this.etiqueta3);
	    this.add(this.botonGuardar);
	    this.setVisible(true);	   	
	}

	private void asignarImagenVehiculo(){
		Vehiculo unVehiculo = this.gestor.getVehiculoEnPosicionActual();
		if (unVehiculo.getClass() == Auto.class){
			this.etiqueta3.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/Auto.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
			}
		
		if (unVehiculo.getClass() == Moto.class){
			this.etiqueta3.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/Moto.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
			}
		
		if (unVehiculo.getClass() == CuatroXCuatro.class){
			this.etiqueta3.setIcon(new ImageIcon(((new ImageIcon("src/imagenes/4x4.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
			}
		
	}
	
	JPanel getPanel(){
		return this;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		this.etiqueta1.setText("Nombre: "+ this.gestor.getVehiculoEnPosicionActual().getConductor().getNombre());
	    this.etiqueta2.setText("Movimientos: " + Integer.toString(this.gestor.getVehiculoEnPosicionActual().getConductor().getCantidadDeMovimientos()));
	    this.asignarImagenVehiculo();
	}

//	public void setVisible(boolean b) {
//		this.setVisible(b);
//		
//	}
//	
}
