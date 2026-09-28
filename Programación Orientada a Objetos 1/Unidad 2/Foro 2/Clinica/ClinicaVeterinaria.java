import java.util.ArrayList;

public class ClinicaVeterinaria {
    
    private ArrayList<Animal> pacientes;

    public ClinicaVeterinaria(){
        pacientes = new ArrayList<Animal>();
    }

    public void agregarPaciente(Animal paciente){
        pacientes.add(paciente);

        System.out.println("Ingresando al paciente "+ paciente.nombre);
    }

    public Animal tratarPaciente(){
        if (pacientes.isEmpty()){
            System.out.println("No hay mas pacientes para atender.");
            return null;
        }
        
        Animal paciente = pacientes.get(0);

        System.out.println("Dando de alta a: " + paciente.nombre );
        pacientes.remove(0);
        return paciente;
    }
}
