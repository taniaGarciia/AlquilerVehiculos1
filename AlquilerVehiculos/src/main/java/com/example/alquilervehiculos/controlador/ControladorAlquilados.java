package com.example.alquilervehiculos.controlador;

import com.example.alquilervehiculos.modelo.Vehiculo;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorAlquilados {

    @FXML
    private TableColumn<VehiculoAlquilado, String> cmDias;

    @FXML
    private TableColumn<VehiculoAlquilado, String> cmMatricula;

    @FXML
    private TableColumn<VehiculoAlquilado, String> cmPrecio;

    @FXML
    private TableColumn<VehiculoAlquilado, String> cmTipo;

    @FXML
    private TableView<VehiculoAlquilado> tablaVehiculos;

    private ObservableList<VehiculoAlquilado> vehiculosAlquilados = FXCollections.observableArrayList();

    public void initialize(){
        cmMatricula.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());
        cmTipo.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
        cmDias.setCellValueFactory(cellData -> cellData.getValue().diasProperty());
        cmPrecio.setCellValueFactory(cellData -> cellData.getValue().precioProperty());

        tablaVehiculos.setItems(vehiculosAlquilados);
    }

    public void alquilarVehiculo(Vehiculo vehiculo){
        StringProperty matricula = new SimpleStringProperty(vehiculo.getMatricula());
        StringProperty tipo = new SimpleStringProperty(vehiculo.getTipoVehiculo().toString());
        StringProperty dias = new SimpleStringProperty(String.valueOf(vehiculo.getDias()));
        StringProperty precio = new SimpleStringProperty(String.valueOf(vehiculo.getPrecio()));

        vehiculosAlquilados.add(new VehiculoAlquilado(matricula, tipo, dias, precio));
    }

    private class VehiculoAlquilado{
        private StringProperty matricula;
        private StringProperty tipo;
        private StringProperty dias;
        private StringProperty precio;

        public VehiculoAlquilado(StringProperty matricula, StringProperty tipo, StringProperty dias, StringProperty precio) {
            this.matricula = matricula;
            this.tipo = tipo;
            this.dias = dias;
            this.precio = precio;
        }

        public StringProperty matriculaProperty() {
            return matricula;
        }

        public StringProperty tipoProperty() {
            return tipo;
        }

        public StringProperty diasProperty() {
            return dias;
        }

        public StringProperty precioProperty() {
            return precio;
        }
    }

}