package alquiler_coches;


import java.util.Scanner;

public class MainAlquiler {

    Scanner reader = new Scanner(System.in);
    ListaVehiculos lista = new ListaVehiculos();

    public static void main(String[] args) {
        MainAlquiler mainAlquiler = new MainAlquiler();
        int opcionIntroducida = 0;
        do {
            opcionIntroducida = mainAlquiler.listarMenu();
            mainAlquiler.menu(opcionIntroducida);
        } while (opcionIntroducida != 9);

    }

    /**
     * Metodo para listar el menu
     */
    int listarMenu() {
        System.out.println("= ALQUILER DE VEHICULOS =");
        System.out.println("1. Añadir vehiculo");
        System.out.println("2. Listar vehiculos");
        System.out.println("3. Buscar vehiculo por matricula");
        System.out.println("4. Modificar dias alquilados");
        System.out.println("5. Modificar recargo premium");
        System.out.println("6. Modificar precio seguro diario");
        System.out.println("7. Eliminar vehiculo");
        System.out.println("8. Ver estadisticas");
        System.out.println("9. Salir");
        System.out.println("Opcion (1-9): ");
        int opcionIntroducida;
        opcionIntroducida = reader.nextInt();
        return opcionIntroducida;
    }

    void menu(int opcionIntroducida) {
        switch (opcionIntroducida) {
            case 1:
                añadirVehiculo();
                break;
            case 2:
                listarVehiculos();
                break;
            case 3:
                buscarVehiculoPorMatricula();
                break;
            case 4:
                modificarDiasAlquilados();
                break;
            case 5:
                modificarRecargoPremium();
                break;
            case 6:
                modificarPrecioSeguroDiario();
                break;
            case 7:
                eliminarVehiculo();
                break;
            case 8:
                mostrarEstadisticas();
                break;
            default:
                System.out.println("Gracias por usar el sistema ¡Hasta Pronto!");
                break;
        }
    }

    /**
     * Metodo para añadir un vehiculo
     */
    void añadirVehiculo() {
        System.out.println("Inserte matricula: ");
        String matricula = reader.next();
        reader.nextLine();

        System.out.println("Inserte modelo: ");
        String modelo = reader.nextLine();

        System.out.println("Precio base por dia: ");
        double precioBasePorDia = reader.nextDouble();

        System.out.println("Inserte porcentaje recargo premium (0-25): ");
        double recargoPremium = reader.nextDouble();

        reader.nextLine();

        Vehiculo vehiculo = new Vehiculo(matricula, modelo, precioBasePorDia, recargoPremium, 0);
        boolean resultado = lista.añadirVehiculo(vehiculo);

        if (resultado) {
            System.out.println("Vehiculo añadido correctamente.");
        } else {
            System.out.println("¿Donde vas? Ya hay un vehiculo con esa matricula.");
        }
    }

    /**
     * Metodo que lista los vehiculos usando otro metodo en la clase ListaVehiculos
     */
    void listarVehiculos() {
        lista.listarTodos();
    }

    /**
     * Metodo que busca un vehiculo por la matricula
     */
    void buscarVehiculoPorMatricula() {
        String matricula;
        System.out.println("Introduce la matricula: ");
        matricula = reader.next();

        Vehiculo encontrado = lista.buscarPorMatricula(matricula);

        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Vehiculo no encontrado.");
        }
    }

    /**
     * Metodo que modifica los dias alquilados, si no lo encuentra lanza error
     */
    void modificarDiasAlquilados() {
        String matricula;
        int dias;
        System.out.println("Introduce la matricula: ");
        matricula = reader.next();
        System.out.println("Introduce los dias de alquiler: ");
        dias = reader.nextInt();

        boolean resultado = lista.modificarDiasAlquilados(matricula, dias);

        if (resultado) {
            System.out.println("Dias alquilados modificados correctamente.");
        } else {
            System.out.println("No se encontro el vehiculo.");
        }

    }

    /**
     * Metodo que modifica el recargo premium del vehiculo
     */
    void modificarRecargoPremium() {
        String matricula;
        int recargoPremium;

        System.out.println("Introduce la matricula: ");
        matricula = reader.next();
        System.out.println("Introduce el porcentaje recargo premium (0-25): ");
        recargoPremium = reader.nextInt();

        boolean resultado = lista.modificarRecargoPremium(matricula, recargoPremium);

        if (resultado) {
            System.out.println("Recargo premium modificado correctamente.");
        } else {
            System.out.println("No se encontro el vehiculo.");
        }
    }

    /**
     * Metodo que modifica el precio de seguro diario para todos los vehiculos
     */
    void modificarPrecioSeguroDiario() {
        String matricula;
        double precioSeguroDiario;

        System.out.println("= NOTA: ESTO AFECTA A TODOS LOS VEHICULOS DE ALQUILER =");
        System.out.println("Introduce la matricula: ");
        matricula = reader.next();
        System.out.println("Introduce el precio del seguro diario: ");
        precioSeguroDiario = reader.nextDouble();


        Vehiculo.setPrecioSeguroDiario(precioSeguroDiario);
        System.out.println("Precio de seguro diario modificado a: " + precioSeguroDiario + "€");
    }

    /**
     * Metodo que elimina un vehiculo por matricula, pidiendo confirmacion
     */
    void eliminarVehiculo() {
        String matricula;


        System.out.println("Introduce la matricula: ");
        matricula = reader.next();
        reader.nextLine();
        System.out.println("¿Está segur@ de eliminar el vehiculo?");

        Vehiculo encontrado = lista.buscarPorMatricula(matricula);
        if (encontrado != null) {
            System.out.println("¿Esta segur@ de eliminar este vehiculo? s/n");
            System.out.println(encontrado);
            String confirmacion = reader.nextLine();

            if (confirmacion.equalsIgnoreCase("s")) {
                lista.eliminarPorMatricula(matricula);
                System.out.println("El vehiculo ha sido eliminado correctamente.");
            } else {
                System.out.println("Operacion cancelada.");
            }
        } else {
            System.out.println("No se encontro el vehiculo");
        }
    }

    /**
     * Metodo para mostrar las estadisticas del alquiler
     */
    void mostrarEstadisticas() {
        System.out.println("Ingreso total por recargos premium: " + lista.calcularIngresoTotalRecargos());
        System.out.println("\n == Vehiculos Premium ==");
        lista.listarVehiculosPremium();
    }
}
