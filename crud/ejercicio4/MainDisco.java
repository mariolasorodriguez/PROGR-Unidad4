package ejercicio4;

import java.util.Scanner;

public class MainDisco {
    static Scanner scanner = new Scanner(System.in);
    static ColeccionDiscos coleccion = new ColeccionDiscos();

    public static void main(String[] args) {
        boolean salir = false;

        coleccion.nuevoDisco(new Disco("D01", "Pink Floyd", "The Wall", 80.0, Genero.ROCK));
        coleccion.nuevoDisco(new Disco("D02", "Michael Jackson", "Thriller", 42.3, Genero.POP));

        while (!salir) {
            System.out.println("\nCOLECCIÓN DE DISCOS");
            System.out.println("===================");
            System.out.println("1. Listado.");
            System.out.println("2. Nuevo Disco.");
            System.out.println("3. Borrar.");
            System.out.println("4. Salir.");
            System.out.print("Elige una opción: ");

            int opcion = leerInt();

            switch (opcion) {
                case 1:
                    listarDiscos();
                    break;
                case 2:
                    crearDisco();
                    break;
                case 3:
                    borrarDisco();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
    }


    public static void listarDiscos() {
        if (coleccion.listar().isEmpty()) {
            System.out.println("--> La colección está vacía.");
        } else {
            System.out.println("--> Listado actual:");
            for (Disco d : coleccion.listar()) {
                System.out.println(d.toString());
            }
        }
    }

    public static void crearDisco() {
        System.out.println("--- NUEVO DISCO ---");
        System.out.print("Código único: ");
        String codigo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Duración (minutos): ");
        double duracion = leerDouble();

        Genero generoSeleccionado = null;
        while (generoSeleccionado == null) {
            System.out.print("Género (ROCK, POP, JAZZ, BLUES): ");
            String entrada = scanner.nextLine().toUpperCase(); 
            try {
                generoSeleccionado = Genero.valueOf(entrada);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Género no válido. Inténtalo de nuevo.");
            }
        }

        Disco nuevo = new Disco(codigo, autor, titulo, duracion, generoSeleccionado);
        
        if (coleccion.nuevoDisco(nuevo)) {
            System.out.println("--> Disco guardado correctamente.");
        } else {
            System.out.println("--> Error: Ya existe un disco con ese código.");
        }
    }

    public static void borrarDisco() {
        System.out.print("Introduce el CÓDIGO del disco a borrar: ");
        String codigo = scanner.nextLine();

        if (coleccion.borrarDisco(codigo)) {
            System.out.println("--> Disco eliminado.");
        } else {
            System.out.println("--> No se encontró ningún disco con ese código.");
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
