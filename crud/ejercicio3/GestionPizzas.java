package ejercicio3;

import java.util.ArrayList;

public class GestionPizzas {
    private ArrayList<Pizza> colaPedidos;

    public GestionPizzas() {
        this.colaPedidos = new ArrayList<>();
    }

    public ArrayList<Pizza> obtenerListado() {
        return colaPedidos;
    }

    public void nuevoPedido(String tipo, String tamano) {
        Pizza p = new Pizza(tipo, tamano);
        colaPedidos.add(p);
    }

    public boolean servirPizza(int codigo) {
        for (Pizza p : colaPedidos) {
            if (p.getCodigo() == codigo) {
                p.marcarComoServida();
                return true;
            }
        }
        return false;
    }
}
