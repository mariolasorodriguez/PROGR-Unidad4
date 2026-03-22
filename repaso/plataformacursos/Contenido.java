package plataformacursos;


import java.util.Objects;

public class Contenido {

    private String codigo;
    private String titulo;
    private int duracion;
    private String categoria;
    private String nivel;
    private String tipo;
    private boolean premium;

    public Contenido(String codigo, String titulo, int duracion, String categoria, String nivel, String tipo, boolean premium) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracion = duracion;
        this.categoria = categoria;
        this.nivel = nivel;
        this.tipo = tipo;
        this.premium = premium;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contenido contenido = (Contenido) o;
        return Objects.equals(codigo, contenido.codigo);
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Titulo: " + titulo + "\n" +
                "Tipo: " + tipo + " | Categoria: " + categoria + "\n" +
                "Nivel: " + nivel + " | Duracion: " + duracion + " min" +
                " | Premium: " + (premium ? "Si" : "No");
    }
}
