package Ejercicio3;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Persona p1 = new Persona("Pedro",1);
        Persona p2 = new Persona("Pablo",2);
        Persona p3 = new Persona("Patricio",3);

        Conexion c = new BaseDatos();

        System.out.println("Se va a guardar a la persona "+p1.getNombre());
        c.guardarPersona(p1);
        System.out.println("Se va a guardar a la persona "+p2.getNombre());
        c.guardarPersona(p2);
        System.out.println("Se va a guardar a la persona "+p3.getNombre());
        c.guardarPersona(p3);

        System.out.println("Buscando a la persona con el id 1");
        System.out.println("Encontrado a "+ c.buscarPersona(1).getNombre());
        
        System.out.println("Buscando a la persona con el id 4");
        Persona pb = c.buscarPersona(4);
        if(pb == null){
            System.out.println("No se encontró a la persona");
        }else{
            System.out.println("Encontrado a "+ pb.getNombre());
        }

        ArrayList<Persona> personas = c.obtenerTodos();
        if(personas.size() == 0){
            System.out.println("No hay personas en la base de datos");
        }else{
            System.out.println("Personas encontradas: ");
            for(Persona p : personas){
                System.out.println(p);
            }
        }
    }
}
