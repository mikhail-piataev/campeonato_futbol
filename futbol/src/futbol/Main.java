package futbol;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		//Persona chico = Persona.crearRandom();
//		Equipo equipo = Equipo.crearRandom();
		//JOptionPane.showMessageDialog(null, chico + " tiene "+ chico.getEdad() + " años.") ;
		//JOptionPane.showMessageDialog(null, equipo.mostrarTodo());
//		String[] options=equipo.toArrayString(); 
//		String elegido =(String)JOptionPane.showInputDialog(null, "Elige un jugador para eliminar", null, 1, null, options, options[0]);
//		String[] elegidoSplit=elegido.split(". ");
//		int numero = Integer.parseInt(elegido.split(". ")[0]);
//		JOptionPane.showMessageDialog(null, "Elegido numero " + numero);
		//equipo.eliminarJugador(numero);
		//equipo.agregarManualmente();
//		JOptionPane.showMessageDialog(null, equipo.mostrarTodo());
//		JOptionPane.showMessageDialog(null, liga.mostrarEquipos());
//		String[] options=liga.toArrayString(); 
//		String elegido =(String)JOptionPane.showInputDialog(null, "Elige un equipo para eliminar", null, 1, null, options, options[0]);
		//JOptionPane.showMessageDialog(null, "Elegido " + elegido);
		String[] mainMenu = {"Jugar partido", "Agregar equipo", "Eliminar equipo", "Agregar jugador", 
				"Eliminar jugador", "Salir"};
		Liga liga = Liga.crearRandom("Agrentina jóvenes", 6);
		boolean salir = false;
		do {
			int acion=JOptionPane.showOptionDialog(null, "Por favor, elige una opción", "Bienvenida a liga \"" 
					+ liga.getNombre()+"\"", 0, JOptionPane.QUESTION_MESSAGE, null, mainMenu, mainMenu[0]);
			String[] nombresEquipos=liga.toArrayString();	
			String eligido;
			switch (acion) {
			case 0:
				String primero = (String)JOptionPane.showInputDialog(null, "Elige el primer equipo",
						"Equipos para jugar un partido", 1, null, nombresEquipos, nombresEquipos[0]);
				nombresEquipos=eliminarDeArray(nombresEquipos, primero);
				String segundo = (String)JOptionPane.showInputDialog(null, "Elige el segundo equipo", 
						"Un equipo rival para " + primero, 1, null, nombresEquipos, nombresEquipos[0]);
				liga.jugarPartido(liga.encontrarEquipo(primero),liga.encontrarEquipo(segundo));
				break;
			case 1:
				JOptionPane.showMessageDialog(null, liga.mostrarEquipos() + "\nVamos agregar una más.");
				liga.agregarEquipoManualmente();
				JOptionPane.showMessageDialog(null, liga.mostrarEquipos());
				break;
			case 2:
				eligido =(String)JOptionPane.showInputDialog(null, liga.mostrarEquipos() 
						+ "Elige el un equipo para eliminar", "Equipo para eliminar", 1, null, nombresEquipos, nombresEquipos[0]);
				liga.eliminarEquipo(eligido);
				JOptionPane.showMessageDialog(null, liga.mostrarEquipos());
				break;
			case 3:
				eligido = (String)JOptionPane.showInputDialog(null, liga.mostrarEquipos()
						+ "Elige un equipo para agregar un jugador",
						"Equipo para agregar un jugador", 1, null, nombresEquipos, nombresEquipos[0]);
                liga.encontrarEquipo(eligido).agregarJugadorManualmente();
                JOptionPane.showMessageDialog(null, liga.encontrarEquipo(eligido).mostrarJugadores());
				break;
			case 4:
				eligido = (String)JOptionPane.showInputDialog(null, liga.mostrarEquipos()
						+ "Elige un equipo para eliminar un jugador ",
						"Equipo para eliminar un jugador", 1, null, nombresEquipos, nombresEquipos[0]);
                liga.encontrarEquipo(eligido).eliminarJugadorManualmente();
                JOptionPane.showMessageDialog(null, liga.encontrarEquipo(eligido).mostrarJugadores());
				break;
			case 5:
				salir = true;
				break;
			}	
		} while (! salir);
	}
	
	public static String[] eliminarDeArray(String[] todos, String excesivo) {
		if (todos.length<2) {
			return null;
		}
		String[] sinExcesivo = new String[todos.length-1];
		int salto=0;
		for (int i=0; i<sinExcesivo.length; i++) {
			if (todos[i].equals(excesivo)) {
				salto=1;
			}
			sinExcesivo[i]=todos[i+salto];
		}
		return sinExcesivo;
	}
}
