package ejercicio1;

	public class Alumno {
	    private String nombre;
	    private double nota;

	    public Alumno(String nombre, double nota) {
	        this.nombre = nombre;
	        this.nota = nota;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNota(double nota) {
	        this.nota = nota;
	    }

	    public String toString() {
	        return "Nombre: " + this.nombre + " | Nota: " + this.nota;
	    }
	}

