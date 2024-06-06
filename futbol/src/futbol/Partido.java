package futbol;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Partido {
	int tipo;
	private Equipo equipo1;
	private Equipo equipo2;
	private int gol1;
	private int gol2;
	private String fase;
	private LocalDate fecha;
	//private static String[] fases= {"Cuartos de final","semifinal", "final"};
	public static int partidoRegular=1;
	public static int partidoEliminatoria=2;

	public Partido(Equipo equipo1, Equipo equipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public int getGol1() {
		return gol1;
	}

	public void setGol1(int gol1) {
		this.gol1 = gol1;
	}

	public int getGol2() {
		return gol2;
	}

	public void setGol2(int gol2) {
		this.gol2 = gol2;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String mostrarResultado() {
		String resultado;
		int gol1=(int)(Math.random()*5);
		int gol2=(int)(Math.random()*5);
		String puntuacion = equipo1.getNombre()+" " + gol1 + " - " + gol2 + " "+ equipo2.getNombre();
		if (gol1 == gol2) {
			resultado = puntuacion + "\n¡Empate!";
		} else if (gol1 > gol2) {
			resultado=puntuacion + "\n¡Ganó " + equipo1.getNombre() + "!";
		} else {
			resultado=puntuacion + "\n¡Ganó " + equipo2.getNombre() + "!";
		}
		JOptionPane.showMessageDialog(null, resultado);
		return resultado;
	}
	
	
}
