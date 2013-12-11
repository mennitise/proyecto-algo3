package Tablero;

import java.util.ArrayList;

import Excepciones.PasoImpedidoException;
import Obstaculos.Obstaculo;
import Sorpresas.Sorpresa;
import Vehiculos.Vehiculo;

public class Calle {
	
	private Esquina esquinaUno;
	private Esquina esquinaDos;
	private Obstaculo elObstaculo;
	private Sorpresa laSorpresa;
	
	public Calle(Esquina unaEsquina, Esquina otraEsquina) {
		this.esquinaUno = unaEsquina;
		this.esquinaDos = otraEsquina;
		this.elObstaculo = null;
		this.laSorpresa = null;
	}
	
	public void agregarObstaculo(Obstaculo unObstaculo){
		this.elObstaculo = unObstaculo;
	}

	public void agregarSorpresa(Sorpresa unaSorpresa){
		this.laSorpresa = unaSorpresa;
	}
	
	public boolean tieneAlgunaSorpresa(){
		return (this.laSorpresa != null);
	}
	
	public boolean tieneAlgunObstaculo(){
		return (this.elObstaculo != null);
	}
	
	public void procesarVehiculo(Vehiculo unVehiculo) throws PasoImpedidoException{
		if (this.tieneAlgunaSorpresa()){
				unVehiculo.interactuarCon(this.laSorpresa);
				this.eliminarSorpresa();
		}	
		if (this.tieneAlgunObstaculo()){
			unVehiculo.interactuarCon(this.elObstaculo);
		}
	}

	public Sorpresa getSorpresa(){
		return this.laSorpresa;		
	}
	
	public Obstaculo getObstaculo(){
		return this.elObstaculo;
	}

	private void eliminarSorpresa(){
		this.laSorpresa = null;
		}
	
}
