package plataformacursos;

import java.util.ArrayList;

public class ListaUsuarios {

    private ArrayList<Usuario> usuarios;

    public ListaUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    /**
     * Añade un usuario si no existe ya uno con el mismo id
     * @param usuario usuario a añadir
     * @return true si se añadio correctamente
     */
    boolean añadirUsuario(Usuario usuario) {
        boolean añadido = false;
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Lista todos los usuarios
     */
    void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
                System.out.println("----------");
            }
        }
    }

    /**
     * Busca un usuario por su id
     * @param id identificador del usuario
     * @return usuario encontrado o null
     */
    Usuario buscarPorId(String id) {
        Usuario encontrado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equalsIgnoreCase(id)) {
                encontrado = usuario;
            }
        }
        return encontrado;
    }

    /**
     * Elimina un usuario por su id
     * @param id identificador del usuario
     * @return true si se elimino correctamente
     */
    boolean eliminarUsuario(String id) {
        boolean eliminado = false;
        Usuario encontrado = buscarPorId(id);
        if (encontrado != null) {
            usuarios.remove(encontrado);
            eliminado = true;
        }
        return eliminado;
    }

    /**
     * Calcula los ingresos totales de la plataforma
     * @return ingresos totales
     */
    double calcularIngresosTotales() {
        double total = 0;
        for (Usuario usuario : usuarios) {
            total += usuario.getIngresoGenerado();
        }
        return total;
    }

    /**
     * Calcula los ingresos por tipo de suscripcion
     * @param tipo tipo de suscripcion
     * @return ingresos del tipo
     */
    double calcularIngresosPorTipo(String tipo) {
        double total = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getTipoSuscripcion().equalsIgnoreCase(tipo)) {
                total += usuario.getIngresoGenerado();
            }
        }
        return total;
    }

    /**
     * Devuelve el usuario que mas ingreso genera
     * @return usuario con mayor ingreso
     */
    Usuario usuarioMayorIngreso() {
        Usuario mayor = null;
        for (Usuario usuario : usuarios) {
            if (mayor == null || usuario.getIngresoGenerado() > mayor.getIngresoGenerado()) {
                mayor = usuario;
            }
        }
        return mayor;
    }

    /**
     * Retorna la lista de usuarios
     * @return lista de usuarios
     */
    ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
