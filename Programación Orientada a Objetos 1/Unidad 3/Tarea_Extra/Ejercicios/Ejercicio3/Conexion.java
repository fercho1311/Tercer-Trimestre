package Ejercicio3;

import java.util.ArrayList;

public interface Conexion {

    public void guardarPersona(Persona p);
    public Persona buscarPersona(int id);
    public ArrayList<Persona> obtenerTodos();
    
}
