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
	
	public Equipo jugar() {
		Equipo ganador=null;
		gol1=(int)(Math.random()*3);
		gol2=(int)(Math.random()*3);
		JOptionPane.showMessageDialog(null, "Primer periodo se termino con resultado\n"
		+mostrarPuntuacion());
		gol1+=(int)(Math.random()*3);
		gol2+=(int)(Math.random()*3);
		JOptionPane.showMessageDialog(null, "Segundo periodo se termino con resultado\n"
		+mostrarPuntuacion());
		
		if (tipo==partidoEliminatoria && gol1==gol2) {
			JOptionPane.showMessageDialog(null, "Va a jugar dos periodos extras");
			gol1+=(int)(Math.random()*2);
			gol2+=(int)(Math.random()*2);
			JOptionPane.showMessageDialog(null, "Primer periodo extra se termino con resultado\n"
			+mostrarPuntuacion());
			gol1+=(int)(Math.random()*2);
			gol2+=(int)(Math.random()*2);
			JOptionPane.showMessageDialog(null, "Segundo periodo extra se termino con resultado\n"
			+mostrarPuntuacion());
		}
		
		if (tipo==partidoEliminatoria && gol1==gol2) {
			JOptionPane.showMessageDialog(null, "Va a hacer penales");
			gol1+=(int)(Math.random()*6);
			gol2+=(int)(Math.random()*6);
			JOptionPane.showMessageDialog(null, "Penales se termino con resultado\n"
			+mostrarPuntuacion());			
		}
		if (tipo==partidoEliminatoria && gol1==gol2) {
			JOptionPane.showMessageDialog(null, "Va a jugar gol de oro");
			gol1+=(int)(Math.random()*6);
			gol2+=(int)(Math.random()*6);
			JOptionPane.showMessageDialog(null, "Penales se termino con resultado\n"
			+mostrarPuntuacion());			
		}
		if (gol1 > gol2) {
			ganador=equipo1;
		} else if (gol1 < gol2){
			ganador=equipo2;;
		}
		return ganador;
	}

	public String mostrarPuntuacion() {
		return  equipo1.getNombre()+" " + gol1 + " - " + gol2 + " "+ equipo2.getNombre();
	}
	
	public String mostrarResultado() {
		String resultado;
		String puntuacion = mostrarPuntuacion();
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
