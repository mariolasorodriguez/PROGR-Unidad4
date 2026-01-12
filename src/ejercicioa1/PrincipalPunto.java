package ejercicioa1;

public class PrincipalPunto {
	public static void main(String[] args) {
		
		// Creamos el primer objeto
		Punto p1 = new Punto();
		
		// Rellenamos las coordenadas
		p1.x = 5;
		p1.y = 0;
		
		
		// Creamos el segundo objeto
		Punto p2 = new Punto();
		
		// Rellenamos las coordenadas
		p2.x = 10;
		p2.y = 10;
		
		
		// Creamos el tercer objeto
		Punto p3 = new Punto();
		
		// Rellenamos las coordenadas
		p3.x = -3;
		p3.y = 7;
		
		// Mostramos por pantalla las coordenadas
		System.out.println("-- Coordenadas --");
		System.out.println("PUNTO 1: Coordenada X: " + p1.x + " Coordenada Y: " + p1.y);
		System.out.println("PUNTO 2: Coordenada X: " + p2.x + " Coordenada Y: " + p2.y);
		System.out.println("PUNTO 3: Coordenada X: " + p3.x + " Coordenada Y: " + p3.y);

		// Modificamos las coordenadas del punto 1
		p1.x = p1.x + p3.x;
		p1.y += p2.x;
		
		// Modificamos las coordenadas del punto 2
		p2.x = p3.x * p1.y;
		p2.y *= p3.y;
		
		// Modificamos las coordenadas del punto 3
		p3.x -= p1.x;
		p3.y += p2.y;
		
		
		// Mostramos por pantalla las coordenadas modificadas
		System.out.println("-- Coordenadas modificadas --");
		System.out.println("PUNTO 1: Coordenada X: " + p1.x + " Coordenada Y: " + p1.y);
		System.out.println("PUNTO 2: Coordenada X: " + p2.x + " Coordenada Y: " + p2.y);
		System.out.println("PUNTO 3: Coordenada X: " + p3.x + " Coordenada Y: " + p3.y);
	}
}
