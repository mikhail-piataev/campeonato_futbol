package futbol;

import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Campeonate {
	private int actual;
	private String nombre;
	private LocalDate inicio; 
	private Equipo equipo1;
	private LinkedList<Equipo> equipos; 
	boolean esVisible;
	private Partido elFinal;
	private Partido[] semifinales = new Partido[2];
	private Partido[] cuartosDeFinal = new Partido[4];
	
	public Campeonate(String nombre, LocalDate inicio, LinkedList<Equipo> equipos) {
		this.nombre = nombre;
		this.inicio = inicio;
		this.equipos = equipos;
		esVisible = true;
		actual=1;
	}
	
	public int getActual() {
		return actual;
	}

	public void setActual(int actual) {
		this.actual = actual;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public boolean isEsVisible() {
		return esVisible;
	}

	public void setEsVisible(boolean esVisible) {
		this.esVisible = esVisible;
	}

	public Partido getElFinal() {
		return elFinal;
	}

	public void setElFinal(Partido elFinal) {
		this.elFinal = elFinal;
	}

	public Partido[] getSemifinales() {
		return semifinales;
	}

	public void setSemifinales(Partido[] semifinales) {
		this.semifinales = semifinales;
	}

	public Partido[] getCuartosDeFinal() {
		return cuartosDeFinal;
	}

	public void setCuartosDeFinal(Partido[] cuartosDeFinal) {
		this.cuartosDeFinal = cuartosDeFinal;
	}

	private static int[] getOchoNumeros(int total) {
		int[] numeros = new int[8];
		boolean yaEsta;
		int alAzar;
		for (int i=0; i<8; i++) {
			do {
				yaEsta=false;
				alAzar = (int)(Math.random()*total);
				for (int j=0; j<i; j++) {
					if (numeros[j] == alAzar) {
						yaEsta = true;
					}
				}
			} while (yaEsta);
			numeros[i]=alAzar;
		}
		return numeros;
	}
	
	public void ordenarAlAzar() {
		if (equipos.size() < 8) {
			JOptionPane.showMessageDialog(null, "Faltan equipos. No es posible organizar el campeonato");
		} else {
			int[] numeros = getOchoNumeros(equipos.size());
			for (int i=0; i<4; i++) {
				cuartosDeFinal[i] = new Partido(equipos.get(numeros[2*i]), equipos.get(numeros[2*i+1]), inicio.plusDays(i), 
						Partido.ELIMINATORIO, "Cuarto de Final " + (i+1));  
			}
		}
	}
	
	public void jugarSeguinte() {
		if (actual <= 4) {
			cuartosDeFinal[actual-1].jugar(esVisible);
			Equipo ganador = cuartosDeFinal[actual-1].getGanador();
			if (actual % 2 != 0) {
				equipo1 = ganador;
			} else {
				semifinales[actual/2 - 1] = new Partido(equipo1, ganador, inicio.plusDays(actual/2 + 3), 
						Partido.ELIMINATORIO, "Semifinal " + (actual/2)); 
			}
		} else if (actual <= 6) {
			semifinales[actual-5].jugar(esVisible);
			Equipo ganador = cuartosDeFinal[actual-5].getGanador();
			if (actual % 2 != 0) {
				equipo1 = ganador;
			} else {
				elFinal = new Partido(equipo1, ganador, inicio.plusDays(6), Partido.ELIMINATORIO, "Final"); 
			}
		} else {
			elFinal.jugar(esVisible);
		}
		actual++;
	}

	public String mostrarEquiposCuartosDeFinal () {
		String resultado = "";
		for (int i=0; i<4; i++) {
			resultado+=cuartosDeFinal[i].mostrarFaseFechaYEquipos() + "\n";
		}
		return resultado;
	}
	
	public String mostrarResultadosCuartosDeFinal () {
		String resultado = "";
		for (int i=0; i<4; i++) {
			resultado+=cuartosDeFinal[i].mostrarResultado() + "\n\n";
		}
		return resultado;
	}	
}
