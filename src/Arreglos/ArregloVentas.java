package Arreglos;

import Clases.Ventas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArregloVentas {
    private ArrayList<Ventas> listaVentas;
    private String archivo = "Archivos txt/ventas.txt";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private int ultimoCodigoVenta = 3000;

    public ArregloVentas() {
        listaVentas = new ArrayList<>();
        cargarVentas();
    }

    public void agregarVenta(Ventas venta) {
        listaVentas.add(venta);
        guardarVentas();
    }

    public Ventas obtenerVenta(int index) {
        return listaVentas.get(index);
    }

    public int tamaño() {
        return listaVentas.size();
    }

    public int generarCodigoVenta() {
        ultimoCodigoVenta++;
        return ultimoCodigoVenta;
    }

    public void cargarVentas() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                if (campos.length == 9) {
                    int codigoVenta = Integer.parseInt(campos[0]);
                    String codigoCliente = campos[1];
                    String nombres = campos[2];
                    String apellidos = campos[3];
                    String codigoProducto = campos[4];
                    String nombreProducto = campos[5];
                    int cantidad = Integer.parseInt(campos[6]);
                    double precio = Double.parseDouble(campos[7]);
                    Date fecha = dateFormat.parse(campos[8]);
                    Ventas venta = new Ventas(codigoVenta, codigoCliente, nombres, apellidos, codigoProducto, nombreProducto, cantidad, precio, fecha);
                    listaVentas.add(venta);
                    if (codigoVenta > ultimoCodigoVenta) {
                        ultimoCodigoVenta = codigoVenta;
                    }
                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error al cargar ventas: " + e.getMessage());
        }
    }

    public void guardarVentas() {
        try (FileWriter fw = new FileWriter(archivo)) {
            for (Ventas venta : listaVentas) {
                fw.write(venta.getCodigoVenta() + ";" +
                        venta.getCodigoCliente() + ";" +
                        venta.getNombres() + ";" +
                        venta.getApellidos() + ";" +
                        venta.getCodigoProducto() + ";" +
                        venta.getNombreProducto() + ";" +
                        venta.getCantidad() + ";" +
                        venta.getPrecio() + ";" +
                        dateFormat.format(venta.getFecha()) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar ventas: " + e.getMessage());
        }
    }
}
