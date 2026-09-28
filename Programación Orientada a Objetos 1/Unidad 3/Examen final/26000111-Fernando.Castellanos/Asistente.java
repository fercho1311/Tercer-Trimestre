public class Asistente extends Humano implements GestionCitas {

    private String turno;

    public Asistente(String nombre, String telefono, String correo, String turno) {

        super(nombre, telefono, correo);

        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    @Override
    public void agendarCita(Paciente paciente, String fecha, String hora) {

        System.out.println("\n--- CITA REGISTRADA ---");
        System.out.println("Asistente: " + getNombre());
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("\n--- INFORMACIÓN DEL ASISTENTE ---");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Correo: " + getCorreo());
        System.out.println("Turno: " + turno);
    }
}