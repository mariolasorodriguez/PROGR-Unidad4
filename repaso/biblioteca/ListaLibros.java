package biblioteca;

import java.util.ArrayList;

public class ListaLibros {

    private ArrayList<Libro> libros;

    public ListaLibros() {
        this.libros = new ArrayList<>();
    }

    boolean añadirLibro(Libro libro) {
        boolean añadido = false;
        if (!libros.contains(libro)) {
            this.libros.add(libro);
            añadido = true;
        }
        return añadido;
    }

    Libro buscarLibro(String isbn) {
        Libro encontrado =  null;
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                for (Libro libros : libros) {
                    System.out.println(libro);
                    System.out.println("------------------");
                }
            }
        }
        return encontrado;
    }

    void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
                System.out.println("----------");
            }
        }
    }

    void listarDisponibles() {
        for (Libro libro : libros) {
            if (libro.estaDisponible()) {
                System.out.println(libro);
                System.out.println("----------");
            }
        }
    }

    boolean modificarEjemplares(Libro libro, String isbn, int ejemplares) {
        boolean modificado = false;
        Libro libro = buscarLibro(libro.getIsbn());
    }






}
