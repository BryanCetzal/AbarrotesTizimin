import java.time.LocalDate;
// Decorador concreto que agrega la funcionalidad de fecha al ticket
public class FechaTicketDecorator implements Ticket {
    private Ticket ticket;

    public FechaTicketDecorator(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void imprimir() {
        ticket.imprimir();
        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha de compra: " + fechaActual);
    }
}