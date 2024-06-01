package futbol;

import java.util.LinkedList;

import javax.swing.JOptionPane;

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
		if (numeroOcupado(jugador.getNumeroCamiseta())) {
			JOptionPane.showMessageDialog(null,"¡Error! ¡Este numero de camiseta ya está ocupado!");
		} else {
			jugadores.add(jugador);			
		}
	}

	public void agregarJugadorManualmente() {
		int numero;
		do {
			numero=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingerese numero de camiseta. "
					+ "\nYa están ocupado los numeros " + mostrarNumeros()));
			if (numeroOcupado(numero)) {
				JOptionPane.showMessageDialog(null,"¡Error! ¡Este numero de camiseta ya está ocupado!");
			}
		} while (numeroOcupado(numero));
		Jugador jugador = Jugador.crearManualmente(numero);
		jugadores.add(jugador);			
	}

	public void eliminarJugadorManualmente() {
		String[] options=toArrayString(); 
		String elegido =(String)JOptionPane.showInputDialog(null, "Elige un jugador para eliminar", 
				null, 1, null, options, options[0]);
		//String[] elegidoSplit = elegido.split(". ");
		int numero = Integer.parseInt(elegido.split(". ")[0]);
		eliminarJugador(numero);		
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

	public static Equipo crearManualmante() {
		String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de equipo ");
		String ciudad = JOptionPane.showInputDialog(null, "Ingrese la ciudad de equipo ");
		return new Equipo(nombre,ciudad);
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

	public String[] toArrayString() {
		if (jugadores.isEmpty()) {
			return null; 
		} 
		String[] result = new String[jugadores.size()];
  	    for(int i=0; i<jugadores.size(); i++) {
			result[i]=jugadores.get(i).getNumeroCamiseta()+". "+jugadores.get(i).getNombre() +" "+jugadores.get(i).getApellido();
  	    }
	    return result;
    }
	
	public boolean numeroOcupado(int numeroCamiseta) {
		for(Jugador jugador:jugadores) {
  				if (jugador.getNumeroCamiseta()==numeroCamiseta) {
  					return true;
  				}
  	    }
	    return false;
    }
	
	public String mostrarNumeros() {
		String stringNumeros="";
		for(int i=0; i<jugadores.size(); i++) {
			stringNumeros+= jugadores.get(i).getNumeroCamiseta();
			if (i<jugadores.size()-1) {
				stringNumeros+=", "; 
			}
			
  	    }
	    return stringNumeros;
    }

	public Jugador encontrarJugador(int numeroCamiseta) {
		for(Jugador jugador:jugadores) {
				if (jugador.getNumeroCamiseta()==numeroCamiseta) {
					return jugador;
				}
	    }
		return null;
	}

	public void eliminarJugador(int numeroCamiseta) {
		Jugador jugador=encontrarJugador(numeroCamiseta);
		if (jugador== null) {
			JOptionPane.showMessageDialog(null, "No hay jugador con este numero en equipo " + getNombre() );
	    } else {
	    	//JOptionPane.showOptionDialog	
	    	if (JOptionPane.showConfirmDialog(null, "Eliminar jugador " + jugador + "?")==0) {
	    		jugadores.remove(jugador);	
	    	}
	    	
	    }
	}
	
}
