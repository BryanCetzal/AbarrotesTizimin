import java.util.ArrayList;
import java.util.List;

public class Articulo {
    private int id;
    private String nombreArticulo;
    private double precioPublico;
    private double precioProveedor;
    private int stock;
    private List<Observer> observadores;

    public Articulo(int id, String nombreArticulo, double precioPublico, double precioProveedor, int stock) {
        this.id = id;
        this.nombreArticulo = nombreArticulo;
        this.precioPublico = precioPublico;
        this.precioProveedor = precioProveedor;
        this.stock = stock;
        this.observadores = new ArrayList<>();
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

    public double getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(double precioPublico) {
        this.precioPublico = precioPublico;
    }

    public double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void notificarObservadores() {
        for (Observer observador : observadores) {
            observador.actualizar();
        }
    }

    public void reducirStock(int cantidad) {
        stock -= cantidad;
        notificarObservadores();
    }
}

