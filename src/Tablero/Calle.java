package Tablero;

import java.util.ArrayList;

import Excepciones.PasoImpedidoException;
import Obstaculos.Obstaculo;
import Vehiculos.Vehiculo;

public class Calle {
	
	private Esquina esquinaUno;
	private Esquina esquinaDos;
	private ArrayList<Obstaculo> objetos;
	//van a venir los obstaculos tambien
	
	public Calle(Esquina unaEsquina, Esquina otraEsquina) {
		this.esquinaUno = unaEsquina;
		this.esquinaDos = otraEsquina;
		this.objetos = new ArrayList<Obstaculo>();
	}

	public void procesarVehiculo(Vehiculo unVehiculo) throws PasoImpedidoException{
		for(int i=0; i<this.objetos.size();i++){
			unVehiculo.interactuarCon(this.objetos.get(i));
		}
	}
	
}
