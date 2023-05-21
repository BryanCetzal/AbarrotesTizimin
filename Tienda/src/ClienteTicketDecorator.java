// Decorador concreto que agrega la funcionalidad de nombre del cliente al ticket
public class ClienteTicketDecorator implements Ticket {
    private Ticket ticket;
    private Cliente cliente;

    public ClienteTicketDecorator(Ticket ticket, Cliente cliente) {
        this.ticket = ticket;
        this.cliente = cliente;
    }

    @Override
    public void imprimir() {
        ticket.imprimir();
        System.out.println("Cliente: " + cliente.getNombreCliente() +" "+ cliente.getApellidoPaterno());
    }
}