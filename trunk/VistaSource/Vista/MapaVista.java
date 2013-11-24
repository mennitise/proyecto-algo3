package Vista;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import GestorDeMovimientos.GestorDeMovimientos;
import Sorpresas.Sorpresa;
import Sorpresas.SorpresaFavorable;
import Tablero.Calle;
import Tablero.Esquina;
import Tablero.Posicion;
import Tablero.Tablero;
import Vehiculos.Vehiculo;

public class MapaVista implements Observer{ 
	private int esquinasHorizontales;
	private int esquinasVerticales;
	private int anchoCalle;
	private int tamanioManzanaHorizontal;
	private int tamanioManzanaVertical;
	private VentanaVista ventanaDestino;
	private GestorDeMovimientos gestor;
	private Tablero tablero;
	
	MapaVista(VentanaVista unaVentana,Tablero tablero, GestorDeMovimientos gestor){
		this.esquinasHorizontales = tablero.getColumnas();
		this.esquinasVerticales = tablero.getFilas();
		this.tamanioManzanaHorizontal = 0;
		this.tamanioManzanaVertical = 0;
		this.anchoCalle = 20;
		this.ventanaDestino = unaVentana;
		this.gestor = gestor;
		this.gestor.addObserver(this);
		this.tablero = tablero;
		this.tablero.addObserver(this);
	}

	public void dibujarMapaConDeterminadaCantidadDePixeles(int cantidadHorizontal,int cantidadVertical){
		this.tamanioManzanaHorizontal = this.calcularTamanioManzanaHorizontal(cantidadHorizontal);
		this.tamanioManzanaVertical = this.calcularTamanioManzanaVertical(cantidadVertical);

		this.localizarManzanasEnMapa();
		this.localizarSorpresasEnMapa();
		
	}
	
	private void localizarManzanasEnMapa(){
		for (int i=0; i<=this.esquinasVerticales;i++){
			for (int j=0; j<=this.esquinasHorizontales;j++){
				int fila = j * (tamanioManzanaHorizontal + this.anchoCalle);
		        int columna = i * (tamanioManzanaVertical + this.anchoCalle);
		        ManzanaVista manzana = new ManzanaVista (tamanioManzanaHorizontal,tamanioManzanaVertical);
		        manzana.ponerManzana(ventanaDestino,fila,columna);
		        }
		}
	}
	
	private void localizarSorpresasEnMapa(){
		for (int i=0; i<=this.esquinasVerticales-1;i++){
			for (int j=0; j<=this.esquinasHorizontales-1;j++){
				Posicion unaPosicion = new Posicion(i,j);
				Esquina unaEsquina = this.tablero.getEsquinaEn(unaPosicion);
				if (unaEsquina.tieneCalleAlEste()){
					Calle unaCalle = unaEsquina.getCalleEste();
					if ((unaCalle.getSorpresas()!=null)&&(unaCalle.getSorpresas().size()!=0)){
						Sorpresa primerSorpresa = unaEsquina.getCalleEste().getSorpresas().get(0);
						
						int pixelHorizontal = (j+1)*this.tamanioManzanaHorizontal+ this.anchoCalle*j+this.anchoCalle+this.tamanioManzanaHorizontal/2 ;
						int pixelVertical = (i+1)*this.tamanioManzanaVertical + this.anchoCalle*i;
						SorpresaVista sorpresaVista = new SorpresaVista(this.ventanaDestino);
						sorpresaVista.dibujarSorpresaEn(new SorpresaFavorable(), pixelHorizontal, pixelVertical);
				
					}
						
				}
			}
		}
	

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
	
	

	@Override
	public void update(Observable arg0, Object arg1) {
		this.localizarSorpresasEnMapa();	
	}
		
}