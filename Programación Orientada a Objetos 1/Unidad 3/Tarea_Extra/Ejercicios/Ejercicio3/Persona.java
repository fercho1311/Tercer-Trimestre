package Ejercicio3;

public class Persona {
    String nombre; 
    Integer id;

    public Persona(String nuevoNombre, Integer nuevoId){
        nombre = nuevoNombre;
        id = nuevoId;
    }

    public String getNombre(){
        return this.nombre;
    }
    @Override 
    public String toString(){
        return "Nombre: "+this.nombre+" Id: "+this.id;
    }
}
