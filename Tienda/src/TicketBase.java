// Clase base que implementa el componente base del ticket
public class TicketBase implements Ticket {
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo lista de artículos del carrito...");
    }
}