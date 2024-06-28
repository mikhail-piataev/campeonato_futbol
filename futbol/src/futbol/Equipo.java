package futbol;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {
	private String nombre;
	private String ciudad;
	private String imagen;

	private LinkedList<Jugador> jugadores;
	
	private static String[] nombres = {"Talleres de Córdoba", "Huracán", "Unión", "Racing Club",
			"Gimnasia La Plata", "Instituto", "River Plate", "Argentinos Juniors", "Lanús", "Belgrano", 
			"Boca Juniors", "Sarmiento"};
	
	private static String[] imagenes = {"01talleres.jpg", "02huracan.jpg", "03union-santa-fe.jpg", 
			"04racing-club.jpg", "05gimnasia-la-plata.jpg", "06instituto.jpg", "07river-plate.jpg", 
			"08argentinos-juniors.jpg", "09lanus.jpg", "10belgrano.jpg", "11boca-juniors.jpg", "12sarmiento.jpg"};
	
	private static String[] ciudades = {"Córdoba", "Buenos Aires", "Santa Fe", "Avellaneda", "La Plata", "Córdoba", 
			"Buenos Aires", "Buenos Aires", "Lanús", "Córdoba", "Buenos Aires", "Junín"};

	public Equipo(String nombre, String ciudad, String imagen) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.imagen = imagen;
		this.jugadores = new LinkedList<Jugador>();
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
			actualizarRatingEquipo();
		}
	}

	public void agregarJugadorManualmente() {
		int numero;
		do {
			String mensaje = (mostrarNumeros()=="") ? "Todavia no hay jugadores" : "\nYa están ocupado los numeros " + mostrarNumeros();
			numero=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingerese numero de camiseta. "
					+ mensaje));
			if (numeroOcupado(numero)) {
				JOptionPane.showMessageDialog(null,"¡Este numero de camiseta ya está ocupado!", "¡Error!",2);
			}
		} while (numeroOcupado(numero));
		Jugador jugador = Jugador.crearManualmente(numero);
		jugadores.add(jugador);
		actualizarRatingEquipo();
	}

	public void eliminarJugadorManualmente() {
		String[] options=toArrayString(); 
		String elegido =(String)JOptionPane.showInputDialog(null, "Elige un jugador para eliminar", 
				null, 1, null, options, options[0]);
		//String[] elegidoSplit = elegido.split(". ");
		int numero = Integer.parseInt(elegido.split(". ")[0]);
		eliminarJugador(numero);
		actualizarRatingEquipo();
	}
	
	
	public static Equipo crearRandom() {
		int numeroNombre = (int)(Math.random()*(nombres.length));
		int numeroCiudad = (int)(Math.random()*(ciudades.length));
		int numeroImagen = (int)(Math.random()*(imagenes.length));
		Equipo equipo = new Equipo(nombres[numeroNombre], ciudades[numeroCiudad], imagenes[numeroImagen]);
		int numeroJugadores = (int)(Math.random()*10+11);
		for (int i=0; i<numeroJugadores; i++) {
			equipo.agregarJugador(Jugador.crearRandom(i+1));
		}
		return equipo;
    }

	public static Equipo crearRegular(int numero) {
		Equipo equipo = new Equipo(nombres[numero], ciudades[numero], imagenes[numero]);
		int numeroJugadores = (int)(Math.random()*10+11);
		for (int i=0; i<numeroJugadores; i++) {
			equipo.agregarJugador(Jugador.crearRandom(i+1));
		}
		return equipo;
    }
	
	
	public static Equipo crearManualmante() {
		String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de equipo ");
		String ciudad = JOptionPane.showInputDialog(null, "Ingrese la ciudad de equipo ");
		return new Equipo(nombre,ciudad, imagenes[0]);
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
	    	if (JOptionPane.showConfirmDialog(null, "Eliminar jugador " + jugador + "?")==0) {
	    		jugadores.remove(jugador);
	    		actualizarRatingEquipo();
	    	}
	    	
	    }
	}
    
	public int getRating() {
		return calcularPromedioRating();
	}
	
	public int calcularPromedioRating() {
        double totalRating = 0;
        for (Jugador jugador : jugadores) {
            totalRating += jugador.getRating();
        }
        return jugadores.isEmpty() ? 0 : (int)(totalRating / jugadores.size());
    }
    
    private void actualizarRatingEquipo() {
       // rating=calcularPromedioRating();
    }
	
}
