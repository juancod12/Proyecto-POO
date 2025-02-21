public class Administrador {
    private String Usuario;
    public int Id;
    private String Password;
    public Administrador(String usuario, int id, String password) {
        Usuario = usuario;
        Id = id;
        Password = password;
    }
    public String getUsuario() {
        return Usuario;
    }
    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }


    
}