/*
* Clase Perro
*/

public class Perro {
	String nombre, color, raza;
	public Perro(String nuevoNombre, String nuevoColor, String nuevaRaza){
		nombre = nuevoNombre;
		color = nuevoColor;
		raza = nuevaRaza;
	}
	public void setNombre(String name) {
		nombre = name;
	}
	public String getNombre() {
		return nombre;
	}
}