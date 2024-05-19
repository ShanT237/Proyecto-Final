module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.logging;
    requires javafx.base;


    opens co.edu.uniquindio.poo.parqueadero to javafx.fxml;
    exports co.edu.uniquindio.poo.parqueadero;
    opens co.edu.uniquindio.poo.parqueadero.gui to javafx.fxml;
    exports co.edu.uniquindio.poo.parqueadero.gui;
}