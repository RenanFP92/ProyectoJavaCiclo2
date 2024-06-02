package Clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int stockActual;
    private int stockMin;
    private int stockMax;

    public Producto(int codigo, String nombre, double precio, int stockActual, int stockMin, int stockMax) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stockActual = stockActual;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
    }

    public void guardarProducto() throws IOException {
        // Crear un nuevo archivo "productos.txt" o sobrescribir si ya existe
        PrintWriter writer = new PrintWriter(new FileWriter("productos.txt", true));

        // Escribir los datos del producto en el archivo
        writer.println("Código: " + codigo);
        writer.println("Nombre: " + nombre);
        writer.println("Precio: " + precio);
        writer.println("Stock Actual: " + stockActual);
        writer.println("Stock Mínimo: " + stockMin);
        writer.println("Stock Máximo: " + stockMax);
        writer.println();

        // Cerrar el flujo de escritura
        writer.close();
    }
}