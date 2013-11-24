package Vista;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import GestorDeMovimientos.GestorDeMovimientos;
import Tablero.Tablero;
import Vehiculos.Vehiculo;

public class MapaVista implements Observer{ 
	private int esquinasHorizontales;
	private int esquinasVerticales;
	private int anchoCalle;
	private int tamanioManzanaHorizontal;
	private int tamanioManzanaVertical;
	private JButton boton;
	private VentanaVista ventanaDestino;
	private GestorDeMovimientos gestor;
	
	MapaVista(VentanaVista unaVentana, int esquinasHorizontales, int esquinasVerticales, GestorDeMovimientos gestor){
		this.esquinasHorizontales = esquinasHorizontales;
		this.esquinasVerticales = esquinasVerticales;
		this.tamanioManzanaHorizontal = 0;
		this.tamanioManzanaVertical = 0;
		this.anchoCalle = 20;
		this.ventanaDestino = unaVentana;
		this.gestor = gestor;
		this.gestor.addObserver(this);
	}

	public void dibujarMapaConDeterminadaCantidadDePixeles(int cantidadHorizontal,int cantidadVertical){
		this.tamanioManzanaHorizontal = this.calcularTamanioManzanaHorizontal(cantidadHorizontal);
		this.tamanioManzanaVertical = this.calcularTamanioManzanaVertical(cantidadVertical);

		for (int i=0; i<=this.esquinasVerticales;i++){
			for (int j=0; j<=this.esquinasHorizontales;j++){
				int fila = j * (tamanioManzanaHorizontal + this.anchoCalle);
		        int columna = i * (tamanioManzanaVertical + this.anchoCalle);
		        ManzanaVista manzana = new ManzanaVista (tamanioManzanaHorizontal,tamanioManzanaVertical);
		        manzana.ponerManzana(ventanaDestino,fila,columna);
		        }
		}
		boton = new JButton("Boton de Prueba");
		boton.setBounds(650,650,40,40);
		boton.setVisible(true);
		this.ventanaDestino.add(boton);
	}
	
	
	public void localizarVehiculoEnMapa(JButton boton, Vehiculo unVehiculo){
		int posicionHorizontalVehiculo = unVehiculo.getPosicion().getColumna();
		int posicionVerticalVehiculo = unVehiculo.getPosicion().getFila();
		int pixelHorizontal = (posicionHorizontalVehiculo+1)*this.tamanioManzanaHorizontal+ this.anchoCalle*posicionHorizontalVehiculo ;
		int pixelVertical = (unVehiculo.getPosicion().getFila()+1)*this.tamanioManzanaVertical + this.anchoCalle*posicionVerticalVehiculo;
		boton.setBackground(Color.red);
		boton.setBounds(pixelHorizontal,pixelVertical,20,20);
		ventanaDestino.add(boton);		
	}
	public int getTamanioManzanaHorizontal(){
		return this.tamanioManzanaHorizontal;
	}
	
	public int getTamanioManzanaVertical(){
		return this.tamanioManzanaVertical;
	}
	
	private int calcularTamanioManzanaHorizontal(int cantidadHorizontal){
		return ((cantidadHorizontal)/(this.esquinasHorizontales+1))-(this.anchoCalle);		
	}
	
	private int calcularTamanioManzanaVertical(int cantidadVertical){;
		return ((cantidadVertical)/(this.esquinasVerticales+1))-(this.anchoCalle);		
	}
	
	public void update(Observable t, Object o)
	{	
		for (int i=0; i<=this.esquinasVerticales;i++){
			for (int j=0; j<=this.esquinasHorizontales;j++){
				int fila = j * (tamanioManzanaHorizontal + this.anchoCalle);
		        int columna = i * (tamanioManzanaVertical + this.anchoCalle);
		        ManzanaVista manzana = new ManzanaVista (tamanioManzanaHorizontal,tamanioManzanaVertical);
		        manzana.ponerManzana(ventanaDestino,fila,columna);
		        }
		}
			
			
	
	}
		

}