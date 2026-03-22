package biblioteca;

import java.util.ArrayList;

public class ListaLibros {

    private ArrayList<Libro> libros;

    public ListaLibros() {
        this.libros = new ArrayList<>();
    }

    /**
     *  Metodo que añade libros a la lista
     * @param libro lista de libros
     * @return true/false si se añade o no
     */
    boolean añadirLibro(Libro libro) {
        boolean añadido = false;
        if (!libros.contains(libro)) {
            this.libros.add(libro);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Metodo que busca libros por isbn
     * @param isbn parametro a buscar
     * @return true/false si se encuentra o no
     */
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

    /**
     * Metodo que lista todos los libros de la lista
     */
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

    /**
     * Metodo que modifica ejemplares existentes de libros
     * @param isbn cantidad
     * @param ejemplares cantidad de ejemplares
     * @return true/false si lo modifica o no
     */
    boolean modificarEjemplares(String isbn, int ejemplares) {
        boolean modificado = false;
        Libro encontrado = buscarLibro(isbn);
        if (encontrado != null) {
            encontrado.setEjemplaresDisponibles(ejemplares);
            modificado = true;
        }
        return modificado;
    }

    /**
     * Metodo que elimina libros
     * @param isbn
     * @return true/false si consige eliminarlo o no
     */
    boolean eliminarLibro(String isbn) {
        boolean eliminado = false;
        Libro encontrado = buscarLibro(isbn);
        if (encontrado != null) {
            libros.remove(encontrado);
            eliminado = true;
        }
        return eliminado;
    }








}
