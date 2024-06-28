package futbol;

import java.util.LinkedList;

public class Sportbook {
	private LinkedList<Apuesta> apuestas;
	private String nombre;
	
	public Sportbook(String nombre) {
		this.nombre = nombre;
		apuestas = new LinkedList<Apuesta>();
	}
	
	public LinkedList<Apuesta> getApuestas() {
		return apuestas;
	}
	public void setApuestas(LinkedList<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarApuesta(Apuesta apuesta) {
		apuestas.add(apuesta);
	}
	
	public String mostrarInforme() {
		String informe = ""; 
		if ( apuestas==null || apuestas.size() ==0 ) {
			informe += "No apostaste en esta session.";
		} else {
			informe += "Tus apuestas en esta session:\n\n";
			double total=0;
			for (Apuesta apuesta:apuestas) {
				informe+=apuesta.mostrarInforme()+"\n\n";
				total +=apuesta.getMontoGanado();
			}
			if (total>=0) {
				informe += "En total ganaste $"+String.format("%.0f", total);
			} else {
				informe += "En total perdiste $"+String.format("%.0f", -total);
			}
		}
		return informe;
	}
	

}
