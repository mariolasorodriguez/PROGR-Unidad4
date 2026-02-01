package ejercicio1;

import java.util.Scanner;
import java.util.ArrayList;

public class MainAlumnos {
    
    // Iniciamos el scanner
    static Scanner scanner = new Scanner(System.in);
    static GestionAlumnos gestor = new GestionAlumnos();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    listarAlumnos();
                    break;
                case 2:
                    crearAlumno();
                    break;
                case 3:
                    modificarAlumno();
                    break;
                case 4:
                    borrarAlumno();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }


    public static void mostrarMenu() {
        System.out.println("\nALUMNOS/AS");
        System.out.println("===================");
        System.out.println("1. Listado.");
        System.out.println("2. Nuevo Alumno.");
        System.out.println("3. Modificar.");
        System.out.println("4. Borrar.");
        System.out.println("5. Salir.");
        System.out.print("Elija una opción: ");
    }

    public static void listarAlumnos() {
        ArrayList<Alumno> lista = gestor.obtenerLista();
        
        if (lista.isEmpty()) {
            System.out.println("--> La lista está vacía.");
        } else {
            System.out.println("--> Listado de alumnos:");
            for (Alumno a : lista) {
                System.out.println(a.toString());
            }
        }
    }

    public static void crearAlumno() {
        System.out.print("Introduzca nombre del alumno: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Introduzca nota del alumno: ");
        double nota = leerDouble();

        Alumno nuevo = new Alumno(nombre, nota);
        gestor.agregarAlumno(nuevo);
        System.out.println("--> Alumno añadido correctamente.");
    }

    public static void modificarAlumno() {
        System.out.print("Introduzca el nombre del alumno a modificar: ");
        String nombre = scanner.nextLine();

        // Primero verificamos si existe antes de pedir la nota, o pedimos la nota dentro
        // Para simplificar, asumimos que intentamos modificar y el gestor nos dice si pudo
        System.out.print("Introduzca la nueva nota: ");
        double nuevaNota = leerDouble();

        boolean exito = gestor.modificarNota(nombre, nuevaNota);
        
        if (exito) {
            System.out.println("--> Nota modificada correctamente.");
        } else {
            System.out.println("--> Error: No se encontró un alumno con ese nombre.");
        }
    }

    public static void borrarAlumno() {
        System.out.print("Introduzca el nombre del alumno a borrar: ");
        String nombre = scanner.nextLine();

        boolean exito = gestor.borrarAlumno(nombre);

        if (exito) {
            System.out.println("--> Alumno eliminado de la lista.");
        } else {
            System.out.println("--> Error: No se encontró al alumno.");
        }
    }
    
    // Método para leer enteros y limpiar el buffer
    public static int leerEntero() {
        try {
            int numero = Integer.parseInt(scanner.nextLine());
            return numero;
        } catch (NumberFormatException e) {
            return -1; 
        }
    }

    // Método para leer doubles 
    public static double leerDouble() {
        try {
            double numero = Double.parseDouble(scanner.nextLine());
            return numero;
        } catch (NumberFormatException e) {
            System.out.println("Número inválido, se asignará 0.0");
            return 0.0;
        }
    }
}
