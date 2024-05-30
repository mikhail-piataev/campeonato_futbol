package futbol;

import java.time.LocalDate;
import java.time.Period;

import javax.swing.JOptionPane;

public class Persona {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	private static String[] apellidos= {"García", "Martínez", "López", "Rodríguez", "González", "Fernández", 
			"Pérez", "Sánchez", "Gómez", "Martín", "Díaz", "Hernández", "Álvarez", "Muñoz", "Romero", 
			"Jiménez", "Ruiz", "Moreno", "Navarro", "Alonso", "Torres", "Domínguez", "Vázquez", 
			"Ramos", "Gil", "Ramírez", "Serrano", "Blanco", "Molina", "Delgado"};
	private static String[] nombres = {"Alejandro", "Antonio", "José", "Francisco", "Javier", 
			"Miguel", "Juan", "Carlos", "David", "Manuel", "Fernando", "Luis", "Pedro", 
			"Ángel", "Daniel", "Rafael", "Alberto", "Jesús", "Sergio", "Jorge", "Ramón", 
			"Adrián", "Ignacio", "Rubén", "Diego", "Ricardo", "Mario", "Pablo", "Víctor", "Enrique"};
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		Period vida = Period.between(fechaNacimiento, LocalDate.now());
		return vida.getYears();
	}
	
    @Override
	public String toString() {
		return  nombre + " " + apellido +" ("+ getEdad() +" años)";
	}

	public static Persona crearRandom() {
    	int numeroApellido=(int)(Math.random()*apellidos.length);
    	int numeroNombre=(int)(Math.random()*nombres.length);
    	int actualEdad=(int)(Math.random()*3)+14;
    	LocalDate fecha = LocalDate.now().minusYears(actualEdad).minusDays((int)(Math.random()*365));
    	return new Persona(nombres[numeroNombre], apellidos[numeroApellido], fecha);
    }
	
	public static Persona crearManualmente() {
    	String nombre=JOptionPane.showInputDialog(null, "Ingrese el nombre");
    	String apellido=JOptionPane.showInputDialog(null, "Ingrese el apellido");
    	int ano =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de nacimiento "));
    	int mes =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de nacimiento "));
    	int dia =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia de nacimiento "));
    	LocalDate fecha = LocalDate.of(ano, mes, dia);
    	return new Persona(nombre, apellido, fecha);
	}
}
