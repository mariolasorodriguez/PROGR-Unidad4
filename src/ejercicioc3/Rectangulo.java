package ejercicioc3;

public class Rectangulo {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
    Rectangulo(int x1, int y1, int x2, int y2) {
        // Validamos que (x1,y1) sea la esquina inferior izquierda
        // y (x2,y2) la superior derecha.
        // Es decir: x1 debe ser menor que x2, e y1 menor que y2.
        if (x1 < x2 && y1 < y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        } else {
            // Opcional: Mensaje para saber que falló la validación
            System.out.println("¡Error! Coordenadas inválidas al crear el rectángulo: (" 
                               + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")");
        }
    }

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
    
}
