import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ControladorCarrito implements SujetoObservable {
    private List<Carrito> carrito;
    private VistaCarrito vista;
    private Carrito producto;
    private Scanner scanner;
    private ArrayList<Observador> observadores;

    public ControladorCarrito(){
        carrito = new ArrayList<>();
        vista = new VistaCarrito();
        scanner = new Scanner(System.in);
        observadores = new ArrayList<>();
    }

    public void inicioCarrito(List<Articulo> inventario){
        int opcion;
        vista.mostrarArticulosDisponibles(inventario);
        do {
            vista.mostrarMenuCarrito();
            opcion = vista.obtenerOpcion();
            switch (opcion){
                case 1:
                    vista.mostrarCarrito(carrito);
                    break;
                case 2:
                    System.out.println("Ingrese el identificador del artículo: ");
                    int ident = scanner.nextInt();
                    System.out.println("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    agregarArticuloCarrito(ident, cantidad, inventario);
                    break;
                case 3:
                    System.out.println("Ingrese el identificador del artículo: ");
                    int identificador = scanner.nextInt();
                    modificarArticuloCarrito(identificador);
                    break;
                case 4:
                    System.out.println("ELIMINAR ARTICULO DEL INVENTARIO");
                    System.out.println("Ingrese el identificador del artículo: ");
                    int id = scanner.nextInt();
                    eliminarArticuloCarrito(id);
                    break;
                case 5:
                    vista.mostrarMensaje("¡Saliendo del menu de carrito!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
                    break;
            }
        }while(opcion!=5);
    }

    public void agregarArticuloCarrito(int ident, int cantidad, List<Articulo> inventario) {
        boolean encontrado = false;

        for (Articulo articulo : inventario) {
            if (articulo.getId() == ident) {
                encontrado = true;
                int cantidadDisponible = articulo.getStock();
                if (cantidad > cantidadDisponible) {
                    cantidad = cantidadDisponible; // Establecer la cantidad máxima como la disponible en el inventario
                    vista.mostrarMensaje("La cantidad máxima que puedes agregar es " + cantidadDisponible);
                }
                producto = new Carrito(articulo.getId(), articulo.getNombreArticulo(), articulo.getPrecioPublico(), cantidad);
                carrito.add(producto);
                notificar(cantidad, articulo.getStock());
                vista.mostrarMensaje("Artículo añadido al carrito exitosamente");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Artículo no encontrado");
        }
    }

    @Override
    public void notificar(int cantidad, int id) {
        for(Observador o: observadores){
            o.actualizar(cantidad, id);
        }
    }

    public void modificarArticuloCarrito(int id){
        boolean encontrado = false;

        for (Carrito carrito1 : carrito) {
            if (carrito1.getId() == id) {
                encontrado = true;
                vista.mostrarDetalleProducto(carrito1);  // Mostrar detalles del artículo antes de la modificación
                vista.modificarProducto(carrito1);  // Solicitar los nuevos datos al usuario para modificar el artículo
                vista.mostrarMensaje("Artículo modificado exitosamente");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Artículo no encontrado");
        }
    }

    public void eliminarArticuloCarrito(int id){
        boolean encontrado = false;

        Iterator<Carrito> iterador = carrito.iterator();
        while (iterador.hasNext()) {
            Carrito carrito1 = iterador.next();
            if (carrito1.getId() == id) {
                iterador.remove();  // Eliminar el artículo del inventario
                encontrado = true;
                System.out.println("Artículo eliminado del carrito: " + carrito1.getNombreArticulo());
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Artículo no encontrado");
        }
    }

    public void enlazar0bservador(Observador o) {observadores.add(o);};

    public List<Carrito> comprarCarrito(){return carrito;}
}
