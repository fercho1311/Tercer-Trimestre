import java.util.ArrayList;
import java.util.List;

public class Servidor {

    List<Usuario> usuarios;

    public Servidor() {
        usuarios = new ArrayList<>();
    }

    public void EnviarCorreo(Correo correo, Usuario remitente, Usuario destinatario) {

        remitente.bandejaSalida.add(correo);
        destinatario.bandejaEntrada.add(correo);
    }

    public static void main(String[] args) {

    
        Usuario usuarioA = new Usuario("usuarioA@gmail.com");
        Usuario usuarioB = new Usuario("usuarioB@gmail.com");

        // Crear los correos
        Correo correo1 = new Correo(
                "usuarioA@gmail.com",
                "usuarioB@gmail.com",
                "Primer correo",
                "Hola, este es el primer correo.",
                "13/08/2026"
        );

        Correo correo2 = new Correo(
                "usuarioB@gmail.com",
                "usuarioA@gmail.com",
                "Segundo correo",
                "Hola, este es el segundo correo.",
                "13/08/2026"
        );

        // Crear el servidor
        Servidor servidor = new Servidor();

        // Agregar los usuarios al servidor
        servidor.usuarios.add(usuarioA);
        servidor.usuarios.add(usuarioB);

    
        servidor.EnviarCorreo(correo1, usuarioA, usuarioB);
        servidor.EnviarCorreo(correo2, usuarioB, usuarioA);

    
        for (Usuario usuario : servidor.usuarios) {

            System.out.println("Usuario: " + usuario.direccionCorreo);

            // Buscar correos recibidos
            System.out.println("Correos recibidos:");

            List<Correo> recibidos = usuario.buscarCorreoRecibido(
                    usuario.direccionCorreo.equals("usuarioA@gmail.com")
                            ? "usuarioB@gmail.com"
                            : "usuarioA@gmail.com"
            );

            for (Correo correo : recibidos) {
                System.out.println("  De: " + correo.origen);
                System.out.println("  Título: " + correo.titulo);
                System.out.println("  Contenido: " + correo.contenido);
            }

            // Buscar correos enviados
            System.out.println("Correos enviados:");

            List<Correo> enviados = usuario.buscarCorreoEnviado(
                    usuario.direccionCorreo.equals("usuarioA@gmail.com")
                            ? "usuarioB@gmail.com"
                            : "usuarioA@gmail.com"
            );

            for (Correo correo : enviados) {
                System.out.println("  Para: " + correo.destino);
                System.out.println("  Título: " + correo.titulo);
                System.out.println("  Contenido: " + correo.contenido);
            }

            System.out.println("---------------------------");
        }
    }
}