package ejerciciob2;

public class PrincipalPersona {
	public static void main(String[] args) {
				
		Persona p1 = new Persona("89765467B", "Mario", "Laso", 21);
		
		Persona p2 = new Persona("98765678A", "Marco", "Perez", 17);
		
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
