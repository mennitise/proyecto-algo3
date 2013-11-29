package Vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import GestorDeMovimientos.GestorDeMovimientos;
import Obstaculos.Obstaculo;
import Tablero.Calle;
import Tablero.Esquina;
import Tablero.Posicion;

public class ObstaculoVista {

	private int tamanioManzana;
	private int anchoCalle;
	private GestorDeMovimientos unGestor;

	public ObstaculoVista(int tamanioManzana, int anchoCalle){
		this.tamanioManzana = tamanioManzana;
		this.anchoCalle = anchoCalle;
		this.unGestor = unGestor;
	}
	
	public void actualizarObstaculos(Graphics g, Posicion unaPosicion, Esquina unaEsquina,
			JPanel panelDeDondeViene){
		
		
		
		int filaActual = unaPosicion.getFila();
		int columnaActual = unaPosicion.getColumna();
		int pixelHorizontal = 0 ;
		int pixelVertical = 0;
		
		this.ponerObstaculoEnCalleEste(unaEsquina, filaActual, columnaActual, g, panelDeDondeViene);
		this.ponerObstaculoEnCalleNorte(unaEsquina,filaActual,columnaActual,g,panelDeDondeViene);
		this.ponerObstaculoEnCalleSur(unaEsquina,filaActual,columnaActual,g,panelDeDondeViene);
		this.ponerObstaculoEnCalleOeste(unaEsquina,filaActual,columnaActual,g,panelDeDondeViene);
}

	private void ponerObstaculoEnCalleOeste(Esquina unaEsquina, int filaActual,
			int columnaActual, Graphics g, JPanel panelDeDondeViene) {
		
		if (unaEsquina.tieneCalleAlOeste()){
			int pixelHorizontal = (columnaActual)*this.tamanioManzana+ this.anchoCalle*(columnaActual) + this.anchoCalle/2 ;
			int pixelVertical = (filaActual+1)*this.tamanioManzana + this.anchoCalle*(filaActual);
			
			Calle unaCalle = unaEsquina.getCalleOeste();
			if ((unaCalle.getObstaculos()!=null)&&(unaCalle.getObstaculos().size()!=0)){
				Image img1 = this.getImagen (unaCalle.getObstaculos().get(0)); 
				g.drawImage(img1,pixelHorizontal,pixelVertical,panelDeDondeViene);
			
			}
						
		}	
		
	}

	private void ponerObstaculoEnCalleSur(Esquina unaEsquina, int filaActual,
			int columnaActual, Graphics g, JPanel panelDeDondeViene) {

		if (unaEsquina.tieneCalleAlSur()){
			int pixelHorizontal = (columnaActual+1)*this.tamanioManzana + this.anchoCalle*(columnaActual) ;
			int pixelVertical = (filaActual+2)*this.tamanioManzana + this.anchoCalle*(filaActual) - this.anchoCalle/2;
			
			Calle unaCalle = unaEsquina.getCalleSur();
			if ((unaCalle.getObstaculos()!=null)&&(unaCalle.getObstaculos().size()!=0)){
				Image img1 = this.getImagen (unaCalle.getObstaculos().get(0)); 					
				g.drawImage(img1,pixelHorizontal,pixelVertical,panelDeDondeViene);
			
			}
		
		
			
		}	
	}

	private void ponerObstaculoEnCalleNorte(Esquina unaEsquina, int filaActual,
			int columnaActual, Graphics g, JPanel panelDeDondeViene) {
		
		if (unaEsquina.tieneCalleAlNorte()){
			int pixelHorizontal = (columnaActual+1)*this.tamanioManzana+ this.anchoCalle*(columnaActual) ;
			int pixelVertical = (filaActual)*this.tamanioManzana + this.anchoCalle*(filaActual) + this.anchoCalle/2;
			
			Calle unaCalle = unaEsquina.getCalleNorte();
			if ((unaCalle.getObstaculos()!=null)&&(unaCalle.getObstaculos().size()!=0)){
				Image img1 = this.getImagen (unaCalle.getObstaculos().get(0)); 
				g.drawImage(img1,pixelHorizontal,pixelVertical,panelDeDondeViene);
			}
		
		}	
		
		
	}

	private void ponerObstaculoEnCalleEste(Esquina unaEsquina, int filaActual, int columnaActual, Graphics g, JPanel panelDeDondeViene){
		if (unaEsquina.tieneCalleAlEste()){
			int pixelHorizontal = (columnaActual+1)*this.tamanioManzana+ this.anchoCalle*(columnaActual+1) + this.anchoCalle/2 ;
			int pixelVertical = (filaActual+1)*this.tamanioManzana + this.anchoCalle*(filaActual);
		
			Calle unaCalle = unaEsquina.getCalleEste();
			
			if ((unaCalle.getObstaculos()!=null)&&(unaCalle.getObstaculos().size()!=0)){
				Image img1 = this.getImagen (unaCalle.getObstaculos().get(0)); 
				g.drawImage(img1,pixelHorizontal,pixelVertical,panelDeDondeViene);
			
			}
			
			
		}	
		
	}
	
	private Image getImagen(Obstaculo unObstaculo){
		switch (unObstaculo.getClass().getSimpleName()){
			case "Piquete": return Toolkit.getDefaultToolkit().getImage("src/imagenes/piquete.png"); 
			case "ControlPolicial": return Toolkit.getDefaultToolkit().getImage("src/imagenes/controlPolicial.png");
			case "Pozo": return Toolkit.getDefaultToolkit().getImage("src/imagenes/pozo.png");
		}
		return Toolkit.getDefaultToolkit().getImage("Ninguna imagen"); //nunca va a llegar a esta instancia porque el obstaculo que le paso siempre existe
	}
}

