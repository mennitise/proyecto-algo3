package Jugador;

import Vehiculos.Vehiculo;
import Excepciones.NumeroNegativoException;
import Excepciones.StringVacioException;

public class Jugador {

	private String nombre;
	private int cantidadDeMovimientos;
	private Vehiculo vehiculoUtilizado;
	
	public Jugador(String unNombre, Vehiculo unVehiculo) throws StringVacioException{
		this.setNombre(unNombre);
		this.cantidadDeMovimientos = 0;
		this.vehiculoUtilizado = unVehiculo;
	}
	
	public void setNombre(String unNombre) throws StringVacioException{
		if(unNombre.equals("")){
			throw new StringVacioException();
		}else{
			this.nombre = unNombre;
		}
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getCantidadDeMovimientos(){
		return this.cantidadDeMovimientos;
	}

	public void sumarMovimientos(int unaCantidadDeMovimientos) throws NumeroNegativoException{
		if(unaCantidadDeMovimientos >= 0){
			this.cantidadDeMovimientos += unaCantidadDeMovimientos;
		}else{
			throw new NumeroNegativoException();
		}
	}
	
	public void quitarMovimientos(int unaCantidadDeMovimientos) throws NumeroNegativoException{
		if(unaCantidadDeMovimientos >= 0){
			this.cantidadDeMovimientos -= unaCantidadDeMovimientos;
		}else{
			throw new NumeroNegativoException();
		}
		
		//me fijo que si la cantidad de movimientos es menor que cero, la pongo en 0
		if(this.cantidadDeMovimientos < 0){
			this.cantidadDeMovimientos = 0;
		}
	}
	
	public double getProbabilidadDeSerDetenidoPorControlPolicial(){
		return this.vehiculoUtilizado.getProbabilidadDeSerDetenidoPorControlPolicial();
		
	}
	
	public Vehiculo getVehiculo(){
		return this.vehiculoUtilizado;
	}

	public void setVehiculo(Vehiculo unVehiculo){
		this.vehiculoUtilizado = unVehiculo;
	}
	
}