package plataformacursos;

import java.util.ArrayList;

public class ListaVisualizaciones {

    private ArrayList<Visualizacion> visualizaciones;

    public ListaVisualizaciones() {
        this.visualizaciones = new ArrayList<>();
    }

    /**
     * Registra una visualizacion si el usuario puede acceder al contenido
     * @param usuario usuario que visualiza
     * @param contenido contenido visualizado
     * @param tiempo tiempo de visualizacion
     * @param fecha fecha de visualizacion
     * @return true si se registro correctamente
     */
    boolean registrarVisualizacion(Usuario usuario, Contenido contenido, int tiempo, String fecha) {
        boolean registrado = false;
        if (!contenido.isPremium() || usuario.tieneSuscripcion()) {
            visualizaciones.add(new Visualizacion(usuario, contenido, tiempo, fecha));
            registrado = true;
        }
        return registrado;
    }

    /**
     * Lista todas las visualizaciones
     */
    void listarVisualizaciones() {
        if (visualizaciones.isEmpty()) {
            System.out.println("No hay visualizaciones registradas.");
        } else {
            for (Visualizacion v : visualizaciones) {
                System.out.println(v);
                System.out.println("----------");
            }
        }
    }

    /**
     * Devuelve el usuario mas activo por tiempo de visualizacion
     * @param listaUsuarios lista de usuarios
     * @return usuario mas activo
     */
    Usuario usuarioMasActivo(ListaUsuarios listaUsuarios) {
        Usuario masActivo = null;
        int maxTiempo = 0;

        for (Usuario usuario : listaUsuarios.getUsuarios()) {
            int tiempoTotal = 0;
            for (Visualizacion v : visualizaciones) {
                if (v.getUsuario().getId().equals(usuario.getId())) {
                    tiempoTotal += v.getTiempoVisualizacion();
                }
            }
            if (tiempoTotal > maxTiempo) {
                maxTiempo = tiempoTotal;
                masActivo = usuario;
            }
        }
        return masActivo;
    }

    /**
     * Devuelve el contenido mas consumido
     * @param listaContenidos lista de contenidos
     * @return contenido mas consumido
     */
    Contenido contenidoMasConsumido(ListaContenidos listaContenidos) {
        Contenido masConsumido = null;
        int maxVeces = 0;

        for (Contenido contenido : listaContenidos.getContenidos()) {
            int veces = 0;
            for (Visualizacion v : visualizaciones) {
                if (v.getContenido().getCodigo().equals(contenido.getCodigo())) {
                    veces++;
                }
            }
            if (veces > maxVeces) {
                maxVeces = veces;
                masConsumido = contenido;
            }
        }
        return masConsumido;
    }
}
