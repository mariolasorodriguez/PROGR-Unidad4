package supermercado;

public class Ticket {

    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private String fecha;

    public Ticket(Cliente cliente, Producto producto, int cantidad, String fecha) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Cliente getCliente() { return cliente; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public String getFecha() { return fecha; }

    /**
     * Calcula el total de la compra aplicando descuento si tiene tarjeta fidelidad
     * @return total de la compra
     */
    double calcularTotal() {
        double total = producto.getPrecio() * cantidad;
        total = total - (total * cliente.calcularDescuento());
        return total;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNombre() + " | DNI: " + cliente.getDni() + "\n" +
                "Producto: " + producto.getNombre() + " | Cantidad: " + cantidad + "\n" +
                "Fecha: " + fecha + " | Total: " + calcularTotal() + "€";
    }
}
