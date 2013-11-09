package GestorDeMovimientos;

import Excepciones.MovimientoFisicamenteInvalidoException;
import Tablero.Esquina;
import Vehiculos.Vehiculo;

public interface EstrategiaDeMovimiento {

	public void realizarMovimiento(Vehiculo unVehiculo, Esquina unaEsquina) throws MovimientoFisicamenteInvalidoException;
}
