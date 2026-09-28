import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Almacen {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        ArrayList<Paquete> paquetes = new ArrayList<>();

        ArrayList<Moto> motosDisponibles = new ArrayList<>();
        ArrayList<Moto> motosRepartiendo = new ArrayList<>();

        ArrayList<Camioneta> camionetasDisponibles = new ArrayList<>();
        ArrayList<Camioneta> camionetasRepartiendo = new ArrayList<>();

        // ==========================================
        // AGREGAR MOTOS
        // ==========================================

        motosDisponibles.add(new Moto("M001", "Juan"));
        motosDisponibles.add(new Moto("M002", "Pedro"));

        // ==========================================
        // AGREGAR CAMIONETAS
        // ==========================================

        camionetasDisponibles.add(new Camioneta("C001", "Carlos"));
        camionetasDisponibles.add(new Camioneta("C002", "Luis"));

        // ==========================================
        // CICLO PRINCIPAL
        // ==========================================

        while (true) {

            System.out.println("\n======================================");

            System.out.println("              NUEVO CICLO");
            System.out.println("======================================");

            // ==========================================
            // 1. REVISAR VEHÍCULOS QUE ESTÁN REPARTIENDO
            // ==========================================

            for (int i = motosRepartiendo.size() - 1; i >= 0; i--) {

                Moto moto = motosRepartiendo.get(i);

                moto.ciclosFuera--;

                if (moto.ciclosFuera <= 0) {

                    moto.paquete = null;

                    motosRepartiendo.remove(i);
                    motosDisponibles.add(moto);

                    System.out.println("La moto conducida por " + moto.empleado + " ha regresado al almacén.");
                }
            }


            for (int i = camionetasRepartiendo.size() - 1; i >= 0; i--) {

                Camioneta camioneta = camionetasRepartiendo.get(i);

                camioneta.ciclosFuera--;

                if (camioneta.ciclosFuera <= 0) {

                    camioneta.paquete = null;

                    camionetasRepartiendo.remove(i);
                    camionetasDisponibles.add(camioneta);

                    System.out.println("La camioneta conducida por " + camioneta.empleado + " ha regresado al almacén.");
                }
            }

            // ==========================================
            // 2. CREAR UN PAQUETE ALEATORIO
            // ==========================================

            int tipoPaquete = random.nextInt(3);

            int numeroCiudad = random.nextInt(5) + 1;

            String direccion = "Ciudad " + numeroCiudad;

            Paquete paquete;


            if (tipoPaquete == 0) {

                paquete = new PaquetePequeno(direccion);

            } else if (tipoPaquete == 1) {

                paquete = new PaqueteMediano(direccion);

            } else {

                paquete = new PaqueteGrande(direccion);
            }

            // Agregar paquete al final de la lista

            paquetes.add(paquete);

            // ==========================================
            // 3. MOSTRAR ESTADO DE LOS VEHÍCULOS
            // ==========================================

            System.out.println("\n---------- MOTOS DISPONIBLES ----------");

            if (motosDisponibles.isEmpty()) {

                System.out.println("No hay motos disponibles.");

            } else {

                for (Moto moto : motosDisponibles) {

                    System.out.println("Placa: " + moto.placa + " | Conductor: " + moto.empleado);
                }
            }

            System.out.println("\n------- CAMIONETAS DISPONIBLES -------");

            if (camionetasDisponibles.isEmpty()) {

                System.out.println("No hay camionetas disponibles.");

            } else {

                for (Camioneta camioneta : camionetasDisponibles) {

                    System.out.println("Placa: " + camioneta.placa + " | Conductor: " + camioneta.empleado);
                }
            }

            System.out.println("\n----------- MOTOS REPARTIENDO -----------");

            if (motosRepartiendo.isEmpty()) {

                System.out.println("No hay motos repartiendo.");

            } else {

                for (Moto moto : motosRepartiendo) {

                    System.out.println("Placa: " + moto.placa + " | Conductor: " + moto.empleado + " | Ciclos restantes: " + moto.ciclosFuera);
                }
            }

            System.out.println("\n-------- CAMIONETAS REPARTIENDO --------");

            if (camionetasRepartiendo.isEmpty()) {

                System.out.println("No hay camionetas repartiendo.");

            } else {

                for (Camioneta camioneta : camionetasRepartiendo) {

                    System.out.println("Placa: " + camioneta.placa + " | Conductor: " + camioneta.empleado + " | Ciclos restantes: " + camioneta.ciclosFuera);
                }
            }

            // ==========================================
            // 4. MOSTRAR EL PAQUETE GENERADO
            // ==========================================

            System.out.println("\n======================================");
            System.out.println("          PAQUETE GENERADO");
            System.out.println("======================================");

            if (paquete instanceof PaquetePequeno) {

                System.out.println("Tipo: Paquete pequeño");

            } else if (paquete instanceof PaqueteMediano) {

                System.out.println("Tipo: Paquete mediano");

            } else if (paquete instanceof PaqueteGrande) {

                System.out.println("Tipo: Paquete grande");
            }

            System.out.println("Dirección: " + paquete.direccionEntrega);

            // ==========================================
            // 5. ELEGIR VEHÍCULO
            // ==========================================

            /*
             * Si es un paquete grande solamente
             * puede utilizar una camioneta.
             */

            if (paquete instanceof PaqueteGrande) {

                System.out.println("\nEl paquete es grande.");

                System.out.println("Solo puede ser transportado por una camioneta.");

                if (!camionetasDisponibles.isEmpty()) {

                    Camioneta camioneta = camionetasDisponibles.remove(0);

                    camioneta.paquete = paquete;

                    // Camioneta = 3 ciclos

                    camioneta.ciclosFuera = 3;

                    camionetasRepartiendo.add(camioneta);

                    // El paquete ya fue asignado

                    paquetes.remove(paquete);

                    System.out.println("\nLa camioneta conducida por " + camioneta.empleado + " se dirige a una entrega en " + paquete.direccionEntrega);

                } else {

                    System.out.println("\nNo hay camionetas disponibles.");

                    System.out.println("El paquete queda pendiente.");
                }

            } else {
                /*
                 * Los paquetes pequeños y medianos
                 * pueden ser transportados por moto
                 * o camioneta.
                 */

                System.out.println("\nSeleccione el tipo de vehículo:");

                if (!motosDisponibles.isEmpty()) {

                    System.out.println("1. Moto");
                }

                if (!camionetasDisponibles.isEmpty()) {

                    System.out.println("2. Camioneta");
                }

                int opcion = teclado.nextInt();

                // ==========================================
                // ELEGIR MOTO
                // ==========================================

                if (opcion == 1 && !motosDisponibles.isEmpty()) {

                    Moto moto = motosDisponibles.remove(0);

                    moto.paquete = paquete;

                    // Moto = 2 ciclos

                    moto.ciclosFuera = 2;

                    motosRepartiendo.add(moto);

                    paquetes.remove(paquete);

                    System.out.println("\nLa moto conducida por " + moto.empleado + " se dirige a una entrega en " + paquete.direccionEntrega);

                // ==========================================
                // ELEGIR CAMIONETA
                // ==========================================

                } else if (opcion == 2 && !camionetasDisponibles.isEmpty()) {

                    Camioneta camioneta = camionetasDisponibles.remove(0);

                    camioneta.paquete = paquete;

                    // Camioneta = 3 ciclos

                    camioneta.ciclosFuera = 3;

                    camionetasRepartiendo.add(camioneta);

                    paquetes.remove(paquete);

                    System.out.println("\nLa camioneta conducida por " + camioneta.empleado + " se dirige a una entrega en " + paquete.direccionEntrega);
                } else {

                    System.out.println("\nOpción no válida.");

                    System.out.println("El paquete queda pendiente.");
                }
            }

            // ==========================================
            // 6. MOSTRAR PAQUETES PENDIENTES
            // ==========================================

            System.out.println("\n======================================");

            System.out.println("       PAQUETES PENDIENTES: " + paquetes.size());

            System.out.println("======================================");

            for (Paquete p : paquetes) {

                if (p instanceof PaquetePequeno) {

                    System.out.print("Pequeño - ");

                } else if (p instanceof PaqueteMediano) {

                    System.out.print("Mediano - ");

                } else if (p instanceof PaqueteGrande) {

                    System.out.print("Grande - ");
                }

                System.out.println(p.direccionEntrega);
            }

            // ==========================================
            // PAUSA ANTES DEL SIGUIENTE CICLO
            // ==========================================

            System.out.println("\nPresione ENTER para continuar...");

            teclado.nextLine();
            teclado.nextLine();
        }
    }
}