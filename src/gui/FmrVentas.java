package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloCliente;
import Arreglos.ArregloProductos;
import Clases.Cliente;
import Clases.Producto;
import Clases.Ventas;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class FmrVentas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodigoCliente;
    private JTextField txtCodigoProducto;
    private JTextField txtCantidad;
    private JTextField txtCodigoVenta; // Nuevo campo para el código de venta
    private JLabel lblCodigoCliente;
    private JLabel lblCodigoProducto;
    private JLabel lblCantidad;
    private JLabel lblCodigoVenta; // Nuevo label para el código de venta
    private JButton btnBoleta;

    private ArregloProductos arregloProductos;
    private ArregloCliente arregloClientes;
    private Map<String, List<Ventas>> ventasPorCliente; // Mapa para almacenar las ventas por cada cliente
    private JScrollPane scrollPane;
    private JScrollPane scrollPane_1;
    private JTextArea txtResultado;

    public FmrVentas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 613, 345);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ventasPorCliente = new HashMap<>(); // Inicializar el mapa de ventas por cliente

        arregloProductos = new ArregloProductos();
        arregloProductos.Leer(); // Cargar productos desde archivo al inicio

        arregloClientes = new ArregloCliente();
        arregloClientes.Leer(); // Cargar clientes desde archivo al inicio

        txtCodigoCliente = new JTextField();
        txtCodigoCliente.setBounds(147, 86, 86, 20);
        contentPane.add(txtCodigoCliente);
        txtCodigoCliente.setColumns(10);

        txtCodigoProducto = new JTextField();
        txtCodigoProducto.setBounds(147, 139, 86, 20);
        contentPane.add(txtCodigoProducto);
        txtCodigoProducto.setColumns(10);

        lblCodigoCliente = new JLabel("Codigo Cliente");
        lblCodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCodigoCliente.setBounds(19, 83, 120, 24);
        contentPane.add(lblCodigoCliente);

        lblCodigoProducto = new JLabel("Codigo Producto");
        lblCodigoProducto.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCodigoProducto.setBounds(19, 136, 118, 24);
        contentPane.add(lblCodigoProducto);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(126, 187, 101, 20);
        contentPane.add(txtCantidad);
        txtCantidad.setColumns(10);

        lblCantidad = new JLabel("Cantidad");
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCantidad.setBounds(26, 189, 126, 14);
        contentPane.add(lblCantidad);

        btnBoleta = new JButton("Boleta");
        btnBoleta.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBoleta.setBounds(23, 235, 89, 23);
        contentPane.add(btnBoleta);

        JSeparator separator = new JSeparator();
        separator.setBounds(19, 61, 213, 2);
        contentPane.add(separator);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(255, 28, 332, 267);
        contentPane.add(scrollPane_1);

        txtResultado = new JTextArea();
        scrollPane_1.setViewportView(txtResultado);

        lblCodigoVenta = new JLabel("CodigoVenta");
        lblCodigoVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCodigoVenta.setBounds(27, 34, 85, 16);
        contentPane.add(lblCodigoVenta);

        txtCodigoVenta = new JTextField();
        txtCodigoVenta.setBounds(137, 31, 86, 20);
        contentPane.add(txtCodigoVenta);
        txtCodigoVenta.setColumns(10);

        // ActionListener para el botón "Boleta"
        btnBoleta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarVenta();
                mostrarTodasLasBoletas();
                limpiarCampos();
            }
        });
    }

    private void realizarVenta() {
        String codigoCliente = txtCodigoCliente.getText();
        String codigoProducto = txtCodigoProducto.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        String codigoVenta = txtCodigoVenta.getText(); // Obtener el código de venta desde el campo

        // Buscar el cliente en el arreglo
        int indiceCliente = arregloClientes.buscar(Integer.parseInt(codigoCliente));
        if (indiceCliente == -1) {
            txtResultado.setText("Cliente no encontrado en el archivo cliente.txt.");
            return;
        }

        Cliente cliente = arregloClientes.obtener(indiceCliente);

        // Buscar el producto en el arreglo
        int indiceProducto = arregloProductos.buscar(Integer.parseInt(codigoProducto));

        if (indiceProducto != -1) {
            Producto producto = arregloProductos.obtener(indiceProducto);
            if (producto.getStockActual() >= cantidad) {
            	
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
            } else {
                txtResultado.setText("No hay suficiente stock para realizar esta venta.");
            }
        } else {
            txtResultado.setText("El producto no se encuentra en el inventario.");
        }
    }

    private void mostrarTodasLasBoletas() {
        txtResultado.setText(""); // Limpiar el campo de resultado
        txtResultado.append("Todas las Boletas Realizadas:\n");

        for (Map.Entry<String, List<Ventas>> entry : ventasPorCliente.entrySet()) {
            String codigoCliente = entry.getKey();
            List<Ventas> ventasCliente = entry.getValue();

            for (Ventas venta : ventasCliente) {
                txtResultado.append("Código de la venta: " + venta.getCodigoVenta() + "\n");
                txtResultado.append("Fecha de la venta: " + venta.getFechaVenta() + "\n");
                txtResultado.append("Código del cliente: " + venta.getCliente().getCodigoCliente() + "\n");
                txtResultado.append("Nombre del cliente: " + venta.getCliente().getNombres() + " " + venta.getCliente().getApellidos() + "\n");
                txtResultado.append("Código del producto: " + venta.getProducto().getCodigoProducto() + "\n");
                txtResultado.append("Nombre del producto: " + venta.getProducto().getNombre() + "\n");
                txtResultado.append("Cantidad de unidades adquiridas: " + venta.getCantidadUnidades() + "\n");
                txtResultado.append("Precio unitario: " + venta.getPrecioUnitario() + "\n");
                txtResultado.append("Importe subtotal: " + venta.getImporteSubtotal() + "\n");
                txtResultado.append("Importe del IGV: " + venta.getImporteIGV() + "\n");
                txtResultado.append("Importe total a pagar: " + venta.getImporteTotal() + "\n");
                txtResultado.append("-------------------------------\n");
            }
        }
    }

    private void limpiarCampos() {
        txtCodigoCliente.setText("");
        txtCodigoProducto.setText("");
        txtCantidad.setText("");
        txtCodigoVenta.setText(""); // Limpiar el campo de código de venta
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FmrVentas frame = new FmrVentas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
