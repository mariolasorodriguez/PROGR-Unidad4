package ejerciciob4;

public class PrincipalArticulo {
	public static void main(String[] args) {
		
		// Creamos el objeto articulo
		Articulo articulo1 = new Articulo("Pijama", 10.0, 21, 50);
		Articulo articulo2 = new Articulo("Zapatos", 25.0, 21, 30);
		
		mostrar(articulo1);
		mostrar(articulo2);
		
	}
	
	static void mostrar(Articulo articulo) {
		System.out.println("------------ TICKET ARTICULO --------------");
		System.out.println(articulo.nombre + " | PRECIO: " + articulo.precio + "€ | IVA: " + articulo.iva + "% | STOCK: " + articulo.cuantosQuedan + "ud(s)");
	}
}
