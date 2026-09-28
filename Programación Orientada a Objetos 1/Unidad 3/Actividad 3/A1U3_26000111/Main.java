import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PointOfSale pos = new PointOfSale();

        TarjetaDebito debito1 = new TarjetaDebito(0.00);
        TarjetaDebito debito2 = new TarjetaDebito(10000.00);

        TarjetaCredito credito1 = new TarjetaCredito(10000.00, 0.00);
        TarjetaCredito credito2 = new TarjetaCredito(10000.00, 9999.00);

        ArrayList<AutorizacionPago> tarjetas = new ArrayList<>();

        tarjetas.add(debito1);
        tarjetas.add(debito2);
        tarjetas.add(credito1);
        tarjetas.add(credito2);

        System.out.print("Ingrese el total de la venta: ");
        Double totalVenta = scanner.nextDouble();

        // Validar que el total sea menor o igual a 10,000
        while (totalVenta > 10000 || totalVenta <= 0) {
            System.out.println("El total debe ser mayor a 0 y menor o igual a 10,000.");
            System.out.print("Ingrese nuevamente el total de la venta: ");
            totalVenta = scanner.nextDouble();
        }

        boolean pagoExitoso = false;

        while (!pagoExitoso) {

            System.out.println("\n----- MÉTODOS DE PAGO -----");
            System.out.println("1. Tarjeta Débito - Saldo: Q" + debito1.getSaldo());
            System.out.println("2. Tarjeta Débito - Saldo: Q" + debito2.getSaldo());
            System.out.println("3. Tarjeta Crédito - Límite: Q" + credito1.getCreditoLimite() + " - Utilizado: Q" + credito1.getCreditoUtilizado());
            System.out.println("4. Tarjeta Crédito - Límite: Q" + credito2.getCreditoLimite() + " - Utilizado: Q" + credito2.getCreditoUtilizado());
            System.out.print("\nSeleccione una tarjeta: ");
            int opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 4) {

                AutorizacionPago tarjetaSeleccionada = tarjetas.get(opcion - 1);
                pagoExitoso = pos.realizarVenta(tarjetaSeleccionada, totalVenta);

                if (pagoExitoso) {
                    System.out.println("\nPago exitoso, gracias por su compra");
                } else {
                    System.out.println("\nNo fue posible realizar el pago, " + "por favor, utilice otro método de pago");
                }

            } else {
                System.out.println("\nOpción inválida. Seleccione una tarjeta disponible.");
            }
        }

        scanner.close();
    }
}