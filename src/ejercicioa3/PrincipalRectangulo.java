package ejercicioa3;

public class PrincipalRectangulo {
	public static void main(String[] args) {
		Rectangulo r1 = new Rectangulo();
		
		Rectangulo r2 = new Rectangulo();
		
		r1.x1 = 0;
		r1.y1 = 0;
		
		r1.x2 = 5;
		r1.y2 = 5;
		
		r2.x1 = 7;
		r2.y1 = 9;
		
		r2.x2 = 2;
		r2.y2 = 3;
		
		// Mostramos por pantalla las coordenadas
		System.out.println("Rectangulo 1: ");
		System.out.println("Vértice 1: " + "(" + r1.x1 + "," + r1.y1 + ")");
		System.out.println("Vértice 2: " + "(" + r1.x2 + "," + r1.y2 + ")");
		
		
		System.out.println("Rectangulo 2: ");
		System.out.println("Vértice 1: " + "(" + r2.x1 + "," + r2.y1 + ")");
		System.out.println("Vértice 2: " + "(" + r2.x2 + "," + r2.y2 + ")");
		
		
	}
	
	public double calculoPerimetro(double perimetro) {
		perimetro = 2 * 0;
		
		return perimetro;
		
	}

}
