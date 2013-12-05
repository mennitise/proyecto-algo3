package Vista;

import java.awt.Color;
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
	private ControladorDeFlechas controladorDeFlechas;
	
	public VentanaPrincipal(){
			
		this.juego = new Juego(); 
		this.configurarMapaJuegoActual();
		this.controladorDeFlechas = null; //Si estuviera creado, estaría leyendo las teclas. Se crea a la hora de jugar
		this.configurarPanelInicial();
		this.juego.addObserver(this); //Cada vez que el juego notifique a los obbservadores, esta clase se actualizara segun el metodo update
		this.juego.addObserver(this.panelInicial); //Idem para el panelIinicial	
		this.configurarFrame();
	}
				
	@Override
	public void update(Observable arg0, Object arg1) {
		//se va a actualizar cuando algun mensaje desde juego llegue aqui 
		if (this.controladorDeFlechas == null){
			this.configurarVentanaParaJugar();
		}
	
		if (this.juego.hayPartidaActiva()){	
			this.ponerVentanaEnEstadoDeJuego();
	
		if (this.juego.terminoLaPartida()){
			this.ponerVentanaEnEstadoInicial();
				}
		} else { // aqui resulta que no hay partida activa y que no termino la partida
			this.ponerVentanaEnEstadoInicial();
			}
	}
	
	
	private void configurarVentanaParaJugar(){
		this.controladorDeFlechas = new ControladorDeFlechas (this.juego.getPartida().getGestorDeMovimientos(), this);
		this.addKeyListener(controladorDeFlechas);
    	this.setFocusable(true);
    	this.panelDeInformacionDelJugador = new PanelDeInformacionVista(this.juego);
    	this.panelDeInformacionDelJugador.setBounds(600, 0, 200, 570);
    	this.add(this.panelDeInformacionDelJugador);
	}
	
    private void ponerVentanaEnEstadoDeJuego(){
		this.panelInicial.setVisible(false);
		this.juego.getPartida().getGestorDeMovimientos().addObserver(this);
		this.mapaJuegoActual.setVisible(true);

    }
	
	private void configurarFrame(){
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.blue);
		this.setTitle("GPS Challenge");
		this.setBounds(300,100,800,600);
		this.setVisible(true);			
	}
	

	private void configurarMapaJuegoActual(){

		this.mapaJuegoActual = new MapaJuegoVista() ; //Se crea con un estado vacio que luego el controlador ira manejando segun el modelo
		this.mapaJuegoActual.setSize(600,600); //configuracion para el JFrame
		this.mapaJuegoActual.setVisible(false); //Configracion para el JFrame//
		this.add(mapaJuegoActual);
	}
	
	private void configurarPanelInicial(){
		ControladorMenuPrincipal control = new ControladorMenuPrincipal(this.juego, this.mapaJuegoActual);		
		this.panelInicial = new PanelInicial(control);	
		this.panelInicial.setBounds(250,150,300,300);	
		this.panelInicial.setVisible(true);
		this.add(this.panelInicial);
	}	
	
	private void ponerVentanaEnEstadoInicial(){		
		this.panelInicial.setVisible(true);
		this.mapaJuegoActual.setVisible(false);
		this.removeKeyListener(this.controladorDeFlechas);
		this.controladorDeFlechas = null;
		this.panelDeInformacionDelJugador.setVisible(false);
	}
	
}


	


	