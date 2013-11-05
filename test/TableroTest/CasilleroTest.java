package TableroTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Obstaculos.ControlPolicial;
import Obstaculos.Obstaculo;
import Tablero.Casillero;

public class CasilleroTest {

	@Test
	public void testCasilleroSeInicializaEnVacio() {
		Casillero casillero = new Casillero();
		
		assertTrue(casillero.estaVacio());
	}

	@Test
	public void testCasilleroOcupado() {
		Casillero casillero = new Casillero();
		ControlPolicial unControlPolicial= new ControlPolicial();
		
		casillero.ponerObstaculoOSorpresa(unControlPolicial);

		assertTrue(casillero.estaOcupado());
	}
	

}
