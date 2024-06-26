package Clases;

import java.util.Scanner;

import Arreglos.ArregloCliente;
import Arreglos.ArregloProductos;

public class Ventaas {
    public static void main(String[] args) {
        // Crear instancia de ArregloProductos y ArregloCliente
        ArregloProductos arregloProductos = new ArregloProductos();
        ArregloCliente arregloClientes = new ArregloCliente();

        // Leer productos y clientes desde los archivos
        arregloProductos.Leer();
        arregloClientes.Leer();

        // Mostrar productos leídos (opcional, para verificación)
        System.out.println("Productos disponibles:");
        for (int i = 0; i < arregloProductos.tamaño(); i++) {
            Producto producto = arregloProductos.obtener(i);
            System.out.println(producto.toString());
        }

        // Simular una venta
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código del cliente: ");
        String codigoCliente = scanner.nextLine();

        // Buscar el cliente en el arreglo
        int indiceCliente = arregloClientes.buscar(Integer.parseInt(codigoCliente));
        if (indiceCliente == -1) {
            System.out.println("Cliente no encontrado en el archivo cliente.txt.");
            scanner.close();
            return;
        }
        Cliente cliente = arregloClientes.obtener(indiceCliente);

        System.out.print("Ingrese el código del producto a vender: ");
        String codigoProducto = scanner.nextLine();

        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = scanner.nextInt();

        // Buscar el producto en el arreglo
        int indiceProducto = arregloProductos.buscar(Integer.parseInt(codigoProducto));
        if (indiceProducto != -1) {
            Producto producto = arregloProductos.obtener(indiceProducto);
            if (producto.getStockActual() >= cantidad) {
                // Calcular montos
                double precioUnitario = producto.getPrecio();
                double subtotal = cantidad * precioUnitario;
                double igv = subtotal * 0.18; // Suponiendo un IGV del 18%
                double total = subtotal + igv;

                // Mostrar boleta de pago
                System.out.println("\nBoleta de Pago:");
                System.out.println("Código del cliente: " + codigoCliente);
                System.out.println("Nombre del cliente: " + cliente.getNombres() + " " + cliente.getApellidos());
                System.out.println("Código del producto: " + codigoProducto);
                System.out.println("Nombre del producto: " + producto.getNombre());
                System.out.println("Cantidad de unidades adquiridas: " + cantidad);
                System.out.println("Precio unitario: " + precioUnitario);
                System.out.println("Importe subtotal: " + subtotal);
                System.out.println("Importe del IGV: " + igv);
                System.out.println("Importe total a pagar: " + total);

                // Actualizar el stock del producto
                producto.setStockActual(producto.getStockActual() - cantidad);

                // Guardar los cambios en el archivo
                arregloProductos.Grabar();
                System.out.println("\nVenta realizada correctamente. Stock actualizado.");
            } else {
                System.out.println("No hay suficiente stock para realizar esta venta.");
            }
        } else {
            System.out.println("El producto no se encuentra en el inventario.");
        }

        scanner.close();
    }
}
