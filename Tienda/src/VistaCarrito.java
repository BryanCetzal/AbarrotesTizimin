import javax.management.openmbean.OpenMBeanAttributeInfo;
import java.util.List;
import java.util.Scanner;

public class VistaCarrito implements Observer {
    private Scanner scanner;

    public VistaCarrito(){
        scanner = new Scanner(System.in);
    }
    public void mostrarMenuCarrito() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Mostrar el carrito de compras");
        System.out.println("2. Agregar artículo al carrito de compras");
        System.out.println("3. Modificar carrito de compra");
        System.out.println("4. Eliminar artículo del carrito de compras");
        System.out.println("5. Salir");
        System.out.println("-----------------");
    }

    public int obtenerOpcion() {
        System.out.print("Ingresa tu opción: ");
        return scanner.nextInt();
    }

    public void mostrarArticulosDisponibles(List<Articulo> articulos) {
        System.out.println("----- ARTÍCULOS DISPONIBLES -----");
        System.out.format("%-5s %-20s %-15s %-10s%n", "ID", "Nombre", "Precio Público", "Stock");
        for (Articulo articulo : articulos) {
            System.out.format("%-5d %-20s %-15.2f %-10d%n", articulo.getId(), articulo.getNombreArticulo(),
                    articulo.getPrecioPublico(), articulo.getStock());
        }
        System.out.println("---------------------");
    }

    public void mostrarCarrito(List<Carrito> carritos) {
        double sumador = 0;
        System.out.println("----- ARTÍCULOS -----");
        System.out.format("%-5s %-20s %-15s %-10s %-15s%n", "ID", "Nombre", "Precio Unidad", "Cantidad", "Total");
        for (Carrito carrito : carritos) {
            double precioTotal = (carrito.getPrecioU() * carrito.getCantidad());
            System.out.format("%-5s %-20s %-15.2f %-10d %-15s%n", carrito.getId(), carrito.getNombreArticulo(),
                    carrito.getPrecioU(), carrito.getCantidad(), precioTotal);
            sumador =  sumador + precioTotal;
        }
        System.out.println("Total del Carrito: " + sumador);
        System.out.println("---------------------");
    }

    public void mostrarDetalleProducto(Carrito carrito){
        double precioTotal = (carrito.getPrecioU() * carrito.getCantidad());
        System.out.format("%-5s %-20s %-15s %-10s %-15s%n", "ID", "Nombre", "Precio Unidad", "Cantidad", "Total");
        System.out.format("%-5s %-20s %-15.2f %-10d %-15s%n", carrito.getId(), carrito.getNombreArticulo(),
                    carrito.getPrecioU(), carrito.getCantidad(), precioTotal);
    }

    public void modificarProducto(Carrito carrito){
        scanner.nextLine();

        System.out.print("Cantidad nueva: ");
        int nuevaCantidad = scanner.nextInt();
        carrito.setCantidad(nuevaCantidad);

    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void actualizar() {
        mostrarMensaje("Artículo añadido al carrito exitosamente");
    }
}