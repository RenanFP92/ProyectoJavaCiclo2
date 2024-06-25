package Clases;

public class Ventas {
	private Cliente cliente;
    private Producto producto;
    private int cantidadUnidades;
    private double precioUnitario;
    private double importeSubtotal;
    private double importeIGV;
    private double importeTotal;
    
  //constructor 
    public Ventas(Cliente cliente, Producto producto, int cantidadUnidades) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidadUnidades = cantidadUnidades;
        this.precioUnitario = producto.getPrecio();
        this.importeSubtotal = precioUnitario * cantidadUnidades;
        this.importeIGV = importeSubtotal * 0.18;
        this.importeTotal = importeSubtotal + importeIGV;
    }
    private double calcularSubtotal() {
        return precioUnitario * cantidadUnidades;
    }

    private double calcularIGV() {
        return importeSubtotal * 0.18; // IGV del 18%
    }

    private double calcularTotal() {
        return importeSubtotal + importeIGV;
    }
    
    public void imprimirBoleta() {
        System.out.println("Boleta de Pago:");
        System.out.println("Código del cliente: " + cliente.getCodigoCliente());
        System.out.println("Nombres y apellidos del cliente: " + cliente.getNombres() + " " + cliente.getApellidos());
        System.out.println("Código del producto: " + producto.getCodigoProducto());
        System.out.println("Nombre del producto: " + producto.getNombre());
        System.out.println("Cantidad de unidades adquiridas: " + cantidadUnidades);
        System.out.println("Precio unitario: " + precioUnitario);
        System.out.println("Importe subtotal: " + importeSubtotal);
        System.out.println("Importe del IGV: " + importeIGV);
        System.out.println("Importe total a pagar: " + importeTotal);
    }
    

    
    
    

}
