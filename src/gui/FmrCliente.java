package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Cliente;
import Arreglos.ArregloCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JSeparator;
import javax.swing.JTable;

public class FmrCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JTable miTabla;
	private JButton btnGrabar;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JLabel lblDireccion;
	private JLabel lblcodigoCliente;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JButton btnAbrirBusqueda;

	// Declaración de variables de trabajo
	ArregloCliente lista = new ArregloCliente();
	DefaultTableModel tabla;
	String[] Columnas = {"CODIGO CLIENTE","NOMBRES","APELLIDOS","DIRECCION","TELEFONO","DNI"};
	Object[][] Filas;
	int fila;
	private JButton btnLeer;
	private JLabel lblTitulo;
	private JSeparator separator;
	private int ultimoCodigo = 1001;  // Inicializar el código a partir de 1001



	// METODO DE CARGA DEL CONTROL JTABLE
	void cargarJTable() {
		
		// Instanciar el objecto de tipo DefaultTableModel
		tabla = new DefaultTableModel();
		// Agregar las columnas al visualizar
		for (String a : Columnas) {
			tabla.addColumn(a);
		}
		// Agregar filas
		Filas = new Object[lista.tamaño()][6];
		for (int i = 0; i < lista.tamaño(); i++) {
			Filas[i][0] = lista.obtener(i).getCodigoCliente();
			Filas[i][1] = lista.obtener(i).getNombres();
			Filas[i][2] = lista.obtener(i).getApellidos();
			Filas[i][3] = lista.obtener(i).getDireccion();
			Filas[i][4] = lista.obtener(i).getTelefono();
			Filas[i][5] = lista.obtener(i).getDni();
		}
		// Asociar el objecto tabla al control JTable
		tabla.setDataVector(Filas, Columnas);
		miTabla.setModel(tabla);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FmrCliente frame = new FmrCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FmrCliente() {
		setBounds(100, 100, 1135, 376);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblcodigoCliente = new JLabel("CÓDIGO :");
		lblcodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcodigoCliente.setBounds(21, 42, 125, 23);
		contentPane.add(lblcodigoCliente);

		lblNombre = new JLabel("NOMBRE :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(21, 95, 70, 14);
		contentPane.add(lblNombre);

		lblApellidos = new JLabel("APELLIDOS :");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos.setBounds(21, 135, 80, 14);
		contentPane.add(lblApellidos);

		lblDireccion = new JLabel("DIRECCIÓN :");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDireccion.setBounds(21, 181, 80, 14);
		contentPane.add(lblDireccion);

		lblTelefono = new JLabel("TELÉFONO :");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefono.setBounds(21, 230, 80, 14);
		contentPane.add(lblTelefono);

		lblDni = new JLabel("DNI :");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDni.setBounds(21, 273, 46, 14);
		contentPane.add(lblDni);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(143, 45, 86, 20);
		txtCodigo.setEditable(false);  // Hacer el campo de código no editable
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 0, 0));
		txtNombre.setBounds(143, 95, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(143, 135, 86, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(143, 181, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(143, 228, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(143, 273, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(239, 37, 771, 275);
		contentPane.add(scrollPane);

		miTabla = new JTable();
		miTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miTablaMouseClicked(e);
			}
		});
		scrollPane.setViewportView(miTabla);

		separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(10, 72, 219, 2);
		contentPane.add(separator);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar(e);
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(1020, 41, 89, 23);
		contentPane.add(btnAgregar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar(e);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(1020, 132, 89, 23);
		contentPane.add(btnModificar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grabar(e);
			}
		});
		btnGrabar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGrabar.setBounds(1020, 81, 89, 23);
		contentPane.add(btnGrabar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar(e);
			}
		});
		btnEliminar.setBounds(1020, 178, 89, 23);
		contentPane.add(btnEliminar);
		
		btnLeer = new JButton("Listado");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Leer(e);
			}
		});
		btnLeer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLeer.setBounds(595, 227, 89, 23);
		contentPane.add(btnLeer);

		btnAbrirBusqueda = new JButton("Buscar");
		btnAbrirBusqueda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAbrirBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirBusquedaCliente();
			}
		});
		btnAbrirBusqueda.setBounds(1020, 227, 89, 23);
		contentPane.add(btnAbrirBusqueda);
		
		lblTitulo = new JLabel("MANTENIMIENTO DE CLIENTES");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitulo.setBounds(21, 11, 239, 14);
		contentPane.add(lblTitulo);

		cargarJTable();
		UltimoCodigo();  // Inicializar el código al cargar la ventana
	}

	private void abrirBusquedaCliente() {
		buscarCliente busquedaCliente = new buscarCliente(lista);
		busquedaCliente.setVisible(true);
	}
	
	//metodos de acciones de los botones  botones 
	

	
	// Metodo Limpiar Cajas
	protected void LimpiarCajas() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		txtDni.requestFocus();
	}

	// Boton Agregar
	protected void Agregar(ActionEvent e) {
		lista.agregar(new Cliente(ultimoCodigo,
		txtNombre.getText(),
	    txtApellidos.getText(), 
		txtDireccion.getText(), 
		txtTelefono.getText(), 
		txtDni.getText()));

		ultimoCodigo++;  // Incrementar el código para el siguiente cliente
		cargarJTable();
		LimpiarCajas();
		UltimoCodigo();  // Actualizar el campo de código con el siguiente valor
	}

	// Boton Grabar
	protected void Grabar(ActionEvent e) {
		lista.Grabar();
		JOptionPane.showMessageDialog(null, "SE HAN GRABADO EN EL ARCHIVO");
	}

	// Boton Leer
	protected void Leer(ActionEvent e) {
		
		listadoCliente ventana1 = new  listadoCliente(lista) ;
		ventana1.setVisible(true);
		lista.Leer();
		LimpiarCajas();
	}

	// método para devolver el último codigo
	public void UltimoCodigo() {
		if (lista.tamaño() > 0) {
			ultimoCodigo = lista.obtener(lista.tamaño() - 1).getCodigoCliente() + 1;
		}
		txtCodigo.setText(ultimoCodigo + "");
	}

	// método click en el JTable
	protected void miTablaMouseClicked(MouseEvent e) {
		// Recupera la fila seleccionada con el Mouse
		fila = miTabla.getSelectedRow();
		// Recuperar los campos de la fila seleccionada
		txtCodigo.setText(lista.obtener(fila).getCodigoCliente() + "");
		txtNombre.setText(lista.obtener(fila).getNombres());
		txtApellidos.setText(lista.obtener(fila).getApellidos() + "");
		txtDireccion.setText(lista.obtener(fila).getDireccion() + "");
		txtTelefono.setText(lista.obtener(fila).getTelefono() + "");
		txtDni.setText(lista.obtener(fila).getDni() + "");
		// Habilitar los botones modificar y eliminar
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
	}

	// Boton Modificar
	protected void Modificar(ActionEvent e) {
		lista.modificar(fila, new Cliente(Integer.parseInt(txtCodigo.getText()), txtNombre.getText(),
				txtApellidos.getText(), txtDireccion.getText(), txtTelefono.getText(), txtDni.getText()));
		cargarJTable();
		UltimoCodigo();
		LimpiarCajas();
		// Desabilitar los botones modificar y eliminar
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}
	

	// Boton Eliminar
	protected void Eliminar(ActionEvent e) {
		lista.suprimir(fila);
		cargarJTable();
		UltimoCodigo();
		LimpiarCajas();
		// Desabilitar los botones modificar y eliminar
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}

}
