package Vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import GestorDeMovimientos.GestorDeMovimientos;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Tablero.Calle;
import Tablero.Esquina;
import Tablero.Posicion;
import Tablero.Tablero;


public class SorpresaVista {
	private int tamanioManzana;
	private int anchoCalle;
	private Tablero tablero;

	public SorpresaVista(int tamanioManzana, int anchoCalle, Tablero unTablero){
		this.tamanioManzana = tamanioManzana;
		this.anchoCalle = anchoCalle;
		this.tablero = unTablero;
	}
	
	public void actualizarSorpresas(Graphics g, Posicion unaPosicion, JPanel panelDeDondeViene){
		Esquina unaEsquina = tablero.getEsquinaEn(unaPosicion);
		int filaActual = unaPosicion.getFila();
		int columnaActual = unaPosicion.getColumna();
		
		this.ponerSorpresaEnCalleEste(unaEsquina, filaActual, columnaActual, g, panelDeDondeViene);
		this.ponerSorpresaEnCalleNorte(unaEsquina,filaActual,columnaActual,g,panelDeDondeViene);
		this.ponerSorpresaEnCalleSur(unaEsquina,filaActual,columnaActual,g,panelDeDondeViene);
		this.ponerSorpresaEnCalleOeste(unaEsquina,filaActual,columnaActual,g,panelDeDondeViene);
}

	private void ponerSorpresaEnCalleOeste(Esquina unaEsquina, int filaActual,
			int columnaActual, Graphics g, JPanel panelDeDondeViene) {
		
		if (unaEsquina.tieneCalleAlOeste()){
			int pixelHorizontal = (columnaActual)*this.tamanioManzana+ this.anchoCalle*(columnaActual) ;
			int pixelVertical = (filaActual+1)*this.tamanioManzana + this.anchoCalle*(filaActual);
			
			Calle unaCalle = unaEsquina.getCalleOeste();
			if ((unaCalle.getSorpresas()!=null)&&(unaCalle.getSorpresas().size()!=0)){
				Image img1 = Toolkit.getDefaultToolkit().getImage("src/imagenes/sorpresa.png");
				g.drawImage(img1,pixelHorizontal,pixelVertical,panelDeDondeViene);
			
			}
						
		}	
		
	}

	private void ponerSorpresaEnCalleSur(Esquina unaEsquina, int filaActual,
			int columnaActual, Graphics g, JPanel panelDeDondeViene) {

		if (unaEsquina.tieneCalleAlSur()){
			int pixelHorizontal = (columnaActual+1)*this.tamanioManzana + this.anchoCalle*(columnaActual) ;
			int pixelVertical = (filaActual+1)*this.tamanioManzana + this.anchoCalle*(filaActual+1);
			
			Calle unaCalle = unaEsquina.getCalleSur();
			if ((unaCalle.getSorpresas()!=null)&&(unaCalle.getSorpresas().size()!=0)){
				Image img1 = Toolkit.getDefaultToolkit().getImage("src/imagenes/sorpresa.png");
				g.drawImage(img1,pixelHorizontal,pixelVertical,panelDeDondeViene);
			
			}
		
		
			
		}	
	}

	private void ponerSorpresaEnCalleNorte(Esquina unaEsquina, int filaActual,
			int columnaActual, Graphics g, JPanel panelDeDondeViene) {
		if (unaEsquina.tieneCalleAlNorte()){
			int pixelHorizontal = (columnaActual+1)*this.tamanioManzana+ this.anchoCalle*(columnaActual) ;
			int pixelVertical = (filaActual)*this.tamanioManzana + this.anchoCalle*(filaActual);
			
			Calle unaCalle = unaEsquina.getCalleNorte();
			if ((unaCalle.getSorpresas()!=null)&&(unaCalle.getSorpresas().size()!=0)){
				Image img1 = Toolkit.getDefaultToolkit().getImage("src/imagenes/sorpresa.png");
				g.drawImage(img1,pixelHorizontal,pixelVertical,panelDeDondeViene);
			}
		
		}	
		
		
	}

	private void ponerSorpresaEnCalleEste(Esquina unaEsquina, int filaActual, int columnaActual, Graphics g, JPanel panelDeDondeViene){
		if (unaEsquina.tieneCalleAlEste()){
			int pixelHorizontal = (columnaActual+1)*this.tamanioManzana+ this.anchoCalle*(columnaActual+1) ;
			int pixelVertical = (filaActual+1)*this.tamanioManzana + this.anchoCalle*(filaActual);
		
			Calle unaCalle = unaEsquina.getCalleEste();
			
			if ((unaCalle.getSorpresas()!=null)&&(unaCalle.getSorpresas().size()!=0)){
				Image img1 = Toolkit.getDefaultToolkit().getImage("src/imagenes/sorpresa.png");
				g.drawImage(img1,pixelHorizontal,pixelVertical,panelDeDondeViene);
			
			}
			
			
		}	
		
	}
}
