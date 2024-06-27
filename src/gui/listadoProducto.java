package gui;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloProductos;
import Clases.Producto;

public class listadoProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;

	public listadoProducto(ArregloProductos lista) {
		setTitle("Listado de Productos");
		setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setLocationRelativeTo(null);
		setResizable(false);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
    
        cargarDatos(lista);
	}
	
	private void cargarDatos(ArregloProductos lista) {
        StringBuilder obj = new StringBuilder();
        for (int i = 0; i < lista.tamaño(); i++) {
            Producto producto = lista.obtener(i);
            obj.append("Codigo: " + producto.getCodigoProducto() + 
              "\nNombre: " + producto.getNombre() +
              "\n-----------------------------------------------------------" + "\n" );
       
        }
        textArea.setText(obj.toString());
    }

}
