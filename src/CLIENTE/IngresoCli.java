package CLIENTE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class IngresoCli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDNI;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JButton btnGuardar;

	
	/**
	 * Create the frame.
	 */
	public IngresoCli() {
		setTitle("Ingreso de Cliente");
		setBounds(100, 100, 450, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 14, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 11, 194, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(10, 45, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(66, 42, 194, 20);
		contentPane.add(txtNombre);
		
		lblApellido = new JLabel("Apellidos:");
		lblApellido.setBounds(10, 76, 46, 14);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(66, 73, 194, 20);
		contentPane.add(txtApellido);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(66, 104, 194, 20);
		contentPane.add(txtDireccion);
		
		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(10, 107, 56, 14);
		contentPane.add(lblDireccion);
		
		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(10, 138, 46, 14);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(66, 135, 194, 20);
		contentPane.add(txtTelefono);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 166, 46, 14);
		contentPane.add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(66, 163, 194, 20);
		contentPane.add(txtDNI);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(335, 10, 89, 23);
		contentPane.add(btnGuardar);
	}

}
