package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import Arreglos.ArregloCliente;
import Arreglos.ArregloProductos;
import Arreglos.ArregloVentas;
import Clases.Cliente;
import Clases.Producto;
import Clases.Ventas;

public class FmrVentas extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JTextField txtCodigoVenta, txtCodigoCliente, txtNombres, txtApellidos, txtCodigoProducto, txtNombreProducto, txtCantidad, txtPrecio, txtSubtotal, txtIGV, txtTotal;
    private JButton btnCalcular, btnVender, btnBuscarCliente, btnBuscarProducto;
    private ArregloCliente arregloCliente;
    private ArregloProductos arregloProductos;
    private ArregloVentas arregloVentas;
    
    
    public static void main(String[] args) {
        ArregloCliente arregloCliente = new ArregloCliente();
        ArregloProductos arregloProductos = new ArregloProductos();
        ArregloVentas arregloVentas = new ArregloVentas();
        arregloCliente.Leer();
        arregloProductos.Leer();
        arregloVentas.cargarVentas();

        FmrVentas frame = new FmrVentas(arregloCliente, arregloProductos, arregloVentas);
        frame.setVisible(true);
    }
    
    
    

    public FmrVentas(ArregloCliente arregloCliente, ArregloProductos arregloProductos, ArregloVentas arregloVentas) {
        this.arregloCliente = arregloCliente;
        this.arregloProductos = arregloProductos;
        this.arregloVentas = arregloVentas;

        setTitle("Ventas");
        setSize(400, 400);
        setLocationRelativeTo(null);
		setResizable(false);
        setLayout(new GridLayout(13, 2));

        // Crear y agregar los componentes
        add(new JLabel("Código de Venta:"));
        txtCodigoVenta = new JTextField();
        txtCodigoVenta.setEditable(false);
        add(txtCodigoVenta);

        add(new JLabel("Código del Cliente:"));
        txtCodigoCliente = new JTextField();
        add(txtCodigoCliente);

        btnBuscarCliente = new JButton("Buscar Cliente");
        btnBuscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });
        add(btnBuscarCliente);

        add(new JLabel("Nombres:"));
        txtNombres = new JTextField();
        txtNombres.setEditable(false);
        add(txtNombres);

        add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        txtApellidos.setEditable(false);
        add(txtApellidos);

        add(new JLabel("Código del Producto:"));
        txtCodigoProducto = new JTextField();
        add(txtCodigoProducto);

        btnBuscarProducto = new JButton("Buscar Producto");
        btnBuscarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });
        add(btnBuscarProducto);

        add(new JLabel("Nombre del Producto:"));
        txtNombreProducto = new JTextField();
        txtNombreProducto.setEditable(false);
        add(txtNombreProducto);

        add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        add(txtCantidad);

        add(new JLabel("Precio Unitario:"));
        txtPrecio = new JTextField();
        txtPrecio.setEditable(false);
        add(txtPrecio);

        add(new JLabel("Subtotal:"));
        txtSubtotal = new JTextField();
        txtSubtotal.setEditable(false);
        add(txtSubtotal);

        add(new JLabel("IGV:"));
        txtIGV = new JTextField();
        txtIGV.setEditable(false);
        add(txtIGV);

        add(new JLabel("Total:"));
        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        add(txtTotal);

        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularImportes();
            }
        });
        add(btnCalcular);

        btnVender = new JButton("Vender");
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarVenta();
            }
        });
        add(btnVender);

        // Inicializar el código de venta
        inicializarCodigoVenta();
    }

    private void buscarCliente() {
        try {
            int codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
            int index = arregloCliente.buscar(codigoCliente);
            if (index != -1) {
                Cliente cliente = arregloCliente.obtener(index);
                txtNombres.setText(cliente.getNombres());
                txtApellidos.setText(cliente.getApellidos());
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                txtNombres.setText("");
                txtApellidos.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un código de cliente válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarProducto() {
        try {
            int codigoProducto = Integer.parseInt(txtCodigoProducto.getText());
            int index = arregloProductos.buscar(codigoProducto);
            if (index != -1) {
                Producto producto = arregloProductos.obtener(index);
                txtNombreProducto.setText(producto.getNombre());
                txtPrecio.setText(String.valueOf(producto.getPrecio()));
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                txtNombreProducto.setText("");
                txtPrecio.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un código de producto válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularImportes() {
        try {
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());
            double subtotal = cantidad * precio;
            double igv = subtotal * 0.18;
            double total = subtotal + igv;
            txtSubtotal.setText(String.valueOf(subtotal));
            txtIGV.setText(String.valueOf(igv));
            txtTotal.setText(String.valueOf(total));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void realizarVenta() {
        try {
            int codigoVenta = Integer.parseInt(txtCodigoVenta.getText());
            String codigoCliente = txtCodigoCliente.getText();
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            String codigoProducto = txtCodigoProducto.getText();
            String nombreProducto = txtNombreProducto.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());
            Date fecha = new Date(); // Fecha actual

            Ventas venta = new Ventas(codigoVenta, codigoCliente, nombres, apellidos, codigoProducto, nombreProducto, cantidad, precio, fecha);
            arregloVentas.agregarVenta(venta);
            JOptionPane.showMessageDialog(this, "Venta realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // Generar nuevo código de venta para la siguiente venta
            txtCodigoVenta.setText(String.valueOf(arregloVentas.generarCodigoVenta()));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Datos de venta inválidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inicializarCodigoVenta() {
        txtCodigoVenta.setText(String.valueOf(arregloVentas.generarCodigoVenta()));
    }

   
}
