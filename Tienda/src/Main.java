public class Main {
    public static void main(String[] args) {
        Ticket ticketBase = new TicketBase();
        Ticket ticketDecorado = new FechaTicketDecorator(new ClienteTicketDecorator(ticketBase));
        ticketDecorado.imprimir();

        ControladorArticulo controladorArticulo = new ControladorArticulo();
        controladorArticulo.iniciar();
    }
}

