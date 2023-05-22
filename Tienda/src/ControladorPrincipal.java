import java.util.List;
import java.util.Scanner;

public class ControladorPrincipal {
    private Scanner scanner;
    private VistaPrincipal vistaPrincipal;
    private ControladorArticulo controladorArticulo;
    private ControladorCliente controladorCliente;
    private ControladorCarrito controladorCarrito;

    public ControladorPrincipal(){
        vistaPrincipal = new VistaPrincipal();
        controladorArticulo = ControladorArticulo.getInstance();
        controladorCliente = new ControladorCliente();
        controladorCarrito = new ControladorCarrito();
        scanner = new Scanner(System.in);
    }

    public void iniciarMenuPrincipal(){
        int opcion;

        do {
            opcion = vistaPrincipal.menuPrincipal();

            switch (opcion){
                case 1:
                    controladorCliente.iniciarMenuCliente();
                    break;
                case 2:
                    controladorArticulo.iniciar();
                    break;
                case 3:
                    Cliente cliente = seleccionCliente();
                    Ticket ticketBase = new TicketBase(iniciarProcesoCompra(controladorArticulo.inventario()));
                    Ticket ticketDecorado = new FechaTicketDecorator(new ClienteTicketDecorator(ticketBase, cliente));
                    ticketDecorado.imprimir();
                    break;
                case 4:
                    vistaPrincipal.mostrarMensaje("Vuelva proto...");
                    break;
                default:
                    vistaPrincipal.mostrarMensaje("Opción inválida");
                    break;
            }

        }while (opcion != 4);
    }

    public Cliente seleccionCliente(){
        System.out.println("Para comenzar con la compra seleccione su perfil");
        System.out.println("Ingrese el ID del Cliente: ");
        return controladorCliente.compradorDatos(scanner.nextInt());
    }

    public List<Carrito> iniciarProcesoCompra(List<Articulo> inventario) {
        int opcion;
        do {
            opcion = vistaPrincipal.procesoCompra();

            switch (opcion) {
                case 1:
                    controladorCarrito.inicioCarrito(inventario);
                    break;
                case 2:
                    try {
                        return controladorCarrito.comprarCarrito();
                    } catch (NumberFormatException e) {
                        vistaPrincipal.mostrarMensaje("Error: el formato del precio es inválido. Intente nuevamente.");
                    }
                    break;
                case 3:
                    vistaPrincipal.mostrarMensaje("Vuelva Pronto");
                    break;
                default:
                    vistaPrincipal.mostrarMensaje("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }
        } while (opcion != 3);

        return null;
    }

}
