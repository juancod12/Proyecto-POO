public class CanchaSintetica {
    public String IdCancha;
    public String NUmeroDeCancha;
    public String Estado;
    public int Precio;
    public CanchaSintetica(String idCancha, String nUmeroDeCancha, String estado, int precio) {
        IdCancha = idCancha;
        NUmeroDeCancha = nUmeroDeCancha;
        Estado = estado;
        Precio = precio;
    }
    public String getIdCancha() {
        return IdCancha;
    }
    public void setIdCancha(String idCancha) {
        IdCancha = idCancha;
    }
    public String getNUmeroDeCancha() {
        return NUmeroDeCancha;
    }
    public void setNUmeroDeCancha(String nUmeroDeCancha) {
        NUmeroDeCancha = nUmeroDeCancha;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public int getPrecio() {
        return Precio;
    }
    public void setPrecio(int precio) {
        Precio = precio;
    }
    
}
