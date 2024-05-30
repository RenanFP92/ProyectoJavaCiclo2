package PRODUCTO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ConsultaProd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;

	

	/**
	 * Create the frame.
	 */
	public ConsultaProd() {
		setTitle("Consulta de Producto");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 15, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("Ingrese el Código");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(66, 12, 194, 20);
		contentPane.add(txtCodigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(335, 11, 89, 23);
		contentPane.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 414, 210);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
	}

}
