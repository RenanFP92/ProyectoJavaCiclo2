package PRODUCTO;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import Clases.Producto;

public class IngresoProd extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//Declarando variables
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMax;
	private JTextField txtStockMin;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblStockActual;
	private JLabel lblStockMinimo;
	private JLabel lblStockMaximo;
	private JButton btnGuardar;
	private int ultimoCodigo = 2000;
	
	
	//Se crea la ventana
	public IngresoProd() {
		setTitle("Ingreso de Producto");
		setBounds(100, 100, 460, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 15, 97, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(117, 9, 194, 20);
		contentPane.add(txtCodigo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 46, 97, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(117, 40, 194, 20);
		contentPane.add(txtNombre);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 77, 97, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(117, 71, 194, 20);
		contentPane.add(txtPrecio);
		
		lblStockActual = new JLabel("Stock Actual:");
		lblStockActual.setBounds(10, 108, 97, 14);
		contentPane.add(lblStockActual);
		
		txtStockActual = new JTextField();
		txtStockActual.setColumns(10);
		txtStockActual.setBounds(117, 102, 194, 20);
		contentPane.add(txtStockActual);
		
		lblStockMinimo = new JLabel("Stock Mínimo:");
		lblStockMinimo.setBounds(10, 139, 97, 14);
		contentPane.add(lblStockMinimo);
		
		txtStockMax = new JTextField();
		txtStockMax.setColumns(10);
		txtStockMax.setBounds(117, 161, 194, 20);
		contentPane.add(txtStockMax);
		
		txtStockMin = new JTextField();
		txtStockMin.setColumns(10);
		txtStockMin.setBounds(117, 133, 194, 20);
		contentPane.add(txtStockMin);
		
		lblStockMaximo = new JLabel("Stock Máximo:");
		lblStockMaximo.setBounds(10, 167, 97, 14);
		contentPane.add(lblStockMaximo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(335, 11, 89, 23);
		contentPane.add(btnGuardar);
	}

	//Redirigiendo botón guardar
	public void actionPerformed(ActionEvent e) {
		if (btnGuardar==e.getSource()) {
			Guardar(e);
		}
	}
	
	//Procesos del botón guardar
	public void Guardar(ActionEvent e) {
		// Obtener los datos ingresados
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int stockActual = Integer.parseInt(txtStockActual.getText());
        int stockMin = Integer.parseInt(txtStockMin.getText());
        int stockMax = Integer.parseInt(txtStockMax.getText());

        // Crear un objeto Producto con los datos ingresados
        Producto producto = new Producto(ultimoCodigo, nombre, precio, stockActual, stockMin, stockMax);

        // Guardar el producto en el archivo
        try {
            producto.guardarProducto();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		// Incrementar el último código generado y establecerlo en el campo de texto
		ultimoCodigo++;
        txtCodigo.setText(String.valueOf(ultimoCodigo));		
	}

}