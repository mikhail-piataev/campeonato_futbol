package futbol;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Jugador extends Persona{
	private int numeroCamiseta;
	private String posicion;
	private int rating;
	
	private static String[] posiciones= {"Portero", "Defensa central", "Defensa derecho", "Defensa izquierdo", "Defensa líbero", 
			"Mediocampista defensivo", "Mediocampista central", "Mediocampista ofensivo", 
			"Delantero centro", "Segundo delantero", "Extremo derecho", "Extremo izquierdo"}; 
	
	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, int numeroCamiseta, String posicion, int rating) {
		super(nombre, apellido, fechaNacimiento);
		this.numeroCamiseta = numeroCamiseta;
		this.posicion = posicion;
		setRating(rating);
	}
	
	public Jugador(Persona persona, int numeroCamiseta, String posicion, int rating) {
		super(persona.getNombre(), persona.getApellido(), persona.getFechaNacimiento());
		this.numeroCamiseta = numeroCamiseta;
		this.posicion = posicion;
		setRating(rating);
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
	
	public int getRating() {
        return rating;
    }
	
	public void setRating(int rating) {
            this.rating = rating;
    }
	
	@Override
	public String toString() {
		return numeroCamiseta + ". " + super.toString() + " [" + rating + "]  - " + posicion;
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
		int randomRating = (int) (Math.random() * 101); 
    	return new Jugador(chico, numeroCamiseta, posicion, randomRating);
    }

	public static Jugador crearManualmente(int numeroCamiseta) {
		Persona chico=Persona.crearManualmente();
		String posicion = JOptionPane.showInputDialog(null, "Ingrese posición del jugador en el equipo ");
		int rating = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la clasificacion del jugador (0-100):"));
    	return new Jugador(chico, numeroCamiseta, posicion, rating);
    }
	
	public boolean tieneNombre(String nombre) {
		return this.getNombre().equals(nombre);
	}

	public boolean tieneApellido(String apellido) {
		return this.getApellido().equals(apellido);
	}

	
}
