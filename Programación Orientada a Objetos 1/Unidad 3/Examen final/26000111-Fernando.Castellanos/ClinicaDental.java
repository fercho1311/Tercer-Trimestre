import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClinicaDental {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Paciente> pacientes = new ArrayList<>();
    static ArrayList<Cita> citas = new ArrayList<>();

    // OBJETOS DE LA CLÍNICA

    static Dentista dentista = new Dentista(
            "Carlos López",
            "5555-1111",
            "carlos@clinica.com",
            "Odontología General"
    );

    static Asistente asistente = new Asistente(
            "Ana García",
            "5555-2222",
            "ana@clinica.com",
            "Matutino"
    );

    // MAIN

    public static void main(String[] args) {

        // PACIENTES YA REGISTRADOS

        Paciente paciente1 = new Paciente(
                1,
                "Juan Pérez",
                "5555-1234",
                "juan@gmail.com",
                "Limpieza dental",
                150
        );

        Paciente paciente2 = new Paciente(
                2,
                "María López",
                "5555-5678",
                "maria@gmail.com",
                "Ortodoncia",
                500
        );

        Paciente paciente3 = new Paciente(
                3,
                "Carlos Ramírez",
                "5555-9012",
                "carlos@gmail.com",
                "Extracción dental",
                300
        );

        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);

        // MENÚ PRINCIPAL

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println("          CLÍNICA DENTAL");
            System.out.println("=================================");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Mostrar pacientes");
            System.out.println("3. Agendar cita");
            System.out.println("4. Ver citas agendadas");
            System.out.println("5. Registrar pago");
            System.out.println("6. Cambiar tratamiento");
            System.out.println("7. Cambiar estado del tratamiento");
            System.out.println("8. Mostrar dentista");
            System.out.println("9. Mostrar asistente");
            System.out.println("0. Salir");
            System.out.println("=================================");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {

                case 1:
                    registrarPaciente();
                    break;

                case 2:
                    mostrarPacientes();
                    break;

                case 3:
                    agendarCita();
                    break;

                case 4:
                    mostrarCitas();
                    break;

                case 5:
                    registrarPago();
                    break;

                case 6:
                    cambiarTratamiento();
                    break;

                case 7:
                    cambiarEstado();
                    break;

                case 8:
                    dentista.mostrarInformacion();
                    break;

                case 9:
                    asistente.mostrarInformacion();
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // REGISTRAR PACIENTE

    public static void registrarPaciente() {

        System.out.println("\n--- REGISTRAR PACIENTE ---");

        System.out.print("ID del paciente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();


        System.out.println("\nSeleccione el tratamiento:");

        System.out.println("1. Limpieza dental - Q150");
        System.out.println("2. Ortodoncia - Q500");
        System.out.println("3. Extracción dental - Q300");
        System.out.println("4. Blanqueamiento - Q250");

        System.out.print("Seleccione: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();


        String tratamiento;
        double costo;


        switch (opcion) {

            case 1:
                tratamiento = "Limpieza dental";
                costo = 150;
                break;

            case 2:
                tratamiento = "Ortodoncia";
                costo = 500;
                break;

            case 3:
                tratamiento = "Extracción dental";
                costo = 300;
                break;

            case 4:
                tratamiento = "Blanqueamiento";
                costo = 250;
                break;

            default:
                System.out.println("Tratamiento no válido.");
                return;
        }

        Paciente paciente = new Paciente(id, nombre, telefono, correo, tratamiento, costo);
        pacientes.add(paciente);

        System.out.println("Paciente registrado correctamente.");
    }

    // MOSTRAR PACIENTES

    public static void mostrarPacientes() {

        if (pacientes.isEmpty()) {

            System.out.println("\nNo hay pacientes registrados.");
            return;
        }

        System.out.println("\n--- PACIENTES REGISTRADOS ---");

        for (Paciente paciente : pacientes) {
            paciente.mostrarInformacion();
        }
    }

    // BUSCAR PACIENTE

    public static Paciente buscarPaciente() {

        System.out.print("Ingrese el ID del paciente: ");

        int id = scanner.nextInt();
        scanner.nextLine();

        for (Paciente paciente : pacientes) {

            if (paciente.getIdPaciente() == id) {

                return paciente;
            }
        }

        System.out.println("Paciente no encontrado.");
        return null;
    }

    // AGENDAR CITA

    public static void agendarCita() {

        System.out.println("\n--- AGENDAR CITA ---");

        Paciente paciente = buscarPaciente();


        if (paciente == null) {
            return;
        }

        // VALIDAR FECHA

        String fecha;

        do {
            System.out.print("Fecha de la cita (dd/MM/yyyy): ");
            fecha = scanner.nextLine();

            if (!validarFecha(fecha)) {
                System.out.println("Fecha inválida. Ejemplo: 15/09/2026");
            }

        } while (!validarFecha(fecha));


        // VALIDAR HORA

        String hora;

        do {

            System.out.print("Hora de la cita (HH:mm): ");

            hora = scanner.nextLine();


            if (!validarHora(hora)) {
                System.out.println("Hora inválida. Ejemplo: 09:30");
            }

        } while (!validarHora(hora));

        // SELECCIONAR RESPONSABLE

        System.out.println("\n¿Quién agendará la cita?");
        System.out.println("1. Dentista");
        System.out.println("2. Asistente");
        System.out.print("Seleccione: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();


        String responsable;


        if (opcion == 1) {
            responsable = dentista.getNombre();

        } else if (opcion == 2) {
            responsable = asistente.getNombre();

        } else {
            System.out.println("Opción no válida.");
            return;
        }

        // VERIFICAR TRASLAPE DEL RESPONSABLE

        if (existeTraslape(fecha, hora, responsable)) {

            System.out.println("\nERROR: Ya existe una cita para " + responsable + " que se traslapa con ese horario.");
            return;
        }

        // VERIFICAR TRASLAPE DEL PACIENTE

        if (pacienteTieneCita(paciente, fecha, hora)) {

            System.out.println("\nERROR: El paciente " + paciente.getNombre() + " ya tiene una cita que se traslapa " + "con ese horario.");
            return;
        }

        // CREAR LA CITA

        if (opcion == 1) {
            dentista.agendarCita( paciente, fecha, hora);

        } else {
            asistente.agendarCita(paciente, fecha, hora);
        }

        Cita cita = new Cita(paciente, fecha, hora, responsable);

        citas.add(cita);

        System.out.println("\nCita registrada correctamente.");
    }

    // VALIDAR FECHA

    public static boolean validarFecha(String fecha) {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

                try {

                LocalDate.parse(fecha, formato);
                return true;

                } catch (DateTimeParseException e) {
                return false;
        }
    }

    // VALIDAR HORA

    public static boolean validarHora(String hora) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

        try {

            LocalTime.parse(hora, formato);
            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // VERIFICAR TRASLAPE

    public static boolean existeTraslape(
            String fecha,
            String hora,
            String responsable) {

        LocalTime nuevaHora = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));

        // Cada cita dura 1 hora
        LocalTime nuevaHoraFin = nuevaHora.plusHours(1);

        for (Cita cita : citas) {

            // Comprobar misma fecha
            if (!cita.getFecha().equals(fecha)) {
                continue;
            }

            // Comprobar mismo responsable
            if (!cita.getResponsable().equals(responsable)) {
                continue;
            }

            LocalTime horaExistente = LocalTime.parse(cita.getHora(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime horaExistenteFin = horaExistente.plusHours(1);

            // Comprobar traslape
            if (nuevaHora.isBefore(horaExistenteFin)
                    && nuevaHoraFin.isAfter(horaExistente)) {

                return true;
            }
        }
        return false;
    }

    // VERIFICAR CITA DEL PACIENTE

    public static boolean pacienteTieneCita(Paciente paciente, String fecha, String hora) {

        LocalTime nuevaHora = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));

        LocalTime nuevaHoraFin = nuevaHora.plusHours(1);

        for (Cita cita : citas) {

            // Comprobar mismo paciente
            if (!cita.getPaciente().equals(paciente)) {
                continue;
            }

            // Comprobar misma fecha
            if (!cita.getFecha().equals(fecha)) {
                continue;
            }

            LocalTime horaExistente = LocalTime.parse(cita.getHora(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime horaExistenteFin = horaExistente.plusHours(1);

            // Comprobar traslape
            if (nuevaHora.isBefore(horaExistenteFin) && nuevaHoraFin.isAfter(horaExistente)) {
                return true;
            }
        }
        return false;
    }

    // MOSTRAR CITAS

    public static void mostrarCitas() {

        System.out.println("\n--- CITAS AGENDADAS ---");


        if (citas.isEmpty()) {

            System.out.println("No hay citas agendadas.");
            return;
        }


        for (Cita cita : citas) {
            cita.mostrarCita();
        }
    }

    // REGISTRAR PAGO

    public static void registrarPago() {

        System.out.println("\n--- REGISTRAR PAGO ---");
        Paciente paciente = buscarPaciente();

        if (paciente == null) {
            return;
        }

        System.out.println("Tratamiento: " + paciente.getTratamiento());
        System.out.println("Costo: Q" + paciente.getCostoTratamiento());
        System.out.println("Pagado: Q" + paciente.getTotalPagado());
        System.out.println("Saldo pendiente: Q" + paciente.getSaldoPendiente());

        if (paciente.getSaldoPendiente() == 0) {

            System.out.println("El tratamiento ya está pagado.");
            return;
        }

        System.out.print("Ingrese la cantidad a pagar: Q");

        double cantidad = scanner.nextDouble();
        scanner.nextLine();
        paciente.registrarPago(cantidad);
    }

    // CAMBIAR TRATAMIENTO

    public static void cambiarTratamiento() {

        System.out.println("\n--- CAMBIAR TRATAMIENTO ---");

        Paciente paciente = buscarPaciente();

        if (paciente == null) {
            return;
        }

        System.out.println("\nSeleccione el nuevo tratamiento:");
        System.out.println("1. Limpieza dental - Q150");
        System.out.println("2. Ortodoncia - Q500");
        System.out.println("3. Extracción dental - Q300");
        System.out.println("4. Blanqueamiento - Q250");
        System.out.print("Seleccione: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();


        String tratamiento;
        double costo;

        switch (opcion) {

            case 1:

                tratamiento = "Limpieza dental";
                costo = 150;
                break;

            case 2:

                tratamiento = "Ortodoncia";
                costo = 500;
                break;

            case 3:

                tratamiento = "Extracción dental";
                costo = 300;
                break;

            case 4:

                tratamiento = "Blanqueamiento";
                costo = 250;
                break;

            default:

                System.out.println("Tratamiento no válido.");
                return;
        }
        paciente.cambiarTratamiento(tratamiento, costo);
    }

    // CAMBIAR ESTADO

    public static void cambiarEstado() {

        System.out.println("\n--- CAMBIAR ESTADO DEL TRATAMIENTO ---");
        Paciente paciente = buscarPaciente();

        if (paciente == null) {
            return;
        }

        System.out.println("1. Pendiente");
        System.out.println("2. En proceso");
        System.out.println("3. Finalizado");
        System.out.print("Seleccione el nuevo estado: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        String estado;

        switch (opcion) {

            case 1:

                estado = "Pendiente";
                break;

            case 2:

                estado = "En proceso";
                break;

            case 3:

                estado = "Finalizado";
                break;

            default:

                System.out.println(
                        "Opción no válida."
                );
                return;
        }

        paciente.cambiarEstadoTratamiento(estado);
        System.out.println("Estado actualizado correctamente.");
    }
}