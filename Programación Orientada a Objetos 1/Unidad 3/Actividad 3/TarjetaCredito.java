public class TarjetaCredito implements AutorizacionPago {

    private Double creditoLimite;
    private Double creditoUtilizado;

    public TarjetaCredito(Double creditoLimite, Double creditoUtilizado) {
        this.creditoLimite = creditoLimite;
        this.creditoUtilizado = creditoUtilizado;
    }

    @Override
    public boolean realizarPago(Double monto) {

        if (creditoUtilizado + monto <= creditoLimite) {
            creditoUtilizado = creditoUtilizado + monto;
            return true;
        } else {
            return false;
        }
    }

    public Double getCreditoLimite() {
        return creditoLimite;
    }

    public Double getCreditoUtilizado() {
        return creditoUtilizado;
    }
}