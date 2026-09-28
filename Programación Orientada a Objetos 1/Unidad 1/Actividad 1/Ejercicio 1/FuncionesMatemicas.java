public class FuncionesMatemicas {

    public void TablaMultiplicar(Integer numero) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + numero + " = " + (i * numero));
        }
    }

    public void Fibonacci(Integer numero) {
        int anterior = 0;
        int actual = 1;

        System.out.print("La secuencia de Fibonacci para el valor "
                + numero + " es: ");

        for (int i = 0; i <= numero; i++) {
            System.out.print(anterior);

            if (i < numero) {
                System.out.print(", ");
            }

            int siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }

        System.out.println();
    }

    public void Divisores(Integer numero) {
        System.out.print("Los divisores de " + numero + " son: ");

        int cantidad = 0;

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                System.out.print(i + " ");
                cantidad++;
            }
        }

        System.out.println();

        if (cantidad == 2) {
            System.out.println("El número " + numero
                    + " es primo, solo tiene 2 divisores: 1 y " + numero);
        }
    }

    public static void main(String[] args) {

        FuncionesMatemicas funciones = new FuncionesMatemicas();

        funciones.TablaMultiplicar(7);

        System.out.println();

        funciones.Fibonacci(5);

        System.out.println();

        funciones.Divisores(10);
    }
}