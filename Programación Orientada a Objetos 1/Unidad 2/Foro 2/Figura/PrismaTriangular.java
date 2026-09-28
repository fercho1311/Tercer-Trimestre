public class PrismaTriangular extends Triangulo{
    
    public Double largo;

    @Override
    public Double calcularArea(){
        return 0.5 * base * altura;
    }

    public Double calcularVolumen(){
        Double area = calcularArea();
        return area * largo;
    }
}
