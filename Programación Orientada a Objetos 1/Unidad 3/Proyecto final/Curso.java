import java.util.ArrayList;

public class Curso {

    private String codCurso;
    private String nombre;
    private String descripcion;
    private int creditos;
    private Profesor profesor;
    private ArrayList<Horario> horarios;

    public Curso(String codCurso, String nombre, String descripcion, int creditos, Profesor profesor) {

        this.codCurso = codCurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.profesor = profesor;

        horarios = new ArrayList<>();
    }

    public void agregarHorario(Horario horario) {
        horarios.add(horario);
    }

    public String getCodCurso() {
        return codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void mostrarInformacion() {

        System.out.println("\n========================================");
        System.out.println("          INFORMACION DEL CURSO         ");
        System.out.println("========================================");
        System.out.println("Código: " + codCurso);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Créditos: " + creditos);
        System.out.println("\nProfesor:");

        profesor.mostrarInformacion();
        System.out.println("\nHorarios disponibles:");

        for (int i = 0; i < horarios.size(); i++) {

            System.out.println((i + 1) + ". " + horarios.get(i));
        }
    }
}
