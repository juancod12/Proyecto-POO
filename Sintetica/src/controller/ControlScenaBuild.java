package controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControlScenaBuild {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private Button registrarse;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }
     @FXML
    void Registrarse(ActionEvent event) {

        Stage primaryStage = (Stage)registrarse.getScene().getWindow();
        primaryStage.close();

        // Crear una nueva ventana
        Stage nuevaVentana = new Stage();
        nuevaVentana.setTitle("Registro");

        // Crear la escena para la nueva ventana
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 200);

        // Aquí puedes agregar más elementos a la nueva ventana
        Button btnNuevo = new Button("Nueva Ventana");
        root.getChildren().add(btnNuevo);

        // Mostrar la nueva ventana
        nuevaVentana.setScene(scene);
        nuevaVentana.show();
    }
}
