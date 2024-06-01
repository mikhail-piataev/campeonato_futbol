package futbol;

public class Partido {
	private Equipo primero, segundo;
	private int golPrimero, golSegundo;
	
	public Partido(Equipo primero, Equipo segundo, int golPrimero, int golSegundo) {
		this.primero = primero;
		this.segundo = segundo;
		this.golPrimero = golPrimero;
		this.golSegundo = golSegundo;
	}

	public Equipo getPrimero() {
		return primero;
	}

	public void setPrimero(Equipo primero) {
		this.primero = primero;
	}

	public Equipo getSegundo() {
		return segundo;
	}

	public void setSegundo(Equipo segundo) {
		this.segundo = segundo;
	}

	public int getGolPrimero() {
		return golPrimero;
	}

	public void setGolPrimero(int golPrimero) {
		this.golPrimero = golPrimero;
	}

	public int getGolSegundo() {
		return golSegundo;
	}

	public void setGolSegundo(int golSegundo) {
		this.golSegundo = golSegundo;
	}
	
	public String mostrarResultado() {
	  return "nada";
	}
	
}
