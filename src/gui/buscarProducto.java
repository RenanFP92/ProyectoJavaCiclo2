package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloProductos;
import Clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class buscarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextArea txtResultado;
	private ArregloProductos arregloProducto;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JLabel lblCodigo;

	public buscarProducto(ArregloProductos arregloProducto) {
		this.arregloProducto = arregloProducto;
		setTitle("Buscar Producto");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("CÓDIGO :");
		lblCodigo.setBounds(10, 11, 68, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(88, 8, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(335, 7, 89, 23);
		contentPane.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 414, 214);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
	}
	
	private void buscar() {
		int codigo = Integer.parseInt(txtCodigo.getText());
		int index = arregloProducto.buscar(codigo);
		if (index != -1) {
			Producto producto = arregloProducto.obtener(index);
			txtResultado.setText("Código :" + producto.getCodigoProducto() + "\n" +
								"Nombre :" + producto.getNombre() + "\n" +
								"Stock Actual :" + producto.getStockActual() + "\n" +
								"Stock Mínimo :" + producto.getStockMinimo() + "\n" +
								"Stock Máximo :" + producto.getStockMaximo() + "\n");
		} else {
			JOptionPane.showMessageDialog(null, "NO EXISTE EL CODIGO");
		}
	}

}
