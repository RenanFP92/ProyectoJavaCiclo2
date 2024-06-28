package Arreglos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import Clases.Cliente;
import Clases.Producto;
import Clases.Ventas;



public class ArregloVentas {

    private ArregloProductos arregloProductos;
    private ArregloCliente arregloClientes;
    private Map<String, List<Ventas>> ventasPorCliente;

    public ArregloVentas(ArregloProductos arregloProductos, ArregloCliente arregloClientes) {
        this.arregloProductos = arregloProductos;
        this.arregloClientes = arregloClientes;
        this.ventasPorCliente = new HashMap<>();
    }

    public String realizarVenta(String codigoCliente, String codigoProducto, int cantidad, String codigoVenta) {
        StringBuilder resultado = new StringBuilder();
        
        // Buscar el cliente en el arreglo
        int indiceCliente = arregloClientes.buscar(Integer.parseInt(codigoCliente));
        if (indiceCliente == -1) {
            return "Cliente no encontrado en el archivo cliente.txt.";
        }

        Cliente cliente = arregloClientes.obtener(indiceCliente);

        // Buscar el producto en el arreglo
        int indiceProducto = arregloProductos.buscar(Integer.parseInt(codigoProducto));
        if (indiceProducto == -1) {
            return "El producto no se encuentra en el inventario.";
        }

        Producto producto = arregloProductos.obtener(indiceProducto);
        if (producto.getStockActual() < cantidad) {
            return "No hay suficiente stock para realizar esta venta.";
        }

        // Generar fecha actual 
        String fechaVenta = new SimpleDateFormat("MM/dd/yyyy").format(new Date());

        // Crear una venta con el código de venta proporcionado y la fecha actual
        Ventas venta = new Ventas(cliente, producto, cantidad, codigoVenta, fechaVenta);

        // Agregar la venta a las ventas del cliente correspondiente
        if (!ventasPorCliente.containsKey(codigoCliente)) {
            ventasPorCliente.put(codigoCliente, new ArrayList<>());
        }
        ventasPorCliente.get(codigoCliente).add(venta);

        // Actualizar el stock del producto
        producto.setStockActual(producto.getStockActual() - cantidad);

        // Guardar los cambios en el archivo
        arregloProductos.Grabar();

        return "Venta realizada con éxito.";
    }

    public String mostrarTodasLasBoletas() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Todas las Boletas Realizadas:\n");

        for (Map.Entry<String, List<Ventas>> entry : ventasPorCliente.entrySet()) {
            String codigoCliente = entry.getKey();
            List<Ventas> ventasCliente = entry.getValue();

            for (Ventas venta : ventasCliente) {
                resultado.append("Código de la venta: ").append(venta.getCodigoVenta()).append("\n");
                resultado.append("Fecha de la venta: ").append(venta.getFechaVenta()).append("\n");
                resultado.append("---------------------------------------------------\n");
                resultado.append("Código del cliente: ").append(venta.getCliente().getCodigoCliente()).append("\n");
                resultado.append("Nombre del cliente: ").append(venta.getCliente().getNombres()).append(" ").append(venta.getCliente().getApellidos()).append("\n");
                resultado.append("Código del producto: ").append(venta.getProducto().getCodigoProducto()).append("\n");
                resultado.append("Nombre del producto: ").append(venta.getProducto().getNombre()).append("\n");
                resultado.append("Cantidad de unidades adquiridas: ").append(venta.getCantidadUnidades()).append("\n");
                resultado.append("Precio unitario: ").append(venta.getPrecioUnitario()).append("\n");
                resultado.append("Importe subtotal: ").append(venta.getImporteSubtotal()).append("\n");
                resultado.append("Importe del IGV: ").append(venta.getImporteIGV()).append("\n");
                resultado.append("Importe total a pagar: ").append(venta.getImporteTotal()).append("\n");
                resultado.append("░▒▓█▓▒░▒▓█▓▒░▒▓█▓▒░▒▓█▓░▒\n");
            }
        }

        return resultado.toString();
        
    }
}
