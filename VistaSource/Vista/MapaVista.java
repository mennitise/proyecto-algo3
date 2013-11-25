package Vista;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;

import GestorDeMovimientos.GestorDeMovimientos;
import Obstaculos.Obstaculo;
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
	
	public MapaVista(VentanaVista unaVentana,Tablero tablero, GestorDeMovimientos gestor){
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
	
	private void ponerSorpresasHorizontales(){
		for (int i=0; i<=this.esquinasVerticales-1;i++){
			for (int j=0; j<=this.esquinasHorizontales-1;j++){
				Posicion unaPosicion = new Posicion(i,j);
				Esquina unaEsquina = this.tablero.getEsquinaEn(unaPosicion);
				int pixelHorizontal = (j+1)*this.tamanioManzanaHorizontal+ this.anchoCalle*j+this.anchoCalle+this.tamanioManzanaHorizontal/2 ;
				int pixelVertical = (i+1)*this.tamanioManzanaVertical + this.anchoCalle*i;
				if (unaEsquina.tieneCalleAlEste()){
					Calle unaCalle = unaEsquina.getCalleEste();
					if ((unaCalle.getSorpresas()!=null)&&(unaCalle.getSorpresas().size()!=0)){
						Sorpresa primerSorpresa = unaEsquina.getCalleEste().getSorpresas().get(0);
						
						SorpresaVista sorpresaVista = new SorpresaVista(this.ventanaDestino);
						sorpresaVista.dibujarSorpresaEn(primerSorpresa, pixelHorizontal, pixelVertical);
					
					}
				
					if((unaCalle.getObstaculos()!=null)&&(unaCalle.getObstaculos().size()!=0)){
						Obstaculo unObstaculo  = unaEsquina.getCalleEste().getObstaculos().get(0);
						pixelVertical += this.anchoCalle/2;
						ObstaculoVista obstaculoVista = new ObstaculoVista(this.ventanaDestino);
						obstaculoVista.dibujarSorpresaEn(unObstaculo, pixelHorizontal, pixelVertical);
					
					}
				}	
				
			}
		}
	}
	
	private void ponerSorpresasVerticales(){
		for (int i=0; i<=this.esquinasVerticales-1;i++){
			for (int j=0; j<=this.esquinasHorizontales-1;j++){
				Posicion unaPosicion = new Posicion(i,j);
				Esquina unaEsquina = this.tablero.getEsquinaEn(unaPosicion);
				int pixelHorizontal = (j+1)*this.tamanioManzanaHorizontal+ this.anchoCalle*j ;
				int pixelVertical = (i+1)*this.tamanioManzanaVertical + this.anchoCalle*i +this.anchoCalle+this.tamanioManzanaHorizontal/2;
				
				if (unaEsquina.tieneCalleAlSur()){
					Calle unaCalle = unaEsquina.getCalleSur();
					if ((unaCalle.getSorpresas()!=null)&&(unaCalle.getSorpresas().size()!=0)){
						Sorpresa primerSorpresa = unaEsquina.getCalleSur().getSorpresas().get(0);
						
						SorpresaVista sorpresaVista = new SorpresaVista(this.ventanaDestino);
						sorpresaVista.dibujarSorpresaEn(primerSorpresa, pixelHorizontal, pixelVertical);
					
					}
					
					if((unaCalle.getObstaculos()!=null)&&(unaCalle.getObstaculos().size()!=0)){
						Obstaculo unObstaculo  = unaEsquina.getCalleSur().getObstaculos().get(0);
						pixelHorizontal += this.anchoCalle/2;
						ObstaculoVista obstaculoVista = new ObstaculoVista(this.ventanaDestino);
						obstaculoVista.dibujarSorpresaEn(unObstaculo, pixelHorizontal, pixelVertical);
					
					}
						
				}
			}
		}
		
	}
	
	private void localizarSorpresasEnMapa(){
		this.ponerSorpresasHorizontales();
		this.ponerSorpresasVerticales();
	}
	
	public void localizarVehiculoEnMapa(JLabel boton, Vehiculo unVehiculo){
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