package supermercado;

import java.util.Objects;

public class Cliente {

    private String dni;
    private String nombre;
    private String email;
    private boolean tarjetaFidelidad;

    public Cliente(String dni, String nombre, String email, boolean tarjetaFidelidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.tarjetaFidelidad = tarjetaFidelidad;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public boolean isTarjetaFidelidad() { return tarjetaFidelidad; }

    public void setEmail(String email) { this.email = email; }
    public void setTarjetaFidelidad(boolean tarjetaFidelidad) { this.tarjetaFidelidad = tarjetaFidelidad; }

    /**
     * Calcula el descuento del cliente segun si tiene tarjeta de fidelidad
     * @return porcentaje de descuento
     */
    double calcularDescuento() {
        double descuento = 0;
        if (tarjetaFidelidad) {
            descuento = 0.05; // 5% de descuento
        }
        return descuento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " | Nombre: " + nombre + "\n" +
                "Email: " + email + "\n" +
                "Tarjeta fidelidad: " + (tarjetaFidelidad ? "Si" : "No");
    }
}
