package supermercado;

import java.util.Scanner;

public class MainSupermercado {
    Scanner reader = new Scanner(System.in);
    ListaProductos listaProductos = new ListaProductos();
    ListaClientes listaClientes = new ListaClientes();
    ListaTickets listaTickets = new ListaTickets();

    public static void main(String[] args) {
        MainSupermercado app = new MainSupermercado();
        System.out.println("Bienvenido al sistema de gestion del supermercado.");
        int opcion;
        do {
            opcion = app.mostrarMenu();
            app.menu(opcion);
        } while (opcion != 0);
        System.out.println("Hasta pronto!");
    }

    int mostrarMenu() {
        System.out.println("\n= SUPERMERCADO =");
        System.out.println("-- PRODUCTOS --");
        System.out.println("1. Añadir producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Listar productos con stock");
        System.out.println("4. Modificar precio");
        System.out.println("5. Eliminar producto");
        System.out.println("-- CLIENTES --");
        System.out.println("6. Añadir cliente");
        System.out.println("7. Listar clientes");
        System.out.println("8. Buscar cliente por DNI");
        System.out.println("9. Eliminar cliente");
        System.out.println("-- COMPRAS --");
        System.out.println("10. Registrar compra");
        System.out.println("11. Listar tickets");
        System.out.println("12. Ver estadisticas");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
        int opcion = reader.nextInt();
        reader.nextLine();
        return opcion;
    }

    void menu(int opcion) {
        switch (opcion) {
            case 1: añadirProducto(); break;
            case 2: listaProductos.listarProductos(); break;
            case 3: listaProductos.listarProductosConStock(); break;
            case 4: modificarPrecio(); break;
            case 5: eliminarProducto(); break;
            case 6: añadirCliente(); break;
            case 7: listaClientes.listarClientes(); break;
            case 8: buscarCliente(); break;
            case 9: eliminarCliente(); break;
            case 10: registrarCompra(); break;
            case 11: listaTickets.listarTickets(); break;
            case 12: mostrarEstadisticas(); break;
            case 0: break;
            default: System.out.println("Opcion no valida."); break;
        }
    }

    void añadirProducto() {
        System.out.print("Codigo: ");
        String codigo = reader.nextLine();
        System.out.print("Nombre: ");
        String nombre = reader.nextLine();
        System.out.print("Precio: ");
        double precio = reader.nextDouble();
        System.out.print("Stock: ");
        int stock = reader.nextInt();
        reader.nextLine();
        System.out.print("Categoria: ");
        String categoria = reader.nextLine();

        Producto producto = new Producto(codigo, nombre, precio, stock, categoria);
        boolean resultado = listaProductos.añadirProducto(producto);

        if (resultado) {
            System.out.println("Producto añadido correctamente.");
        } else {
            System.out.println("Ya existe un producto con ese codigo.");
        }
    }

    void modificarPrecio() {
        System.out.print("Codigo del producto: ");
        String codigo = reader.nextLine();
        System.out.print("Nuevo precio: ");
        double precio = reader.nextDouble();
        reader.nextLine();

        boolean resultado = listaProductos.modificarPrecio(codigo, precio);

        if (resultado) {
            System.out.println("Precio modificado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    void eliminarProducto() {
        System.out.print("Codigo del producto: ");
        String codigo = reader.nextLine();

        Producto encontrado = listaProductos.buscarPorCodigo(codigo);
        if (encontrado != null) {
            System.out.println("¿Esta segur@ de eliminar este producto? s/n");
            System.out.println(encontrado);
            String confirmacion = reader.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                listaProductos.eliminarProducto(codigo);
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("Operacion cancelada.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    void añadirCliente() {
        System.out.print("DNI: ");
        String dni = reader.nextLine();
        System.out.print("Nombre: ");
        String nombre = reader.nextLine();
        System.out.print("Email: ");
        String email = reader.nextLine();
        System.out.print("¿Tiene tarjeta fidelidad? s/n: ");
        boolean tarjeta = reader.nextLine().equalsIgnoreCase("s");

        Cliente cliente = new Cliente(dni, nombre, email, tarjeta);
        boolean resultado = listaClientes.añadirCliente(cliente);

        if (resultado) {
            System.out.println("Cliente añadido correctamente.");
        } else {
            System.out.println("Ya existe un cliente con ese DNI.");
        }
    }

    void buscarCliente() {
        System.out.print("DNI del cliente: ");
        String dni = reader.nextLine();

        Cliente encontrado = listaClientes.buscarPorDni(dni);
        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    void eliminarCliente() {
        System.out.print("DNI del cliente: ");
        String dni = reader.nextLine();

        Cliente encontrado = listaClientes.buscarPorDni(dni);
        if (encontrado != null) {
            System.out.println("¿Esta segur@ de eliminar este cliente? s/n");
            System.out.println(encontrado);
            String confirmacion = reader.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                listaClientes.eliminarCliente(dni);
                System.out.println("Cliente eliminado correctamente.");
            } else {
                System.out.println("Operacion cancelada.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    void registrarCompra() {
        System.out.print("DNI del cliente: ");
        String dni = reader.nextLine();
        System.out.print("Codigo del producto: ");
        String codigo = reader.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = reader.nextInt();
        reader.nextLine();
        System.out.print("Fecha: ");
        String fecha = reader.nextLine();

        Cliente cliente = listaClientes.buscarPorDni(dni);
        Producto producto = listaProductos.buscarPorCodigo(codigo);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        } else if (producto == null) {
            System.out.println("Producto no encontrado.");
        } else {
            boolean resultado = listaTickets.registrarCompra(cliente, producto, cantidad, fecha);
            if (resultado) {
                System.out.println("Compra registrada correctamente.");
            } else {
                System.out.println("No hay stock suficiente.");
            }
        }
    }

    void mostrarEstadisticas() {
        System.out.println("\n== ESTADISTICAS ==");
        System.out.println("Ingresos totales: " + listaTickets.calcularIngresosTotales() + "€");

        Producto masVendido = listaTickets.productoMasVendido(listaProductos);
        if (masVendido != null) {
            System.out.println("Producto mas vendido: " + masVendido.getNombre());
        }

        Cliente mayorGasto = listaTickets.clienteMayorGasto(listaClientes);
        if (mayorGasto != null) {
            System.out.println("Cliente con mayor gasto: " + mayorGasto.getNombre());
        }
    }
}
