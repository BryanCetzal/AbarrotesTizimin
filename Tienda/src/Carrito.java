public class Carrito {
    private int id;
    private String nombreArticulo;
    private double precioU;
    private int cantidad;

    public Carrito(int id, String nombreArticulo, double precioU, int cantidad) {
        this.id= id;
        this.nombreArticulo = nombreArticulo;
        this.precioU = precioU;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }

}


