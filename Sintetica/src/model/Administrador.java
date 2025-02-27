package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Sqlconexion.Conexion;
import java.sql.SQLException;

public class Administrador {

   public static boolean registrarUsuario (String usuario, String clave){
    String sql = "INSERT INTO administrador (usuario, clave) VALUES (?, ?)";
    try (Connection conn = Conexion.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            stmt.executeUpdate();
            return true;
        
    } catch (SQLException e) {
        System.out.println("❌ Error al registrar usuario: " + e.getMessage());
        return false;
    }
   }
}