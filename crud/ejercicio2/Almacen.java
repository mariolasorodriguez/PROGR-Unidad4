package ejercicio2;

import java.util.ArrayList;

public class Almacen {
    private ArrayList<Articulo> inventario;

    public Almacen() {
        this.inventario = new ArrayList<>();
    }

    public ArrayList<Articulo> listar() {
        return inventario;
    }

    public Articulo buscarArticulo(String codigo) {
        for (Articulo a : inventario) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                return a;
            }
        }
        return null; 
    }

    public void alta(Articulo articulo) {
        inventario.add(articulo);
    }

    public boolean baja(String codigo) {
        Articulo a = buscarArticulo(codigo);
        if (a != null) {
            inventario.remove(a);
            return true;
        }
        return false;
    }
}