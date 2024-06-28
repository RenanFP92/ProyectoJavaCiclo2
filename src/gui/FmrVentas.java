package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloCliente;
import Arreglos.ArregloProductos;
import Arreglos.ArregloVentas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FmrVentas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodigoCliente;
    private JTextField txtCodigoProducto;
    private JTextField txtCantidad;
    private JTextField txtCodigoVenta;
    private JLabel lblCodigoCliente;
    private JLabel lblCodigoProducto;
    private JLabel lblCantidad;
    private JLabel lblCodigoVenta;
    private JButton btnBoleta;
    private ArregloProductos arregloProductos;
    private ArregloCliente arregloClientes;
    private ArregloVentas arregloVentas;

    private JScrollPane scrollPane_1;
    private JTextArea txtResultado;
    private JLabel lblNewLabel;
    private JButton btnGuardar;

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

    public FmrVentas() {
        setTitle("Ventas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 802, 345);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtCodigoCliente = new JTextField();
        txtCodigoCliente.setBounds(180, 125, 86, 20);
        contentPane.add(txtCodigoCliente);
        txtCodigoCliente.setColumns(10);

        txtCodigoProducto = new JTextField();
        txtCodigoProducto.setBounds(180, 175, 86, 20);
        contentPane.add(txtCodigoProducto);
        txtCodigoProducto.setColumns(10);

        lblCodigoCliente = new JLabel("CÓDIGO CLIENTE:");
        lblCodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCodigoCliente.setBounds(19, 121, 151, 24);
        contentPane.add(lblCodigoCliente);

        lblCodigoProducto = new JLabel("CÓDIGO PRODUCTO:");
        lblCodigoProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCodigoProducto.setBounds(19, 171, 160, 24);
        contentPane.add(lblCodigoProducto);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(177, 230, 89, 20);
        contentPane.add(txtCantidad);
        txtCantidad.setColumns(10);

        lblCantidad = new JLabel("CANTIDAD:");
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCantidad.setBounds(19, 231, 126, 14);
        contentPane.add(lblCantidad);

        btnBoleta = new JButton("Boleta");
        btnBoleta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarVenta();
            }
        });
        btnBoleta.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBoleta.setBounds(673, 46, 89, 23);
        contentPane.add(btnBoleta);

        JSeparator separator = new JSeparator();
        separator.setBounds(25, 108, 213, 2);
        contentPane.add(separator);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(288, 28, 364, 267);
        contentPane.add(scrollPane_1);

        txtResultado = new JTextArea();
        scrollPane_1.setViewportView(txtResultado);

        lblCodigoVenta = new JLabel("CÓDIGO:");
        lblCodigoVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCodigoVenta.setBounds(19, 68, 85, 16);
        contentPane.add(lblCodigoVenta);

        txtCodigoVenta = new JTextField();
        txtCodigoVenta.setBounds(114, 68, 86, 20);
        contentPane.add(txtCodigoVenta);
        txtCodigoVenta.setColumns(10);
        
        lblNewLabel = new JLabel("MANTENIMIENTO VENTAS");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(21, 28, 237, 14);
        contentPane.add(lblNewLabel);
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Guardar();
        	}
        });
        btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnGuardar.setBounds(673, 108, 89, 23);
        contentPane.add(btnGuardar);

        // Cargar productos y clientes desde archivo al inicio
        arregloProductos = new ArregloProductos();
        arregloProductos.Leer();
        arregloClientes = new ArregloCliente();
        arregloClientes.Leer();

        // Inicializar la lógica de ventas
        arregloVentas = new ArregloVentas(arregloProductos, arregloClientes);
    }

    protected  void realizarVenta() {
        String codigoCliente = txtCodigoCliente.getText();
        String codigoProducto = txtCodigoProducto.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        // Obtener el código de venta desde el campo
        String codigoVenta = txtCodigoVenta.getText();

        String resultadoVenta = arregloVentas.realizarVenta(codigoCliente, codigoProducto, cantidad, codigoVenta);
        txtResultado.setText(resultadoVenta);

        String resultadoBoletas = arregloVentas.mostrarTodasLasBoletas();
        txtResultado.append("\n" + resultadoBoletas);

        limpiarCampos();
    }
    protected void Guardar() {
    	
    	
    }
    
    
    

    private void limpiarCampos() {
        txtCodigoCliente.setText("");
        txtCodigoProducto.setText("");
        txtCantidad.setText("");
        txtCodigoVenta.setText("");
    }
}

