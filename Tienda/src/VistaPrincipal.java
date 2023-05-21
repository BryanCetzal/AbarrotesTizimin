import java.util.Scanner;

public class VistaPrincipal {
    private Scanner scanner;

    public VistaPrincipal(){
        scanner = new Scanner(System.in);
    }
    public int menuPrincipal(){
        System.out.println("--------ABARROTES TIZIMÍN---------");
        System.out.println("1. Clientes");
        System.out.println("2. Artículos (Inventario)");
        System.out.println("3. Realizar compra");
        System.out.println("4. Salir");
        System.out.println("----------------------------------");
        System.out.println("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int procesoCompra(){
        System.out.println("1. Seleccionar productos");
        System.out.println("2. Pagar");
        System.out.println("3. Salir");
        System.out.println("Seleccione una opcion: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
