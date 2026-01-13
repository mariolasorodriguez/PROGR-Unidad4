package ejerciciob2;

import java.util.Scanner;

public class PrincipalPersona {
	public static void main(String[] args) {
		
		// Creamos el scanner
		Scanner reader = new Scanner(System.in);
		
		Persona p1 = new Persona();
		
		Persona p2 = new Persona();
		
		// Leemos los datos de la persona 1
		System.out.println("Introduce los datos de la PERSONA 1: ");
		
		System.out.print("Nombre: ");
		p1.nombre = reader.next();
		
		System.out.print("Apellidos: ");
		p1.apellidos = reader.next();
		
		System.out.print("DNI: ");
		p1.dni = reader.nextInt();
		
		System.out.print("Edad: ");
		p1.edad = reader.nextInt();
		
		// Leemos los datos de la persona 2
		System.out.println("Introduce los datos de la PERSONA 2: ");
		
		System.out.print("Nombre: ");
		p2.nombre = reader.next();
		
		System.out.print("Apellidos: ");
		p2.apellidos = reader.next();
		
		System.out.print("DNI: ");
		p2.dni = reader.nextInt();
		
		System.out.print("Edad: ");
		p2.edad = reader.nextInt();
		
		// Llamamos a la funcion para ver las personas introducidas
		System.out.println("Comprueba los datos introducidos: ");
		imprimirPersonas(p1);
		imprimirPersonas(p2);
	}
	
	// Función para imprimir las personas
	public static void imprimirPersonas(Persona p) {
		String mayoria = p.esMayorDeEdad() ? "es mayor de edad" : "no es mayor de edad";
		System.out.println(p.nombre + " " + p.apellidos + " con DNI " + p.dni + " " + mayoria);
	}
}
