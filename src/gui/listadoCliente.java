
package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import Arreglos.ArregloCliente;
import Clases.Cliente;

public class listadoCliente extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public listadoCliente(ArregloCliente lista) {
    	setTitle("Listado de Clientes");
    	
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

    private void cargarDatos(ArregloCliente lista) {
        StringBuilder obj = new StringBuilder();
        for (int i = 0; i < lista.tamaño(); i++) {
            Cliente cliente = lista.obtener(i);
            obj.append("Codigo: " + cliente.getCodigoCliente() + 
              "\nNombre: " + cliente.getNombres() +
              "\nApellidos: " + cliente.getApellidos()+
              "\n-----------------------------------------------------------" + "\n" );
       
        }
        textArea.setText(obj.toString());
    }
    //tengo hambre jajajaj por Ruvi Rivera
    
}