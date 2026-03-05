package ejercicio5;

import java.util.ArrayList;

public class GestionBanco {
	private ArrayList<CuentaCorriente> listaCuentas;

	public GestionBanco() {
		this.listaCuentas = new ArrayList<>();
	}

	public ArrayList<CuentaCorriente> listar() {
		return listaCuentas;
	}

	public boolean abrirCuenta(CuentaCorriente nuevaCuenta) {
		if (buscarPorDni(nuevaCuenta.getDni()) == null) {
			listaCuentas.add(nuevaCuenta);
			return true;
		}
		return false; 
	}

	public CuentaCorriente buscarPorDni(String dni) {
		for (CuentaCorriente c : listaCuentas) {
			if (c.getDni().equalsIgnoreCase(dni)) {
				return c;
			}
		}
		return null;
	}

	public boolean cerrarCuenta(String dni) {
		CuentaCorriente c = buscarPorDni(dni);
		if (c != null) {
			listaCuentas.remove(c);
			return true;
		}
		return false;
	}
}
