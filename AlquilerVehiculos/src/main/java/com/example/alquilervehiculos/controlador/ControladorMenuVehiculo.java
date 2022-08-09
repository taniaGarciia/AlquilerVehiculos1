package com.example.alquilervehiculos.controlador;

import com.example.alquilervehiculos.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class ControladorMenuVehiculo {

    @FXML
    private HBox contenedorPMA;

    @FXML
    private Label disponible;

    @FXML
    private Label lblPrecio;

    @FXML
    private Separator separadorPMA;

    @FXML
    private Label lblTipoVehiculo;

    @FXML
    private TextField txtCantidadDias;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtPMA;

    private  ControladorPrincipal principal;

    private TipoVehiculo tipoVehiculo;

    private Vehiculo vehiculo;

    public void initialize(ControladorPrincipal principal){
        this.principal = principal;
    }

    public void cargarInterfaz(TipoVehiculo vehiculo){
        limpiarDatosAutomaticamente();
        tipoVehiculo = vehiculo;
        switch (vehiculo){
            case COCHE: this.lblTipoVehiculo.setText(String.valueOf(TipoVehiculo.COCHE));
            contenedorPMA.setVisible(false);
            separadorPMA.setVisible(false);
            break;
            case MICROBUS: this.lblTipoVehiculo.setText(String.valueOf(TipoVehiculo.MICROBUS));
                contenedorPMA.setVisible(false);
                separadorPMA.setVisible(false);
            break;
            case FURGONETA: this.lblTipoVehiculo.setText(String.valueOf(TipoVehiculo.FURGONETA));
                contenedorPMA.setVisible(true);
                separadorPMA.setVisible(true);
            break;
            case CAMION: this.lblTipoVehiculo.setText(String.valueOf(TipoVehiculo.CAMION));
                contenedorPMA.setVisible(true);
                separadorPMA.setVisible(true);
        }
    }

    @FXML
    void CalcularPrecio(ActionEvent event) {
        if (txtMatricula.getText() != "" && txtCantidadDias.getText() != "") {
            String matricula = txtMatricula.getText();
            int dias = Integer.parseInt(txtCantidadDias.getText());
            switch (tipoVehiculo) {
                case COCHE:
                    vehiculo = new Coche(matricula, dias, tipoVehiculo);
                    break;
                case MICROBUS:
                    vehiculo = new Microbus(matricula, dias, tipoVehiculo);
                    break;
                case FURGONETA:
                    if (txtPMA.getText() != "")
                    vehiculo = new Furgoneta(matricula, dias, tipoVehiculo, Double.parseDouble(txtPMA.getText()));
                    else
                        alertaError("Verifique los datos");
                    break;
                case CAMION:
                    if (txtPMA.getText() != "")
                    vehiculo = new Camion(matricula, dias, tipoVehiculo, Double.parseDouble(txtPMA.getText()));
                    else
                    alertaError("Verifique los datos");
            }
            lblPrecio.setText(String.valueOf(vehiculo.getPrecio()));
        }else{
            alertaError("Verifique los datos");
        }
    }

    @FXML
    void alquilarVehiculo(ActionEvent event) {
        if (vehiculo != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Desea alquilar el vehiculo?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                principal.alquilarVehiculo(vehiculo);
                alertaInformacion("¡Vehiculo alquilado exitosamente!");
                limpiarDatosAutomaticamente();
            }
        }else{
            alertaError("Debe calcular el precio");
        }
    }

    @FXML
    void limpiarDatos() {
        limpiarDatosAutomaticamente();
        alertaInformacion("Datos limpiados correctamente");
    }

    void limpiarDatosAutomaticamente() {
        txtMatricula.clear();
        txtCantidadDias.clear();
        txtPMA.clear();
        lblPrecio.setText("0.0");

        vehiculo = null;
    }

    private void alertaInformacion (String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void alertaError (String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
