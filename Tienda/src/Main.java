public class Main {
    public static void main(String[] args) {
        ControladorCliente controladorCliente = new ControladorCliente();
        controladorCliente.iniciarMenuCliente();

        ControladorArticulo controladorArticulo = new ControladorArticulo();
        controladorArticulo.iniciar();

        ControladorCarrito controladorCarrito = new ControladorCarrito();
        controladorCarrito.inicioCarrito(controladorArticulo.inventario());

        Ticket ticketBase = new TicketBase();
        Ticket ticketDecorado = new FechaTicketDecorator(new ClienteTicketDecorator(ticketBase));
        ticketDecorado.imprimir();
    }
}

