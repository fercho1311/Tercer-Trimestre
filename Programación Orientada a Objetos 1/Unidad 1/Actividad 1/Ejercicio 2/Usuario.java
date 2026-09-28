import java.util.ArrayList;
import java.util.List;

public class Usuario {

    String direccionCorreo;
    List<Correo> bandejaEntrada;
    List<Correo> bandejaSalida;

    public Usuario(String direccionCorreo) {
        this.direccionCorreo = direccionCorreo;
        this.bandejaEntrada = new ArrayList<>();
        this.bandejaSalida = new ArrayList<>();
    }

    public List<Correo> buscarCorreoRecibido(String remitente) {

        List<Correo> correosEncontrados = new ArrayList<>();

        for (Correo correo : bandejaEntrada) {
            if (correo.origen.equals(remitente)) {
                correosEncontrados.add(correo);
            }
        }

        return correosEncontrados;
    }

    public List<Correo> buscarCorreoEnviado(String destinatario) {

        List<Correo> correosEncontrados = new ArrayList<>();

        for (Correo correo : bandejaSalida) {
            if (correo.destino.equals(destinatario)) {
                correosEncontrados.add(correo);
            }
        }

        return correosEncontrados;
    }
}