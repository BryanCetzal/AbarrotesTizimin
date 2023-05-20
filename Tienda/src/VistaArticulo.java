import java.util.List;
import java.util.Scanner;

public class VistaArticulo {
    private Scanner scanner;
    private ControladorArticulo controladorArticulo;

    public VistaArticulo(){
        scanner = new Scanner(System.in);
        controladorArticulo = new ControladorArticulo();
    }

    public void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Ver artículos");
        System.out.println("2. Agregar artículo");
        System.out.println("3. Actualizar artículo");
        System.out.println("4. Eliminar artículo");
        System.out.println("0. Salir");
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
        scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
        System.out.print("Ingresa el nombre del artículo: ");
        String nombre = scanner.nextLine();
        scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
        System.out.print("Ingresa el precio del artículo: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingresa el precio del artículo (proveedor): ");
        double precioProveedor = scanner.nextDouble();
        System.out.print("Ingresa la cantidad en stock: ");
        int stock = scanner.nextInt();
        return new Articulo(id, nombre, precio, precioProveedor, stock);
    }

    public void modificarArticulo() {

        // Obtener los parámetros para modificar el artículo
        System.out.print("Ingrese el identificador del artículo a modificar: ");
        int identificador = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Nuevo nombre del artículo: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nuevo precio al público del artículo: ");
        double nuevoPrecioPublico = scanner.nextDouble();

        System.out.print("Nuevo precio del proveedor del artículo: ");
        double nuevoPrecioProveedor = scanner.nextDouble();

        System.out.print("Nueva cantidad de existencia del artículo: ");
        int nuevaCantidadExistencia = scanner.nextInt();

        // Llamar al controlador para modificar el artículo
        controladorArticulo.modificarArticulo(identificador, nuevoNombre, nuevoPrecioPublico, nuevoPrecioProveedor, nuevaCantidadExistencia);

    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}