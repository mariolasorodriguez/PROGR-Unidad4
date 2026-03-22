package alquiler_coches;

import java.util.ArrayList;

public class ListaVehiculos {

    private ArrayList<Vehiculo> vehiculos;

    public ListaVehiculos() {
        this.vehiculos = new ArrayList<>();
    }

    /**
     * Metodo que añade el vehiculo si no lo contiene ya
     *
     * @param vehiculo
     * @return true/false si lo consigue añadir o no
     */
    boolean añadirVehiculo(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            return false;
        } else {
            vehiculos.add(vehiculo);
            return true;
        }
    }

    /**
     * Metodo que lista todos los vehiculos de la lista
     */
    void listarTodos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos aún.");
            return;
        }
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
            System.out.println("------------------");
        }
    }

    /**
     * Metodo que busca un vehiculo por matricula
     *
     * @param matricula
     * @return si lo encuentra devuelve el vehiculo en concreto, si no null
     */
    Vehiculo buscarPorMatricula(String matricula) {
        Vehiculo encontrado = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
                encontrado = vehiculo;
            }
        }
        return encontrado;
    }

    /**
     * Metodo que modifica los dias alquilados de un coche
     *
     * @param matricula
     * @param dias
     * @return true/false si lo consigue modificar
     */
    boolean modificarDiasAlquilados(String matricula, int dias) {
        boolean modificado = false;
        Vehiculo vehiculo = buscarPorMatricula(matricula);
        if (vehiculo != null) {
            vehiculo.setDiasAlquilados(dias);
            modificado = true;
        }
        return modificado;
    }

    /**
     * Metodo que modifica el recargo premium
     *
     * @param matricula
     * @param porcentaje
     * @return true/false si lo consigue modificar
     */
    boolean modificarRecargoPremium(String matricula, double porcentaje) {
        boolean modificado = false;
        Vehiculo vehiculo = buscarPorMatricula(matricula);
        if (vehiculo != null && porcentaje >= 0 && porcentaje <= 25) {
            vehiculo.setPorcentajeRecargo(porcentaje);
            modificado = true;
        }
        return modificado;
    }

    boolean eliminarPorMatricula(String matricula) {
        boolean eliminado = false;
        Vehiculo encontrado = buscarPorMatricula(matricula);
        if (encontrado != null) {
            vehiculos.remove(encontrado);
            eliminado = true;
        }
        return eliminado;
    }

    /**
     * Suma los recargos premium de todos los vehiculos
     *
     * @return total de recargos
     */
    double calcularIngresoTotalRecargos() {
        double totalRecargos = 0;
        for (Vehiculo vehiculo : vehiculos) {
            totalRecargos += vehiculo.importeRecargoPremium();
        }
        return totalRecargos;

    }

    /**
     * Metodo que lista los vehiculos premium
     */
    void listarVehiculosPremium() {
        boolean hayPremium = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.esPremium()) {
                System.out.println(vehiculo);
                System.out.println("-------------------");
                hayPremium = true;

            }
        }
        if (!hayPremium) {
            System.out.println("No hay vehiculos premium.");
        }
    }


}
