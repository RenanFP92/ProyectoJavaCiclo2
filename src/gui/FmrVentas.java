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
        JLabel label = new JLabel("Código de Venta:");
        label.setBounds(10, 25, 192, 27);
        getContentPane().add(label);
        txtCodigoVenta = new JTextField();
        txtCodigoVenta.setBounds(192, 25, 192, 27);
        txtCodigoVenta.setEditable(false);
        getContentPane().add(txtCodigoVenta);

        JLabel label_1 = new JLabel("Código del Cliente:");
        label_1.setBounds(20, 75, 140, 27);
        getContentPane().add(label_1);
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

        JLabel label_2 = new JLabel("Nombres:");
        label_2.setBounds(20, 102, 140, 27);
        getContentPane().add(label_2);
        txtNombres = new JTextField();
        txtNombres.setBounds(192, 102, 192, 27);
        txtNombres.setEditable(false);
        getContentPane().add(txtNombres);

        JLabel label_3 = new JLabel("Apellidos:");
        label_3.setBounds(20, 129, 140, 27);
        getContentPane().add(label_3);
        txtApellidos = new JTextField();
        txtApellidos.setBounds(192, 129, 192, 27);
        txtApellidos.setEditable(false);
        getContentPane().add(txtApellidos);

        JLabel label_4 = new JLabel("Código del Producto:");
        label_4.setBounds(20, 179, 140, 27);
        getContentPane().add(label_4);
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

        JLabel label_5 = new JLabel("Nombre del Producto:");
        label_5.setBounds(20, 205, 140, 27);
        getContentPane().add(label_5);
        txtNombreProducto = new JTextField();
        txtNombreProducto.setBounds(192, 205, 192, 27);
        txtNombreProducto.setEditable(false);
        getContentPane().add(txtNombreProducto);

        JLabel label_6 = new JLabel("Cantidad:");
        label_6.setBounds(20, 228, 140, 27);
        getContentPane().add(label_6);
        txtCantidad = new JTextField();
        txtCantidad.setBounds(192, 228, 192, 27);
        getContentPane().add(txtCantidad);

        JLabel label_7 = new JLabel("Precio Unitario:");
        label_7.setBounds(20, 256, 140, 27);
        getContentPane().add(label_7);
        txtPrecio = new JTextField();
        txtPrecio.setBounds(192, 256, 192, 27);
        txtPrecio.setEditable(false);
        getContentPane().add(txtPrecio);

        JLabel label_8 = new JLabel("Subtotal:");
        label_8.setBounds(20, 283, 140, 27);
        getContentPane().add(label_8);
        txtSubtotal = new JTextField();
        txtSubtotal.setBounds(192, 283, 192, 27);
        txtSubtotal.setEditable(false);
        getContentPane().add(txtSubtotal);

        JLabel label_9 = new JLabel("IGV:");
        label_9.setBounds(20, 310, 140, 27);
        getContentPane().add(label_9);
        txtIGV = new JTextField();
        txtIGV.setBounds(192, 310, 192, 27);
        txtIGV.setEditable(false);
        getContentPane().add(txtIGV);

        JLabel label_10 = new JLabel("Total:");
        label_10.setBounds(20, 337, 140, 27);
        getContentPane().add(label_10);
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
			//////////////////////////////////////////////////
			// Actualizar el stock del producto
			int codigoProd = Integer.parseInt(codigoProducto);
			arregloProductos.actualizarStock(codigoProd, cantidad);
			//////////////////
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