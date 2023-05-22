import java.util.ArrayList;
import java.util.InputMismatchException;
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
        System.out.format("%-5s %-20s %-15s %-18s %-10s%n", "ID", "Nombre", "Precio Público", "Precio Proveedor", "Stock");
        for (Articulo articulo : articulos) {
            System.out.format("%-5d %-20s %-15.2f %-18.2f %-10d%n", articulo.getId(), articulo.getNombreArticulo(),
                    articulo.getPrecioPublico(), articulo.getPrecioProveedor(), articulo.getStock());
        }
        System.out.println("---------------------");
    }

    public Articulo obtenerDatosArticulo() {
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingresa el identificador del artículo: ");
        int id = 0;
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: el identificador debe ser un número entero. Intente nuevamente.");
            scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
            return null;
        }

        scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
        System.out.print("Ingresa el nombre del artículo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa el precio del artículo: ");
        double precio = 0.0;
        try {
            precio = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Error: el precio debe ser un número decimal. Intente nuevamente.");
            scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
            return null;
        }

        System.out.print("Ingresa el precio del artículo (proveedor): ");
        double precioProveedor = 0.0;
        try {
            precioProveedor = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Error: el precio del proveedor debe ser un número decimal. Intente nuevamente.");
            scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
            return null;
        }

        System.out.print("Ingresa la cantidad en stock: ");
        int stock = 0;
        try {
            stock = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: la cantidad en stock debe ser un número entero. Intente nuevamente.");
            return null;
        }

        return new Articulo(id, nombre, precio, precioProveedor, stock);
    }


    public void mostarDetalleArticulo(Articulo articulo){
        System.out.println("ID: " + articulo.getId() + " - Nombre: " + articulo.getNombreArticulo() + " - Precio publico: "
                + articulo.getPrecioPublico() + " - Precio Proveedor: " + articulo.getPrecioProveedor() +
                " - Stock: " + articulo.getStock() );
    }
    public void modificarArticulo(Articulo articulo) {
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        articulo.setNombreArticulo(nuevoNombre);

        System.out.print("Nuevo precio al público del artículo: ");
        double nuevoPrecioPublico = scanner.nextDouble();
        articulo.setPrecioPublico(nuevoPrecioPublico);

        System.out.print("Nuevo precio del proveedor del artículo: ");
        double nuevoPrecioProveedor = scanner.nextDouble();
        articulo.setPrecioProveedor(nuevoPrecioProveedor);

        System.out.print("Nueva cantidad de existencia del artículo: ");
        int nuevaCantidadExistencia = scanner.nextInt();
        articulo.setStock(nuevaCantidadExistencia);
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}