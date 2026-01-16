package ejercicioc1;

	public class Punto {
		
		public Punto(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		private int x;
		private int y;
		
		// Creamos los get para obtener la variable x
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		// Y un set para que se pueda modificar
		public void setX(int x) {
			this.x = x;
		}
		
		public void setY(int y) {
			this.y = y;
		}
	}

