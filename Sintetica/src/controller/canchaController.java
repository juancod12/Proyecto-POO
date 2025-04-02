package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.CanchaSintetica;
import model.Reserva;
import service.obtenerReservasH;

public class canchaController {
    /* crear cancha nueva elementos */
    @FXML
    private Button ButtoNew; // boton de cancha nueva
    @FXML
    private Button canchas;// boton de canchas
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
    /*Elementos de Reserva */
    @FXML
    private Button reservas;
    @FXML
    private Label tituloReserva;
    @FXML
    private Pane paneReserva;
    /*elementos de historial */
    @FXML
    private Button HistorialButton;
    @FXML
    private Pane PaneHistorial;
    @FXML
    private ListView<Reserva>  HistorialViw;
    @FXML
    private ObservableList<Reserva> reservaslist = FXCollections.observableArrayList();
    

    /* metodo iniciar */
    @FXML
    void initialize() {

    }

    /* accion del boton canchas */
    @FXML
    void Canchas(ActionEvent event) {
        //ocultal panel reservas
        paneReserva.setManaged(false);
        paneReserva.setVisible(false);
        //ocultar panel historial
        PaneHistorial.setVisible(false);
        PaneHistorial.setManaged(false);

        System.out.println("dentro del botton");
        ButtoNew.setManaged(true);
        ButtoNew.setVisible(true);
        listaCanchas.setVisible(true);
        listaCanchas.setManaged(true);

        // Cargar las canchas desde la base de datos
        canchasList.setAll(CanchaSintetica.obtenerCanchas());
        listaCanchas.setItems(canchasList);

        // Personalizar cómo se muestra cada elemento en el ListView
        listaCanchas.setCellFactory(param -> new ListCell<CanchaSintetica>() {
        // Definir los elementos gráficos para cada celda
        HBox hbox = new HBox(50); // Contenedor horizontal con un espaciado de 10 píxeles
        Circle estadoCircle = new Circle(8); // Círculo con radio 8
        Label infoLabel = new Label();
        Label infoLabel2 = new Label();
        VBox infoContainer = new VBox(infoLabel);
        Region espacio = new Region();
        Button deleteButton = new Button("Eliminar");
        

        
        {
            infoContainer.setAlignment(Pos.TOP_LEFT);
            espacio.setMinWidth(10); // Define un espacio vacío antes del círculo
            infoLabel.setPrefWidth(100); // Ancho máximo
            infoLabel2.prefWidth(200); 
            // Configuración inicial del HBox y los componentes
            hbox.setAlignment(Pos.CENTER_LEFT);
            hbox.getChildren().addAll( infoLabel, espacio,infoLabel2, estadoCircle,deleteButton);
            // Ajustar márgenes de cada elemento
            HBox.setMargin(infoLabel, new Insets(5, 10, 5, 5)); // Margen superior, derecho, inferior, izquierdo
            HBox.setMargin(estadoCircle, new Insets(10, 10, 10, 10)); // Más espacio alrededor
            HBox.setMargin(deleteButton, new Insets(15, 0, 5, 10)); // Empuja el botón más abajo
            // Acción del botón de eliminar
            deleteButton.setOnAction(event -> {
                CanchaSintetica cancha = getItem();
                if (cancha != null) {
                    // Remover el elemento de la lista visual
                    getListView().getItems().remove(cancha);
                    // Aquí puedes agregar la lógica para eliminar la cancha de la base de datos si es necesario.
                    CanchaSintetica.EliminarCancha(cancha);
                }
            });
        }
    
            @Override
            protected void updateItem(CanchaSintetica cancha, boolean empty) {
                super.updateItem(cancha, empty);
                if (empty || cancha == null) {
                    setText(null);
                    setGraphic(null);
                } else {
            
                    // Tamaños fijos para cada campo
                    String tipo = size.ajustarTamaño(cancha.getTipo(), 20);   // 15 caracteres
                    String estado = size.ajustarTamaño(cancha.getEstado(), 20); // 10 caracteres
                    String precio = "$" + size.ajustarTamaño(String.valueOf(cancha.getPrecio()),10);  // No necesita ajuste

                    // Actualizar la información del label con los detalles de la cancha
                    infoLabel.setText(tipo);
                    infoLabel2.setText( estado + precio );
                    
                    // Cambiar el color del círculo según el estado de la cancha.
                    // Ejemplo: si el estado es "Disponible" o "Libre" se muestra en verde, de lo contrario en rojo.
                    if (cancha.getEstado().equalsIgnoreCase("Disponible") || cancha.getEstado().equalsIgnoreCase("Libre")) {
                        estadoCircle.setFill(Color.GREEN);
                    } else {
                        estadoCircle.setFill(Color.RED);
                    }
                    
                    // Asignar el HBox como el contenido gráfico de la celda.
                    setGraphic(hbox);
                }
            }
    });
        
}

