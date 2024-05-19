package co.edu.uniquindio.poo.parqueadero.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar la Interfaz1
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interfaz.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("UQ");
        primaryStage.setScene(new Scene(root, 650, 400));

        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Images/Icon.png")));

        // Obtener el controlador de la Interfaz1
        Interfaz1 controller = loader.getController();

        // Configurar la ventana principal como no redimensionable
        controller.setStageNonResizable(primaryStage);

        // Mostrar la ventana principal
        primaryStage.show();

        // Evento para cerrar la ventana principal
        primaryStage.setOnCloseRequest(event -> {

        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}