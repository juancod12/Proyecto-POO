public class Reserva {
    public String Nombre ;
    public String Fecha;
    public String Hora;
    public int IdCancha;
    public int IdReserva;
    public Reserva(String nombre, String fecha, String hora, int idCancha, int idReserva) {
        Nombre = nombre;
        Fecha = fecha;
        Hora = hora;
        IdCancha = idCancha;
        IdReserva = idReserva;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getFecha() {
        return Fecha;
    }
    public void setFecha(String fecha) {
        Fecha = fecha;
    }
    public String getHora() {
        return Hora;
    }
    public void setHora(String hora) {
        Hora = hora;
    }
    public int getIdCancha() {
        return IdCancha;
    }
    public void setIdCancha(int idCancha) {
        IdCancha = idCancha;
    }
    public int getIdReserva() {
        return IdReserva;
    }
    public void setIdReserva(int idReserva) {
        IdReserva = idReserva;
    }
    

    
}
