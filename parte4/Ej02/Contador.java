package Ej02;

/**
 * Clase que representa un contador
 * 
 * Contador > cont
 * - incrementar
 * - decrementar
 * 
 * Limitación: El contador nunca puede tener valores negativos
 */

public class Contador {
	
	private int cont;
	
	/**
	 * Constructor con valor inicial
	 */
	
	public Contador(int cont) {
		this.cont = cont;
	}
	
	/**
	 * Constructor por defecto
	 */
	
	public Contador() {
		this.cont = 0;
	}
	
	// Getter y Setter
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		if (cont >= 0) {
			this.cont = cont;
		}
	}
	/**
	 * Incrementar una unidad el contador
	 */
	
	public void incrementar() {
		incrementar(1);
	}
	
	/**
	 * Incrementar el contador en una unidad
	 * @param suma cantidad que se incrementa al contador
	 */
	
	public void incrementar(int suma) {
		if (suma >= 0) {
			cont += suma;
		}
	}
	
	/**
	 * Decrementar el contador en una unidad, si llega
	 * a negativo se establece en 0
	 */
	public void decrementar() {
		cont--;
		
		if (cont < 0) {
			cont = 0;
		}
	}
	
	/**
	 * Decrementa el contador en resta unidades
	 * @param resta cantidad en la que se reduce
	 */
	public void decrementar(int resta) {
		cont -= resta;
		
		if (cont < 0) {
			cont = 0;
		}
	}

	@Override
	public String toString() {
		return "Contador [cont=" + cont + "]";
	}

	
	
	
	
	
	
	
	
}
