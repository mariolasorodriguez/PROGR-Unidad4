package ejercicioa2;

import java.util.Scanner;

public class PrincipalPersona {
	public static void main(String[] args) {
		
		// Creamos el scanner
		Scanner reader = new Scanner(System.in);
		
		Persona p1 = new Persona();
		
		Persona p2 = new Persona();
		
		// Leemos los datos de la persona 1
		System.out.println("Introduce los datos de la PERSONA 1: ");
		
		System.out.println("Nombre: ");
		p1.nombre = reader.next();
		
		System.out.println("Apellidos: ");
		p1.apellidos = reader.next();
		
		System.out.println("DNI: ");
		p1.dni = reader.nextInt();
		
		System.out.println("Edad: ");
		p1.edad = reader.nextInt();
		
		// Leemos los datos de la persona 2
		System.out.println("Introduce los datos de la PERSONA 2: ");
		
		System.out.println("Nombre: ");
		p2.nombre = reader.next();
		
		System.out.println("Apellidos: ");
		p2.apellidos = reader.next();
		
		System.out.println("DNI: ");
		p2.dni = reader.nextInt();
		
		System.out.println("Edad: ");
		p2.edad = reader.nextInt();
		
		
	}
}
