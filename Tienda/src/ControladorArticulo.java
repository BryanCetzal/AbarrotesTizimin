import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ControladorArticulo {
    private List<Articulo> inventario;
    private VistaArticulo vista;
    private Articulo aux;
    Scanner scanner;

    public ControladorArticulo() {
        inventario = new ArrayList<>();
        vista = new VistaArticulo();
        scanner = new Scanner(System.in);
    }

    public void agregarArticulo(){
        aux = vista.obtenerDatosArticulo();
        inventario.add(aux);
        System.out.println("Artículo agregado al carrito: " + aux.getNombreArticulo());
    }

    public void iniciar() {
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = vista.obtenerOpcion();

            switch (opcion) {
                case 1:
                    vista.mostrarArticulos(inventario);
                    break;
                case 2:
                    agregarArticulo();
                    break;
                case 3:
                    System.out.println("Ingrese el identificador del artículo: ");
                    int identificador = scanner.nextInt();
                    modificarArticuloPorId(identificador);
                    break;
                case 4:
                    System.out.println("ELIMINAR ARTICULO DEL INVENTARIO");
                    System.out.println("Ingrese el identificador del artículo: ");
                    int id = scanner.nextInt();
                    eliminarArticulo(id);
                    break;
                case 0:
                    vista.mostrarMensaje("¡Saliendo del menu de artículo!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    public void modificarArticuloPorId(int identificador) {
        boolean encontrado = false;

        for (Articulo articulo : inventario) {
            if (articulo.getId() == identificador) {
                encontrado = true;
                vista.mostarDetalleArticulo(articulo);  // Mostrar detalles del artículo antes de la modificación
                vista.modificarArticulo(articulo);  // Solicitar los nuevos datos al usuario para modificar el artículo
                vista.mostrarMensaje("Artículo modificado exitosamente");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Artículo no encontrado");
        }
    }

    public void eliminarArticulo(int identificador) {
        boolean encontrado = false;

        Iterator<Articulo> iterador = inventario.iterator();
        while (iterador.hasNext()) {
            Articulo articulo = iterador.next();
            if (articulo.getId() == identificador) {
                iterador.remove();  // Eliminar el artículo del inventario
                encontrado = true;
                System.out.println("Artículo eliminado: " + articulo.getNombreArticulo());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Artículo no encontrado");
        }
    }

}

