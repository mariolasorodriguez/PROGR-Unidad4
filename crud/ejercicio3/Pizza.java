package ejercicio3;

public class Pizza {
    private static int contadorPedidos = 0;
    
    private int codigo;
    private String tipo;
    private String tamano;
    private String estado;

    public Pizza(String tipo, String tamano) {
        contadorPedidos++;
        this.codigo = contadorPedidos;
        this.tipo = tipo;
        this.tamano = tamano;
        this.estado = "PEDIDA";
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void marcarComoServida() {
        this.estado = "SERVIDA";
    }

    public String toString() {
        return "Ticket #" + codigo + " | " + tipo + " (" + tamano + ") - Estado: " + estado;
    }
}
