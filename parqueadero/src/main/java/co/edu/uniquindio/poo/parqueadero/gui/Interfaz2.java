package co.edu.uniquindio.poo.parqueadero.gui;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;

public class Interfaz2 {

    @FXML
    private Button estacionar;

    @FXML
    private TextField modelo;

    @FXML
    private TextField placa;

    @FXML
    private Button retirar;

    @FXML
    private TextField vehiculo;

    @FXML
    void initialize() {
        assert estacionar != null : "fx:id=\"estacionar\" was not injected: check your FXML file 'Interfaz2.fxml'.";
        assert modelo != null : "fx:id=\"modelo\" was not injected: check your FXML file 'Interfaz2.fxml'.";
        assert placa != null : "fx:id=\"placa\" was not injected: check your FXML file 'Interfaz2.fxml'.";
        assert retirar != null : "fx:id=\"retirar\" was not injected: check your FXML file 'Interfaz2.fxml'.";
        assert vehiculo != null : "fx:id=\"vehiculo\" was not injected: check your FXML file 'Interfaz2.fxml'.";

        vehiculo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (!newValue.matches("[a-zA-Z]*")) {

                    vehiculo.setText(newValue.replaceAll("[^a-zA-Z]", ""));
                }
            }
        });

        // Agrega un evento de clic al botón estacionar
        estacionar.setOnAction(event -> {
            // Verifica si alguno de los campos está vacío
            if (placa.getText().isEmpty() || modelo.getText().isEmpty() || vehiculo.getText().isEmpty()) {
                // Muestra un mensaje de error al usuario
                mostrarMensajeError("Debe completar todos los campos para estacionar el vehículo.");
            } else {
                // Muestra un mensaje de éxito al usuario
                mostrarMensajeExito("El vehículo ha sido estacionado exitosamente.");

            }
        });

        // Agrega un evento de clic al botón retirar
        retirar.setOnAction(event -> {
            // Verifica si alguno de los campos está vacío
            if (placa.getText().isEmpty() || modelo.getText().isEmpty() || vehiculo.getText().isEmpty()) {
                // Muestra un mensaje de error al usuario
                mostrarMensajeError("Debe completar todos los campos para retirar el vehículo.");
            } else {
                // Muestra un mensaje de éxito al usuario
                mostrarMensajeExito("El vehículo ha sido retirado exitosamente.");
            }
        });
    }

    // Método para mostrar un mensaje de error
    private void mostrarMensajeError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Método para mostrar un mensaje de éxito
    private void mostrarMensajeExito(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}