import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    // Atributos en minúscula
    private String nombreUsuario;  
    private LocalDate fecha;       
    private LocalTime hora;        
    private int idCancha;          
    private int idReserva;         
    // Constructor
    public Reserva(String nombreUsuario, LocalDate fecha, LocalTime hora, int idCancha, int idReserva) {
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.hora = hora;
        this.idCancha = idCancha;
        this.idReserva = idReserva;
    }

    // Getters y Setters
    public String getNombreUsuario() { 
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) { 
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    // Método toString para mostrar los detalles de la reserva
    @Override
    public String toString() {
        return "Reserva: idReserva=" + idReserva + ", nombreUsuario=" + nombreUsuario + ", fecha=" + fecha + ", hora=" + hora + ", idCancha=" + idCancha;
    }
}