    /* crear canchas nuevas */
    @FXML
    void CrearCancha(ActionEvent event) {
        System.out.println("funciona crear");
        listaCanchas.setVisible(false);
        penelNewCancha.setVisible(true);
   
    }

    @FXML
    void CerrarCrear() {
        System.out.println("se cerro la ventana");
        penelNewCancha.setVisible(true);
        listaCanchas.setVisible(true);
         // Recargar los datos desde la base de datos
        canchasList.setAll(CanchaSintetica.obtenerCanchas());

        // Asegurar que la lista se actualice en la vista
        listaCanchas.refresh();


    }

    @FXML
    void GuardarCancha(ActionEvent event) {
        System.out.println("se preciono");

        String tipo = txTipo.getText();
        int precio = Integer.parseInt(txPrecio.getText());
        CanchaSintetica nuevo = new CanchaSintetica(tipo, precio);
        boolean si = CanchaSintetica.RegistrarCancha(nuevo);
        if (si == false) {
            System.out.println("no se guardo nada");
        } else {
            System.out.println("gardado exitoso");
            TxExito.setVisible(true);
            txPrecio.clear();
            txTipo.clear();

        }

    }
    @FXML
    void mostrarReservas(ActionEvent event){
        //ocultal panel canchas
        penelNewCancha.setManaged(false);
        penelNewCancha.setVisible(false);
        listaCanchas.setManaged(false);
        listaCanchas.setVisible(false);
        ButtoNew.setManaged(false);
        ButtoNew.setVisible(false);

        //ocultal panel historial
        PaneHistorial.setVisible(false);
        PaneHistorial.setManaged(false);

        System.out.println("estoy en reservas");
        //mostrar las reservas del dia pagina principal 
        paneReserva.setVisible(true);
        tituloReserva.setVisible(true);


    }

    
    @FXML
    void VerHistorial(ActionEvent event){
        ButtoNew.setManaged(false);
        ButtoNew.setVisible(false);
        PaneHistorial.setVisible(true);
        PaneHistorial.setManaged(true);
        // Cargar las canchas desde la base de datos
        reservaslist.setAll(obtenerReservasH.obtenerReservas());
        HistorialViw.setItems(reservaslist);
        System.out.println("Reservas obtenidas: " + reservaslist.size());

        // Personalizar cómo se muestra cada elemento en el ListView
        HistorialViw.setCellFactory(param -> new ListCell<Reserva>() {
        // Definir los elementos gráficos para cada celda
        HBox hbox = new HBox(25); // Contenedor horizontal con un espaciado de 10 píxeles
        Label infoLabel = new Label();
        Label nombre = new Label();
        VBox infoContainer = new VBox(nombre,infoLabel);
        
        {
            infoContainer.setAlignment(Pos.TOP_LEFT);
            nombre.setPrefWidth(80);
            hbox.setAlignment(Pos.CENTER_LEFT);
            hbox.getChildren().addAll(nombre,infoLabel);
            
            
        }
    
            @Override
            protected void updateItem(Reserva reservas, boolean empty) {
                super.updateItem(reservas, empty);
                if (empty || reservas == null) {
                    setGraphic(null);
                } else {
                    String Nombre =  size.ajustarTamaño(reservas.getNombreUsuario(), 15);
                    String cancha =size.ajustarTamaño(reservas.getCancha(), 27);
                    String telefono =size.ajustarTamaño(reservas.getTelefono(), 27);
                    String correo = size.ajustarTamaño(reservas.getCorreo(), 27);
                    
                    // Tamaños fijos para cada campo
                    String info =  reservas.getFecha()+"          " +reservas.getHora() + "        "+ cancha + telefono + correo;   // 15 caracteres
                

                    // Actualizar la información del label con los detalles de la cancha
                    infoLabel.setText(info);
                    nombre.setText(Nombre);
                    
                    // Asignar el HBox como el contenido gráfico de la celda.
                    setGraphic(hbox);
                }
            }
    });
        

    }

    



}

