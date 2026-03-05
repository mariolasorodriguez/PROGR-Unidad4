package ejercicio4;

import java.util.ArrayList;

public class ColeccionDiscos {
	private ArrayList<Disco> lista;

	public ColeccionDiscos() {
		this.lista = new ArrayList<>();
	}

	public ArrayList<Disco> listar() {
		return lista;
	}

	public boolean nuevoDisco(Disco d) {
		if (lista.contains(d)) {
			return false;
		}
		lista.add(d);
		return true;
	}

	public boolean borrarDisco(String codigo) {
		Disco discoParaBorrar = new Disco(codigo, null, null, 0, null);

		return lista.remove(discoParaBorrar);
	}
}
