public class Cita {

    private Paciente paciente;
    private String fecha;
    private String hora;
    private String responsable;

    public Cita(Paciente paciente, String fecha, String hora, String responsable) {

        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.responsable = responsable;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getResponsable() {
        return responsable;
    }

    public void mostrarCita() {

        System.out.println("\n-----------------------------");
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Responsable: " + responsable);
        System.out.println("-----------------------------");
    }
}