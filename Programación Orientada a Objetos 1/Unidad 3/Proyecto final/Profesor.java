public class Profesor {

    private String nombre;
    private String identificacion;
    private String especialidad;

    public Profesor(String nombre, String identificacion, String especialidad) {

        this.nombre = nombre;
        this.identificacion = identificacion;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void mostrarInformacion() {

        System.out.println("Profesor: " + nombre);
        System.out.println("Identificación: " + identificacion);
        System.out.println("Especialidad: " + especialidad
        );
    }
}
