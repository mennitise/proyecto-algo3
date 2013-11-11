package Tablero;

import java.util.ArrayList;

import Excepciones.PasoImpedidoException;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Vehiculos.Vehiculo;

public class Calle {
	
	private Esquina esquinaUno;
	private Esquina esquinaDos;
	private ArrayList<Obstaculo> losObstaculos;
	private ArrayList<Sorpresa> lasSorpresas;
	
	public Calle(Esquina unaEsquina, Esquina otraEsquina) {
		this.esquinaUno = unaEsquina;
		this.esquinaDos = otraEsquina;
		this.losObstaculos = new ArrayList<Obstaculo>();
		this.lasSorpresas = new ArrayList<Sorpresa>();
	}
	
	public void agregarObstaculo(Obstaculo unObstaculo){
		this.losObstaculos.add(unObstaculo);
	}

	public void agregarSorpresa(Sorpresa unaSorpresa){
		this.lasSorpresas.add(unaSorpresa);
	}
	
	public void procesarVehiculo(Vehiculo unVehiculo) throws PasoImpedidoException{
		for(int i=0; i<this.lasSorpresas.size();i++){
			unVehiculo.interactuarCon(this.lasSorpresas.get(i));
		}
		for(int i=0; i<this.losObstaculos.size();i++){
			unVehiculo.interactuarCon(this.losObstaculos.get(i));
		}
	}
	
}
