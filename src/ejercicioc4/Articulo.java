package ejercicioc4;

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
	
	private String nombre;
	private double precio;
	private int iva;
	private int cuantosQuedan;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getCuantosQuedan() {
		return cuantosQuedan;
	}
	public void setCuantosQuedan(int cuantosQuedan) {
		this.cuantosQuedan = cuantosQuedan;
	}
	
}
