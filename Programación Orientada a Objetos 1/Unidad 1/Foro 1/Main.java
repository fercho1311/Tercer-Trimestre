public class Main {

    public static void main(String[] args) {

    
        Vendedor vendedor = new Vendedor("Juan Pérez");

        
        Comprador comprador = new Comprador("Carlos López");

       
        Factura factura = new Factura(1001, vendedor, comprador);

        Producto arroz = new Producto("Arroz", 10.00, 2);
        Producto leche = new Producto("Leche", 12.00, 3);
        Producto pan = new Producto("Pan", 5.00, 4);

        
        factura.agregarProducto(arroz);
        factura.agregarProducto(leche);
        factura.agregarProducto(pan);

       
        factura.mostrarFactura();
    }
}