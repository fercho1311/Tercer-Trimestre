import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String carnet;
    private ArrayList<Curso> cursosAsignados;
    private ArrayList<Horario> horariosAsignados;
    private ArrayList<Curso> cursosRetirados;

    public Estudiante(
            String nombre,
            String carnet) {

        this.nombre = nombre;
        this.carnet = carnet;

        cursosAsignados = new ArrayList<>();
        horariosAsignados = new ArrayList<>();
        cursosRetirados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public ArrayList<Curso> getCursosAsignados() {
        return cursosAsignados;
    }

    public ArrayList<Horario> getHorariosAsignados() {
        return horariosAsignados;
    }

    public ArrayList<Curso> getCursosRetirados() {
        return cursosRetirados;
    }

    public boolean cursoEstaAsignado(Curso curso) {

        return cursosAsignados.contains(curso);
    }

    public boolean cursoFueRetirado(Curso curso) {

        return cursosRetirados.contains(curso);
    }

    public boolean existeConflicto(Horario nuevoHorario) {

        for (Horario horarioAsignado : horariosAsignados) {

            if (horarioAsignado.tieneConflicto(nuevoHorario)) {
                return true;
            }
        }
        return false;
    }

    public boolean asignarCurso(Curso curso, Horario horario) {

        if (cursoEstaAsignado(curso)) {

            System.out.println("\nNo se puede asignar el curso.");
            System.out.println("Ya tiene asignado este curso.");
            System.out.println("No puede inscribirse en otra " + "sección del mismo curso.");
            return false;
        }

        if (cursoFueRetirado(curso)) {

            System.out.println("\nNo se puede asignar el curso.");
            System.out.println("El curso fue retirado anteriormente.");
            System.out.println("No puede volver a asignarlo " + "durante esta ejecución.");
            return false;
        }

        if (existeConflicto(horario)) {

            System.out.println("\nNo se puede asignar el curso.");
            System.out.println("Existe un conflicto de horario.");

            return false;
        }

        cursosAsignados.add(curso);
        horariosAsignados.add(horario);

        System.out.println("\nCurso asignado exitosamente.");

        return true;
    }

    public boolean retirarCurso(Curso curso) {

        int posicion = cursosAsignados.indexOf(curso);

        if (posicion == -1) {

            System.out.println("\nEl curso no está asignado.");
            return false;
        }

        cursosAsignados.remove(posicion);
        horariosAsignados.remove(posicion);
        cursosRetirados.add(curso);

        System.out.println("\nCurso retirado exitosamente.");
        return true;
    }

    public boolean cambiarHorario(Curso curso, Horario nuevoHorario) {

        int posicion = cursosAsignados.indexOf(curso);

        if (posicion == -1) {

            System.out.println("\nEl curso no está asignado.");
            return false;
        }

        for (int i = 0; i < horariosAsignados.size(); i++) {

            if (i == posicion) {
                continue;
            }

            if (horariosAsignados.get(i).tieneConflicto(nuevoHorario)) {

                System.out.println("\nNo se puede cambiar " + "el horario.");
                System.out.println("El nuevo horario entra " + "en conflicto con " + "otro curso.");
                return false;
            }
        }

        horariosAsignados.set(posicion, nuevoHorario);

        System.out.println("\nCambio de horario exitoso.");
        return true;
    }

    public void mostrarCursosAsignados() {

        System.out.println("\n========================================");
        System.out.println("           MIS CURSOS ASIGNADOS         ");
        System.out.println("========================================");

        if (cursosAsignados.isEmpty()) {

            System.out.println("No tiene cursos asignados.");
            return;
        }

        for (int i = 0; i < cursosAsignados.size(); i++) {

            Curso curso = cursosAsignados.get(i);
            Horario horario = horariosAsignados.get(i);

            System.out.println((i + 1) + ". " + curso.getCodCurso() + " - " + curso.getNombre());
            System.out.println(" Horario: " + horario);
        }
    }

    public void mostrarCursosRetirados() {

        System.out.println("\n========================================");
        System.out.println("            CURSOS RETIRADOS            ");
        System.out.println("========================================");

        if (cursosRetirados.isEmpty()) {
            System.out.println("No tiene cursos retirados.");
            return;
        }

        for (Curso curso : cursosRetirados) {
            System.out.println(curso.getCodCurso() + " - " + curso.getNombre());
        }
    }

    public Horario obtenerHorario(Curso curso) {
        int posicion = cursosAsignados.indexOf(curso);

        if (posicion == -1) {
            return null;
        }
        return horariosAsignados.get(posicion);
    }
}