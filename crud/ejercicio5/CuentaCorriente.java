package ejercicio5;

enum Nacionalidad {
	ESPANOLA, EXTRANJERA
}

public class CuentaCorriente {
	private String dni;
	private String nombre;
	private double saldo;
	private Nacionalidad nacionalidad;

	public CuentaCorriente(String dni, double saldoInicial) {
		this(dni, "Desconocido", saldoInicial, Nacionalidad.ESPANOLA);
	}

	public CuentaCorriente(String dni, String nombre, double saldoInicial) {
		this(dni, nombre, saldoInicial, Nacionalidad.ESPANOLA);
	}

	public CuentaCorriente(String dni, String nombre, double saldoInicial, Nacionalidad nacionalidad) {
		this.dni = dni;
		this.nombre = nombre;
		this.saldo = saldoInicial;
		this.nacionalidad = nacionalidad;
	}

	public CuentaCorriente(String dni) {
		this.dni = dni;
		this.nombre = "";
		this.saldo = 0;
		this.nacionalidad = Nacionalidad.ESPANOLA;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public boolean ingresarDinero(double cantidad) {
		if (cantidad > 0) {
			this.saldo += cantidad;
			return true;
		}
		return false;
	}

	public boolean sacarDinero(double cantidad) {
		if (cantidad > 0 && this.saldo >= cantidad) {
			this.saldo -= cantidad;
			return true;
		}
		return false;
	}

	public String toString() {
		return "DNI: " + dni + " | Titular: " + nombre + " | Saldo: " + saldo + "€ | " + nacionalidad;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		CuentaCorriente otra = (CuentaCorriente) obj;

		return this.dni.equalsIgnoreCase(otra.dni) && this.nombre.equalsIgnoreCase(otra.nombre);
	}
}
