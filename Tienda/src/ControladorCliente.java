import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ControladorCliente {
    private List<Cliente> clientes;
    private VistaCliente vista;
    private Scanner scanner;

    private Cliente cliente;

    public ControladorCliente(){
        clientes = new ArrayList<>();
        vista = new VistaCliente();
        scanner = new Scanner(System.in);
    }

    public void agregarCliente(){
        cliente = vista.obtenerDatosArticulo();
        clientes.add(cliente);
        System.out.printf("Se ha agregado al cliente:" + cliente.getNombreCliente() + " "+ cliente.getApellidoPaterno());
        System.out.println();
    }

    public void iniciarMenuCliente() {
        int opcion;

        do {
            vista.mostrarMenuCliente();
            opcion = vista.obtenerOpcion();

            switch (opcion) {
                case 1:
                    vista.mostrarClientes(clientes);
                    break;
                case 2:
                    agregarCliente();
                    break;
                case 3:
                    System.out.println("Ingrese el identificador del Cliente: ");
                    int identificador = scanner.nextInt();
                    modificarClientePorId(identificador);
                    break;
                case 4:
                    System.out.println("ELIMINAR CLIENTE");
                    System.out.println("Ingrese el identificador del Cliente: ");
                    int id = scanner.nextInt();
                    eliminarCliente(id);
                    break;
                case 5:
                    vista.mostrarMensaje("¡Saliendo del menu de artículo!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
                    break;
            }
        } while (opcion != 5);
    }

    public void modificarClientePorId(int identificador) {
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getIdcliente() == identificador) {
                encontrado = true;
                vista.mostarDetalleCliente(cliente);
                vista.modificarCliente(cliente);
                vista.mostrarMensaje("Cliente modificado exitosamente");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado");
        }
    }

    public void eliminarCliente(int identificador) {
        boolean encontrado = false;

        Iterator<Cliente> iterador = clientes.iterator();
        while (iterador.hasNext()) {
            Cliente cliente = iterador.next();
            if (cliente.getIdcliente() == identificador) {
                iterador.remove();  // Eliminar el artículo del inventario
                encontrado = true;
                System.out.println("Cliente eliminado: " + cliente.getNombreCliente());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Artículo no encontrado");
        }
    }


}
