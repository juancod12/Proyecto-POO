package controller;
import java.io.IOException;

import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;



import javafx.scene.Node;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


import javafx.stage.Stage;
import model.Administrador;
public class ControlScenaBuild  {
    
    @FXML
    private ResourceBundle resources;
    @FXML
    private Button registrarse;
    
    
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField password;


    @FXML
    private Label texusuario;
    @FXML
    private Label texpassword;
    
    @FXML
    private Label texprogresbar;
    @FXML
    private ProgressBar progresbar;

    @FXML
    private Button guardarDatos;
    @FXML
    private URL location;
    @FXML
    void initialize() {
        
        
    }

    // accion del boton donde la se crea una nueva ventana para registrar los datos del usuario
    @FXML
    void Registrarse(ActionEvent event ) {
        try {
            
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
    //accion del botton para guardar los datos en la base de datos
    @FXML
    void GuardarDatos(ActionEvent event){

        

        String us = usuario.getText();
        String clave = password.getText();

        System.out.println("usurario: " + us + "contraseña: "+clave);


        if (us.isEmpty() || clave.isEmpty()) {
        System.out.println("❌ Por favor, complete todos los campos.");
        return;
        }
        boolean exito = Administrador.registrarUsuario(us, clave);
        if (exito) {
        System.out.println("✅ Usuario registrado correctamente.");
        } else {
        System.out.println("❌ Error al registrar usuario.");
        }
    
    }

    @FXML
    void IniciarSesion(ActionEvent event) {

        //Obtener el nombre de usuario y la contraseña
        String us = usuario.getText();
        String clave = password.getText();

        //Verificar si los campos están vacíos
        if (us.isEmpty() || clave.isEmpty()) {
            mensajeError.setText("❌ Por favor, complete todos los campos.");
            mensajeError.setVisible(true);
            return;
        }

        
        //Validar las credenciales contra la base de datos
        boolean loginExitoso = Administrador.login(us, clave);
        if (loginExitoso) {
            System.out.println("✅ Inicio de sesión exitoso.");
            //ocultar los label y poner la barra de progreso
            

           
                usuario.setVisible(false);
                usuario.setManaged(false);

                password.setVisible(false);
                password.setManaged(false);

                texpassword.setManaged(false);
                texpassword.setVisible(false); 

                texusuario.setManaged(false);
                texusuario.setVisible(false); 

                texprogresbar.setVisible(true);
                progresbar.setVisible(true);
            
                
                Timeline timeline = new Timeline( 
                    new KeyFrame(Duration.seconds(1), e -> progresbar.setProgress(0.3)),
                    new KeyFrame(Duration.seconds(2), e -> progresbar.setProgress(0.6)),
                    new KeyFrame(Duration.seconds(3), e -> progresbar.setProgress(1.0)),
                    new KeyFrame(Duration.seconds(4), e -> progresbar.setProgress(1.0))
                    
                    );
                    timeline.setCycleCount(1); // Ejecutar una sola vez
                    timeline.play();
                // Definir qué hacer cuando la animación termine
                timeline.setOnFinished(e -> {
                        try {
                            try {
                                Thread.sleep(1000);  // Espera 5 segundos (5000 milisegundos)
                            } catch (InterruptedException es) {
                                es.printStackTrace();
                            }
                        // Cargar la nueva escena desde un archivo FXML
                        Parent nuevaVista = FXMLLoader.load(getClass().getResource("/util/iniciarSesion.fxml"));
                        Scene nuevaEscena = new Scene(nuevaVista);

                        // Obtener el Stage actual
                        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        // Reemplazar la escena en la misma ventana
                        stageActual.setScene(nuevaEscena);
                        stageActual.show();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                });    

        } else {
            //Si las credenciales son incorrectas, mostrar un mensaje de error
            mensajeError.setText("❌ Usuario o contraseña incorrectos."); // Asignar texto al Label
            mensajeError.setVisible(true);
        }
    }




}







