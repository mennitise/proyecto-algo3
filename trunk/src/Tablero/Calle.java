package Tablero;

import java.util.ArrayList;

import Excepciones.PasoImpedidoException;
import Obstaculos.Obstaculo;
import Vehiculos.Vehiculo;

public class Calle {
	
	private Esquina esquinaUno;
	private Esquina esquinaDos;
	private ArrayList<Obstaculo> losObstaculos;
	//van a venir los obstaculos tambien
	
	public Calle(Esquina unaEsquina, Esquina otraEsquina) {
		this.esquinaUno = unaEsquina;
		this.esquinaDos = otraEsquina;
		this.losObstaculos = new ArrayList<Obstaculo>();
	}
	
	public void agregarObstaculo(Obstaculo unObstaculo){
		this.losObstaculos.add(unObstaculo);
	}

	public void procesarVehiculo(Vehiculo unVehiculo) throws PasoImpedidoException{
		for(int i=0; i<this.losObstaculos.size();i++){
			unVehiculo.interactuarCon(this.losObstaculos.get(i));
		}
	}
	
}
