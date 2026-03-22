package gestionempleados;

import java.util.Scanner;

public class MainEmpleados {

    Scanner reader = new Scanner(System.in);
    ListadoEmpleados listado = new ListadoEmpleados();

    public static void main(String[] args) {
        MainEmpleados app = new MainEmpleados();
        System.out.println("Bienvenido al sistema de gestion de empleados.");
        int opcion;
        do {
            opcion = app.mostrarMenu();
            app.menu(opcion);
        } while (opcion != 0);
        System.out.println("Saliendo del sistema...");
    }

    int mostrarMenu() {
        System.out.println("\n= GESTION DE EMPLEADOS =");
        System.out.println("1. Añadir empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Modificar horas extra");
        System.out.println("4. Modificar importe horas extra");
        System.out.println("5. Eliminar empleado");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
        int opcion = reader.nextInt();
        reader.nextLine();
        return opcion;
    }

    void menu(int opcion) {
        switch (opcion) {
            case 1: añadirEmpleado(); break;
            case 2: listado.listarEmpleados(); break;
            case 3: modificarHorasExtra(); break;
            case 4: modificarImporteHorasExtra(); break;
            case 5: eliminarEmpleado(); break;
            case 0: break;
            default: System.out.println("Opcion no valida."); break;
        }
    }

    void añadirEmpleado() {
        System.out.print("DNI: ");
        String dni = reader.nextLine();
        System.out.print("Nombre: ");
        String nombre = reader.nextLine();
        System.out.print("Sueldo base: ");
        double sueldoBase = reader.nextDouble();
        System.out.print("Horas extra: ");
        int horasExtra = reader.nextInt();
        reader.nextLine();

        Empleado empleado = new Empleado(dni, nombre, sueldoBase, horasExtra);
        boolean resultado = listado.añadirEmpleado(empleado);

        if (resultado) {
            System.out.println("Empleado añadido correctamente.");
        } else {
            System.out.println("Ya existe un empleado con ese DNI.");
        }
    }

    void modificarHorasExtra() {
        System.out.print("DNI del empleado: ");
        String dni = reader.nextLine();
        System.out.print("Nuevas horas extra: ");
        int horas = reader.nextInt();
        reader.nextLine();

        boolean resultado = listado.modificarHorasExtra(dni, horas);

        if (resultado) {
            System.out.println("Horas extra modificadas correctamente.");
        } else {
            System.out.println("No se encontro el empleado.");
        }
    }

    void modificarImporteHorasExtra() {
        System.out.print("Nuevo importe por hora extra: ");
        double importe = reader.nextDouble();
        reader.nextLine();

        Empleado.setImporteHoraExtra(importe);
        System.out.println("Importe hora extra actualizado a: " + importe + "€");
    }

    void eliminarEmpleado() {
        System.out.print("DNI del empleado: ");
        String dni = reader.nextLine();

        Empleado encontrado = listado.buscarPorDni(dni);
        if (encontrado != null) {
            System.out.println("¿Esta segur@ de eliminar este empleado? s/n");
            System.out.println(encontrado);
            String confirmacion = reader.nextLine();

            if (confirmacion.equalsIgnoreCase("s")) {
                listado.eliminarEmpleado(dni);
                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("Operacion cancelada.");
            }
        } else {
            System.out.println("No se encontro el empleado.");
        }
    }
}
