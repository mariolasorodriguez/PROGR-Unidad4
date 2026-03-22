package biblioteca;

import java.util.ArrayList;

public class ListaSocios {

    private ArrayList<Socio> socios;

    public ListaSocios() {
        this.socios = new ArrayList<>();
    }

    /**
     * Metodo que añade socios
     * @param socio
     * @return true/false si lo añade o no
     */
    boolean añadirSocio(Socio socio) {
        boolean añadido = false;
        if (!socios.contains(socio)) {
            socios.add(socio);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Metodo que lista los socios
     */
    void listarSocios() {
        if (socios.isEmpty()) {
            System.out.println("Lista de socios no encontrada");
        } else {
            for (Socio socio : socios) {
                System.out.println(socio);
                System.out.println("--------------");
            }
        }
    }

    /**
     * Metodo que busca por dni
     * @param dni
     * @return devuelve el objeto encontrado
     */
    Socio buscarPorDni(String dni){
        Socio encontrado = null;
        for (Socio socio : socios) {
            if (socio.getDni().equals(dni)) {
                encontrado = socio;
            }
        }
        return encontrado;
    }

    /**
     * Metodo que modifica el email
     * @param dni dni para buscar
     * @param email email a modificar
     * @return true/false si lo modifica o no
     */
    boolean modificarEmail(String dni, String email) {
        boolean modificado = false;
        Socio encontrado = buscarPorDni(dni);
        if (encontrado != null) {
                encontrado.setEmail(email);
                modificado = true;
        }
        return modificado;
    }

    /**
     * Metodo que elimina por dni
     * @param dni a buscar para eliminar
     * @return true/false si lo elimina
     */
    boolean eliminarPorDni(String dni) {
        boolean eliminado = false;
        Socio encontrado = buscarPorDni(dni);
        if (encontrado != null) {
            socios.remove(encontrado);
            eliminado = true;
        }
        return eliminado;
    }
}
