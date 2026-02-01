package ejercicio1;

import java.util.ArrayList;

public class GestionAlumnos {
    // Lista privada para guardar datos
    private ArrayList<Alumno> listaAlumnos;

    public GestionAlumnos() {
        this.listaAlumnos = new ArrayList<>();
    }

    // Opcion 1, lista de alumnos
    public ArrayList<Alumno> obtenerLista() {
        return this.listaAlumnos;
    }

    // Opcion 2, añadir alumno nuevo
    public void agregarAlumno(Alumno nuevoAlumno) {
        listaAlumnos.add(nuevoAlumno);
    }

    // Opcion 3, modificar nota por nombre
    // Devuelve true si lo encontró y modificó, false si no existe
    public boolean modificarNota(String nombre, double nuevaNota) {
        for (Alumno al : listaAlumnos) {
            if (al.getNombre().equalsIgnoreCase(nombre)) {
                al.setNota(nuevaNota);
                return true;
            }
        }
        return false;
    }

    // Opcion 4, borrar alumno
    // Devuelve true si lo borró, false si no lo encontró
    public boolean borrarAlumno(String nombre) {
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Alumno al = listaAlumnos.get(i);
            if (al.getNombre().equalsIgnoreCase(nombre)) {
                listaAlumnos.remove(i);
                return true;
            }
        }
        return false;
    }
}
