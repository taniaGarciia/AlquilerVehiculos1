package com.example.alquilervehiculos.modelo;

public class Coche extends Vehiculo{
    private final double precioDia = 1.5;

    public Coche(String matricula, int dias, TipoVehiculo tipoVehiculo) {
        super(matricula, dias, tipoVehiculo);
        setPrecio((getBaseDia()+precioDia)*getDias());
    }
}
