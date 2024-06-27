package futbol;

import javax.swing.JOptionPane;

public class Apuesta {
	private double montoApostado;
	private double montoGanado;
	private Partido partido;
	private int numeroEquipo;
	
	public Apuesta(Partido partido) {
		this.partido = partido;
		this.montoApostado = 0;
		this.montoGanado = 0;		
		numeroEquipo = 0;
	}
	
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	public double getRatio1() {
		double r1 = partido.getEquipo1().getRating();
		double r2 = partido.getEquipo2().getRating();
		return 2*r2/(r1+r2);
	}   

	public double getRatio2() {
		double r1 = partido.getEquipo1().getRating();
		double r2 = partido.getEquipo2().getRating();
		return 2*r1/(r1+r2);
	}   


	public void solicitarMonto() {
		montoApostado = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad de pesos para auesta"));
	}
	
	public void apostar() {
		String[] opciones = {partido.getEquipo1().getNombre(), partido.getEquipo2().getNombre(), "Saltar"};
		String aviso = partido.mostrarFaseFechaYEquipos();
		aviso += "\n\nSi gana " + partido.getEquipo1().getNombre() + " recibirás " +String.format("%.0f", 100*getRatio1())+ "% de tu apuesta.";
		aviso += "\nSi gana " + partido.getEquipo2().getNombre() + " recibirás " +String.format("%.0f", 100*getRatio2())+ "% de tu apuesta.";
		aviso +="\n\nSi querés hacer apusta, elegí un equipo";
		int opcionElegido=JOptionPane.showOptionDialog(null, aviso, "Apuestas",	0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcionElegido == 2) {
			numeroEquipo=0; 
		} else {
			numeroEquipo = opcionElegido+1;
			solicitarMonto();
		}
		
	}

	
	public void verificar() {
		if (numeroEquipo != 0) {
			if (numeroEquipo == 1 && partido.getGanador() == partido.getEquipo1()) {
				montoGanado = montoApostado*getRatio1();
				JOptionPane.showMessageDialog(null, "Ganaste $" + String.format("%.0f", montoGanado));
			} else if (numeroEquipo == 2 && partido.getGanador() == partido.getEquipo2()) {
				montoGanado = montoApostado*getRatio1();
				JOptionPane.showMessageDialog(null, "Ganaste $" + String.format("%.0f", montoGanado));
			} else {
				montoGanado = - montoApostado;
				JOptionPane.showMessageDialog(null, "Perdiste $" + String.format("%.0f", -montoGanado));
			}
			
		}
	}
}
