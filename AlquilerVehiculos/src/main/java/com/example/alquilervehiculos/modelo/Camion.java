package com.example.alquilervehiculos.modelo;

public class Camion extends Vehiculo{
    private double PMA;

    public Camion(String matricula, int dias, TipoVehiculo tipoVehiculo, double PMA) {
        super(matricula, dias, tipoVehiculo);
        this.PMA = PMA;
        setPrecio(getBaseDia()*getDias() + 20*PMA + 40);
    }
}
