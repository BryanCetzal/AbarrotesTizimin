import java.util.List;

// Clase base que implementa el componente base del ticket
public class TicketBase implements Ticket {
    private List<Carrito> carrito;
    public TicketBase(List<Carrito> carrito){
        this.carrito = carrito;
    }
    @Override
    public void imprimir() {
        double sumador = 0;
        System.out.println("----- ARTÍCULOS -----");
        System.out.format("%-5s %-20s %-15s %-10s %-15s%n", "ID", "Nombre", "Precio Unidad", "Cantidad", "Total");
        for (Carrito carrito : carrito) {
            double precioTotal = (carrito.getPrecioU() * carrito.getCantidad());
            System.out.format("%-5s %-20s %-15.2f %-10d %-15s%n", carrito.getId(), carrito.getNombreArticulo(),
                    carrito.getPrecioU(), carrito.getCantidad(), precioTotal);
            sumador =  sumador + precioTotal;
        }
        System.out.println("Total del Carrito: " + sumador);
        System.out.println("---------------------");
    }
}