package futbol;

import java.util.LinkedList;

public class Equipo {
	private String nombre;
	private String ciudad;
	private LinkedList<Jugador> jugadores;
	
	private static String[] nombres = {"Rayos del Horizonte", "Titanes de la Ciudad", "Águilas Doradas", 
			"Centauros del Valle", "Lobos del Sur", "Dragones de Fuego", "Centinelas del Abismo", 
			"Tormenta FC", "Trueno Azul", "Cazadores del Norte", "Fénix FC", "Espectros del Crepúsculo", 
			"Estrellas del Ocaso", "Guerreros del Viento", "Leones del Desierto", "Imperio Rojo", 
			"Quimeras FC", "Espectros del Bosque", "Centellas del Este", "Soles del Mediodía"};
	
	private static String[] ciudades = {"Buenos Aires", "Córdoba", "Rosario", "Mar del Plata", 
			"San Miguel de Tucumán", "Salta", "Santa Fe", "Corrientes", "Bahía Blanca", 
			"Resistencia", "Posadas", "Merlo", "Quilmes", "San Salvador de Jujuy", "Guaymallén", 
			"Santiago del Estero", "Gregorio de Laferrere", "José C. Paz", "Paraná", "Banfield", 
			"González Catán", "Neuquén", "Formosa", "Lanús", "La Plata", "Godoy Cruz", 
			"Isidro Casanova", "Las Heras", "Berazategui", "La Rioja"};

	public Equipo(String nombre, String ciudad) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.jugadores = new LinkedList<Jugador>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
	
	public static Equipo crearRandom() {
		int numeroNombre = (int)(Math.random()*(nombres.length));
		int numeroCiudad = (int)(Math.random()*(ciudades.length));
		Equipo equipo = new Equipo(nombres[numeroNombre], ciudades[numeroCiudad]);
		int numeroJugadores = (int)(Math.random()*(10)+5);
		for (int i=0; i<numeroJugadores; i++) {
			equipo.agregarJugador(Jugador.crearRandom(i+1));
		}
		return equipo;
    }
	
	public String mostrarBasic() {
		String result ="\"" + nombre + "\""+ " de " + ciudad;
		result+="\ntiene " + jugadores.size() + " jugadores";
		return result;
    }

	public String mostrarJugadores() {
		String result = "";
  	    for(Jugador jugador:jugadores) {
			result+= jugador +"\n";
		}
		return result;
    }

	public String mostrarTodo() {
		String result = mostrarBasic() +":\n" + mostrarJugadores();
		return result;
    }
	
}
