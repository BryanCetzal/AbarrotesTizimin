import java.util.List;
import java.util.Scanner;

public class VistaCliente {

    private Scanner scanner;
    private Direccion direccion;

    public VistaCliente(){
        scanner = new Scanner(System.in);
        direccion = new Direccion();
    }

    public void mostrarMenuCliente() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Ver Clientes");
        System.out.println("2. Agregar Cliente");
        System.out.println("3. Actualizar Cliente");
        System.out.println("4. Eliminar Cliente");
        System.out.println("5. Salir");
        System.out.println("-----------------");
    }

    public int obtenerOpcion() {
        System.out.print("Ingresa tu opción: ");
        return scanner.nextInt();
    }

    public void mostrarClientes(List<Cliente> clientes) {
        System.out.println("----- CLIENTES -----");
        System.out.format("%-5s %-20s %-20s %-40s%n", "ID", "Nombre", "Apellido", "Dirección");
        for (Cliente cliente : clientes) {
            System.out.format("%-5d %-20s %-20s %-40s%n",
                    cliente.getIdcliente(),
                    cliente.getNombreCliente(),
                    cliente.getApellidoPaterno(),
                    cliente.getDireccion().toString()); // Aquí se llama al método toString() de la clase Direccion
        }
        System.out.println("---------------------");
    }


    public Cliente obtenerDatosCliente() {
        scanner.nextLine(); // Limpiar el buffer
        int id = 0;
        try {
            System.out.print("Ingresa el identificador del Cliente: ");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: el formato del identificador es inválido. Intente nuevamente.");
            return null;
        }

        System.out.print("Ingresa el nombre del Cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa el apellido del Cliente: ");
        String apellido = scanner.nextLine();

        Direccion dir = direccion.solictarDireccion();
        System.out.println();

        return new Cliente(id, nombre, apellido, dir);
    }


    public void mostarDetalleCliente(Cliente cliente){
        System.out.println("ID: " + cliente.getIdcliente() + " Nombre: " + cliente.getNombreCliente() +
                " Apellido: " + cliente.getApellidoPaterno() + " Dirección: " + cliente.getDireccion() );
    }

    public void modificarCliente(Cliente cliente) {
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        cliente.setNombreCliente(nuevoNombre);

        System.out.print("Nuevo apellido: ");
        String nuevoApellido = scanner.nextLine();
        cliente.setApellidoPaterno(nuevoApellido);

        direccion.modificarDireccion(cliente.getDireccion());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
