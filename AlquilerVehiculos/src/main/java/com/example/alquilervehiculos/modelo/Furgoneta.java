package com.example.alquilervehiculos.modelo;

public class Furgoneta extends Vehiculo{
    private double PMA;

    public Furgoneta(String matricula, int dias, TipoVehiculo tipoVehiculo, double PMA) {
        super(matricula, dias, tipoVehiculo);
        this.PMA = PMA;
        setPrecio(getBaseDia()*getDias() + 20*PMA);
    }
}
