public class Main {
    public static void main(String[] args) {
        
        Circulo circulo1 = new Circulo();
        circulo1.radio = 3.5;

        System.out.println("===== CIRCULO =====");
        System.out.println("Radio: " + circulo1.radio);
        System.out.println("Area: " + circulo1.calcularArea());
//----------------------------------------------------------------------------------

        Triangulo triangulo1 = new Triangulo();
        triangulo1.base = 2.1;
        triangulo1.altura = 3.4;

        System.out.println("===== TRIANGULO =====");
        System.out.println("Base: " + triangulo1.base);
        System.out.println("Altura: " + triangulo1.altura);
        System.out.println("Area: " + triangulo1.calcularArea());
//----------------------------------------------------------------------------------

        Rectangulo rectangulo1 = new Rectangulo();
        rectangulo1.base = 3.5;
        rectangulo1.altura = 9.7;

        System.out.println("===== RECTANGULO =====");
        System.out.println("Base: " + rectangulo1.base);
        System.out.println("Altura: " + rectangulo1.altura);
        System.out.println("Area: " + rectangulo1.calcularArea());
//----------------------------------------------------------------------------------

        Cilindro cilindro1 = new Cilindro();
        cilindro1.radio = 4.1;
        cilindro1.altura = 8.3;

        System.out.println("===== CILINDRO =====");
        System.out.println("Radio: " + cilindro1.radio);
        System.out.println("Altura: " + cilindro1.altura);
        System.out.println("Area: " + cilindro1.calcularArea());
        System.out.println("Volumen: " + cilindro1.calcularVolumen());
//----------------------------------------------------------------------------------

        PrismaTriangular prismaTriangular1 = new PrismaTriangular();
        prismaTriangular1.base = 5.0;
        prismaTriangular1.altura = 7.5;
        prismaTriangular1.largo = 15.2;

        System.out.println("===== PRISMA TRIANGULAR =====");
        System.out.println("Base: " + prismaTriangular1.base);
        System.out.println("Altura: " + prismaTriangular1.altura);
        System.out.println("Largo: " + prismaTriangular1.largo);
        System.out.println("Area: " + prismaTriangular1.calcularArea());
        System.out.println("Volumen: " + prismaTriangular1.calcularVolumen());
//----------------------------------------------------------------------------------

        PrismaRectangular prismaRectangular1 = new PrismaRectangular();
        prismaRectangular1.base = 3.5;
        prismaRectangular1.altura = 7.3;
        prismaRectangular1.largo = 12.5;

         System.out.println("===== PRISMA RECTANGULAR =====");
        System.out.println("Base: " + prismaRectangular1.base);
        System.out.println("Altura: " + prismaRectangular1.altura);
        System.out.println("Largo: " + prismaRectangular1.largo);
        System.out.println("Area: " + prismaRectangular1.calcularArea());
        System.out.println("Volumen: " + prismaRectangular1.calcularVolumen());
    }
}
