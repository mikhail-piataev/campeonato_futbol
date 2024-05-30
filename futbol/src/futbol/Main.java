package futbol;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		Liga liga = Liga.crearRandom("Agrentina jóvenes", 6);
		JOptionPane.showMessageDialog(null, liga.mostrarEquipos());
		String[] options=liga.toArrayString(); 
		String elegido =(String)JOptionPane.showInputDialog(null, "Elige un equipo para eliminar", null, 1, null, options, options[0]);
		JOptionPane.showMessageDialog(null, "Elegido " + elegido);
		
	}

}
