public class PointOfSale {

    public boolean realizarVenta(AutorizacionPago metodoPago, Double totalVenta) {

        return metodoPago.realizarPago(totalVenta);
    }
}