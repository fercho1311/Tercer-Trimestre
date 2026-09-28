package Ejercicio2;

public class Principal {
    
    /*
        Para los primeros dos ejercicios considere el método de String: charAt(int)
        Para el ejercicio 2 puede considerar el Objeto StringBuilder 
        https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html 
        Para el tercer ejercicio considere la estructura de datos Set 
        https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
    */
    /*
        Esta función debe contar, en la oración indicada por el primer parámetro, 
        todas las instancias del caracter indicado por el segundo parámetro 
        y devolver la cantidad, es Case Sensitive, es decir hace distinción entre mayúsculas y 
        minúsculas. 
    */
    public static Integer ContarCaracter(String oracion, char caracter){
        //TODO completar el funcionamiento
        return 0;
    }
    /*
        Esta función debe buscar, en la oración indicada por el primer parámetro, 
        todas las instancias del caracter especificado por el 
        segundo parámetro y reemplazarlo por el caracter indicado en el tercer parámetro.
        Al final debe retornar la oración
    */
    public static String Reemplazar(String oracion, char caracter, char reemplazo){
        //TODO completar el funcionamiento
        
        return "";
    }

    /*
       Esta función va a recorrer la oracion indicada y buscar si existe alguna palabra repetida 
       En caso de encontrar una palabra que se repite, inmediatamente retorna indicando la palabra. 
       Ej. Los números enteros están conformados por 3 partes: los números enteros positivos, 
       los números enteros negativos y el cero. 
       Debería retornar la palabra "números", ya que las palabras "Los" y "los" no son iguales.  
       En caso de no encontrar una palabra repetida, debe retornar un String vacio: "" 
    */

    public static String BuscarPalabraRepetida(String oracion){
        //TODO completar el funcionamiento
        
        return "";
    }
    public static void main(String[] args){

        String oracion1 = "Este es un ejemplo";
        char caracter1 = 'e';
        String oracion2 = "Estamos solucionando el ejercicio 2";
        char caracter2 = 'a';
        String oracion3 = "Los números enteros están conformados por 3 partes: los números enteros positivos, los números enteros negativos y el cero.";


        System.out.println("La cantidad de veces que el caracter "+caracter1+" aparece en la oración \""+ oracion1 +"\" es:"+Principal.ContarCaracter(oracion1, 'e'));

        System.out.println("La oración \""+oracion2+"\" con el caracter "+caracter1+" reemplazado por "+caracter2+ " es: \""+Principal.Reemplazar(oracion2, caracter1, caracter2)+"\"");

        String palabraRepetida = Principal.BuscarPalabraRepetida(oracion3);
        if(palabraRepetida.equals("")){
            System.out.println("La oración no contiene palabras repetidas");
        }else{
            System.out.println("La primera palabra que se repite es: "+palabraRepetida);
        }

    }
}
