package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Arreglos.ArregloProductos;
import Clases.Producto;

public class Reportes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnImporteTotal;
	private JButton btnUnidadesVendidas;
	private JButton btnListadoStockMinimo;
	private JButton btnListadoVentas;
	private JTextArea txtResultado;
	private JScrollPane scrollPane;
	ArregloProductos lista = new ArregloProductos();
	
	public Reportes() {
		setTitle("Reportes");
		setBounds(100, 100, 900, 507);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 864, 382);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		txtResultado.setFont(new Font("Monospaced", Font.BOLD, 14));
		scrollPane.setViewportView(txtResultado);
		
		btnListadoVentas = new JButton("LISTADO GENERAL");
		btnListadoVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoGeneral();
			}
		});
		btnListadoVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListadoVentas.setBounds(89, 404, 331, 23);
		contentPane.add(btnListadoVentas);
		
		btnListadoStockMinimo = new JButton("PRODUCTOS DEBAJO DEL STOCK MÍNIMO");
		btnListadoStockMinimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeStockMinimo(lista);
			}
		});
		btnListadoStockMinimo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListadoStockMinimo.setBounds(453, 438, 349, 23);
		contentPane.add(btnListadoStockMinimo);
		
		btnUnidadesVendidas = new JButton("UNIDADES VENDIDAS POR PRODUCTO");
		btnUnidadesVendidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnidadesVendidasPorProducto();
			}
		});
		btnUnidadesVendidas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUnidadesVendidas.setBounds(89, 438, 331, 23);
		contentPane.add(btnUnidadesVendidas);
		
		btnImporteTotal = new JButton("IMPORTE TOTAL DE CADA PRODUCTO");
		btnImporteTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImporteTotalPorProducto();
			}
		});
		btnImporteTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnImporteTotal.setBounds(453, 404, 349, 23);
		contentPane.add(btnImporteTotal);
	}
	
	
	
	public void ListadoDeStockMinimo(ArregloProductos lista) {
		lista.Leer(); // Asegúrate de leer los datos
        StringBuilder obj = new StringBuilder();
        for (int i = 0; i < lista.tamaño(); i++) {
            Producto producto = lista.obtener(i);
            if (producto.getStockActual() < producto.getStockMinimo()) {
                obj.append("Código: " + producto.getCodigoProducto() + 
                           "\nNombre: " + producto.getNombre() +
                           "\nStock Actual: " + producto.getStockActual() + 
                           "\nStock Mínimo: " + producto.getStockMinimo() +
                           "\n-----------------------------------------------------------" + "\n");
            }
        }
        txtResultado.setText(obj.toString());
	}
	
	public void ListadoGeneral() {
		
	}
	
	public void UnidadesVendidasPorProducto() {
		
	}
	
	public void ImporteTotalPorProducto() {
		
	}
}
