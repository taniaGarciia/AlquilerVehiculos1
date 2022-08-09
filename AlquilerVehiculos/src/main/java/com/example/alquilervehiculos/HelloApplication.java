package com.example.alquilervehiculos;

import com.example.alquilervehiculos.controlador.ControladorPrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Alquiler de vehiculos");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream( "iconos/camion.png")));
        ControladorPrincipal principal = fxmlLoader.getController();
        principal.initialize((BorderPane) root);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}