package CLIENTE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Cliente;
import clases.Alumnos;
import CLIENTE.ArregloCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JSeparator;
import javax.swing.JTable;

public class FmrCliente extends JFrame {
	
	// Declaración de variables de trabajo
		ArregloCliente lista = new ArregloCliente();
		DefaultTableModel tabla;
		String[] Columnas = {"CODIGO CLIENTE","NOMBRES","APELLIDOS","DIRECCION","TELEFONO","DNI"};
		Object[][] Filas;
		int fila;
		private JScrollPane scrollPane;
		
		//METODO DE CARGA DEL CONTROL JTABLE
		void cargarJTable() {
			//Instanciar el objecto de tipo defaultModel
			tabla =  new DefaultTableModel();	
			//Agregar las columnas al visualizar
			for(String a:Columnas)tabla.addColumn(a);
			
			//Agregar filas
			Filas =  new Object [lista.tamaño()][6];
			for(int i= 0; i < lista.tamaño();i++) {
				Filas[i][0]=lista.obtener(i).getCodigoCliente();
				Filas[i][1]=lista.obtener(i).getNombres();
				Filas[i][2]=lista.obtener(i).getApellidos();
				Filas[i][3]=lista.obtener(i).getDireccion();
				Filas[i][4]=lista.obtener(i).getTelefono();
				Filas[i][5]=lista.obtener(i).getDni();		
				
			}
			//Asociar el objecto tabla al control Jtable
			
			miTabla.setModel(tabla);
	}
	
	
	

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
	private JButton btnLeer;
	private JButton btnModificar;
	private Container btnEliminar;
	private JButton btnBuscar;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JLabel lblDireccion;
	private Container lblcodigoCliente;
	private JLabel lblNombre;
	private Container lblApellidos;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public FmrCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblcodigoCliente = new JLabel("Codigo Cliente");
		lblcodigoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcodigoCliente.setBounds(21, 11, 125, 23);
		contentPane.add(lblcodigoCliente);
		
		lblNombre = new JLabel("Nombres :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(21, 84, 70, 14);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos.setBounds(21, 135, 70, 14);
		contentPane.add(lblApellidos);
		
		lblDireccion = new JLabel("Dirección : ");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDireccion.setBounds(21, 181, 80, 14);
		contentPane.add(lblDireccion);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefono.setBounds(21, 230, 80, 14);
		contentPane.add(lblTelefono);
		
		lblDni = new JLabel("Dni :");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDni.setBounds(21, 273, 46, 14);
		contentPane.add(lblDni);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(21, 41, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 0, 0));
		txtNombre.setBounds(101, 82, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(101, 133, 86, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(101, 179, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(101, 228, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(101, 271, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(117, 40, 89, 23);
		contentPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 72, 186, 2);
		contentPane.add(separator);
		
		miTabla = new JTable();
		miTabla.setBounds(225, 41, 349, 247);
		contentPane.add(miTabla);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBounds(595, 40, 89, 23);
		contentPane.add(btnAgregar);
		
		btnLeer = new JButton("Leer");
		btnLeer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeer.setBounds(595, 132, 89, 23);
		contentPane.add(btnLeer);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(595, 178, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(595, 230, 89, 23);
		contentPane.add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGrabar.setBounds(595, 81, 89, 23);
		contentPane.add(btnGrabar);
		cargarJTable();
	}
	
	//Metodo Limpiar Cajas
	void LimpiarCajas() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtDni.requestFocus();
	}
	// Boton Agregar
		protected void Agregar(ActionEvent e) {
			lista.agregar(new Cliente(Integer.parseInt(txtCodigo.getText()),
			txtNombre.getText(),
			txtApellidos.getText(),
			txtDireccion.getText(),
			txtTelefono.getText(),
			txtDni.getText()));
			
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
			int codigo = lista.obtener(lista.tamaño()-1).getCodigoCliente() + 1;
			txtCodigo.setText(codigo + "");
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
			lista.modificar(fila, new Cliente(Integer.parseInt(txtCodigo.getText()),
			txtNombre.getText(),
			txtApellidos.getText(),
			txtDireccion.getText(),
			txtTelefono.getText(),
			txtDni.getText()));
			cargarJTable();
			UltimoCodigo();
			
			// Desabilitar los botones modificar y eliminar
			btnModificar.setEnabled(false);
			btnEliminar.setEnabled(false);
		}
		
		// Boton Eliminar
		protected void btnEliminarActionPerformed(ActionEvent e) {
			lista.suprimir(fila);
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
										"CODIGO :" + lista.obtener(i).getCodigoCliente() + "\n" +
										"NOMBRE :" + lista.obtener(i).getNombres() + "\n" +
										"APELLIDOS :" + lista.obtener(i).getApellidos() + "\n" +
										"DIRECCION:" + lista.obtener(i).getDireccion()+ "\n" +
										"TELEFONO:" + lista.obtener(i).getTelefono() + "\n" +
										"DNI:" + lista.obtener(i).getDni());
			}else JOptionPane.showMessageDialog(null, "NO EXISTE EL CODIGO");
			
			
		}
		
}
