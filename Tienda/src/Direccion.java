import java.util.Scanner;

public class Direccion {
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;
    private String ciudad;
    private String estado;
    private String telefono;
    private Scanner scanner;

    public Direccion(String calle, String numero, String colonia, String codigoPostal, String ciudad, String estado, String telefono) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telefono = telefono;
    }

    public Direccion() {
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion solictarDireccion(){
        scanner = new Scanner(System.in);
        System.out.print("Calle: ");
        String calle = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Colonia: ");
        String colonia = scanner.nextLine();
        System.out.print("Código Postal: ");
        String cp = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        return new Direccion(calle, numero, colonia, cp, ciudad, estado, telefono);
    }

    public void modificarDireccion(Direccion direccion){
        scanner.nextLine();
        System.out.print("Calle: ");
        String calle = scanner.nextLine();
        direccion.setCalle(calle);

        System.out.print("Núcmero: ");
        String numero = scanner.nextLine();
        direccion.setNumero(numero);

        System.out.print("Colonia: ");
        String colonia = scanner.nextLine();
        direccion.setColonia(colonia);

        System.out.print("Código Postal: ");
        String cp = scanner.nextLine();
        direccion.setCodigoPostal(cp);

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        direccion.setCiudad(ciudad);

        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        direccion.setEstado(estado);

        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        direccion.setTelefono(telefono);
    }

    public String toString() {
        return "Calle: " + calle +
                " Número: " + numero +
                " Colonia: " + colonia +
                " Código Postal: " + codigoPostal +
                " Ciudad: " + ciudad +
                " Estado: " + estado +
                " Teléfono: " + telefono;
    }
}