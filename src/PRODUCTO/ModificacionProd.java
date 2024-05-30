package PRODUCTO;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModificacionProd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMin;
	private JTextField txtStockMax;
	private JPanel contentPane_1;
	private JLabel lblCodigo;
	private JLabel lblProducto;
	private JLabel lblPrecio;
	private JLabel lblStockActual;
	private JLabel lblStockMinimo;
	private JLabel lblStockMaximo;
	private JButton btnBuscar;
	private JButton btnModificar;

	

	/**
	 * Create the frame.
	 */
	public ModificacionProd() {
		setTitle("Modificación de Producto");
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 11, 434, 191);
		contentPane.add(contentPane_1);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 3, 46, 14);
		contentPane_1.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("Ingrese el código");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(105, 0, 194, 20);
		contentPane_1.add(txtCodigo);
		
		lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(10, 34, 56, 14);
		contentPane_1.add(lblProducto);
		
		txtProducto = new JTextField();
		txtProducto.setColumns(10);
		txtProducto.setBounds(105, 31, 194, 20);
		contentPane_1.add(txtProducto);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 65, 46, 14);
		contentPane_1.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(105, 62, 194, 20);
		contentPane_1.add(txtPrecio);
		
		lblStockActual = new JLabel("Stock Actual:");
		lblStockActual.setBounds(10, 96, 85, 14);
		contentPane_1.add(lblStockActual);
		
		txtStockActual = new JTextField();
		txtStockActual.setColumns(10);
		txtStockActual.setBounds(105, 93, 194, 20);
		contentPane_1.add(txtStockActual);
		
		lblStockMinimo = new JLabel("Stock Mínimo:");
		lblStockMinimo.setBounds(10, 127, 73, 14);
		contentPane_1.add(lblStockMinimo);
		
		txtStockMin = new JTextField();
		txtStockMin.setColumns(10);
		txtStockMin.setBounds(105, 124, 194, 20);
		contentPane_1.add(txtStockMin);
		
		lblStockMaximo = new JLabel("Stock Máximo");
		lblStockMaximo.setBounds(10, 155, 73, 14);
		contentPane_1.add(lblStockMaximo);
		
		txtStockMax = new JTextField();
		txtStockMax.setColumns(10);
		txtStockMax.setBounds(105, 152, 194, 20);
		contentPane_1.add(txtStockMax);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(335, -1, 89, 23);
		contentPane_1.add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(335, 30, 89, 23);
		contentPane_1.add(btnModificar);
	}
}