package ejercicioc2;

public class Persona {
	
	public Persona(String dni, String nombre, String apellidos, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	// Declaramos las variables
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	
	
	// Verificamos si es mayor de edad
    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    // Metodos get y set
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
