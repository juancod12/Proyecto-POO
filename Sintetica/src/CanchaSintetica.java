public class CanchaSintetica {
    // Atributos
    private String idCancha;
    private String numeroDeCancha;
    private String estado;
    private int precio;

    // Constructor
    public CanchaSintetica(String idCancha, String numeroDeCancha, String estado, int precio) {
        this.idCancha = idCancha;
        this.numeroDeCancha = numeroDeCancha;
        this.estado = estado;
        this.precio = precio;
    }

    // Getters y Setters
    public String getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(String idCancha) {
        this.idCancha = idCancha;
    }

    public String getNumeroDeCancha() {
        return numeroDeCancha;
    }

    public void setNumeroDeCancha(String numeroDeCancha) {
        this.numeroDeCancha = numeroDeCancha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    // Método toString para mostrar los detalles de la cancha
    @Override
    public String toString() {
        return "CanchaSintetica: idCancha=" + idCancha + ", numeroDeCancha=" + numeroDeCancha + ", estado=" + estado + ", precio=" + precio;
    }
}