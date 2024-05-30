package CLIENTE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ListadoCli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnListado;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;

	
	

	/**
	 * Create the frame.
	 */
	public ListadoCli() {
		setTitle("Listado de Cliente");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 414, 198);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		btnListado = new JButton("Listado");
		btnListado.setBounds(171, 11, 89, 23);
		contentPane.add(btnListado);
	}

}