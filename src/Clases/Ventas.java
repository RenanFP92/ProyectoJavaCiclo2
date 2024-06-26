package Clases;

public class Ventas {
    private Cliente cliente;
    private Producto producto;
    private int cantidadUnidades;
    private double precioUnitario;
    private double importeSubtotal;
    private double importeIGV;
    private double importeTotal;

    // Constructor
    public Ventas(Cliente cliente, Producto producto, int cantidadUnidades) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidadUnidades = cantidadUnidades;
        this.precioUnitario = producto.getPrecio();
        this.importeSubtotal = calcularSubtotal();
        this.importeIGV = calcularIGV();
        this.importeTotal = calcularTotal();
    }

    // Métodos getters y setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getImporteSubtotal() {
        return importeSubtotal;
    }

    public void setImporteSubtotal(double importeSubtotal) {
        this.importeSubtotal = importeSubtotal;
    }

    public double getImporteIGV() {
        return importeIGV;
    }

    public void setImporteIGV(double importeIGV) {
        this.importeIGV = importeIGV;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    // Métodos de cálculo
    private double calcularSubtotal() {
        return precioUnitario * cantidadUnidades;
    }

    private double calcularIGV() {
        return importeSubtotal * 0.18; // IGV del 18%
    }

    private double calcularTotal() {
        return importeSubtotal + importeIGV;
    }

    
}
