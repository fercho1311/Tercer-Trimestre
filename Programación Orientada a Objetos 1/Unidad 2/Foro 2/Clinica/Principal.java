public class Principal {
    
    public static void main(String[] args) {
        
        Perro perro1 = new Perro();
        perro1.nombre = "Bruno";
        Perro perro2 = new Perro();
        perro2.nombre = "Max";
        Perro perro3 = new Perro();
        perro3.nombre = "Duquesa";
//----------------------------------------------------------------------------------
        Gato gato1 = new Gato();
        gato1.nombre = "Mechas";
//----------------------------------------------------------------------------------
        Conejo conejo1 = new Conejo();
        conejo1.nombre = "Bugs";
//----------------------------------------------------------------------------------

        ClinicaVeterinaria clinica = new ClinicaVeterinaria();
        clinica.agregarPaciente(perro1);
        clinica.agregarPaciente(perro2);
        clinica.agregarPaciente(gato1);
        clinica.agregarPaciente(conejo1);
        clinica.agregarPaciente(perro3);

        clinica.tratarPaciente();
        clinica.tratarPaciente();
        clinica.tratarPaciente();
        clinica.tratarPaciente();
        clinica.tratarPaciente();
        clinica.tratarPaciente();

//----------------------------------------------------------------------------------

        SalonPerros salon = new SalonPerros();
        salon.agregarPerro(perro1);
        salon.agregarPerro(perro2);
        salon.agregarPerro(perro3);

        salon.atenderSiguientePerro();
        salon.atenderSiguientePerro();
        salon.atenderSiguientePerro();
        salon.atenderSiguientePerro();
    }
}
