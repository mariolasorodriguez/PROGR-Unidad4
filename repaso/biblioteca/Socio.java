package biblioteca;

import java.util.Objects;

public class Socio {

    private String dni;
    private String nombre;
    private String email;
    private int prestamosActuales;
    private static int limitePrestamos = 3;

    public Socio(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.prestamosActuales = 0;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrestamosActuales() {
        return prestamosActuales;
    }

    public void setPrestamosActuales(int prestamosActuales) {
        this.prestamosActuales = prestamosActuales;
    }

    public static int getLimitePrestamos() {
        return limitePrestamos;
    }

    public static void setLimitePrestamos(int limitePrestamos) {
        Socio.limitePrestamos = limitePrestamos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(dni, socio.dni);
    }

    @Override
    public String toString() {
        return "Socio: " + nombre +
                " | DNI: " + dni + "\n" +
                "Email: " + email + "\n" +
                "Prestamos actuales: " + prestamosActuales;
    }
}
