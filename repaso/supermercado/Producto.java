package supermercado;

import java.util.Objects;

public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String codigo, String nombre, double precio, int stock, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public String getCategoria() { return categoria; }

    public void setPrecio(double precio) { this.precio = precio; }
    public void setStock(int stock) { this.stock = stock; }

    /**
     * Retorna true si el producto tiene stock disponible
     * @return stock > 0
     */
    boolean tieneStock() {
        return stock > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Nombre: " + nombre + "\n" +
                "Precio: " + precio + "€ | Stock: " + stock + "\n" +
                "Categoria: " + categoria;
    }
}

