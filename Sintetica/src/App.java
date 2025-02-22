import java.sql.Connection;
import java.sql.SQLException;
import SQLconexion.Conexion;

public class App {
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
      
        
    }
}
