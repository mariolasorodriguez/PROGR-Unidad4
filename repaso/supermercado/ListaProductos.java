package supermercado;

import java.util.ArrayList;

public class ListaProductos {

    private ArrayList<Producto> productos;

    public ListaProductos() {
        this.productos = new ArrayList<>();
    }

    /**
     * Añade un producto si no existe ya uno con el mismo codigo
     * @param producto producto a añadir
     * @return true si se añadio correctamente
     */
    boolean añadirProducto(Producto producto) {
        boolean añadido = false;
        if (!productos.contains(producto)) {
            productos.add(producto);
            añadido = true;
        }
        return añadido;
    }

    /**
     * Lista todos los productos
     */
    void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
                System.out.println("----------");
            }
        }
    }

    /**
     * Lista los productos con stock disponible
     */
    void listarProductosConStock() {
        boolean hayStock = false;
        for (Producto producto : productos) {
            if (producto.tieneStock()) {
                System.out.println(producto);
                System.out.println("----------");
                hayStock = true;
            }
        }
        if (!hayStock) {
            System.out.println("No hay productos con stock disponible.");
        }
    }

    /**
     * Busca un producto por su codigo
     * @param codigo codigo del producto
     * @return producto encontrado o null
     */
    Producto buscarPorCodigo(String codigo) {
        Producto encontrado = null;
        for (Producto producto : productos) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = producto;
            }
        }
        return encontrado;
    }

    /**
     * Modifica el precio de un producto
     * @param codigo codigo del producto
     * @param precio nuevo precio
     * @return true si se modifico correctamente
     */
    boolean modificarPrecio(String codigo, double precio) {
        boolean modificado = false;
        Producto encontrado = buscarPorCodigo(codigo);
        if (encontrado != null) {
            encontrado.setPrecio(precio);
            modificado = true;
        }
        return modificado;
    }

    /**
     * Elimina un producto por su codigo
     * @param codigo codigo del producto
     * @return true si se elimino correctamente
     */
    boolean eliminarProducto(String codigo) {
        boolean eliminado = false;
        Producto encontrado = buscarPorCodigo(codigo);
        if (encontrado != null) {
            productos.remove(encontrado);
            eliminado = true;
        }
        return eliminado;
    }

    /**
     * Retorna la lista de productos
     * @return lista de productos
     */
    ArrayList<Producto> getProductos() {
        return productos;
    }
}
