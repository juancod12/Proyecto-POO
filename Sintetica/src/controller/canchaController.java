package controller;
import java.io.IOException;

import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;



import javafx.scene.Node;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Administrador;
import model.CanchaSintetica;
public class canchaController {
    /*crear cancha nueva elementos */
    @FXML
    private Button ButtoNew; //boton de cancha nueva 
    @FXML
    private  Button canchas;// boton de canchas
    @FXML
    private Pane penelNewCancha; 
    @FXML
    private TextField txTipo; // texto de tipo de cancha
    @FXML
    private TextField txPrecio; // texto de precio 
    @FXML
    private Button buttonAgregarCancha; // boton de agregar cancha
    @FXML
    private Label TxExito; // mensaje de gardado
    @FXML
    private ListView<CanchaSintetica> listaCanchas;
    private ObservableList<CanchaSintetica> canchasList = FXCollections.observableArrayList();


     
     /* metodo iniciar*/
     @FXML 
     void initialize() {  
        
         
     } 
    /*accion del boton canchas */
    @FXML
    void Canchas(ActionEvent event ) {
        System.out.println("dentro del botton");
        ButtoNew.setManaged(true);
        ButtoNew.setVisible(true);
         /*Vista de las canchas creadas */
         listaCanchas.setItems(CanchaSintetica.obtenerCanchas());
       
    }
    /*crear canchas nuevas */
    @FXML
    void CrearCancha(ActionEvent event){
        System.out.println("funciona crear");
        penelNewCancha.setVisible(true);
        // Cargar las canchas desde la base de datos
        canchasList.setAll(CanchaSintetica.obtenerCanchas());
        listaCanchas.setItems(canchasList);

        // Personalizar cómo se muestra cada elemento en el ListView
        listaCanchas.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(CanchaSintetica cancha, boolean empty) {
                super.updateItem(cancha, empty);
                if (empty || cancha == null) {
                    setText(null);
                } else {
                    setText("🏟️ " + cancha.getTipo()  + " - " + cancha.getEstado()+ " - 💲" + cancha.getPrecio());
                }
            }
        });
        
    }
    @FXML
    void CerrarCrear(){
        System.out.println("se cerro la ventana");
        penelNewCancha.setVisible(false);

    }

    @FXML
    void GuardarCancha(ActionEvent event){
        System.out.println("se preciono");
        
        String tipo = txTipo.getText();
        int precio = Integer.parseInt(txPrecio.getText());
        CanchaSintetica nuevo =new CanchaSintetica(tipo, precio);
        boolean si = CanchaSintetica.RegistrarCancha(nuevo);
        if(si == false){
            System.out.println("no se guardo nada");
        }else{
            System.out.println("gardado exitoso");
            TxExito.setVisible(true);
 
            } 
        
    }
    
}
