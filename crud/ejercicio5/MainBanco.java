package ejercicio5;

import java.util.Scanner;

public class MainBanco {
	static Scanner scanner = new Scanner(System.in);
	static GestionBanco banco = new GestionBanco();

	public static void main(String[] args) {
		banco.abrirCuenta(new CuentaCorriente("111A", "Juan Perez", 1000, Nacionalidad.ESPANOLA));
		banco.abrirCuenta(new CuentaCorriente("222B", "Maria Gomez", 500, Nacionalidad.EXTRANJERA));

		boolean salir = false;
		while (!salir) {
			System.out.println("\nGESTIÓN BANCARIA - CUENTA CORRIENTE");
			System.out.println("===================================");
			System.out.println("1. Listado de cuentas");
			System.out.println("2. Abrir nueva cuenta");
			System.out.println("3. Operar (Ingresar/Sacar dinero)");
			System.out.println("4. Cerrar cuenta (Borrar)");
			System.out.println("5. Salir");
			System.out.print("Seleccione opción: ");

			int opcion = leerInt();

			switch (opcion) {
			case 1:
				listarCuentas();
				break;
			case 2:
				crearCuenta();
				break;
			case 3:
				menuOperaciones();
				break;
			case 4:
				borrarCuenta();
				break;
			case 5:
				salir = true;
				System.out.println("Gracias por usar nuestro banco.");
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}
	}

	public static void listarCuentas() {
		if (banco.listar().isEmpty()) {
			System.out.println("--> No hay cuentas registradas.");
		} else {
			System.out.println("--> Cuentas activas:");
			for (CuentaCorriente c : banco.listar()) {
				System.out.println(c.toString());
			}
		}
	}

	public static void crearCuenta() {
		System.out.print("Introduce DNI del titular: ");
		String dni = scanner.nextLine();

		if (banco.buscarPorDni(dni) != null) {
			System.out.println("Error: Ya existe una cuenta con ese DNI.");
			return;
		}

		System.out.print("Nombre del titular: ");
		String nombre = scanner.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = leerDouble();

		System.out.print("Nacionalidad (1. Española / 2. Extranjera): ");
		int nacOpt = leerInt();
		Nacionalidad nac = (nacOpt == 2) ? Nacionalidad.EXTRANJERA : Nacionalidad.ESPANOLA;

		CuentaCorriente nueva = new CuentaCorriente(dni, nombre, saldo, nac);
		banco.abrirCuenta(nueva);
		System.out.println("--> Cuenta creada con éxito.");
	}

	public static void menuOperaciones() {
		System.out.print("Introduce DNI para operar: ");
		String dni = scanner.nextLine();

		CuentaCorriente cuenta = banco.buscarPorDni(dni);

		if (cuenta == null) {
			System.out.println("--> Error: No existe cuenta asociada a ese DNI.");
			return;
		}

		System.out.println("CUENTA SELECCIONADA: " + cuenta.getNombre() + " (Saldo: " + cuenta.getSaldo() + "€)");
		System.out.println("  1. Ingresar dinero");
		System.out.println("  2. Sacar dinero");
		System.out.print("  Elige opción: ");
		int op = leerInt();

		if (op == 1) {
			System.out.print("Cantidad a ingresar: ");
			double cant = leerDouble();
			if (cuenta.ingresarDinero(cant)) {
				System.out.println("--> Ingreso realizado. Nuevo saldo: " + cuenta.getSaldo() + "€");
			} else {
				System.out.println("--> Error: La cantidad debe ser positiva.");
			}
		} else if (op == 2) {
			System.out.print("Cantidad a retirar: ");
			double cant = leerDouble();
			if (cuenta.sacarDinero(cant)) {
				System.out.println("--> Retirada realizada. Nuevo saldo: " + cuenta.getSaldo() + "€");
			} else {
				System.out.println("--> Error: Saldo insuficiente o cantidad inválida.");
			}
		} else {
			System.out.println("Opción cancelada.");
		}
	}

	public static void borrarCuenta() {
		System.out.print("Introduce el DNI de la cuenta a cerrar: ");
		String dni = scanner.nextLine();

		if (banco.cerrarCuenta(dni)) {
			System.out.println("--> Cuenta cerrada y eliminada.");
		} else {
			System.out.println("--> No se encontró ninguna cuenta con ese DNI.");
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
