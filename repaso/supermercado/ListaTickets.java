package supermercado;

import java.util.ArrayList;

public class ListaTickets {


    private ArrayList<Ticket> tickets;

    public ListaTickets() {
        this.tickets = new ArrayList<>();
    }

    /**
     * Registra una compra si el producto tiene stock suficiente
     * @param cliente cliente que compra
     * @param producto producto comprado
     * @param cantidad cantidad comprada
     * @param fecha fecha de la compra
     * @return true si se registro correctamente
     */
    boolean registrarCompra(Cliente cliente, Producto producto, int cantidad, String fecha) {
        boolean registrado = false;
        if (producto.getStock() >= cantidad) {
            tickets.add(new Ticket(cliente, producto, cantidad, fecha));
            // reducir stock del producto
            producto.setStock(producto.getStock() - cantidad);
            registrado = true;
        }
        return registrado;
    }

    /**
     * Lista todos los tickets
     */
    void listarTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
                System.out.println("----------");
            }
        }
    }

    /**
     * Calcula los ingresos totales del supermercado
     * @return ingresos totales
     */
    double calcularIngresosTotales() {
        double total = 0;
        for (Ticket ticket : tickets) {
            total += ticket.calcularTotal();
        }
        return total;
    }

    /**
     * Devuelve el producto mas vendido
     * @param listaProductos lista de productos
     * @return producto mas vendido
     */
    Producto productoMasVendido(ListaProductos listaProductos) {
        Producto masVendido = null;
        int maxCantidad = 0;
        for (Producto producto : listaProductos.getProductos()) {
            int cantidad = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getProducto().getCodigo().equals(producto.getCodigo())) {
                    cantidad += ticket.getCantidad();
                }
            }
            if (cantidad > maxCantidad) {
                maxCantidad = cantidad;
                masVendido = producto;
            }
        }
        return masVendido;
    }

    /**
     * Devuelve el cliente que mas ha gastado
     * @param listaClientes lista de clientes
     * @return cliente con mayor gasto
     */
    Cliente clienteMayorGasto(ListaClientes listaClientes) {
        Cliente mayorGasto = null;
        double maxGasto = 0;
        for (Cliente cliente : listaClientes.getClientes()) {
            double gasto = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getCliente().getDni().equals(cliente.getDni())) {
                    gasto += ticket.calcularTotal();
                }
            }
            if (gasto > maxGasto) {
                maxGasto = gasto;
                mayorGasto = cliente;
            }
        }
        return mayorGasto;
    }
}
