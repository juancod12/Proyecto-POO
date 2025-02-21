import java.util.List;

public class Negocio {
    public List<CanchaSintetica> NumCanchas;
    private  Administrador Usuario;
    public String Direccion;
    public String Nombre;
    public Negocio(List<CanchaSintetica> numCanchas, Administrador usuario, String direccion, String nombre) {
        NumCanchas = numCanchas;
        Usuario = usuario;
        Direccion = direccion;
        Nombre = nombre;
    }
    public List<CanchaSintetica> getNumCanchas() {
        return NumCanchas;
    }
    public void setNumCanchas(List<CanchaSintetica> numCanchas) {
        NumCanchas = numCanchas;
    }
    public Administrador getUsuario() {
        return Usuario;
    }
    public void setUsuario(Administrador usuario) {
        Usuario = usuario;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
   
}
