package gestionempleados;

import java.util.ArrayList;

public class ListadoEmpleados {

    private ArrayList<Empleado> empleados;

    public ListadoEmpleados() {
        this.empleados = new ArrayList<>();
    }

    /**
     * Añade un empleado si no existe ya uno con el mismo dni
     * @param empleado empleado a añadir
     * @return true si se añadio correctamente
     */
    boolean añadirEmpleado(Empleado empleado) {
        boolean añadido = false;
        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Lista todos los empleados
     */
    void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
                System.out.println("----------");
            }
        }
    }

    /**
     * Busca un empleado por su dni
     * @param dni dni del empleado
     * @return empleado encontrado o null
     */
    Empleado buscarPorDni(String dni) {
        Empleado encontrado = null;
        for (Empleado empleado : empleados) {
            if (empleado.getDni().equalsIgnoreCase(dni)) {
                encontrado = empleado;
            }
        }
        return encontrado;
    }

    /**
     * Modifica las horas extra de un empleado
     * @param dni dni del empleado
     * @param horas nuevas horas extra
     * @return true si se modifico correctamente
     */
    boolean modificarHorasExtra(String dni, int horas) {
        boolean modificado = false;
        Empleado encontrado = buscarPorDni(dni);
        if (encontrado != null) {
            encontrado.setHorasExtra(horas);
            modificado = true;
        }
        return modificado;
    }

    /**
     * Elimina un empleado por su dni
     * @param dni dni del empleado
     * @return true si se elimino correctamente
     */
    boolean eliminarEmpleado(String dni) {
        boolean eliminado = false;
        Empleado encontrado = buscarPorDni(dni);
        if (encontrado != null) {
            empleados.remove(encontrado);
            eliminado = true;
        }
        return eliminado;
    }
}
