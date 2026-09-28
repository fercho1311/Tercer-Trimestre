public class TarjetaDebito implements AutorizacionPago {

    private Double saldo;

    public TarjetaDebito(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean realizarPago(Double monto) {

        if (saldo >= monto) {
            saldo = saldo - monto;
            return true;
        } else {
            return false;
        }
    }

    public Double getSaldo() {
        return saldo;
    }
}