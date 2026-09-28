public class Dentista extends Humano implements GestionCitas {

    private String especialidad;

    public Dentista(String nombre, String telefono, String correo, String especialidad) {

        super(nombre, telefono, correo);

        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public void agendarCita(Paciente paciente, String fecha, String hora) {

        System.out.println("\n--- CITA AGENDADA ---");
        System.out.println("Dentista: " + getNombre());
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("\n--- INFORMACIÓN DEL DENTISTA ---");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Correo: " + getCorreo());
        System.out.println("Especialidad: " + especialidad);
    }
}