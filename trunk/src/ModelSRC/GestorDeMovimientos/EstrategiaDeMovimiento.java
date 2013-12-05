package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Tablero.Esquina;
import Tablero.Posicion;
import Vehiculos.Vehiculo;

public interface EstrategiaDeMovimiento {

	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina) throws MovimientoFisicamenteInvalidoException;

	public void moverPosicion(Posicion posicion);

}
