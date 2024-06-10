package futbol;

import java.util.LinkedList;

public class Nivel {
	int nivel, actualPartido;
	private LinkedList<Equipo> equipos;
	private LinkedList<Partido> partidos;
	
	public void formarPartidos() {
       int cantidadPartidos=getCantidadPartidos(nivel);
       for (int i=0; i<cantidadPartidos; i++) {
    	   Partido partido = new Partido(equipos.get(2*i), equipos.get(2*i+1));
    	   partidos.add(partido);
       }						
	}
	
	public Equipo jugarSeguinte() {
		
	}
	
	
	public static int getCantidadPartidos(int nivel) {
		return (int)Math.pow(2, nivel-1);
	}


}
