package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Sqlconexion.Conexion;

public class Administrador {

    public static boolean registrarUsuario(String usuario, String clave) {
        String sql = "INSERT INTO administrador (usuario, clave) VALUES (?, ?)";
        try (Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    public static boolean login(String usuario, String clave) {
        String sql = "SELECT * FROM administrador WHERE usuario = ? AND clave = ?";
        try (Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            ResultSet rs = stmt.executeQuery();

            // Si hay al menos un resultado, el usuario y la contraseña son correctos
            return rs.next();

        } catch (SQLException e) {
            System.out.println("❌ Error al intentar iniciar sesión: " + e.getMessage());
            return false;
        }
    }
}