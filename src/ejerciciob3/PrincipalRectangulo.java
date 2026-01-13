package ejerciciob3;

public class PrincipalRectangulo {
	public static void main(String[] args) {
		
		// Creamos los objetos
		Rectangulo r1 = new Rectangulo(0,0,5,5);
       
        Rectangulo r2 = new Rectangulo(7,9,2,3);

        System.out.println("--- ESTADO INICIAL ---");
        imprimirDetalles(r1, "Rectángulo 1");
        imprimirDetalles(r2, "Rectángulo 2");

        // Modificamos los datos
        r1.x2 = 10; 
        r1.y2 = 10;
        r2.x1 = 1;  
        r2.y1 = 1;

        System.out.println("--- TRAS MODIFICAR ---");
        imprimirDetalles(r1, "Rectángulo 1");
        imprimirDetalles(r2, "Rectángulo 2");
    }

    /* @param Funcion que obtiene la base del rectangulo y la devuelve */
    static int obtenerBase(Rectangulo r) {
        return Math.abs(r.x2 - r.x1);
    }

    /* @param Funcion que obtiene la altura del rectangulo y la devuelve */
    static int obtenerAltura(Rectangulo r) {
        return Math.abs(r.y2 - r.y1);
    }

    /* @param Funcion que obtiene el area del rectangulo y la devuelve */
    static int calcularArea(Rectangulo r) {
        return obtenerBase(r) * obtenerAltura(r);
    }

    /* @param Funcion que obtiene el perimetro del rectangulo */
    static int calcularPerimetro(Rectangulo r) {
        return 2 * (obtenerBase(r) + obtenerAltura(r));
    }

    /* @param Funcion que imprime los datos del objeto, base, perimetro y altura */
    static void imprimirDetalles(Rectangulo r, String nombre) {
        System.out.println(nombre + " (" + r.x1 + "," + r.y1 + ") a (" + r.x2 + "," + r.y2 + ")");
        System.out.println("  > Base: " + obtenerBase(r) + " Altura: " + obtenerAltura(r));
        System.out.println("  > Perímetro: " + calcularPerimetro(r));
        System.out.println("  > Área: " + calcularArea(r));
		
	}
}
