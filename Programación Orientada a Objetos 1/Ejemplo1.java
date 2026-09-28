import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.util.Scanner;

class Ejemplo1 {

public static void main(String[] args) {
	Scanner scanner = new Scanner( System.in );
	System.out.println("Ingrese el nombre de su perro");
	String input1 = scanner.nextLine();
	System.out.println("Ingrese el color de su perro");
	String input2 = scanner.nextLine();
	System.out.println("Ingrese la raza de su perro");
	String input3 = scanner.nextLine();
	Perro perro1 = new Perro(input1, input2, input3);
	System.out.println("Su perro se llama " + perro1.getNombre());
	}
}