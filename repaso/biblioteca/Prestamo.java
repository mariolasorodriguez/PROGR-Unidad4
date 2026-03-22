package biblioteca;

import java.util.Objects;

public class Prestamo {
    private Socio socio;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean activo;

    public Prestamo(Socio socio, Libro libro, String fechaPrestamo) {
        this.socio = socio;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
        this.activo = true;
    }

    public Socio getSocio() {
        return socio;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(socio, prestamo.socio) && Objects.equals(libro, prestamo.libro);
    }

    @Override
    public String toString() {
        return "Socio: " + socio.getNombre() + " | DNI: " + socio.getDni() + "\n" +
                "Libro: " + libro.getTitulo() + " | ISBN: " + libro.getIsbn() + "\n" +
                "Fecha Prestamo: " + fechaPrestamo +
                " | Fecha Devolucion: " + (fechaDevolucion == null ? "No devuelto" : fechaDevolucion) + "\n" +
                "Activo: " + activo;
    }
}
