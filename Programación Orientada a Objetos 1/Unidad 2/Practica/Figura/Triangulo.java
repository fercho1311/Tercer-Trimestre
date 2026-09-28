public class Triangulo extends figura {
    
    public Double base;
    public Double altura;

      @Override
    public Double calcularArea(){
        return (base * altura)/2;
    }
}
