package Vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Archivadores.ArchivadorDeJugadores;
import Controladores.ControladorDeMovimientos;
import Controladores.ControladorIniciarJuego;
import Juego.DatoJugador;
import Juego.Juego;

public class VentanaPrincipal extends JFrame implements Observer{
	
	private JPanel panelInicial;
	private Juego juego;
	private MapaJuegoVista mapaJuegoActual;
	private PanelDeInformacionVista panelDeInformacionDelJugador;
	private ControladorDeMovimientos controladorDeFlechas;
	private ArrayList<JPanel> paneles;
	private PanelJugadorExistenteVista panelJugadorExistente;
	private JButton botonVolver;
	
	public VentanaPrincipal(){
			
		this.juego = new Juego(); 
		this.configurarMapaJuegoActual();
		this.panelJugadorExistente = new PanelJugadorExistenteVista();
		this.controladorDeFlechas = null; //Si estuviera creado, estaría leyendo las teclas. Se crea a la hora de jugar
		this.configurarPanelInicial();
		this.juego.addObserver(this); //Cada vez que el juego notifique a los obbservadores, esta clase se actualizara segun el metodo update
		this.configurarFrame();
		this.botonVolver = new JButton("Volver al menu principal");
		this.botonVolver.setBounds(500,500,100,100);
		this.botonVolver.setVisible(false);
		this.add(this.botonVolver);
		this.botonVolver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panelJugadorExistente.setVisible(false);
				panelInicial.setVisible(true);
				botonVolver.setVisible(false);
				}
			
		});

		
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
			this.ponerVentanaEnCuentaDelJugador();
			//this.ponerVentanaEnEstadoInicial();
				}
		} else { // aqui resulta que no hay partida activa y que no termino la partida
			this.ponerVentanaEnCuentaDelJugador();
			}
	}
	
	private void ponerVentanaEnCuentaDelJugador(){
		this.panelInicial.setVisible(false);
		this.mapaJuegoActual.setVisible(false);
		this.removeKeyListener(this.controladorDeFlechas);
		this.controladorDeFlechas = null;
		this.panelDeInformacionDelJugador.setVisible(false);
		this.panelJugadorExistente.setVisible(true);
		// System.out.println("Si, termino la partida");
	}
	
	private void configurarVentanaParaJugar(){
		this.controladorDeFlechas = new ControladorDeMovimientos (this.juego.getPartida().getGestorDeMovimientos(), this);
		this.addKeyListener(controladorDeFlechas);
    	this.setFocusable(true);
    	this.panelDeInformacionDelJugador = new PanelDeInformacionVista(this.juego);
    	this.panelDeInformacionDelJugador.setBounds(600, 0, 200, 570);
    	this.add(this.panelDeInformacionDelJugador);
	}
	
    private void ponerVentanaEnEstadoDeJuego(){
		this.panelInicial.setVisible(false);
		this.juego.getPartida().getGestorDeMovimientos().addObserver(this);
		this.panelJugadorExistente.setVisible(false);
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
		ControladorIniciarJuego control = new ControladorIniciarJuego(this.juego, this.mapaJuegoActual);		
		
		//this.panelInicial = new PanelInicial(control);	
		this.panelInicial = new JPanel();
		this.panelInicial.setLayout(new GridLayout(3,1));
		JButton botonJugadorNuevo = new JButton("Jugador Nuevo");
		JButton botonJugadorExistente = new JButton("Jugador Existente");
		JButton botonSalir = new JButton("Salir");
			botonSalir.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
				
			});
		botonJugadorNuevo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = new String("");			
				while ((nombre != null) && (nombre.equals(""))){
				nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
				if(nombre != null){
					nombre = nombre.trim();
				}
				if ((nombre != null) && (nombre.equals(""))){
					JOptionPane.showMessageDialog(null,"Usted no ingreso un nombre","Aviso",JOptionPane.WARNING_MESSAGE);

				}
								
				
				}
				if (nombre!= null){
	            	ControladorIniciarJuego control = new ControladorIniciarJuego(juego, mapaJuegoActual);		
	            		
	            	panelJugadorExistente = new PanelJugadorExistenteVista(juego, control, nombre);
	            	panelJugadorExistente.setBounds(250,100,300,400);
	            	add(panelJugadorExistente);
	            	botonVolver.setVisible(true);
	            	botonVolver.setBounds(0, 0, 200, 100);
	            	panelInicial.setVisible(false); 
	                panelJugadorExistente.setVisible(true);
		            invalidate(); // Changed here
	                repaint(); // Changed here
	            	}		
			}
			
		});
		botonJugadorExistente.addActionListener(new ActionListener() {
		
       
			@Override
            public void actionPerformed(ActionEvent e) {
            	
            	DatoJugador unDato = pedirJugador();
            	if (unDato!= null){
            	ControladorIniciarJuego control = new ControladorIniciarJuego(juego, mapaJuegoActual);		
            		
            	panelJugadorExistente = new PanelJugadorExistenteVista(juego, control, unDato.getNombre());
            	panelJugadorExistente.setBounds(250,100,300,400);
            	add(panelJugadorExistente);
            	botonVolver.setVisible(true);
            	botonVolver.setBounds(0, 0, 200, 100);
            	panelInicial.setVisible(false); 
                panelJugadorExistente.setVisible(true);
	            invalidate(); // Changed here
                repaint(); // Changed here
            	}
            }
        });
		this.panelInicial.add(botonJugadorNuevo);
		this.panelInicial.add(botonJugadorExistente);
		this.panelInicial.add(botonSalir);
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
	
	private DatoJugador pedirJugador(){
		Hashtable unHashDatosJugadores = ArchivadorDeJugadores.cargarListaDeDatosDeJugadores(Juego.getNombreArchivoDeJugadores());
		Enumeration datosJugador = unHashDatosJugadores.elements(); 
		int cantidadDeJugadores = unHashDatosJugadores.size();
		String unstring = "";
		Object[] nombresDeLosJugadores = new Object[cantidadDeJugadores];
		
		if(!datosJugador.hasMoreElements()){
			unstring = "NO HAY NINGUN JUGADOR CREADO";
			JOptionPane.showMessageDialog(null,	unstring ,"Jugadores Creados",JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		int posicion = 0;
		while(datosJugador.hasMoreElements()){
			DatoJugador datoJugadorActual = (DatoJugador)datosJugador.nextElement();
			nombresDeLosJugadores[posicion]  = datoJugadorActual.getNombre();
			posicion++;
		}
		
		String jugadorElegido = (String)JOptionPane.showInputDialog(
                new JFrame(),
                "Elegir Jugador",
                "Jugador",
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(),
                nombresDeLosJugadores,
                "Jugador");

		if (jugadorElegido == null){
			return null;	
			//IMPLEMENTAR
		}else{
			return (DatoJugador)unHashDatosJugadores.get(jugadorElegido);
			
		}
	}
	
}


	


	