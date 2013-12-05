package Tablero;

public class Esquina {

	private Calle calleOeste;
	private Calle calleEste;
	private Calle calleNorte;
	private Calle calleSur;
	
	public Esquina(){
		this.calleSur   = null;
		this.calleNorte = null;
		this.calleEste  = null;
		this.calleOeste = null;
	}

	public void ponerCalleHaciaElEste(Calle unaCalle) {
		this.calleEste = unaCalle;
	}
	
	public void ponerCalleHaciaElOeste(Calle unaCalle) {
		this.calleOeste = unaCalle;
	}
	
	public void ponerCalleHaciaElNorte(Calle unaCalle) {
		this.calleNorte = unaCalle;
	}
	
	public void ponerCalleHaciaElSur(Calle unaCalle) {
		this.calleSur = unaCalle;
	}

	public boolean tieneCalleAlOeste() {
		return (this.calleOeste != null);
	}
	
	public boolean tieneCalleAlEste() {
		return (this.calleEste != null);
	}
	
	public boolean tieneCalleAlNorte() {
		return (this.calleNorte != null);
	}
	
	public boolean tieneCalleAlSur() {
		return (this.calleSur != null);
	}

	public Calle getCalleNorte() {
		return this.calleNorte;
	}
	
	public Calle getCalleSur() {
		return this.calleSur;
	}
	
	public Calle getCalleOeste() {
		return this.calleOeste;
	}
	
	public Calle getCalleEste() {
		return this.calleEste;
	}
	
}
