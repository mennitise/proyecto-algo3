package Vista;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import Controladores.ControladorDeFlechas;
import Controladores.ControladorMenuPrincipal;
import Juego.Juego;

public class VentanaPrincipal extends JFrame implements Observer{
	
	private PanelInicial panelInicial;
	private Juego juego;
	private MapaJuegoVista mapaJuegoActual;
	private PanelDeInformacionVista panelDeInformacionDelJugador;
	private ControladorDeFlechas unListener;
	
	public VentanaPrincipal(){

		
		this.juego = new Juego(); //el controlador se encargara de iniciarlo
		this.mapaJuegoActual = new MapaJuegoVista() ;
		this.mapaJuegoActual.setSize(600,600);
		this.mapaJuegoActual.setVisible(false);
//		this.mapaJuegoActual.setBounds(0, 0, 600, 600);
		this.unListener = null;
		this.add(mapaJuegoActual);
		ControladorMenuPrincipal control = new ControladorMenuPrincipal(juego, mapaJuegoActual);
		
		this.panelInicial = new PanelInicial(control);	
		this.panelInicial.setBounds(250,150,300,300);	
		this.panelInicial.setVisible(true);
		
		
			this.juego.addObserver(this);
			this.juego.addObserver(this.panelInicial);	
		this.add(panelInicial);
				
		this.configurarFrame();
		
		
	}
	
	private void configurarFrame(){
		this.setLayout(null);
		this.setTitle("GPS Challenge");
		this.setBounds(300,100,800,600);
		this.setVisible(true);
		;
		
	}
	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		if (this.unListener == null){
			this.unListener = new ControladorDeFlechas (this.juego.getPartida().getGestorDeMovimientos(), this);
			this.addKeyListener(unListener);
	    	this.setFocusable(true);
	    	this.panelDeInformacionDelJugador = new PanelDeInformacionVista(this.juego);
	    	this.panelDeInformacionDelJugador.setBounds(600, 0, 200, 500);
	    	this.add(this.panelDeInformacionDelJugador);
	    
		}
	
		if (this.juego.hayPartidaActiva()){	
				this.panelInicial.setVisible(false);
				this.juego.getPartida().getGestorDeMovimientos().addObserver(this);
				this.mapaJuegoActual.setVisible(true);
				if (this.juego.terminoLaPartida()){
					this.panelInicial.setVisible(true);
					this.mapaJuegoActual.setVisible(false);
					this.removeKeyListener(unListener);
					this.unListener = null;
					this.panelDeInformacionDelJugador.setVisible(false);
				}
		}else {
			this.panelInicial.setVisible(true);
			this.mapaJuegoActual.setVisible(false);
			this.removeKeyListener(unListener);
			this.unListener = null;
			this.panelDeInformacionDelJugador.setVisible(false);

			}
		}
	
	
}
	
//	public static void main (String[] args){
//		VentanaPrincipal nuevaVenta = new VentanaPrincipal();
//	}
//



	