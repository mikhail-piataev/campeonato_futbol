package futbol;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Liga {
	private String nombre;
	private LinkedList<Equipo> equipos;
	private LinkedList<Partido> partidos;

	public Liga(String nombre) {
		this.nombre = nombre;
		equipos = new LinkedList<Equipo>();
		partidos = new LinkedList<Partido>();
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
	

	public void agregarPartido(Partido partido) {
		partidos.add(partido);
	}
	
	public int getNumeroEquipos() {
		return equipos.size();
	}

	public int getNumeroPartidos() {
		return partidos.size();
	}
	
	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
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
			JOptionPane.showMessageDialog(null, "No hay equipo " + nombre + " en la liga " + getNombre() );
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
	
	public String mostrarResultados() {
		String informe = "Resultados de los partidos en la liga \""+ getNombre() + "\": \n\n";
  	    for(Partido partido:partidos) {
			informe += partido.mostrarResultado() + "\n\n";
		}
		return informe;
    }

}
