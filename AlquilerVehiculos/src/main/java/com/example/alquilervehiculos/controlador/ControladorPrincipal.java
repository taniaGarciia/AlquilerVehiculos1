package com.example.alquilervehiculos.controlador;
import com.example.alquilervehiculos.HelloApplication;
import com.example.alquilervehiculos.modelo.TipoVehiculo;
import com.example.alquilervehiculos.modelo.Vehiculo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ControladorPrincipal {
    private BorderPane borderPane;
    private ControladorMenuVehiculo controladorMenuVehiculo;
    private ControladorAlquilados controladorAlquilados;
    private Parent parentVehiculos;
    private Parent parentAlquilados;

    public void initialize(BorderPane root) throws IOException {
        this.borderPane = root;
        FXMLLoader fxmlLoaderVehiculos = new FXMLLoader(HelloApplication.class.getResource("VistaVehiculos.fxml"));
        FXMLLoader fxmlLoaderAlquilados = new FXMLLoader(HelloApplication.class.getResource("VistaAlquilados.fxml"));
        parentVehiculos = fxmlLoaderVehiculos.load();
        parentAlquilados = fxmlLoaderAlquilados.load();
        controladorAlquilados = fxmlLoaderAlquilados.getController();
        controladorMenuVehiculo = fxmlLoaderVehiculos.getController();
        controladorMenuVehiculo.initialize(this);
        mostrarMenuCoche();
    }

    public void alquilarVehiculo(Vehiculo vehiculo){
        controladorAlquilados.alquilarVehiculo(vehiculo);
    }

    @FXML
    void mostrarMenuAlquilados(MouseEvent event) throws IOException {
        borderPane.setCenter(parentAlquilados);
    }

    @FXML
    void mostrarMenuCamion(MouseEvent event) throws IOException {
        borderPane.setCenter(parentVehiculos);
        controladorMenuVehiculo.cargarInterfaz(TipoVehiculo.CAMION);
    }

    @FXML
    void mostrarMenuCoche() throws IOException {
        borderPane.setCenter(parentVehiculos);
        controladorMenuVehiculo.cargarInterfaz(TipoVehiculo.COCHE);
    }

    @FXML
    void mostrarMenuFurgoneta(MouseEvent event) throws IOException {
        borderPane.setCenter(parentVehiculos);
        controladorMenuVehiculo.cargarInterfaz(TipoVehiculo.FURGONETA);
    }

    @FXML
    void mostrarMenuMicrobus(MouseEvent event) throws IOException {
        borderPane.setCenter(parentVehiculos);
        controladorMenuVehiculo.cargarInterfaz(TipoVehiculo.MICROBUS);
    }

}

