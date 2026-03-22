package plataformacursos;

import java.util.ArrayList;

public class ListaContenidos {

    private ArrayList<Contenido> contenidos;

    public ListaContenidos() {
        this.contenidos = new ArrayList<>();
    }

    ArrayList<Contenido> getContenidos() {
        return contenidos;
    }

    /**
     * Añade un contenido si no existe ya uno con el mismo codigo
     * @param contenido contenido a añadir
     * @return true si se añadio correctamente
     */
    boolean añadirContenido(Contenido contenido) {
        boolean añadido = false;
        if (!contenidos.contains(contenido)) {
            contenidos.add(contenido);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Lista todos los contenidos
     */
    void listarContenidos() {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenidos registrados.");
        } else {
            for (Contenido contenido : contenidos) {
                System.out.println(contenido);
                System.out.println("----------");
            }
        }
    }

    /**
     * Busca un contenido por su codigo
     * @param codigo codigo del contenido
     * @return contenido encontrado o null
     */
    Contenido buscarPorCodigo(String codigo) {
        Contenido encontrado = null;
        for (Contenido contenido : contenidos) {
            if (contenido.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = contenido;
            }
        }
        return encontrado;
    }
}
