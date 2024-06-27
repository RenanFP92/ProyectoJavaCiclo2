package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloProductos;

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

	public Almacen() {
		setTitle("Almacen");
		setBounds(100, 100, 450, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblProductoCodigo = new JLabel("CÓDIGO \r\nDEL PRODUCTO :");
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
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setBounds(321, 139, 103, 23);
		contentPane.add(btnGuardar);
	}
	
	public void buscar() {
		int i = lista.buscar(Integer.parseInt(txtCodigoProducto.getText()));
		if(i > -1) {txtNombreProducto.setText(lista.obtener(i).getNombre());
					txtStockActual.setText(String.valueOf(lista.obtener(i).getStockActual()));
					txtStockMaximo.setText(String.valueOf(lista.obtener(i).getStockMaximo()));
			
		}else JOptionPane.showMessageDialog(null,"EL CÓDIGO INTRODUCIDO NO EXISTE");
	}
}
