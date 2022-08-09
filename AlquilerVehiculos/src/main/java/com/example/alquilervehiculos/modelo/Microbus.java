package com.example.alquilervehiculos.modelo;

public class Microbus extends Vehiculo{
    private final double precioDia = 1.5;

    public Microbus(String matricula, int dias, TipoVehiculo tipoVehiculo) {
        super(matricula, dias, tipoVehiculo);
        setPrecio((getBaseDia()+precioDia)*getDias() + 2);
    }
}
