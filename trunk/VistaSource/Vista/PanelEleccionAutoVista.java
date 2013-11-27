package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controladores.ControladorEleccionAutos;
import Controladores.ControladorMenuPrincipal;
import GestorDeMovimientos.GestorDeMovimientos;

public class PanelEleccionAutoVista extends JFrame{
	
	private JPanel panelInicial;
	private JButton botonAuto;
	private JButton botonCuatroXCuatro;
	private JButton botonMoto;
	private GestorDeMovimientos gestor;
	
	PanelEleccionAutoVista(ControladorEleccionAutos control){
	
		setLayout(null);
		this.setBounds(100, 100, 400, 400);
		
		this.botonAuto = new JButton ("Auto");
		this.botonCuatroXCuatro = new JButton("CuatroXCuatro");
		
		this.botonAuto.addActionListener(control.getListenerBotonNuevoAuto());
		this.botonMoto.addActionListener(control.getListenerBotonNuevaMoto());
		this.botonCuatroXCuatro.addActionListener(control.getListenerBotonNuevoCuatroXCuatro());
		
		this.panelInicial = new JPanel();
		this.panelInicial.setSize(200,200);		
		this.panelInicial.add(this.botonAuto);
		this.panelInicial.add(this.botonMoto);
		this.panelInicial.add(this.botonCuatroXCuatro);
		this.panelInicial.setVisible(true);
		
		this.add(panelInicial);
		setVisible(true);
		  
	}
	
}
