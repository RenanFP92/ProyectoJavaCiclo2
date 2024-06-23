package PRODUCTO;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;

public class ListadoProd extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;
	private JButton btnListado;

	

	//Crea la ventana
	public ListadoProd() {
		setTitle("Listado de Producto");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 414, 198);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		btnListado = new JButton("Listado");
		btnListado.setBounds(171, 11, 89, 23);
		btnListado.addActionListener(this);
		contentPane.add(btnListado);
	}

	//Redirigiendo el botón Listado
	public void actionPerformed(ActionEvent e) {
		if (btnListado==e.getSource()) {
			Listado(e);
		}		
	}
	
	//Procesos del botón Listado
	public void Listado(ActionEvent e) {
	        File file = new File("productos.txt");
	        if (file.length() == 0) {
	            JOptionPane.showMessageDialog(this, "NO SE HAN GUARDADO DATOS");
	            txtResultado.setText("");
	        } else {
	            StringBuilder productos = new StringBuilder();
	            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	                String linea;
	                boolean firstProduct = true;
	                while ((linea = br.readLine()) != null) {
	                    if (!firstProduct && linea.trim().isEmpty()) {
	                        productos.append("-------------------\n");
	                        continue;
	                    }
	                    if (!linea.trim().isEmpty()) {
	                        productos.append(linea).append("\n");
	                        firstProduct = false;
	                    }
	                }
	                txtResultado.setText(productos.toString());
	            } catch (IOException ex) {
	                ex.printStackTrace();
	                txtResultado.setText("Error al leer el archivo de productos.");
	            }
	       }
	}	

	
	// hola mundo me llamo renan proyecto 2
}
