package futbol;

import javax.swing.JOptionPane;

public class Apuesta {
	private double montoApostado;
	private Partido partido;
	private int numeroEquipo;
	
	public Apuesta(Partido partido) {
		this.partido = partido;
		this.montoApostado = 0;
		numeroEquipo = -1;
	}
	
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	public double getProbabilidadGano1() {
		double r1 = partido.getEquipo1().getRating();
		double r2 = partido.getEquipo2().getRating();
		return r1/(r1+r2)*(1-getProbabilidadEmpate());
	}   

	public double getProbabilidadGano2() {
		double r1 = partido.getEquipo1().getRating();
		double r2 = partido.getEquipo2().getRating();
		return r2/(r1+r2)*(1-getProbabilidadEmpate());
	}   

		public double getProbabilidadEmpate() {
		if (partido.getTipo() == Partido.ELIMINATORIO) {
			return 0;
		}
		return 0.25; // No es verdad, pero la verdad es muy complejo.
	}   

	public void solicitarMonto() {
		boolean error;
		do {
			error=false;
		try {
			montoApostado = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad de pesos para auesta"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No es numero. Por favor, ingrese un numero.", null, 0);
			error=true; 
		}
		} while (error); 
	}
	
	public void apostar() {
		String aviso = partido.mostrarFaseFechaYEquipos();
		aviso += "\n\nSi apostás al " + partido.getEquipo1().getNombre() + " y ganás recibirás " 
				+ String.format("%.0f", 100*(1/getProbabilidadGano1()-1)) + "% de tu apuesta.";
		aviso += "\n\nSi apostás al  " + partido.getEquipo2().getNombre() + " y ganás recibirás "
				+ String.format("%.0f", 100*(1/getProbabilidadGano2()-1)) + "% de tu apuesta.";
		if (partido.getTipo() == Partido.REGULAR) {
			aviso += "\n\nSi apostás al empate y ganás recibirás "
					+ String.format("%.0f", 100*(1/getProbabilidadEmpate()-1)) + "% de tu apuesta.";
		}
		aviso +="\n\nElegí una opcion\n";
		if (partido.getTipo() == Partido.ELIMINATORIO) {
			String[] opciones = {partido.getEquipo1().getNombre(), partido.getEquipo2().getNombre(), "Saltar"};
			int opcionElegido=JOptionPane.showOptionDialog(null, aviso, "Apuestas",	0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			if (opcionElegido == 2) {
				numeroEquipo=-1; 
			} else {
				numeroEquipo = opcionElegido+1;
				solicitarMonto();
			}
		} else {
			String[] opciones = {partido.getEquipo1().getNombre(), partido.getEquipo2().getNombre(), "Empate", "Saltar"};
			int opcionElegido=JOptionPane.showOptionDialog(null, aviso, "Apuestas",	0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			if (opcionElegido == 3) {
				numeroEquipo=-1; 
			} else if (opcionElegido == 2){
				numeroEquipo = 0;
				solicitarMonto();
			} else {
				numeroEquipo = opcionElegido+1;
				solicitarMonto();
			}
		}
	}
	
	public void verificar() {
		if (numeroEquipo >= 0) {
			JOptionPane.showMessageDialog(null, mostrarInforme(), "Informe de apuestas", 1);
		}
	}

	public double getMontoGanado() {
		double montoGanado=0;
	    if (numeroEquipo >= 0) {
			if (numeroEquipo == 1 && partido.getGanador() == partido.getEquipo1()) {
				montoGanado = montoApostado*(1/getProbabilidadGano1()-1);
			} else if (numeroEquipo == 2 && partido.getGanador() == partido.getEquipo2()) {
				montoGanado = montoApostado*(1/getProbabilidadGano2()-1);
			} else if (numeroEquipo == 0 && partido.getGanador() == null){
				montoGanado = montoApostado*(1/getProbabilidadEmpate()-1);
			} else {
				montoGanado = - montoApostado;
			}
		}
		return montoGanado;
	}
	
	public Equipo getEquipoApuesta() {
		Equipo equipoApuesta = null; 
		if (numeroEquipo == 1) {
			equipoApuesta = partido.getEquipo1();
		} else if (numeroEquipo == 2) {
			equipoApuesta = partido.getEquipo2();
		}
		return equipoApuesta;
	}
	
	public String mostrarInforme() {
		String informe = partido.mostrarFaseFechaYEquipos();
        if (numeroEquipo < 0) {
        	return informe + "\nNo apostaste en este partido.";
        }
		if (partido.getTipo() == Partido.REGULAR && numeroEquipo == 0) {
			informe += "\nApostaste al Empate.";	
		} else {
			informe += "\nApostaste al " + getEquipoApuesta().getNombre()+".";
		}
		if (partido.getTipo() == Partido.REGULAR && partido.getGanador() == null) {
			informe += " El partido acabó en empate.";
		} else {
			informe += " Ganó " + partido.getGanador().getNombre()+".";
		}
		double montoGanado=getMontoGanado();
		if (montoGanado >= 0) {
			informe += " Ganaste $" + String.format("%.0f", montoGanado)+".";
		} else {
			informe += " Perdiste $" + String.format("%.0f", -montoGanado)+".";
		}
		return informe;
	}
}
