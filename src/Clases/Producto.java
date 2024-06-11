package Clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int stockActual;
    private int stockMin;
    private int stockMax;
    private String[] productoData; // Arreglo para almacenar los datos del producto

    public Producto(int codigo, String nombre, double precio, int stockActual, int stockMin, int stockMax) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stockActual = stockActual;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
        this.productoData = new String[]{
            "Código: " + codigo,
            "Nombre: " + nombre,
            "Precio: " + precio,
            "Stock Actual: " + stockActual,
            "Stock Mínimo: " + stockMin,
            "Stock Máximo: " + stockMax
        };
    }

    public void guardarProducto() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("productos.txt", true))) {
            for (String dato : productoData) {
                bw.write(dato);
                bw.newLine();
            }
            bw.write("--------------------------------------------------");
            bw.newLine();
        }
    }
}