public class Paciente extends Humano {

    private int idPaciente;
    private String tratamiento;
    private double costoTratamiento;
    private String estadoTratamiento;
    private double totalPagado;

    public Paciente(int idPaciente, String nombre, String telefono, String correo, String tratamiento, double costoTratamiento) {

        super(nombre, telefono, correo);

        this.idPaciente = idPaciente;
        this.tratamiento = tratamiento;
        this.costoTratamiento = costoTratamiento;
        this.estadoTratamiento = "Pendiente";
        this.totalPagado = 0;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public double getCostoTratamiento() {
        return costoTratamiento;
    }

    public String getEstadoTratamiento() {
        return estadoTratamiento;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public double getSaldoPendiente() {
        return costoTratamiento - totalPagado;
    }

    public void registrarPago(double cantidad) {

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            return;
        }

        if (cantidad > getSaldoPendiente()) {
            System.out.println("El pago no puede ser mayor al saldo pendiente.");
            return;
        }

        totalPagado += cantidad;

        System.out.println("Pago registrado correctamente.");
        System.out.println("Saldo pendiente: Q" + getSaldoPendiente());
    }

    public void cambiarTratamiento(String tratamiento, double costo) {

        this.tratamiento = tratamiento;
        this.costoTratamiento = costo;
        this.estadoTratamiento = "Pendiente";

        System.out.println("Tratamiento actualizado correctamente.");
        System.out.println("Nuevo costo: Q" + costo);
        System.out.println("Saldo pendiente: Q" + getSaldoPendiente());
    }

    public void cambiarEstadoTratamiento(String estado) {
        this.estadoTratamiento = estado;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("\n--- INFORMACIÓN DEL PACIENTE ---");
        System.out.println("ID: " + idPaciente);
        System.out.println("Nombre: " + getNombre());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Correo: " + getCorreo());
        System.out.println("Tratamiento: " + tratamiento);
        System.out.println("Costo del tratamiento: Q" + costoTratamiento);
        System.out.println("Estado: " + estadoTratamiento);
        System.out.println("Total pagado: Q" + totalPagado);
        System.out.println("Saldo pendiente: Q" + getSaldoPendiente());
    }
}