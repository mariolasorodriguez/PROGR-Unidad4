package gestionempleados;

import java.util.Objects;

public class Empleado {

    private String dni;
    private String nombre;
    private double sueldoBase;
    private int horasExtra;
    private static double importeHoraExtra;

    public Empleado(String dni, String nombre, double sueldoBase, int horasExtra) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.horasExtra = horasExtra;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public double getSueldoBase() { return sueldoBase; }
    public int getHorasExtra() { return horasExtra; }

    public void setHorasExtra(int horasExtra) { this.horasExtra = horasExtra; }
    public void setSueldoBase(double sueldoBase) { this.sueldoBase = sueldoBase; }

    public static double getImporteHoraExtra() { return importeHoraExtra; }
    public static void setImporteHoraExtra(double importeHoraExtra) {
        Empleado.importeHoraExtra = importeHoraExtra;
    }

    /**
     * Calcula el complemento por horas extra
     * @return horas extra multiplicadas por el importe de la hora extra
     */
    double calcularComplemento() {
        return horasExtra * importeHoraExtra;
    }

    /**
     * Calcula el sueldo bruto del empleado
     * @return sueldo base mas complemento por horas extra
     */
    double sueldoBruto() {
        return sueldoBase + calcularComplemento();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(dni, empleado.dni);
    }

    @Override
    public String toString() {
        return dni + " " + nombre + "\n" +
                "Horas Extras: " + horasExtra + "\n" +
                "Sueldo bruto: " + sueldoBruto();
    }
}
