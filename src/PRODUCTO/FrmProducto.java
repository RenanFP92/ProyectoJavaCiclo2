package PRODUCTO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import Clases.*;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class FrmProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblStockActual;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JButton btnBuscar;
	private JTable miTabla;
	private JButton btnAgregar;
	private JButton btnGrabar;
	private JButton btnLeer;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JSeparator separator;

	// Declaración de variables de trabajo
	ArregloProductos lista = new ArregloProductos();
	DefaultTableModel tabla;
	String[] Columnas = {"CODIGO","NOMBRES","PRECIO","STOCK ACTUAL","STOCK MÁXIMO","STOCK MÍNIMO"};
	Object[][] Filas;
	int fila;
	private JScrollPane scrollPane;
	private JTextField txtStockMaximo;
	private JTextField txtStockMinimo;
	private JLabel lblStockMáximo;
	private JLabel lblStockMínimo;
	
	// método de carga del control JTable
	void cargarJTable() {
		// Instanciar el objeto de tipo DefaultTableModel
		tabla = new DefaultTableModel();
		// Agregar las columnas a visualizar
		for(String c:Columnas)tabla.addColumn(c);
		// Agregar las filas
		Filas = new Object[lista.tamaño()][6];
		for(int i = 0; i < lista.tamaño(); i++) {
			Filas[i][0] = lista.obtener(i).getCodigoProducto();
			Filas[i][1] = lista.obtener(i).getNombre();
			Filas[i][2] = lista.obtener(i).getPrecio();
			Filas[i][3] = lista.obtener(i).getStockActual();
			Filas[i][4] = lista.obtener(i).getStockMaximo();
			Filas[i][5] = lista.obtener(i).getStockMinimo();
			tabla.addRow(Filas[i]);
		}
		// Asociar el objeto tabla al control JTable
		miTabla.setModel(tabla);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProducto frame = new FrmProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("MANTENIMIENTO DE PRODUCTOS");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(25, 11, 437, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("CODIGO");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setBounds(25, 55, 102, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("NOMBRE");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(25, 148, 102, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("PRECIO");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_3.setBounds(25, 186, 102, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblStockActual = new JLabel("STOCK ACTUAL");
			lblStockActual.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblStockActual.setBounds(25, 227, 117, 14);
			contentPane.add(lblStockActual);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					txtCodigoKeyPressed(e);
				}
			});
			txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtCodigo.setBounds(25, 76, 86, 20);
			contentPane.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtNombre.setBounds(143, 145, 86, 20);
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtPrecio.setBounds(143, 183, 86, 20);
			contentPane.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtStockActual = new JTextField();
			txtStockActual.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtStockActual.setBounds(143, 224, 86, 20);
			contentPane.add(txtStockActual);
			txtStockActual.setColumns(10);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBuscarActionPerformed(e);
				}
			});
			btnBuscar.setEnabled(false);
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBuscar.setBounds(121, 75, 89, 23);
			contentPane.add(btnBuscar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(239, 37, 411, 289);
			contentPane.add(scrollPane);
			{
				miTabla = new JTable();
				miTabla.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						miTablaMouseClicked(e);
					}
				});
				scrollPane.setViewportView(miTabla);
			}
		}
		{
			btnAgregar = new JButton("Agregar");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAgregarActionPerformed(e);
				}
			});
			btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAgregar.setBounds(670, 24, 117, 23);
			contentPane.add(btnAgregar);
		}
		{
			btnGrabar = new JButton("Grabar");
			btnGrabar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnGrabarActionPerformed(e);
				}
			});
			btnGrabar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnGrabar.setBounds(670, 71, 117, 23);
			contentPane.add(btnGrabar);
		}
		{
			btnLeer = new JButton("Leer");
			btnLeer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnLeerActionPerformed(e);
				}
			});
			btnLeer.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLeer.setBounds(670, 118, 117, 23);
			contentPane.add(btnLeer);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnModificarActionPerformed(e);
				}
			});
			btnModificar.setEnabled(false);
			btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnModificar.setBounds(670, 165, 117, 23);
			contentPane.add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnEliminarActionPerformed(e);
				}
			});
			btnEliminar.setEnabled(false);
			btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnEliminar.setBounds(670, 212, 117, 23);
			contentPane.add(btnEliminar);
		}
		{
			separator = new JSeparator();
			separator.setBackground(Color.DARK_GRAY);
			separator.setBounds(25, 124, 184, 10);
			contentPane.add(separator);
		}
		
		lblStockMáximo = new JLabel("STOCK MÁXIMO");
		lblStockMáximo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStockMáximo.setBounds(25, 266, 117, 14);
		contentPane.add(lblStockMáximo);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtStockMaximo.setColumns(10);
		txtStockMaximo.setBounds(143, 263, 86, 20);
		contentPane.add(txtStockMaximo);
		
		lblStockMínimo = new JLabel("STOCK MÍNIMO");
		lblStockMínimo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStockMínimo.setBounds(25, 309, 117, 14);
		contentPane.add(lblStockMínimo);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtStockMinimo.setColumns(10);
		txtStockMinimo.setBounds(143, 306, 86, 20);
		contentPane.add(txtStockMinimo);
		cargarJTable();
	}
	
	// Método LimpiarCajas
	void LimpiarCajas() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMaximo.setText("");
		txtStockMinimo.setText("");
		txtCodigo.requestFocus();
	}
	
	// Boton Agregar
	protected void btnAgregarActionPerformed(ActionEvent e) {
		lista.agregar(new Producto(Integer.parseInt(txtCodigo.getText()),
							txtNombre.getText(),
							Double.parseDouble(txtPrecio.getText()),
							Integer.parseInt(txtStockActual.getText()), 
							Integer.parseInt(txtStockMaximo.getText()),
							Integer.parseInt(txtStockMinimo.getText())));
		LimpiarCajas();
		cargarJTable();
		UltimoCodigo();
	}
	
	// Boton Grabar
	protected void btnGrabarActionPerformed(ActionEvent e) {
		lista.Grabar();
		JOptionPane.showMessageDialog(null, "SE HAN GRABADO EN EL ARCHIVO");
	}
	
	// Boton Leer
	protected void btnLeerActionPerformed(ActionEvent e) {
		lista.Leer();
		cargarJTable();
		UltimoCodigo();
	}
	
	// método para devolver el último codigo
	public void UltimoCodigo() {
		int codigo = lista.obtener(lista.tamaño()-1).getCodigoProducto() + 1;
		txtCodigo.setText(codigo + "");
	}
	
	// método click en el JTable
	protected void miTablaMouseClicked(MouseEvent e) {
		// Recupera la fila seleccionada con el Mouse
		fila = miTabla.getSelectedRow();
		// Recuperar los campos de la fila seleccionada
		txtCodigo.setText(lista.obtener(fila).getCodigoProducto() + "");
		txtNombre.setText(lista.obtener(fila).getNombre());
		txtPrecio.setText(lista.obtener(fila).getPrecio() + "");
		txtStockActual.setText(lista.obtener(fila).getStockActual() + "");
		txtStockMaximo.setText(lista.obtener(fila).getStockMaximo() + "");
		txtStockMinimo.setText(lista.obtener(fila).getStockMinimo() + "");
		// Habilitar los botones modificar y eliminar
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);		
	}
	
	// Boton Modificar
	protected void btnModificarActionPerformed(ActionEvent e) {
		lista.modificar(fila, new Producto(Integer.parseInt(txtCodigo.getText()),
											txtNombre.getText(),
											Double.parseDouble(txtPrecio.getText()),
											Integer.parseInt(txtStockActual.getText()), 
											Integer.parseInt(txtStockMaximo.getText()),
											Integer.parseInt(txtStockMinimo.getText())));
		cargarJTable();
		UltimoCodigo();
		// Desabilitar los botones modificar y eliminar
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}
	
	// Boton Eliminar
	protected void btnEliminarActionPerformed(ActionEvent e) {
		lista.Suprimir(fila);
		cargarJTable();
		UltimoCodigo();
		// Desabilitar los botones modificar y eliminar
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}
	
	// método keypressed para la caja txtCodigo
	protected void txtCodigoKeyPressed(KeyEvent e) {
		btnBuscar.setEnabled(txtCodigo.getText().length() > 0);
	}
	
	// Boton Buscar
	protected void btnBuscarActionPerformed(ActionEvent e) {
		int i = lista.buscar(Integer.parseInt(txtCodigo.getText()));
		if(i > -1) {
			JOptionPane.showMessageDialog(null, "ALUMNO ENCONTRADO\n" +
									"CODIGO :" + lista.obtener(i).getCodigoProducto() + "\n" +
									"NOMBRE :" + lista.obtener(i).getNombre() + "\n" +
									"PRECIO :" + lista.obtener(i).getPrecio() + "\n" +
									"STOCK ACTUAL :" + lista.obtener(i).getStockActual() + "\n" +
									"STOCK MAXIMO :" + lista.obtener(i).getStockMaximo() + "\n" +
									"STOCK MÍNIMO :" + lista.obtener(i).getStockMinimo());
		}else JOptionPane.showMessageDialog(null, "NO EXISTE EL CODIGO");
	}
}
