public class PrismaRectangular extends Rectangulo{
    
    public Double largo;

    @Override
    public Double calcularArea(){
        return 2 * ((base * largo)+(largo * altura)+(altura * base)); 
    }

    public Double calcularVolumen(){
        return base * altura * largo;
    }
}
