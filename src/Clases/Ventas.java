package Clases;


import java.text.SimpleDateFormat;
import java.util.Date;


public class Ventas {
    private Cliente cliente;
    private Producto producto;
    private int cantidadUnidades;
    private double precioUnitario;
    private double importeSubtotal;
    private double importeIGV;
    private double importeTotal;
    private String codigoVenta;
    private String fechaVenta;

    public Ventas(Cliente cliente, Producto producto, int cantidad, String codigoVenta, String fechaVenta) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidadUnidades = cantidad;
        this.precioUnitario = producto.getPrecio();
        this.importeSubtotal = cantidad * precioUnitario;
        //aqui ya sin metodo lo estoy ejecutando  directo  la logica
        this.importeIGV = importeSubtotal * 0.18; // 18% IGV
        this.importeTotal = importeSubtotal + importeIGV;
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
    }

    // Getters
    public Cliente getCliente() { return cliente; }
    public Producto getProducto() { return producto; }
    public int getCantidadUnidades() { return cantidadUnidades; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getImporteSubtotal() { return importeSubtotal; }
    public double getImporteIGV() { return importeIGV; }
    public double getImporteTotal() { return importeTotal; }
    public String getCodigoVenta() { return codigoVenta; }
    public String getFechaVenta() { return fechaVenta; }
}
