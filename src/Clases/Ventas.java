package Clases;

import java.util.Date;

public class Ventas {
    private int codigoVenta;
    private String codigoCliente;
    private String nombres;
    private String apellidos;
    private String codigoProducto;
    private String nombreProducto;
    private int cantidad;
    private double precio;
    private double subTotal;
    private double igv;
    private double importeTotal;
    private Date fecha;

    public Ventas(int codigoVenta, String codigoCliente, String nombres, String apellidos, String codigoProducto, String nombreProducto, int cantidad, double precio, Date fecha) {
        this.codigoVenta = codigoVenta;
        this.codigoCliente = codigoCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = cantidad*precio;
        this.igv = subTotal * 0.18;
        this.importeTotal = subTotal + igv;
        this.fecha = fecha;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
    
    public double getSubTotal() {
    	return subTotal;
    }
    
    public double getIgv() {
    	return igv;
    }
    
    public double getImporteTotal() {
    	return importeTotal;
    }

    public Date getFecha() {
        return fecha;
    }
}
