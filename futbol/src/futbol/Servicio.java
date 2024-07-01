package futbol;

import javax.swing.JOptionPane;

public class Servicio {
	
	public static int solisitarInt(String mensaje) {
		boolean error;
		int value=0;
		do {
			error=false;
		try {
			value = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No es numero entero. Por favor, ingrese un numero entero.", null, 0);
			error=true; 
		}
		} while (error);
		return value;
	}

}
