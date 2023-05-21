// Decorador concreto que agrega la funcionalidad de nombre del cliente al ticket
public class ClienteTicketDecorator implements Ticket {
    private Ticket ticket;

    public ClienteTicketDecorator(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void imprimir() {
        ticket.imprimir();
        System.out.println("Cliente: Juan Pérez");
    }
}