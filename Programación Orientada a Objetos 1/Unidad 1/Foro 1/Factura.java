import java.util.ArrayList;
import java.util.List;

public class Factura {

    int numeroFactura;
    Vendedor vendedor;
    Comprador comprador;
    List<Producto> productos;

    public Factura(int numeroFactura, Vendedor vendedor, Comprador comprador) {
        this.numeroFactura = numeroFactura;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularSubtotal() {

        double subtotal = 0;

        for (Producto producto : productos) {
            subtotal = subtotal + producto.calcularSubtotal();
        }

        return subtotal;
    }

    public double calcularTotal() {
        return calcularSubtotal();
    }

    public void mostrarFactura() {

        System.out.println("=================================");
        System.out.println("           FACTURA");
        System.out.println("=================================");
        System.out.println("Factura No.: " + numeroFactura);
        System.out.println("Vendedor: " + vendedor.nombre);
        System.out.println("Comprador: " + comprador.nombre);
        System.out.println("---------------------------------");

        for (Producto producto : productos) {

            System.out.println(
                    producto.nombre
                    + " | Cantidad: " + producto.cantidad
                    + " | Precio: Q" + producto.precio
                    + " | Subtotal: Q" + producto.calcularSubtotal()
            );
        }

        System.out.println("---------------------------------");
        System.out.println("Subtotal: Q" + calcularSubtotal());
        System.out.println("Total: Q" + calcularTotal());
        System.out.println("=================================");
    }
}