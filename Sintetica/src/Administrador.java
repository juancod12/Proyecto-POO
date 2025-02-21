public class Administrador {
    //Atributos 
    private String usuario;
    private int id;
    private String password;

    // Constructor
    public Administrador(String usuario, int id, String password) {
        this.usuario = usuario;
        this.id = id;
        this.password = password;
    }

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método toString para mostrar los detalles del administrador
    @Override
    public String toString() {
        return "Administrador: usuario=" + usuario + ", id=" + id + ", password=" + password;
    }

    //Metodos
    public void iniciarSesion(){
        
    }
}