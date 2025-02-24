
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ventana extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Configurar la ventana principal (Stage)
        primaryStage.setTitle("Mi Aplicación JavaFX");

        // Crear un componente simple (Label)
        Label label = new Label("¡Hola, JavaFX!");

        // Crear una escena y añadir el componente
        Scene scene = new Scene(label, 300, 200);

        // Asignar la escena al Stage
        primaryStage.setScene(scene);

        // Mostrar la ventana
        primaryStage.show();
    
    }
    public static void main(String[] args) {
        launch(args);
    }
   
}