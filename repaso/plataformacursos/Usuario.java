package plataformacursos;

import java.util.Objects;

public class Usuario {

    private String id;
    private String nombre;
    private String email;
    private String tipoSuscripcion; // gratuito, mensual, anual
    private double ingresoGenerado;

    public Usuario(String id, String nombre, String email, String tipoSuscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tipoSuscripcion = tipoSuscripcion;
        this.ingresoGenerado = calcularIngreso();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public double getIngresoGenerado() {
        return ingresoGenerado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipoSuscripcion(String tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
        this.ingresoGenerado = calcularIngreso();
    }

    /**
     * Calcula el ingreso generado segun el tipo de suscripcion
     *
     * @return ingreso mensual
     */
    double calcularIngreso() {
        double ingreso = 0;
        if (tipoSuscripcion.equalsIgnoreCase("mensual")) {
            ingreso = 9.99;
        } else if (tipoSuscripcion.equalsIgnoreCase("anual")) {
            ingreso = 79.99;
        }
        return ingreso;
    }

    /**
     * Retorna true si el usuario tiene suscripcion activa
     *
     * @return tieneSuscripcion
     */
    boolean tieneSuscripcion() {
        return !tipoSuscripcion.equalsIgnoreCase("gratuito");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + "\n" +
                "Email: " + email + " | Suscripcion: " + tipoSuscripcion + "\n" +
                "Ingreso generado: " + ingresoGenerado + "€";
    }
}
