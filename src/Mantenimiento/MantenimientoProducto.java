package Mantenimiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Clases.Producto;

public class MantenimientoProducto {
    private List<Producto> productos;

    public MantenimientoProducto() {
        this.productos = new ArrayList<>();
    }

    /// BufferedReader y FileReader se utilizan para leer el archivo línea por línea.
    public void cargarProductosDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                int codigoProducto = Integer.parseInt(datos[0].trim());
                String nombre = datos[1].trim();
                double precio = Double.parseDouble(datos[2].trim());
                int stockActual = Integer.parseInt(datos[3].trim());
                int stockMinimo = Integer.parseInt(datos[4].trim());
                int stockMaximo = Integer.parseInt(datos[5].trim());
                productos.add(new Producto(codigoProducto, nombre, precio, stockActual, stockMinimo, stockMaximo));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Producto buscarProductoPorCodigo(int codigoProducto) {
        for (Producto producto : productos) {
            if (producto.getCodigoProducto() == codigoProducto) {
                return producto;
            }
        }
        return null;
    }

    public boolean actualizarStock(int codigoProducto, int cantidad) {
        Producto producto = buscarProductoPorCodigo(codigoProducto);
        if (producto != null) {
            int nuevoStock = producto.getStockActual() + cantidad;
            if (nuevoStock <= producto.getStockMaximo()) {
                producto.setStockActual(nuevoStock);
                return true;
            } else {
                System.out.println("Error: El nuevo stock supera el stock máximo permitido.");
                return false;
            }
        }
        System.out.println("Error: Producto no encontrado.");
        return false;
    }

    public static void main(String[] args) {
        MantenimientoProducto mantenimiento = new MantenimientoProducto();

        // Cargar productos desde un archivo de texto
        mantenimiento.cargarProductosDesdeArchivo("Archivos txt/productos.txt");

        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.println("Ingrese el código del producto:");
        int codigoBuscado = scanner.nextInt();

        System.out.println("Ingrese la cantidad de unidades a ingresar:");
        int cantidad = scanner.nextInt();

        // Actualizar stock
        if (mantenimiento.actualizarStock(codigoBuscado, cantidad)) {
            System.out.println("Stock actualizado para el producto con código " + codigoBuscado);
        } else {
            System.out.println("No se pudo actualizar el stock.");
        }

        // Imprimir todos los productos para verificar el cambio
        for (Producto producto : mantenimiento.productos) {
            System.out.println(producto);
        }

        scanner.close();
    }
}
