module com.example.alquilervehiculos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.alquilervehiculos.controlador to javafx.fxml;
    exports com.example.alquilervehiculos;
}