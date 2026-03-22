package supermercado;

import java.util.ArrayList;

public class ListaClientes {

    private ArrayList<Cliente> clientes;

    public ListaClientes() {
        this.clientes = new ArrayList<>();
    }

    /**
     * Añade un cliente si no existe ya uno con el mismo dni
     * @param cliente cliente a añadir
     * @return true si se añadio correctamente
     */
    boolean añadirCliente(Cliente cliente) {
        boolean añadido = false;
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Lista todos los clientes
     */
    void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
                System.out.println("----------");
            }
        }
    }

    /**
     * Busca un cliente por su dni
     * @param dni dni del cliente
     * @return cliente encontrado o null
     */
    Cliente buscarPorDni(String dni) {
        Cliente encontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                encontrado = cliente;
            }
        }
        return encontrado;
    }

    /**
     * Elimina un cliente por su dni
     * @param dni dni del cliente
     * @return true si se elimino correctamente
     */
    boolean eliminarCliente(String dni) {
        boolean eliminado = false;
        Cliente encontrado = buscarPorDni(dni);
        if (encontrado != null) {
            clientes.remove(encontrado);
            eliminado = true;
        }
        return eliminado;
    }

    /**
     * Retorna la lista de clientes
     * @return lista de clientes
     */
    ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
