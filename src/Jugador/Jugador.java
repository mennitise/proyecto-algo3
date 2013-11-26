package Jugador;

import org.jdom.Attribute;
import org.jdom.Element;

import Vehiculos.Vehiculo;
import Excepciones.NumeroNegativoException;
import Excepciones.StringVacioException;

public class Jugador {

	private String nombre;
	private int cantidadDeMovimientos;
	private Vehiculo vehiculoUtilizado;
	
	public Jugador(String unNombre, Vehiculo unVehiculo) throws StringVacioException{
		this.setNombre(unNombre);
		
		if( unVehiculo != null ){
			this.setVehiculo(unVehiculo);
		}else{
			this.vehiculoUtilizado = null;
		}
		
		this.cantidadDeMovimientos = 0;
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

	public void sumarUnMovimiento(){
		this.cantidadDeMovimientos += 1;
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
	
	
	public Vehiculo getVehiculo(){
		return this.vehiculoUtilizado;
	}

	public void setVehiculo(Vehiculo unVehiculo){
		this.vehiculoUtilizado = unVehiculo;
		this.vehiculoUtilizado.setConductor(this);
	}

	// Serialización
	
	
	public Element serializarXML() {
		Element element = new Element("jugador");
		
		Attribute attNombre = new Attribute("nombre",this.nombre);
		Attribute attCantDeMovimientos = new Attribute("cantidadDeMovimientos",((Integer)this.cantidadDeMovimientos).toString());
		element.getAttributes().add(attNombre);
		element.getAttributes().add(attCantDeMovimientos);
		
		Element elementVehiculo = this.vehiculoUtilizado.serializarXML();
		element.getChildren().add(elementVehiculo);
		return element;
	}
	
	
	public static Jugador cargarDesdeXML(Element element){
		
		String nombre           = (String)element.getAttributeValue("nombre");
		int cantidadMovimientos = Integer.parseInt(element.getAttributeValue("cantidadDeMovimientos"));
		
		Element elementVehiculo = (Element)element.getChildren().get(0);
		Vehiculo unVehiculo     = Vehiculo.cargarDesdeXML(elementVehiculo);
		
		Jugador unJugador = null;
		try {
			unJugador = new Jugador(nombre, unVehiculo);
		} catch (StringVacioException e1) {
			// No ingresará ya que siempre se guardará de una manera válida.
		}
		
		try {
			unJugador.sumarMovimientos(cantidadMovimientos);
		} catch (NumeroNegativoException e) {
			// No ingresará ya que siempre se guardará de una manera válida.
		}
		return unJugador;
	}
}