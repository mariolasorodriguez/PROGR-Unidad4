package ejercicioa2;

public class Persona {
	int dni;
	String nombre;
	String apellidos;
	int edad;
	
	// Verificamos si es mayor de edad
    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }
}
