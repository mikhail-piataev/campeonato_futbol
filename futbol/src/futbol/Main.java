package futbol;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Persona chico = Persona.crearRandom();
		Equipo equipo = Equipo.crearRandom();
		//JOptionPane.showMessageDialog(null, chico + " tiene "+ chico.getEdad() + " años.") ;
		JOptionPane.showMessageDialog(null, equipo.mostrarTodo());
	}

}
