import java.util.List;

public class Negocio {
    // Atributos
    private List<CanchaSintetica> numCanchas; 
    private Administrador usuario;         
    private String direccion;             
    private String nombre;                 

    // Constructor
    public Negocio(List<CanchaSintetica> canchas, Administrador usuario, String direccion, String nombre) {
        this.numCanchas = canchas;
        this.usuario = usuario;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    // Getters y Setters
    public List<CanchaSintetica> getCanchas() { 
        return numCanchas;
    }

    public void setCanchas(List<CanchaSintetica> canchas) { 
        this.numCanchas = canchas;
    }

    public Administrador getUsuario() {
        return usuario;
    }

    public void setUsuario(Administrador usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString para mostrar los detalles del negocio
    @Override
    public String toString() {
        return "Negocio: nombre=" + nombre + ", direccion=" + direccion + ", usuario=" + usuario.getUsuario();
    }
}