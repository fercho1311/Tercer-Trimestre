import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // CREAR PROFESORES

        Profesor profesor1 = new Profesor("Carlos López", "P001", "Programación");
        Profesor profesor2 = new Profesor("María García", "P002", "Matemática");
        Profesor profesor3 = new Profesor("Juan Pérez", "P003", "Bases de Datos");
        Profesor profesor4 = new Profesor("Ana Martínez", "P004", "Estructuras de Datos");
        Profesor profesor5 = new Profesor("Luis Rodríguez", "P005", "Sistemas Operativos");
        Profesor profesor6 = new Profesor("Sofía Hernández", "P006", "Redes");

        // CREAR CURSOS

        Curso matematica1 = new Curso("MAT101", "Matemática 1", "Fundamentos de matemática.", 4, profesor2);

        matematica1.agregarHorario(new Horario("Lunes", "08:00", "10:00"));
        matematica1.agregarHorario(new Horario("Martes", "14:00", "16:00"));

        Curso programacion1 = new Curso("PROG101", "Programación 1", "Introducción a la programación.", 5, profesor1);

        programacion1.agregarHorario(new Horario("Lunes", "09:00", "11:00"));
        programacion1.agregarHorario(new Horario("Miércoles", "14:00", "16:00"));

        Curso matematica2 = new Curso("MAT201", "Matemática 2", "Continuación de Matemática 1.", 4, profesor2);

        matematica2.agregarHorario(new Horario("Martes", "08:00", "10:00"));
        matematica2.agregarHorario(new Horario("Jueves", "14:00", "16:00"));

        Curso programacion2 = new Curso("PROG201", "Programación 2", "Programación orientada a objetos.", 5, profesor1);

        programacion2.agregarHorario(new Horario( "Martes", "09:00", "11:00"));
        programacion2.agregarHorario(new Horario("Viernes", "14:00", "16:00"));

        Curso basesDatos = new Curso("BD101", "Bases de Datos", "Fundamentos de bases de datos.", 4, profesor3);

        basesDatos.agregarHorario(new Horario("Lunes", "10:00", "12:00"));
        basesDatos.agregarHorario(new Horario("Martes", "14:00", "16:00"));

        Curso estructurasDatos = new Curso("ED101", "Estructuras de Datos", "Estructuras y manejo de datos.", 5, profesor4);

        estructurasDatos.agregarHorario(new Horario("Miércoles", "08:00", "10:00"));
        estructurasDatos.agregarHorario(new Horario("Viernes", "10:00", "12:00"));

        Curso sistemasOperativos = new Curso("SO101", "Sistemas Operativos", "Fundamentos de sistemas operativos.", 4, profesor5);

        sistemasOperativos.agregarHorario(new Horario( "Miércoles", "09:00", "11:00"));
        sistemasOperativos.agregarHorario(new Horario("Jueves", "14:00", "16:00"));

        Curso redes = new Curso("RED101", "Redes de Computadoras", "Fundamentos de redes.", 4, profesor6);

        redes.agregarHorario(new Horario("Jueves", "08:00", "10:00"));
        redes.agregarHorario(new Horario( "Viernes", "14:00", "16:00"));

        Curso ingenieriaSoftware = new Curso("IS101", "Ingeniería de Software", "Principios de desarrollo de software.", 4, profesor1);

        ingenieriaSoftware.agregarHorario(new Horario("Lunes", "14:00", "16:00"));
        ingenieriaSoftware.agregarHorario(new Horario("Miércoles", "16:00", "18:00"));

        Curso analisisSistemas = new Curso("ADS101", "Análisis y Diseño de Sistemas", "Análisis y diseño de sistemas informáticos.", 4, profesor3);

        analisisSistemas.agregarHorario(new Horario("Martes", "16:00", "18:00"));
        analisisSistemas.agregarHorario(new Horario("Jueves", "16:00", "18:00"));

        // CREAR CARRERA

        Carrera carrera = new Carrera("Ingeniería en Sistemas");

        carrera.agregarCurso(matematica1);
        carrera.agregarCurso(programacion1);
        carrera.agregarCurso(matematica2);
        carrera.agregarCurso(programacion2);
        carrera.agregarCurso(basesDatos);
        carrera.agregarCurso(estructurasDatos);
        carrera.agregarCurso(sistemasOperativos);
        carrera.agregarCurso(redes);
        carrera.agregarCurso(ingenieriaSoftware);
        carrera.agregarCurso(analisisSistemas);

        // CREAR ESTUDIANTE

        Estudiante estudiante = new Estudiante("Pedro González", "20260001");

        // MENÚ PRINCIPAL

        int opcion;

        do {

            mostrarMenuPrincipal(estudiante);

            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {

                case 1:

                    menuCursosDisponibles(scanner, carrera, estudiante);

                    break;

                case 2:

                    menuCursosAsignados( scanner, estudiante);

                    break;

                case 3:

                    menuCursosRetirados(scanner, estudiante);

                    break;

                case 0:

                    System.out.println("\nPrograma finalizado.");

                    break;

                default:

                    System.out.println("\nOpción no válida.");
                    System.out.println("Debe seleccionar una de " + "las opciones presentadas.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // MENÚ PRINCIPAL

    public static void mostrarMenuPrincipal(Estudiante estudiante) {

        System.out.println("\n==========================================");
        System.out.println("       SISTEMA DE ASIGNACIÓN DE CURSOS    ");
        System.out.println("==========================================");
        System.out.println("Carrera: Ingeniería en Sistemas");
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Carnet: " + estudiante.getCarnet());
        System.out.println();
        System.out.println("1. Ver cursos disponibles");
        System.out.println("2. Ver mis cursos asignados");
        System.out.println("3. Ver cursos retirados");
        System.out.println("0. Salir");
        System.out.println();
    }

    // CURSOS DISPONIBLES

    public static void menuCursosDisponibles(Scanner scanner, Carrera carrera, Estudiante estudiante) {

        while (true) {

            System.out.println("\n==========================================");
            System.out.println("             CURSOS DISPONIBLES           ");
            System.out.println("==========================================");

            boolean hayCursos = false;

            for (Curso curso : carrera.getCursos()) {

                if (!estudiante.cursoEstaAsignado(curso) && !estudiante.cursoFueRetirado(curso)) {

                    System.out.println(curso.getCodCurso() + " - " + curso.getNombre());

                    hayCursos = true;
                }
            }

            if (!hayCursos) {

                System.out.println("No hay cursos disponibles.");

                pausar(scanner);

                return;
            }

            System.out.println();
            System.out.println("Ingrese el código del curso.");
            System.out.println("Ingrese 0 para regresar.");
            System.out.print("Código: ");

            String codigo = scanner.nextLine().trim();

            if (codigo.equals("0")) {
                return;
            }

            Curso curso = carrera.buscarCurso(codigo);

            if (curso == null) {

                System.out.println("\nEl curso no existe.");
                continue;
            }

            if (estudiante.cursoEstaAsignado(curso)) {

                System.out.println("\nEl curso ya está asignado.");
                continue;
            }

            if (estudiante.cursoFueRetirado(curso)) {

                System.out.println("\nEl curso fue retirado " + "anteriormente.");
                continue;
            }

            curso.mostrarInformacion();

            System.out.println("\n1. Inscribirse al curso");
            System.out.println("0. Regresar");

            int opcion = leerOpcion(scanner, "Seleccione una opción: ", 0, 1);

            if (opcion == 0) {
                continue;
            }

            Horario horarioSeleccionado = seleccionarHorario( scanner, curso);

            if (horarioSeleccionado == null) {
                continue;
            }

            estudiante.asignarCurso(curso, horarioSeleccionado);

            pausar(scanner);
        }
    }

    // SELECCIONAR HORARIO

    public static Horario seleccionarHorario(Scanner scanner, Curso curso) {

        System.out.println("\n==========================================");
        System.out.println("          SELECCIÓN DE HORARIO            ");
        System.out.println("==========================================");

        for (int i = 0; i < curso.getHorarios().size(); i++) {

            System.out.println((i + 1) + ". " + curso.getHorarios().get(i));
        }

        System.out.println("0. Regresar");

        int seleccion = leerOpcion(scanner, "Seleccione el horario: ", 0, curso.getHorarios().size());

        /*0 = regresar.*/
        if (seleccion == 0) {
            return null;
        }

        return curso.getHorarios().get(seleccion - 1);
    }

    // CURSOS ASIGNADOS

    public static void menuCursosAsignados(
            Scanner scanner,
            Estudiante estudiante) {

        while (true) {

            estudiante.mostrarCursosAsignados();

            if (estudiante.getCursosAsignados().isEmpty()) {

                System.out.println("\n0. Regresar");

                int opcion = leerOpcion(scanner, "Seleccione una opción: ", 0, 0);

                if (opcion == 0) {
                    return;
                }
            }

            System.out.println("\nIngrese el código de un curso.");
            System.out.println("Ingrese 0 para regresar.");
            System.out.print("Código: ");

            String codigo = scanner.nextLine().trim();

            if (codigo.equals("0")) {
                return;
            }

            Curso cursoSeleccionado = null;

            for (Curso curso : estudiante.getCursosAsignados()) {

                if (curso.getCodCurso().equalsIgnoreCase(codigo)) {
                    cursoSeleccionado = curso;

                    break;
                }
            }

            if (cursoSeleccionado == null) {

                System.out.println("\nEl curso no está asignado.");
                continue;
            }

            cursoSeleccionado.mostrarInformacion();

            System.out.println("\nHorario actualmente asignado:");
            System.out.println(estudiante.obtenerHorario(cursoSeleccionado));
            System.out.println();
            System.out.println("1. Retirarme del curso");

            if (cursoSeleccionado.getHorarios().size() > 1) {

                System.out.println("2. Cambiar de horario");
            }

            System.out.println(
                    "0. Regresar"
            );

            int maximo;

            if (cursoSeleccionado.getHorarios().size() > 1) {
                maximo = 2;

            } else {
                maximo = 1;
            }

            int opcion = leerOpcion(scanner, "Seleccione una opción: ", 0, maximo);

            // REGRESAR

            if (opcion == 0) {
                return;
            }

            // RETIRAR

            if (opcion == 1) {

                estudiante.retirarCurso(cursoSeleccionado);

                pausar(scanner);

                continue;
            }

            // CAMBIAR HORARIO

            if (opcion == 2) {

                Horario nuevoHorario = seleccionarHorario(scanner, cursoSeleccionado);

                if (nuevoHorario != null) {

                    estudiante.cambiarHorario(cursoSeleccionado, nuevoHorario);
                    pausar(scanner);
                }
            }
        }
    }

    // CURSOS RETIRADOS

    public static void menuCursosRetirados(Scanner scanner, Estudiante estudiante) {

        while (true) {

            System.out.println("\n==========================================");
            System.out.println("             CURSOS RETIRADOS");
            System.out.println("==========================================");

            if (estudiante.getCursosRetirados().isEmpty()) {

                System.out.println("No tiene cursos retirados.");

            } else {
                for (Curso curso : estudiante.getCursosRetirados()) {

                    System.out.println(curso.getCodCurso() + " - " + curso.getNombre());
                }
            }

            System.out.println();
            System.out.println("0. Regresar");

            int opcion = leerOpcion(scanner, "Seleccione una opción: ", 0, 0);

            if (opcion == 0) {
                return;
            }
        }
    }

    // VALIDAR ENTEROS

    public static int leerEntero(Scanner scanner, String mensaje) {

        /*Solamente acepta números enteros*/
        while (true) {

            System.out.print(mensaje);

            String entrada = scanner.nextLine().trim();

            try {

                return Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println("\nEntrada no válida.");
                System.out.println("Debe ingresar un número entero.");
            }
        }
    }

    // VALIDAR OPCIÓN

    public static int leerOpcion(Scanner scanner, String mensaje, int minimo, int maximo) {

        while (true) {

            int opcion = leerEntero(scanner, mensaje);

            if (opcion >= minimo
                    && opcion <= maximo) {

                return opcion;
            }

            System.out.println("\nOpción no válida.");
            System.out.println("Debe seleccionar una de " + "las opciones presentadas.");
        }
    }

    public static void pausar(Scanner scanner) {

        System.out.println();
        System.out.println("Presione ENTER para continuar...");
        scanner.nextLine();
    }
}