package biblioteca;

import java.util.ArrayList;

public class ListaPrestamos {

    private ArrayList<Prestamo> prestamos;

    public ListaPrestamos() {
        this.prestamos = new ArrayList<>();
    }

    /**
     * Metodo que registra prestamos
     * @param socio
     * @param libro
     * @param fecha
     * @return
     */
    boolean registrarPrestamo(Socio socio, Libro libro, String fecha) {
        boolean registrado = false;
        if (libro.estaDisponible() && socio.getPrestamosActuales() < Socio.getLimitePrestamos()) {
            prestamos.add(new Prestamo(socio, libro, fecha));
            socio.setPrestamosActuales(socio.getPrestamosActuales() + 1);
            libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() - 1);
            registrado = true;
        }
        return registrado;
    }

    /**
     * Metodo que registra devoluciones de prestamos
     * @param dni
     * @param isbn
     * @param fecha
     * @return
     */
    boolean registrarDevolucion(String dni, String isbn, String fecha) {
        boolean devuelto = false;
        Prestamo encontrado = buscarPrestamo(dni, isbn);

        if (encontrado != null && encontrado.isActivo()) {
            encontrado.setActivo(false);
            encontrado.setFechaDevolucion(fecha);
            encontrado.getLibro().setEjemplaresDisponibles(encontrado.getLibro().getEjemplaresDisponibles() + 1);
            encontrado.getSocio().setPrestamosActuales(encontrado.getSocio().getPrestamosActuales() - 1);
            devuelto = true;
        }
        return devuelto;
    }

    /**
     * Metodo que busca los prestamos
     * @param dni del socio del prestamo
     * @param isbn del libro del prestamo
     * @return el prestamo en concreto
     */
    Prestamo buscarPrestamo(String dni, String isbn) {
        Prestamo encontrado = null;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getSocio().getDni().equalsIgnoreCase(dni) &&
                    prestamo.getLibro().getIsbn().equalsIgnoreCase(isbn)) {
                encontrado = prestamo;
            }
        }
        return encontrado;
    }

    /**
     * Metodo que lista los prestamos
     */
    void listarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos.");
        } else {
            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
                System.out.println("----------------");
            }
        }
    }

    /**
     * Metodo que lista los prestamos activos
     */
    void listarPrestamosActivos() {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isActivo()) {
                System.out.println(prestamo);
                System.out.println("----------------");
            }
        }
    }

}
