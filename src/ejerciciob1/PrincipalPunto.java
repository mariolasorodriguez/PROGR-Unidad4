package ejerciciob1;

public class PrincipalPunto {
	public static void main(String[] args) {
		
		// Creamos el primer objeto pasandole los argumentos 
		Punto p1 = new Punto(5,0);
		
		// Creamos el segundo objeto pasandole los argumentos 
		Punto p2 = new Punto(10,10);
		
		// Creamos el tercer objeto pasandole los argumentos 
		Punto p3 = new Punto(-3,7);
		
		System.out.println("-- Coordenadas --");
		imprimirCoordenadas(1, p1);
		imprimirCoordenadas(2, p2);
		imprimirCoordenadas(3, p3);
		

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
		imprimirCoordenadas(1, p1);
		imprimirCoordenadas(2, p2);
		imprimirCoordenadas(3, p3);

	}
	
	/*
	 * @param Función para imprimir por pantalla las coordenadas dependiendo del numero de objeto
	 */
	public static void imprimirCoordenadas(int numero, Punto punto) {
		System.out.println("PUNTO " + numero + ": Coordenada X: " + punto.x + " Coordenada Y: " + punto.y);
	}
}
