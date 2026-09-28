import java.util.ArrayList;

public class Carrera {

    private String nombre;
    private ArrayList<Curso> cursos;

    public Carrera(String nombre) {
        this.nombre = nombre;
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public Curso buscarCurso(String codCurso) {

        for (Curso curso : cursos) {

            if (curso.getCodCurso().equalsIgnoreCase(codCurso)) {
                return curso;
            }
        }

        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}
