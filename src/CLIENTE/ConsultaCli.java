package CLIENTE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ConsultaCli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;
	private JButton btnBuscar;

	
	/**
	 * Create the frame.
	 */
	public ConsultaCli() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(10, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("Ingrese el Código");
		txtCodigo.setBounds(66, 11, 194, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 414, 211);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(335, 10, 89, 23);
		contentPane.add(btnBuscar);
	}
}
