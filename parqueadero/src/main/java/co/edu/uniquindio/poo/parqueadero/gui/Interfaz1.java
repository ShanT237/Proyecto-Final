package co.edu.uniquindio.poo.parqueadero.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Interfaz1 {

    @FXML
    private TextField ID;

    @FXML
    private Button Ingresar;

    @FXML
    private TextField Nombre;

    @FXML
    private Stage stage;

    @FXML
    void initialize() {
        assert ID != null : "fx:id=\"ID\" was not injected: check your FXML file 'Interfaz.fxml'.";
        assert Ingresar != null : "fx:id=\"Ingresar\" was not injected: check your FXML file 'Interfaz.fxml'.";
        assert Nombre != null : "fx:id=\"Nombre\" was not injected: check your FXML file 'Interfaz.fxml'.";

        // Limitar entrada a solo números en el campo de ID
        ID.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                ID.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // Limitar entrada a solo letras en el campo de nombre
        Nombre.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z]*")) {
                Nombre.setText(newValue.replaceAll("[^a-zA-Z]", ""));
            }
        });

        // Agregar evento de clic al botón "Ingresar"
        Ingresar.setOnAction(event -> {
            // Verificar si los campos de texto de nombre y ID están llenos
            if (!Nombre.getText().isEmpty() && !ID.getText().isEmpty()) {
                // Cerrar la ventana actual
                stage.close();

                // Cargar la nueva ventana o realizar otras acciones aquí
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Interfaz2.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Interfaz 2");
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Mostrar un mensaje de error al usuario indicando que ambos campos son
                // obligatorios
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Debe ingresar un nombre y un ID.");
                alert.showAndWait();
            }
        });
    }

    // Método para configurar la ventana como no redimensionable
    public void setStageNonResizable(Stage stage) {
        this.stage = stage;
        stage.setResizable(false);
    }
}