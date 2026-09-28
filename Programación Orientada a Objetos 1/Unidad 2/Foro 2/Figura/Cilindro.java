public class Cilindro extends Circulo {

    public Double altura;

    @Override
    public Double calcularArea(){
        return 2 * Math.PI * radio*(radio+altura);
    }

    public Double calcularVolumen(){
        return Math.PI * Math.pow(radio,2) * altura;
    }
}
