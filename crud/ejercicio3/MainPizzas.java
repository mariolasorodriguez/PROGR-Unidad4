package ejercicio3;

import java.util.Scanner;

public class MainPizzas {
    static Scanner scanner = new Scanner(System.in);
    static GestionPizzas gestor = new GestionPizzas();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nPIZZERÍA - GESTIÓN DE PEDIDOS");
            System.out.println("=============================");
            System.out.println("1. Listado de pizzas");
            System.out.println("2. Nuevo pedido");
            System.out.println("3. Pizza servida");
            System.out.println("4. Salir");
            System.out.print("Elige opción: ");
            
            int opcion = leerInt();

            switch (opcion) {
                case 1:
                    mostrarListado();
                    break;
                case 2:
                    hacerPedido();
                    break;
                case 3:
                    servirPedido();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Cerrando caja...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }


    public static void mostrarListado() {
        if (gestor.obtenerListado().isEmpty()) {
            System.out.println("--> No hay pedidos registrados hoy.");
        } else {
            System.out.println("--> Pedidos actuales:");
            for (Pizza p : gestor.obtenerListado()) {
                System.out.println(p.toString());
            }
        }
    }

    public static void hacerPedido() {
        System.out.print("Introduce el tipo de pizza (Margarita, 4 Quesos...): ");
        String tipo = scanner.nextLine();
        
        System.out.print("Introduce el tamaño (Mediana, Familiar...): ");
        String tamano = scanner.nextLine();

        gestor.nuevoPedido(tipo, tamano);
        System.out.println("--> Pedido registrado con éxito.");
    }

    public static void servirPedido() {
        mostrarListado(); 
        
        if (!gestor.obtenerListado().isEmpty()) {
            System.out.print("Introduce el Nº de Ticket de la pizza a servir: ");
            int codigo = leerInt();

            boolean exito = gestor.servirPizza(codigo);

            if (exito) {
                System.out.println("--> ¡Pizza servida!");
            } else {
                System.out.println("--> Error: No existe un pedido con ese número de ticket.");
            }
        }
    }

    public static int leerInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
