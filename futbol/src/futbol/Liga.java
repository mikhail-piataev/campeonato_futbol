package futbol;

import java.util.LinkedList;

public class Liga {
	private String nombre;
	private LinkedList<Equipo> equipos;

	public Liga(String nombre) {
		this.nombre = nombre;
		equipos = new LinkedList<Equipo>();
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
		for (int i=0; i<cantidadEquipos; i++) {
			liga.agregarEquipo(Equipo.crearRandom());
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
	
	public boolean tieneEquipo(String nombre) {
		return !(encontrarEquipo(nombre)==null);
	}
}
