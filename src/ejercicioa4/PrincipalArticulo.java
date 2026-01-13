package ejercicioa4;

public class PrincipalArticulo {
	public static void main(String[] args) {
		
		// Creamos el objeto articulo
		Articulo art = new Articulo();
		
		// Definimos valores para el producto
		art.nombre = "Camiseta Amate";
		art.precio = 13;
		art.cuantosQuedan = 10;
		
		// Mostramos el producto por pantalla
		System.out.println(art.nombre + " | Precio: " + art.precio + " | IVA: 21% " + " | PVP: " + (art.precio + art.precio * art.cantIva));
		
		// Modificamos los precios
		art.nombre = "Camiseta Amate";
		art.precio = 18;
		art.cuantosQuedan = 10;
		
		// Mostramos el producto por pantalla modificado
		System.out.println(art.nombre + " | Precio: " + art.precio + " | IVA: 21% " + " | PVP: " + (art.precio + art.precio * art.cantIva));
	}
}
