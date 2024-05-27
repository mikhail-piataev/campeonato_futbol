package futbol;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Persona chico = Persona.crearRandom();
		Equipo equipo = Equipo.crearRandom();
		//JOptionPane.showMessageDialog(null, chico + " tiene "+ chico.getEdad() + " años.") ;
		JOptionPane.showMessageDialog(null, equipo.mostrarTodo());
		String[] options=equipo.toArrayString(); 
		String elegido =(String)JOptionPane.showInputDialog(null, "Elija un jugador para eliminar", null, 1, null, options, options[0]);
		String[] elegidoSplit=elegido.split(". ");
		int numero = Integer.parseInt(elegido.split(". ")[0]);
		JOptionPane.showMessageDialog(null, "Elegido numero " + numero);
		equipo.eliminarJugador(numero);
		JOptionPane.showMessageDialog(null, equipo.mostrarTodo());
	}

}
