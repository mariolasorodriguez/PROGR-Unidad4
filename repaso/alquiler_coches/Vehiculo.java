package alquiler_coches;

import java.util.Objects;

public class Vehiculo {

    private String matricula;
    private String modelo;
    private double precioBasePorDia = 0;
    private double porcentajeRecargo;
    private int diasAlquilados;
    private static double precioSeguroDiario = 0;

    public Vehiculo(String matricula, String modelo, double precioBasePorDia, double porcentajeRecargo, int diasAlquilados) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.porcentajeRecargo = porcentajeRecargo;
        this.precioBasePorDia = precioBasePorDia;
        this.diasAlquilados = diasAlquilados;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioBasePorDia() {
        return precioBasePorDia;
    }

    public void setPrecioBasePorDia(double precioBasePorDia) {
        this.precioBasePorDia = precioBasePorDia;
    }

    public double getPorcentajeRecargo() {
        return porcentajeRecargo;
    }

    public void setPorcentajeRecargo(double porcentajeRecargo) {
        this.porcentajeRecargo = porcentajeRecargo;
    }

    public int getDiasAlquilados() {
        return diasAlquilados;
    }

    public void setDiasAlquilados(int diasAlquilados) {
        this.diasAlquilados = diasAlquilados;
    }

    public static double getPrecioSeguroDiario() {
        return precioSeguroDiario;
    }

    public static void setPrecioSeguroDiario(double precioSeguroDiario) {
        Vehiculo.precioSeguroDiario = precioSeguroDiario;
    }

    /**
     * Metodo que devuelve el importe del recargo premium
     *
     * @return importeRecargoPremium
     */
    double importeRecargoPremium() {
        return precioBasePorDia * porcentajeRecargo / 100;
    }

    /**
     * Metodo que devuelva el importe total del seguro
     *
     * @return importeTotalSeguro
     */
    double importeTotalSeguro() {
        return diasAlquilados * precioSeguroDiario;
    }

    /**
     * Metodo que calcula el ingreso total que ha generado el vehiculo
     * @return ingresoTotalVehiculo
     */
    double ingresoTotalVehiculo() {
        return precioBasePorDia + importeRecargoPremium() + importeTotalSeguro();
    }

    /**
     * Metodo que devuelve true o false dependiendo si el recargo premium es mayor a 12
     * @return porcentajeRecargo > 12
     */
    boolean esPremium() {
        return porcentajeRecargo > 12;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public String toString() {
        return matricula + " - " + modelo + "\n" +
                "Precio Base/Dia: " + precioBasePorDia + " | Recargo Premium: " + importeRecargoPremium() + " (" + (int) porcentajeRecargo + "%)\n" +
                "Dias alquilado: " + diasAlquilados + " | Total Generado: " + ingresoTotalVehiculo();
    }


}

