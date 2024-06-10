package futbol;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Liga {
	private String nombre;
	private LinkedList<Equipo> equipos;
	private LinkedList<Partido> partidos;
	private LinkedList<String> resultados;

	public Liga(String nombre) {
		this.nombre = nombre;
		equipos = new LinkedList<Equipo>();
		partidos = new LinkedList<Partido>();
		resultados = new LinkedList<String>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarEquipo(Equipo equipo) {
		equipos.add(equipo);
	}
	
	public void agregarResultado(String resultado) {
		resultados.add(resultado);
	}

	public void agregarPartido(Partido partido) {
		partidos.add(partido);
	}
	
	public int getNumeroEquipos() {
		return equipos.size();
	}

	@Override
	public String toString() {
		return "Liga \"" + nombre + "\" tiene " + getNumeroEquipos() + " equipos";
	}

	public String mostrarEquipos() {
		String result = toString() +":\n\n";
  	    for(Equipo equipo:equipos) {
			result+= equipo.mostrarBasic() +"\n\n";
		}
		return result;
    }
	
	public String mostrarTodo() {
		String result = toString() +":\n\n";
  	    for(Equipo equipo:equipos) {
			result+= equipo.mostrarTodo() +"\n";
		}
		return result;
    }
	
	public static Liga crearRandom(String nombre, int cantidadEquipos) {
		Liga liga = new Liga(nombre);
		int i=0; 
		while (i<cantidadEquipos){
			Equipo equipo=Equipo.crearRandom();
			if (!liga.tieneEquipo(equipo)) {
				liga.agregarEquipo(equipo);
				i++;
			}
		}
		return liga;
    }
	
	public String[] toArrayString() {
		if (equipos.isEmpty()) {
			return null; 
		} 
		String[] result = new String[equipos.size()];
  	    for(int i=0; i<equipos.size(); i++) {
			result[i]=equipos.get(i).getNombre();
  	    }
	    return result;
    }
	
	public Equipo encontrarEquipo(String nombre) {
		for(Equipo equipo:equipos) {
			if (equipo.getNombre().equals(nombre)) {
				return equipo;
			}
	    }
		return null;
	}

	public void agregarEquipoManualmente() {
		Equipo equipo = Equipo.crearManualmante();
		while (tieneEquipo(equipo.getNombre())) {
			equipo.setNombre(JOptionPane.showInputDialog(null, "Liga " + getNombre() 
			+ " ya tiene equipo " + equipo.getNombre()+".\nIngrese otro nombre."));
		}
		boolean unaMas;
		do {
			equipo.agregarJugadorManualmente();
			unaMas = (JOptionPane.showConfirmDialog(null, "¿Querés agregar un hugador más?") == 0);
		} while (unaMas);
		JOptionPane.showMessageDialog(null, equipo.mostrarTodo());
		agregarEquipo(equipo);		
	}
	
	
	public void eliminarEquipo(String nombre) {
		Equipo equipo = encontrarEquipo(nombre);
		if (equipo == null) {
			JOptionPane.showMessageDialog(null, "No hay equipo " + nombre + " en liga " + getNombre() );
		} else {
			if (JOptionPane.showConfirmDialog(null, "Eliminar equipo " + nombre + "?")==0) {
	    		equipos.remove(equipo);
			}
	    }
	}
	
	public boolean tieneEquipo(String nombre) {
		return !(encontrarEquipo(nombre)==null);
	}
	
	public boolean tieneEquipo(Equipo equipo) {
		return !(encontrarEquipo(equipo.getNombre())==null);
	}

//	public void jugarPartido(Equipo primero, Equipo segundo) {
//		String resultado;
//		int gol1=(int)(Math.random()*5);
//		int gol2=(int)(Math.random()*5);
//		String puntuacion = primero.getNombre()+" " + gol1 + " - " + gol2 + " "+ segundo.getNombre();
//		if (gol1 == gol2) {
//			resultado = puntuacion + "\n¡Empate!";
//		} else if (gol1 > gol2) {
//			resultado=puntuacion + "\n¡Ganó " + primero.getNombre() + "!";
//		} else {
//			resultado=puntuacion + "\n¡Ganó " + segundo.getNombre() + "!";
//		}
//		JOptionPane.showMessageDialog(null, resultado);
//		agregarResultado(resultado);	
//	}
	
	public String mostrarResultados() {
		String informe = "Resultados de los partidos en la Liga "+ getNombre() + ": \n\n";
  	    for(String resultado:resultados) {
			informe+= resultado +"\n\n";
		}
		return informe;
    }

}
