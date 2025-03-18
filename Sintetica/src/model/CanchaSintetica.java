package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Sqlconexion.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CanchaSintetica {
    private String tipo;
    private String estado; 
    private int precio;
    private int id;

public CanchaSintetica(String tipo, int precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

 public CanchaSintetica(int id, String tipo,String estado, int precio) {
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado; 
        this.id= id;
    }



@Override
public String toString() {
    return  "     " + id + "   "+ tipo + "    " + estado + "      " + precio  ;
}

public String getTipo() {
    return tipo;
}

public int getPrecio() {
    return precio;
}
public String getEstado() {
    return estado;
}
   


public static boolean RegistrarCancha(CanchaSintetica cancha){
    String tipo= cancha.getTipo();
    int precio= cancha.getPrecio();
    boolean estado =false;


    String sql = "INSERT INTO canchas (tipo,estado, precio) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipo);
            stmt.setBoolean(2, estado);
            stmt.setInt(3, precio);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("❌ Error al registrar cancha: " + e.getMessage());
            return false;
        }
    }

    public static ObservableList<CanchaSintetica> obtenerCanchas() {
        ObservableList<CanchaSintetica> canchas = FXCollections.observableArrayList();
        String query = "SELECT id, tipo, estado, precio FROM canchas";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String estado = rs.getString("estado");
                int precio = rs.getInt("precio");

                canchas.add(new CanchaSintetica( id, tipo, estado, precio));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canchas;
    }




}