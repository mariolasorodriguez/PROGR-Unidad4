package ejerciciob2;

public class Persona {
	String dni;
	String nombre;
	String apellidos;
	int edad;
	
	// Verificamos si es mayor de edad
    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }
}
