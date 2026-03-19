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
    	for (Articulo articulo : inventario) {
            if (articulo.getCodigo().equalsIgnoreCase(codigo)) {
                return articulo;
            }
        }
        return null; 
    }

    public void alta(Articulo articulo) {
        inventario.add(articulo);
    }

    public boolean baja(String codigo) {
        Articulo articulo = buscarArticulo(codigo);
        boolean eliminado = false;
        if (articulo != null) {
            inventario.remove(articulo);
            eliminado = true;
        }
        return eliminado;
    }
    
    public boolean modificarArticulo(String codigo, 
    								String nuevaDescripcion, 
    								double nuevoPrecioCompra, 
    								double nuevoPrecioVenta) {
    	
		Articulo articulo = buscarArticulo(codigo);
		boolean modificado = false;
		if (articulo != null) {
			articulo.setDescripcion(nuevaDescripcion);
			articulo.setPrecioCompra(nuevoPrecioCompra);
			articulo.setPrecioVenta(nuevoPrecioVenta);
			modificado = true;
		}
		return modificado;
	}
}