package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Action;
import javafx.scene.Node;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class ControlScenaBuild  {
    
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
    void Registrarse(ActionEvent event ) {
         try {
            System.out.println("hola");
            // Cargar la nueva escena desde un archivo FXML
            Parent registrarVista = FXMLLoader.load(getClass().getResource("/util/gurdarUsuarioAdmin.fxml"));
            System.out.println(getClass().getResource("/util/gurdarUsuarioAdmin.fxml"));
            Scene nuevaEscena = new Scene(registrarVista);

            // Obtener el Stage actual
            Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Reemplazar la escena en la misma ventana
            stageActual.setScene(nuevaEscena);
            stageActual.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
