public class Pez {
    String nombre, tamanio;
    int edad;

    public Pez () {
        this.nombre = "";
        this.tamanio = "";
        this.edad = 0;
    }

    public Pez (String nombre, String tamanio, int edad){
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.edad = edad;
    }

    public void cambiaEdad(int edad){
        this.edad = edad;
    }
}
