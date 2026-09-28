package Ejercicio1;

import java.util.ArrayList;
import java.util.Random;

public class Principal{


    public static void main(String[] args) {
     
        System.out.println("Se van a generar 10 números al azar");

        Random r = new Random();
        ArrayList<Integer> numeros = new ArrayList<>();
        
        for(int i = 0; i<10 ; i++){
            numeros.add(r.nextInt(100));
        }
    
        for(int i = 0; i<10 ; i++){
            Integer actual = numeros.get(i);
            if(actual  % 2 == 0){
                System.out.println("El número "+actual+" es par");
            }else{
                System.out.println("El número "+actual+" es impar");
            }
        }

        System.out.println("Solucionado el ejercicio 1");
    }

}