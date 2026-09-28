public class Circulo extends figura {
    
    public Double radio;

    @Override
    public Double calcularArea(){
       return Math.PI * Math.pow(radio,2);
    }
}
