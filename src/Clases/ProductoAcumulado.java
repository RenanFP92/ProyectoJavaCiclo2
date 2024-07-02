package Clases;

public class ProductoAcumulado {
    private String codigoProducto;
    private String nombreProducto;
    private double importeTotalAcumulado;
    private int cantidadAcumulada;

    public ProductoAcumulado(String codigoProducto, String nombreProducto, double importeTotalAcumulado) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.importeTotalAcumulado = importeTotalAcumulado;
        this.cantidadAcumulada = 0;
    }

    public ProductoAcumulado(String codigoProducto, String nombreProducto, int cantidadAcumulada) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.importeTotalAcumulado = 0;
        this.cantidadAcumulada = cantidadAcumulada;
    }

    public void acumularImporte(double importe) {
        this.importeTotalAcumulado += importe;
    }

    public void acumularCantidad(int cantidad) {
        this.cantidadAcumulada += cantidad;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getImporteTotalAcumulado() {
        return importeTotalAcumulado;
    }

    public int getCantidadAcumulada() {
        return cantidadAcumulada;
    }
}
