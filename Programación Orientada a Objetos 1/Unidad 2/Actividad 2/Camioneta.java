public class Camioneta {

    String placa;
    String empleado;
    Paquete paquete;
    int ciclosFuera;

    public Camioneta(String placa, String empleado) {
        this.placa = placa;
        this.empleado = empleado;
        this.paquete = null;
        this.ciclosFuera = 0;
    }
}