package gui;

import javax.swing.*;
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
    private JSeparator separator_1;
    
    
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
        setSize(605, 460);
        setLocationRelativeTo(null);
		setResizable(false);
        getContentPane().setLayout(null);

        // Crear y agregar los componentes
        JLabel lblCodigoVenta = new JLabel("Código de Venta:");
        lblCodigoVenta.setBounds(10, 25, 192, 27);
        getContentPane().add(lblCodigoVenta);
        txtCodigoVenta = new JTextField();
        txtCodigoVenta.setBounds(192, 25, 192, 27);
        txtCodigoVenta.setEditable(false);
        getContentPane().add(txtCodigoVenta);

        JLabel lblCodigoCliente = new JLabel("Código del Cliente:");
        lblCodigoCliente.setBounds(20, 75, 140, 27);
        getContentPane().add(lblCodigoCliente);
        txtCodigoCliente = new JTextField();
        txtCodigoCliente.setBounds(192, 75, 192, 27);
        getContentPane().add(txtCodigoCliente);

        btnBuscarCliente = new JButton("Buscar Cliente");
        btnBuscarCliente.setBounds(394, 75, 192, 27);
        btnBuscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });
        getContentPane().add(btnBuscarCliente);

        JLabel lblNombreCliente = new JLabel("Nombres:");
        lblNombreCliente.setBounds(20, 102, 140, 27);
        getContentPane().add(lblNombreCliente);
        txtNombres = new JTextField();
        txtNombres.setBounds(192, 102, 192, 27);
        txtNombres.setEditable(false);
        getContentPane().add(txtNombres);

        JLabel lblApellidoCliente = new JLabel("Apellidos:");
        lblApellidoCliente.setBounds(20, 129, 140, 27);
        getContentPane().add(lblApellidoCliente);
        txtApellidos = new JTextField();
        txtApellidos.setBounds(192, 129, 192, 27);
        txtApellidos.setEditable(false);
        getContentPane().add(txtApellidos);

        JLabel lblCodigoProducto = new JLabel("Código del Producto:");
        lblCodigoProducto.setBounds(20, 179, 140, 27);
        getContentPane().add(lblCodigoProducto);
        txtCodigoProducto = new JTextField();
        txtCodigoProducto.setBounds(192, 179, 192, 27);
        getContentPane().add(txtCodigoProducto);

        btnBuscarProducto = new JButton("Buscar Producto");
        btnBuscarProducto.setBounds(394, 179, 192, 27);
        btnBuscarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });
        getContentPane().add(btnBuscarProducto);

        JLabel lblNombreProducto = new JLabel("Nombre del Producto:");
        lblNombreProducto.setBounds(20, 205, 140, 27);
        getContentPane().add(lblNombreProducto);
        txtNombreProducto = new JTextField();
        txtNombreProducto.setBounds(192, 205, 192, 27);
        txtNombreProducto.setEditable(false);
        getContentPane().add(txtNombreProducto);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(20, 228, 140, 27);
        getContentPane().add(lblCantidad);
        txtCantidad = new JTextField();
        txtCantidad.setBounds(192, 228, 192, 27);
        getContentPane().add(txtCantidad);

        JLabel lblPrecioUnitario = new JLabel("Precio Unitario:");
        lblPrecioUnitario.setBounds(20, 256, 140, 27);
        getContentPane().add(lblPrecioUnitario);
        txtPrecio = new JTextField();
        txtPrecio.setBounds(192, 256, 192, 27);
        txtPrecio.setEditable(false);
        getContentPane().add(txtPrecio);

        JLabel lblSubtotal = new JLabel("Subtotal:");
        lblSubtotal.setBounds(20, 283, 140, 27);
        getContentPane().add(lblSubtotal);
        txtSubtotal = new JTextField();
        txtSubtotal.setBounds(192, 283, 192, 27);
        txtSubtotal.setEditable(false);
        getContentPane().add(txtSubtotal);

        JLabel lblIGV = new JLabel("IGV:");
        lblIGV.setBounds(20, 310, 140, 27);
        getContentPane().add(lblIGV);
        txtIGV = new JTextField();
        txtIGV.setBounds(192, 310, 192, 27);
        txtIGV.setEditable(false);
        getContentPane().add(txtIGV);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(20, 337, 140, 27);
        getContentPane().add(lblTotal);
        txtTotal = new JTextField();
        txtTotal.setBounds(192, 337, 192, 27);
        txtTotal.setEditable(false);
        getContentPane().add(txtTotal);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(394, 337, 192, 27);
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularImportes();
            }
        });
        getContentPane().add(btnCalcular);

        btnVender = new JButton("Vender");
        btnVender.setBounds(394, 375, 192, 27);
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarVenta();
            }
        });
        getContentPane().add(btnVender);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 63, 569, 1);
        getContentPane().add(separator);
        
        separator_1 = new JSeparator();
        separator_1.setBounds(10, 167, 569, 1);
        getContentPane().add(separator_1);

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
