public class PezPayaso extends Pez {
    
    public PezPayaso (){
        super();
    }

    public PezPayaso(String nombre, String tamanio, int edad){
        super(nombre, tamanio, edad);
    }

    public static void main(String[] args) {
        Pez nemo = new PezPayaso("Nemo","10 cms",4);
        System.out.println(nemo.edad);
        nemo.cambiaEdad(5);
        System.out.println(nemo.edad);
    }
}
