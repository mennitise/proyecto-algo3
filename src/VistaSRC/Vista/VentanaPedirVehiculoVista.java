package Vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Excepciones.CanceloJuegoException;


//el modelo sabe interpretar el numero 1, 2 o 3, por eso devuelve enteros
public class VentanaPedirVehiculoVista {
	
	public static int pedirVehiculo() throws CanceloJuegoException{
		Object[] posibilidades = {"Auto", "CuatroXCuatro", "Moto"};
		String autoElegido = (String)JOptionPane.showInputDialog(
		                    new JFrame(),
		                    "Elegir Vehiculo",
		                    "Vehiculo",
		                    JOptionPane.PLAIN_MESSAGE,
		                    new ImageIcon(),
		                    posibilidades,
		                    "Auto");

	if (autoElegido == null){
		throw new CanceloJuegoException();
	}else{
	
		if (autoElegido.equals("Auto")) return 1;
		if (autoElegido.equals("CuatroXCuatro")) return 3;
		if (autoElegido.equals("Moto")) return 2;

	}

	return 1;
	}
}
