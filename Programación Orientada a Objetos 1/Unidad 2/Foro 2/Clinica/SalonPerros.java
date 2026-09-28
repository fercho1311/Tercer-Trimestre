import java.util.ArrayList;

public class SalonPerros {
    
    private ArrayList<Perro> perros;

    public SalonPerros(){
        perros = new ArrayList<Perro>();
    }

    public void agregarPerro(Perro nuevoPerro){
        perros.add(nuevoPerro);

        System.out.println("Ingresando al salon a " + nuevoPerro.nombre);
    }

    public Perro atenderSiguientePerro(){
        if (perros.isEmpty()) {
            System.out.println("No hay mas pacientes para ingresar al salon.");
            return null;
        }

        Perro nuevoPerro = perros.get(0);

        System.out.println("Atendiendo a " + nuevoPerro.nombre);
        perros.remove(0);
        return nuevoPerro;
    }
}
