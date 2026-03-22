package biblioteca;

import java.util.Objects;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int ejemplaresDisponibles;

    public Libro(String isbn, String titulo, String autor, int ejemplaresDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro that = (Libro) o;
        return Objects.equals(isbn, that.isbn);
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn +
                "| Titulo: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Ejemplares disponibles: " + ejemplaresDisponibles;
    }

    /**
     * Metodo que comprueba si hay libros disponibles
     * @return false/true si hay mas de 0 libros disponibles o no
     */
    boolean estaDisponible() {
        boolean disponible = false;
        if (this.ejemplaresDisponibles > 0) {
            disponible = true;
        }
        return disponible;
    }
}
