package ejercicio4;

enum Genero {
	ROCK, POP, JAZZ, BLUES
}

public class Disco {
	private String codigo;
	private String autor;
	private String titulo;
	private double duracion;
	private Genero genero;

	public Disco(String codigo, String autor, String titulo, double duracion, Genero genero) {
		this.codigo = codigo;
		this.autor = autor;
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
	}

	// Getters
	public String getCodigo() {
		return codigo;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public Genero getGenero() {
		return genero;
	}

	// Setters
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Disco otroDisco = (Disco) obj;
		return this.codigo.equals(otroDisco.codigo);
	}

	public String toString() {
		return "COD: [" + codigo + "] " + titulo + " | Autor: " + autor + " | Duración: " + duracion + " min | Género: "
				+ genero;
	}
}
