package futbol;

import java.time.LocalDate;

public class Jugador extends Persona{
	private int numeroCamiseta;
	private String posicion;
	
	private static String[] posiciones= {"Portero", "Defensa central", "Defensa derecho", "Defensa izquierdo", "Defensa líbero", 
			"Mediocampista defensivo", "Mediocampista central", "Mediocampista ofensivo", 
			"Delantero centro", "Segundo delantero", "Extremo derecho", "Extremo izquierdo"}; 
	
	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, int numeroCamiseta, String posicion) {
		super(nombre, apellido, fechaNacimiento);
		this.numeroCamiseta = numeroCamiseta;
		this.posicion = posicion;
	}
	
	public Jugador(Persona persona, int numeroCamiseta, String posicion) {
		super(persona.getNombre(), persona.getApellido(), persona.getFechaNacimiento());
		this.numeroCamiseta = numeroCamiseta;
		this.posicion = posicion;
	}

	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}

	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	@Override
	public String toString() {
		return numeroCamiseta + ". " + super.toString() + " - " + posicion;
	}

	public static Jugador crearRandom(int numeroCamiseta) {
		int numeroPosition;
		if (numeroCamiseta ==1) {
			numeroPosition = 0;
		} else {
			numeroPosition = (int)(Math.random()*(posiciones.length-1)+1); //nunca es "Portero"
		}
		String posicion = posiciones[numeroPosition];
		Persona chico=Persona.crearRandom();
    	return new Jugador(chico, numeroCamiseta, posicion);
    }

}
