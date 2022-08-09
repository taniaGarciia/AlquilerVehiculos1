package com.example.alquilervehiculos.modelo;

public class Vehiculo {
    private String matricula;
    private int dias;
    private final double baseDia = 50;
    private double precio;
    private TipoVehiculo tipoVehiculo;

    public Vehiculo(String matricula, int dias, TipoVehiculo tipoVehiculo) {
        this.matricula = matricula;
        this.dias = dias;
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getBaseDia() {
        return baseDia;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getDias() {
        return dias;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
}
