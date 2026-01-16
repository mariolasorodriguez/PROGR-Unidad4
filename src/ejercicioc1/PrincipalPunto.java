package ejercicioc1;

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
			p1.setX(p1.getX() + p3.getX());
			p1.setY(p1.getY() + p2.getX());
			
			// Modificamos las coordenadas del punto 2
			p2.setX(p3.getX() * p1.getY());
			p2.setY(p2.getY() * p3.getY());
			
			// Modificamos las coordenadas del punto 3
			p3.setX(p3.getX() - p1.getX());
			p3.setY(p3.getY() + p2.getY());
			
			
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
			System.out.println("PUNTO " + numero + ": Coordenada X: " + punto.getX() + " Coordenada Y: " + punto.getY());
		}
	}

