package App;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import Sqlconexion.Conexion;
import controller.ControlScenaBuild;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class ventana extends Application {
    Parent root;
   
    
    @Override
    public void start(Stage primaryStage) {
        try {
            
            root = FXMLLoader.load(getClass().getResource("/util/login.fxml"));    //se cargan los recursos y se pone la ruta del fxml
            Scene scene =new Scene(root);         //se crea la scena y como parametro le pasamos los recursos
            
            primaryStage.setTitle("SinteticaAAP");
            primaryStage.setScene(scene);
            primaryStage.show();
            

        } catch (IOException e) {
           e.printStackTrace(); // TODO: handle exception
        }
        
    
    }

    public static void main(String[] args) throws Exception {
        Connection  conexion =  Conexion.conectar();
      

        if (conexion != null) {
            try {
                // Cerrar la conexión
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        launch(args);
    
    }
   
}