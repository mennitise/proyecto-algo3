package Vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Excepciones.CanceloJuegoException;

//El modelo sabe interpretar el numero 1,2 o 3 al pedir nivel. Por eso se devuelven enteros
public class VentanaPedirNivelVista {

	public static int pedirNivel() throws CanceloJuegoException{
		Object[] posibilidades = {"Facil", "Intermedio", "Dificil"};
		String nivelElegido = (String)JOptionPane.showInputDialog(
		                    new JFrame(),
		                    "Elegir Nivel",
		                    "Nivel",
		                    JOptionPane.PLAIN_MESSAGE,
		                    new ImageIcon(),
		                    posibilidades,
		                    "Facil");

		if (nivelElegido == null){
			throw new CanceloJuegoException(); //significa que cancelo el juego
		}else{
		
			if (nivelElegido.equals("Facil")) return 1;
			if (nivelElegido.equals("Intermedio")) return 2;
			if (nivelElegido.equals("Dificil")) return 3;
			
		}
			
		return 1;	
		
	}
	
}
