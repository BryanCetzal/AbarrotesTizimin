import java.util.ArrayList;
import java.util.List;

public class ControladorArticulo {
    private List<Articulo> carrito;
    private VistaArticulo vista;

    public ControladorArticulo() {
        carrito = new ArrayList<>();
        vista = new VistaArticulo();
    }

    public void agregarArticulo(){
        Articulo articulo = new vista.obtenerDatosArticulo();
        carrito.add(articulo);
        System.out.println("Artículo agregado al carrito: " + articulo.getNombreArticulo());
    }

    public void iniciar() {
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = vista.obtenerOpcion();

            switch (opcion) {
                case 1:
                    vista.mostrarArticulos(carrito);
                    break;
                case 2:
                    agregarArticulo();
                    break;
                case 3:
                    actualizarArticulo();
                    break;
                case 4:
                    vista.mostrarMensaje("¡Saliendo del menu de artículo!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
                    break;
            }
        } while (opcion != 4);
    }

    private void actualizarArticulo() {

    }

}

