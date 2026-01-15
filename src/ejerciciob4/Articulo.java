package ejerciciob4;

public class Articulo {
	
	public Articulo(String nombre, double precio, int iva, int cuantosQuedan) {
		if (!nombre.isBlank()) {
			this.nombre = nombre;
		} if (precio > 0) { 
			this.precio = precio;
		} if (iva >= 0 && iva < precio) {
			this.iva = iva;
		} if (cuantosQuedan > 0) {
			this.cuantosQuedan = cuantosQuedan;
		}
	}
	
	String nombre;
	double precio;
	int iva;
	int cuantosQuedan;
}
