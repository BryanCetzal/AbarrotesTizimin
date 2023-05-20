import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorArticulo {
    private List<Articulo> inventario;
    private VistaArticulo vista;
    private Articulo aux;

    public ControladorArticulo() {
        inventario = new ArrayList<>();
        vista = new VistaArticulo();
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
                    vista.modificarArticulo();
                    break;
                case 4:
                    eliminarArticulo();
                    break;
                case 5:
                    vista.mostrarMensaje("¡Saliendo del menu de artículo!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }

    public void modificarArticulo(int identificador, String nuevoNombre, double nuevoPrecioPublico, double nuevoPrecioProveedor, int nuevaCantidadExistencia) {
        Articulo articulo = buscarArticuloPorId(identificador);
        if (articulo != null) {
            articulo.setNombreArticulo(nuevoNombre);
            articulo.setPrecioPublico(nuevoPrecioPublico);
            articulo.setPrecioProveedor(nuevoPrecioProveedor);
            articulo.setStock(nuevaCantidadExistencia);
            System.out.println("El artículo se ha modificado correctamente.");
        } else {
            System.out.println("No se encontró ningún artículo con el identificador especificado.");
        }
    }

    public Articulo buscarArticuloPorId(int identificador) {
        for (Articulo inventario : inventario) {
            if (inventario.getId() == identificador) {
                return inventario;
            }
        }
        return null; // Si no se encuentra el artículo
    }



    private void eliminarArticulo(){

    }



}

