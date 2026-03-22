package plataformacursos;

public class Visualizacion {

    private Usuario usuario;
    private Contenido contenido;
    private int tiempoVisualizacion;
    private String fecha;

    public Visualizacion(Usuario usuario, Contenido contenido, int tiempoVisualizacion, String fecha) {
        this.usuario = usuario;
        this.contenido = contenido;
        this.tiempoVisualizacion = tiempoVisualizacion;
        this.fecha = fecha;
    }

    public Usuario getUsuario() { return usuario; }
    public Contenido getContenido() { return contenido; }
    public int getTiempoVisualizacion() { return tiempoVisualizacion; }
    public String getFecha() { return fecha; }

    @Override
    public String toString() {
        return "Usuario: " + usuario.getNombre() + " | Contenido: " + contenido.getTitulo() + "\n" +
                "Tiempo visualizado: " + tiempoVisualizacion + " min | Fecha: " + fecha;
    }
}
