import java.util.List;
import java.util.Scanner;

public class VistaArticulo {
    private Scanner scanner;

    public VistaArticulo(){
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Ver artículos");
        System.out.println("2. Agregar artículo");
        System.out.println("3. Actualizar artículo");
        System.out.println("4. Salir");
        System.out.println("-----------------");
    }

    public int obtenerOpcion() {
        System.out.print("Ingresa tu opción: ");
        return scanner.nextInt();
    }

    public void mostrarArticulos(List<Articulo> articulos) {
        System.out.println("----- ARTÍCULOS -----");
        for (Articulo articulo : articulos) {
            System.out.println("Nombre: " + articulo.getNombreArticulo() + " - Precio: " + articulo.getPrecioPublico() + " - Stock: " + articulo.getStock());
        }
        System.out.println("---------------------");
    }

    public Articulo obtenerDatosArticulo() {
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingresa el identificador del artículo: ");
        int id = scanner.nextInt();
        System.out.println("Ingresa el nombre del artículo: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa el precio del artículo: ");
        double precio = scanner.nextDouble();
        System.out.println("Ingresa el precio del artículo (proveedor): ");
        double precioProveedor = scanner.nextDouble();
        System.out.print("Ingresa la cantidad en stock: ");
        int stock = scanner.nextInt();
        return new Articulo(id, nombre, precio, precioProveedor, stock);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}