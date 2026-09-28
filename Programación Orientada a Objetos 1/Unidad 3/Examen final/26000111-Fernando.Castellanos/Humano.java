public abstract class Humano {

    private String nombre;
    private String telefono;
    private String correo;

    public Humano(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public abstract void mostrarInformacion();
}