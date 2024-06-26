package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloCliente;
import Arreglos.ArregloProductos;
import Clases.Cliente;
import Clases.Producto;
import Clases.Ventas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FmrVentas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodigoCliente;
    private JTextField txtCodigoProducto;
    private JTextField txtCantidad;
    private JLabel lblCodigoCliente;
    private JLabel lblCodigoProducto;
    private JLabel lblCantidad;
    private JButton btnBoleta;
    private JTextArea txtResultado;

    private ArregloProductos arregloProductos;
    private ArregloCliente arregloClientes;
    private Map<String, List<Ventas>> ventasPorCliente; // Mapa para almacenar las ventas por cada cliente

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
        txtCodigoCliente.setBounds(147, 28, 86, 20);
        contentPane.add(txtCodigoCliente);
        txtCodigoCliente.setColumns(10);

        txtCodigoProducto = new JTextField();
        txtCodigoProducto.setBounds(147, 67, 86, 20);
        contentPane.add(txtCodigoProducto);
        txtCodigoProducto.setColumns(10);

        lblCodigoCliente = new JLabel("Codigo Cliente");
        lblCodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCodigoCliente.setBounds(21, 30, 120, 14);
        contentPane.add(lblCodigoCliente);

        lblCodigoProducto = new JLabel("Codigo Producto");
        lblCodigoProducto.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCodigoProducto.setBounds(23, 69, 118, 14);
        contentPane.add(lblCodigoProducto);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(122, 158, 101, 20);
        contentPane.add(txtCantidad);
        txtCantidad.setColumns(10);

        lblCantidad = new JLabel("Cantidad");
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCantidad.setBounds(23, 160, 126, 14);
        contentPane.add(lblCantidad);

        btnBoleta = new JButton("Boleta");
        btnBoleta.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBoleta.setBounds(23, 207, 89, 23);
        contentPane.add(btnBoleta);

        txtResultado = new JTextArea();
        txtResultado.setBounds(253, 26, 323, 269);
        txtResultado.setEditable(false); // Hacer el área de texto no editable
        contentPane.add(txtResultado);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 121, 213, 2);
        contentPane.add(separator);

        // ActionListener para el botón "Boleta"
        btnBoleta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarVenta();
                mostrarBoletas();
                limpiarCampos();
            }
        });
    }

    private void realizarVenta() {
        String codigoCliente = txtCodigoCliente.getText();
        String codigoProducto = txtCodigoProducto.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());

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
                // Crear una venta
                Ventas venta = new Ventas(cliente, producto, cantidad);

                // Agregar la venta a las ventas del cliente correspondiente
                if (!ventasPorCliente.containsKey(codigoCliente)) {
                    ventasPorCliente.put(codigoCliente, new ArrayList<>());
                }
                ventasPorCliente.get(codigoCliente).add(venta);

                // No mostrar la boleta de pago aquí, se muestra en mostrarBoletas()

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

    private void mostrarBoletas() {
    	txtResultado.setText("\nBoletas Realizadas para el Cliente:\n");
        String codigoCliente = txtCodigoCliente.getText();
        String codigoProductoBuscado = txtCodigoProducto.getText();

        if (ventasPorCliente.containsKey(codigoCliente)) {
            List<Ventas> ventasCliente = ventasPorCliente.get(codigoCliente);
            boolean encontrado = false;

            for (Ventas venta : ventasCliente) {
            	
            	int codigoProductoBuscadoInt = Integer.parseInt(codigoProductoBuscado);
            	
                if (venta.getProducto().getCodigoProducto() == (codigoProductoBuscadoInt)) {
                    encontrado = true;
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

            if (!encontrado) {
                txtResultado.append("No se han realizado ventas para este cliente con el producto especificado.\n");
            }
        } else {
            txtResultado.append("No se han realizado ventas para este cliente.\n");
        }
    }

    private void limpiarCampos() {
        // txtCodigoProducto.setText("");
        // txtCantidad.setText("");
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
//modificar y crear el scrollpanel
