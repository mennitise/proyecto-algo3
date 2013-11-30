package Vista;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Controladores.ControladorDeMovimientos;
import Controladores.ControladorMenuPrincipal;
import Juego.Juego;

public class VentanaPrincipal extends JFrame implements Observer{
	
	private PanelInicial panelInicial;
	private Juego juego;
	
	public VentanaPrincipal(){

		
		this.juego = new Juego(); //el controlador se encargara de iniciarlo
		
		ControladorMenuPrincipal control = new ControladorMenuPrincipal(juego);
		
		this.panelInicial = new PanelInicial(control);	
		this.panelInicial.setBounds(250,150,300,300);	
		this.panelInicial.setVisible(true);
		
		if (this.juego!= null){
			this.juego.addObserver(this);
			this.juego.addObserver(this.panelInicial);			
			
		}
		
		this.add(panelInicial);
				
		this.configurarFrame();
		
		
	}
	
	private void configurarFrame(){
		this.setLayout(null);
		this.setTitle("GPS Challenge");
		this.setBounds(300,100,800,600);
		this.setVisible(true);
	}
	
	public static void main (String[] args){
		Juego unJuego = new Juego();
		VentanaPrincipal nuevaVenta = new VentanaPrincipal();
	}

	
	@Override
	public void update(Observable arg0, Object arg1) {
			if (this.juego.hayPartidaActiva()){	
				this.panelInicial.setVisible(false);
				this.juego.getPartida().getGestorDeMovimientos().addObserver(this);
			}
			
//			if (juego.hayPartidaActiva()){
//				this.juego.getPartida().getGestorDeMovimientos().addObserver(this.panelInicial);
//			}
//			
			if (this.juego.terminoLaPartida()){				
				this.panelInicial.setVisible(true);
//				ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(this.juego);
//				PanelInicial unpanelInicial = new PanelInicial(controlador);
//				unpanelInicial.setBounds(250,150,300,300);	
//				unpanelInicial.setVisible(true);
//				this.add(unpanelInicial);
			}
	}

}
	