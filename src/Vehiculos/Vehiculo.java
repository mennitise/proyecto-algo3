package Vehiculos;

import Excepciones.NumeroNegativoException;
import Excepciones.ProbabilidadNoValidaException;

public class Vehiculo {
	private double probabilidadDeSerDetenidoPorControlPolicial;
	
	public Vehiculo(){
		this.probabilidadDeSerDetenidoPorControlPolicial = 0;
	}
	
	public Vehiculo(double unaProbabilidad) throws ProbabilidadNoValidaException{
		if(( unaProbabilidad >= 0) & (unaProbabilidad<= 1)){
			this.probabilidadDeSerDetenidoPorControlPolicial = unaProbabilidad;
		}else{
			throw new ProbabilidadNoValidaException();
		}
	}
	
	
	public double getProbabilidadDeSerDetenidoPorControlPolicial(){
		return this.probabilidadDeSerDetenidoPorControlPolicial;
	}

}
