package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Sqlconexion.Conexion;

public class VerHorasReservas {
    
    public VerHorasReservas(){

        String sql = "SELECT * FROM reservas WHERE fecha = ?";
        try (Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            
            ResultSet rs = stmt.executeQuery();

            // Si hay al menos un resultado, el usuario y la contraseña son correctos
            

        } catch (SQLException e) {
           
        }
    }




}

