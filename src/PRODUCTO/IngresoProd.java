package PRODUCTO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class IngresoProd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	/**
	 * Create the frame.
	 */
	public IngresoProd() {
		setTitle("Ingreso de Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 15, 46, 14);
		contentPane.add(lblCodigo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(66, 12, 194, 20);
		contentPane.add(textField);
		
		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(10, 46, 46, 14);
		contentPane.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 43, 194, 20);
		contentPane.add(textField_1);
		
		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setBounds(10, 77, 46, 14);
		contentPane.add(lblApellido);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 74, 194, 20);
		contentPane.add(textField_2);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(10, 108, 56, 14);
		contentPane.add(lblDireccion);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 105, 194, 20);
		contentPane.add(textField_3);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(10, 139, 46, 14);
		contentPane.add(lblTelefono);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(66, 164, 194, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(66, 136, 194, 20);
		contentPane.add(textField_5);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 167, 46, 14);
		contentPane.add(lblDni);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(335, 11, 89, 23);
		contentPane.add(btnGuardar);
	}

}
