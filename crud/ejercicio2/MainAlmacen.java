package ejercicio2;

import java.util.Scanner;

public class MainAlmacen {
    static Scanner scanner = new Scanner(System.in);
    static Almacen almacen = new Almacen();

    public static void main(String[] args) {
        boolean salir = false;

        // Datos de almacen
        almacen.alta(new Articulo("A01", "Monitor 24p", 100.0, 150.0, 10));
        almacen.alta(new Articulo("A02", "Teclado Mecánico", 30.0, 50.0, 5));

        while (!salir) {
            System.out.println("GESTISIMAL - GESTIÓN DE ALMACÉN");
            System.out.println("=================================");
            System.out.println("1. Listado");
            System.out.println("2. Alta");
            System.out.println("3. Baja");
            System.out.println("4. Modificación");
            System.out.println("5. Entrada de mercancía");
            System.out.println("6. Salida de mercancía");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = leerInt();

            switch (opcion) {
                case 1:
                    listar();
                    break;
                case 2:
                    altaArticulo();
                    break;
                case 3:
                    bajaArticulo();
                    break;
                case 4:
                    modificarArticulo();
                    break;
                case 5:
                    entradaMercancia();
                    break;
                case 6:
                    salidaMercancia();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
    }


    public static void listar() {
        if (almacen.listar().isEmpty()) {
            System.out.println("Almacén vacío.");
        } else {
            for (Articulo a : almacen.listar()) {
                System.out.println(a.toString());
            }
        }
    }

    public static void altaArticulo() {
        System.out.println("--- NUEVO ARTÍCULO ---");
        System.out.print("Código: ");
        String cod = scanner.nextLine();
        
        if (almacen.buscarArticulo(cod) != null) {
            System.out.println("Error: Ya existe un artículo con ese código.");
            return;
        }

        System.out.print("Descripción: ");
        String desc = scanner.nextLine();
        System.out.print("Precio Compra: ");
        double pCompra = leerDouble();
        System.out.print("Precio Venta: ");
        double pVenta = leerDouble();
        System.out.print("Stock inicial: ");
        int stock = leerInt();

        almacen.alta(new Articulo(cod, desc, pCompra, pVenta, stock));
        System.out.println("Artículo creado.");
    }

    public static void bajaArticulo() {
        System.out.print("Introduce el código del artículo a borrar: ");
        String cod = scanner.nextLine();
        if (almacen.baja(cod)) {
            System.out.println("Artículo eliminado.");
        } else {
            System.out.println("No se encuentra el código.");
        }
    }

    public static void modificarArticulo() {
        System.out.print("Introduce el código del artículo a modificar: ");
        String cod = scanner.nextLine();
        Articulo a = almacen.buscarArticulo(cod);

        if (a != null) {
            System.out.println("Artículo encontrado: " + a.toString());
            System.out.print("Nueva descripción: ");
            a.setDescripcion(scanner.nextLine());
            System.out.print("Nuevo precio de compra: ");
            a.setPrecioCompra(leerDouble());
            System.out.print("Nuevo precio de venta: ");
            a.setPrecioVenta(leerDouble());
            System.out.println("Datos modificados.");
        } else {
            System.out.println("El artículo no existe.");
        }
    }

    public static void entradaMercancia() {
        System.out.print("Código del artículo: ");
        String cod = scanner.nextLine();
        Articulo a = almacen.buscarArticulo(cod);

        if (a != null) {
            System.out.print("Cantidad que entra al almacén: ");
            int cant = leerInt();
            a.entrarMercancia(cant);
            System.out.println("Stock actualizado. Nuevo stock: " + a.toString());
        } else {
            System.out.println("El artículo no existe.");
        }
    }

    public static void salidaMercancia() {
        System.out.print("Código del artículo: ");
        String cod = scanner.nextLine();
        Articulo a = almacen.buscarArticulo(cod);

        if (a != null) {
            System.out.print("Cantidad que sale del almacén: ");
            int cant = leerInt();
            
            boolean exito = a.salirMercancia(cant);
            
            if (exito) {
                System.out.println("Venta realizada. Nuevo stock: " + a.toString());
            } else {
                System.out.println("ERROR: No hay suficiente stock para esa salida.");
            }
        } else {
            System.out.println("El artículo no existe.");
        }
    }

    public static int leerInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static double leerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}