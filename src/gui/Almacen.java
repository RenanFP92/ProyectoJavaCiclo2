package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloProductos;
import Clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Almacen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodigoProducto;
    private JTextField txtNombreProducto;
    private JTextField txtStockActual;
    private JTextField txtStockMaximo;
    private JLabel lblProductoCodigo;
    private JButton btnBuscar;
    private JLabel lblNnombreProducto;
    private JSeparator separator;
    private JLabel lblStockActual;
    private JLabel lblStockMaximo;
    ArregloProductos lista = new ArregloProductos();
    private JButton btnGuardar;
    private int indiceProducto = -1;
    private JTextField txtStockMinimo;
	private JLabel lblStockMinimo;

    public Almacen() {
        setTitle("Almacen");
        setBounds(100, 100, 450, 235);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
		setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblProductoCodigo = new JLabel("CÓDIGO DEL PRODUCTO :");
        lblProductoCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblProductoCodigo.setBounds(10, 11, 189, 14);
        contentPane.add(lblProductoCodigo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
        btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBuscar.setBounds(335, 7, 89, 23);
        contentPane.add(btnBuscar);

        txtCodigoProducto = new JTextField();
        txtCodigoProducto.setBounds(209, 10, 103, 20);
        contentPane.add(txtCodigoProducto);
        txtCodigoProducto.setColumns(10);

        lblNnombreProducto = new JLabel("NOMBRE DEL PRODUCTO :");
        lblNnombreProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNnombreProducto.setBounds(10, 59, 189, 14);
        contentPane.add(lblNnombreProducto);

        separator = new JSeparator();
        separator.setBounds(10, 36, 414, 2);
        contentPane.add(separator);

        txtNombreProducto = new JTextField();
        txtNombreProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtNombreProducto.setEditable(false);
        txtNombreProducto.setBounds(209, 58, 215, 20);
        contentPane.add(txtNombreProducto);
        txtNombreProducto.setColumns(10);

        lblStockActual = new JLabel("STOCK ACTUAL :");
        lblStockActual.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStockActual.setBounds(10, 84, 189, 14);
        contentPane.add(lblStockActual);

        txtStockActual = new JTextField();
        txtStockActual.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtStockActual.setBounds(209, 83, 215, 20);
        contentPane.add(txtStockActual);
        txtStockActual.setColumns(10);

        lblStockMaximo = new JLabel("STOCK MÁXIMO :");
        lblStockMaximo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStockMaximo.setBounds(10, 109, 189, 14);
        contentPane.add(lblStockMaximo);

        txtStockMaximo = new JTextField();
        txtStockMaximo.setEditable(false);
        txtStockMaximo.setBounds(209, 108, 215, 20);
        contentPane.add(txtStockMaximo);
        txtStockMaximo.setColumns(10);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardar();
            }
        });
        btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnGuardar.setBounds(321, 162, 103, 23);
        contentPane.add(btnGuardar);
        
        lblStockMinimo = new JLabel("STOCK MÍNIMO :");
        lblStockMinimo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStockMinimo.setBounds(10, 132, 189, 14);
        contentPane.add(lblStockMinimo);
        
        txtStockMinimo = new JTextField();
        txtStockMinimo.setEditable(false);
        txtStockMinimo.setColumns(10);
        txtStockMinimo.setBounds(209, 131, 215, 20);
        contentPane.add(txtStockMinimo);
    }

    public void buscar() {
        int codigo = Integer.parseInt(txtCodigoProducto.getText());
        lista.Leer();
        indiceProducto = lista.buscar(codigo);
        if (indiceProducto != -1) {
            Producto producto = lista.obtener(indiceProducto);
            txtNombreProducto.setText(producto.getNombre());
            txtStockActual.setText(String.valueOf(producto.getStockActual()));
            txtStockMaximo.setText(String.valueOf(producto.getStockMaximo()));
            txtStockMinimo.setText(String.valueOf(producto.getStockMinimo()));
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
            LimpiarCajas();
        }
    }

    public void guardar() {
        if (indiceProducto != -1) {
            int stockActual = Integer.parseInt(txtStockActual.getText());
            int stockMaximo = Integer.parseInt(txtStockMaximo.getText());
            if (stockActual > stockMaximo) {
                JOptionPane.showMessageDialog(null, "El stock actual no puede ser mayor que el stock máximo");
            } else {
                Producto producto = lista.obtener(indiceProducto);
                producto.setStockActual(stockActual);
                producto.setStockMaximo(stockMaximo);
                producto.setStockMinimo(Integer.parseInt(txtStockMinimo.getText()));
                lista.modificar(indiceProducto, producto);
                lista.Grabar();
                JOptionPane.showMessageDialog(null, "Stock actualizado y guardado");
                LimpiarCajas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero debe buscar un producto");
        }
    }
    public void LimpiarCajas() {
    	lista.limpiar();
    }
}
