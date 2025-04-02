package model;
import java.sql.Date;
import java.sql.Time;


public class Reserva {
    // Atributos en minúscula
    private String nombreUsuario;  
    private Date fecha;       
    private Time hora;        
    private int id;       
    private String cancha;    
    private String telefono;         
    private String correo;         
    // Constructor
    public Reserva(String nombreUsuario, Date fecha, Time hora, int id, String cancha, String telefono, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.hora = hora;
        this.id = id;
        this.cancha = cancha;
        this.telefono = telefono;
        this.correo = correo;
    }


    
    @Override
    public String toString() {
        return "Reserva [nombreUsuario=" + nombreUsuario + ", fecha=" + fecha + ", hora=" + hora + ", id=" + id
                + ", cancha=" + cancha + ", telefono=" + telefono + ", coreo=" + correo + "]";
    }




    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public Date getFecha() {
        return fecha;
    }


    public Time getHora() {
        return hora;
    }


    public int getId() {
        return id;
    }



    public String getCancha() {
        return cancha;
    }


    public String getTelefono() {
        return telefono;
    }


    public String getCorreo() {
        return correo;
    }
    
}