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
	final public static int REGULAR=1;
	final public static int ELIMINATORIO=2;

	public Partido(Equipo equipo1, Equipo equipo2, LocalDate fecha, int tipo, String fase) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.tipo = tipo;
		this.fecha = fecha;
		this.fase = fase;
	}

	public Partido(Equipo equipo1, Equipo equipo2, LocalDate fecha) {
		this(equipo1, equipo2, fecha, REGULAR, "Partido amistoso");
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
	
	public Equipo getGanador() {
		Equipo ganador=null;
		if (gol1 > gol2) {
			ganador=equipo1;
		} else if (gol1 < gol2){
			ganador=equipo2;;
		}
		return ganador;
	}
	
	private static void exhibir(boolean esVisible, String mensaje) {
		if (esVisible) {
 		  JOptionPane.showMessageDialog(null, mensaje);
		}
	}
	
	public void jugar(boolean esVisible) {
		gol1=(int)(Math.random()*3);
		gol2=(int)(Math.random()*3);
		exhibir(esVisible, "Primer periodo terminó con resultado\n" + mostrarPuntuacion());
		gol1+=(int)(Math.random()*3);
		gol2+=(int)(Math.random()*3);
		exhibir(esVisible, "Segundo periodo terminó con resultado\n" + mostrarPuntuacion());
		if (tipo == ELIMINATORIO && gol1 == gol2) {
			exhibir(esVisible, "Van a jugar dos periodos extras");
			gol1+=(int)(Math.random()*2);
			gol2+=(int)(Math.random()*2);
			exhibir(esVisible, "Primer periodo extra terminó con resultado\n" + mostrarPuntuacion());
			gol1+=(int)(Math.random()*2);
			gol2+=(int)(Math.random()*2);
			exhibir(esVisible, "Segundo periodo extra terminó con resultado\n" + mostrarPuntuacion());
		}
		if (tipo == ELIMINATORIO && gol1 == gol2) {
			exhibir(esVisible, "Habrá penales");
			gol1+=(int)(Math.random()*6);
			gol2+=(int)(Math.random()*6);
			exhibir(esVisible, "Penales terminaron con resultado\n"+mostrarPuntuacion());			
		}
		if (tipo == ELIMINATORIO && gol1 == gol2) {
			exhibir(esVisible, "Va a jugar \"gol de oro\"");
			do {
				gol1+=(int)(Math.random()*2);
				gol2+=(int)(Math.random()*2);
				exhibir(esVisible, "La ronda terminó con un resultado\n"+mostrarPuntuacion());
			} while (gol1==gol2);
		}
	}

	public String mostrarPuntuacion() {
		return equipo1.getNombre()+" " + gol1 + " - " + gol2 + " "+ equipo2.getNombre();
	}

	public String mostrarFaseFechaYEquipos() {
		return fase + ": " + fecha + ": " + equipo1.getNombre() + " - " + equipo2.getNombre();
	}

	public String mostrarResultado() {
		String resultado = fase + " " + fecha + ":\n" + mostrarPuntuacion();
		Equipo ganador = getGanador();
		resultado += ganador  == null ? "\n¡Empate!" : "\n¡Ganó " + ganador.getNombre() + "!";
		return resultado;
	}
	
}
