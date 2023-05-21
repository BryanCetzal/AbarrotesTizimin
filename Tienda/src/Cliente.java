public class Cliente {
    private int idcliente;
    private String nombreCliente;
    private String apellidoPaterno;
    private Direccion direccion;

    public Cliente(int idcliente, String nombreCliente, String apellidoPaterno, Direccion direccion) {
        this.idcliente = idcliente;
        this.nombreCliente = nombreCliente;
        this.apellidoPaterno = apellidoPaterno;
        this.direccion = direccion;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

}
