package ejercicio2;

public class Articulo {
    private String codigo;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int stock;

    public Articulo(String codigo, String descripcion, double precioCompra, double precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    // Getters y Setters para modificaciones
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    // Lógica de negocio: Entrada de mercancía
    public void entrarMercancia(int cantidad) {
        this.stock += cantidad;
    }

    // Devuelve true si se pudo sacar, false si no hay suficiente
    public boolean salirMercancia(int cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Cod: " + codigo + " | " + descripcion + 
               " | P.Compra: " + precioCompra + " | P.Venta: " + precioVenta + 
               " | Stock: " + stock;
    }
}
