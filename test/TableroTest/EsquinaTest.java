package TableroTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Tablero.Calle;
import Tablero.Esquina;

public class EsquinaTest {

	@Test
	public void testEsquinaSeInicializaSinCalleAlOeste() {
		Esquina esquina = new Esquina();
		assertTrue( !esquina.tieneCalleAlOeste() );
	}
	
	@Test
	public void testEsquinaSeInicializaSinCalleAlSur() {
		Esquina esquina = new Esquina();
		assertTrue( !esquina.tieneCalleAlSur() );
	}
	
	@Test
	public void testEsquinaSeInicializaSinCalleAlNorte() {
		Esquina esquina = new Esquina();
		assertTrue( !esquina.tieneCalleAlNorte() );
	}
	
	@Test
	public void testEsquinaSeInicializaSinCalleAlEste() {
		Esquina esquina = new Esquina();
		assertTrue( !esquina.tieneCalleAlEste() );
	}
	
	@Test
	public void testEsquinaPonerCalleAlOeste() {
		Esquina esquina = new Esquina();
		Calle calleAuxiliar = new Calle(new Esquina(),new Esquina());
		esquina.ponerCalleHaciaElOeste(calleAuxiliar);
		assertTrue( esquina.tieneCalleAlOeste() );
	}
	
	@Test
	public void testEsquinaPonerCalleAlEste() {
		Esquina esquina = new Esquina();
		Calle calleAuxiliar = new Calle(new Esquina(),new Esquina());
		esquina.ponerCalleHaciaElEste(calleAuxiliar);
		assertTrue( esquina.tieneCalleAlEste() );
	}
	@Test
	public void testEsquinaPonerCalleAlNorte() {
		Esquina esquina = new Esquina();
		Calle calleAuxiliar = new Calle(new Esquina(),new Esquina());
		esquina.ponerCalleHaciaElNorte(calleAuxiliar);
		assertTrue( esquina.tieneCalleAlNorte() );
	}
	
	@Test
	public void testEsquinaPonerCalleAlSur() {
		Esquina esquina = new Esquina();
		Calle calleAuxiliar = new Calle(new Esquina(),new Esquina());
		esquina.ponerCalleHaciaElSur(calleAuxiliar);
		assertTrue( esquina.tieneCalleAlSur() );
	}
	
	

}