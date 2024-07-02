package VentanaPrincipal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import gui.Almacen;
import gui.FmrCliente;
import gui.FmrVentas;
import gui.FrmProducto;
import gui.Reportes;

import java.awt.Color;

public class TIENDA extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//Declaración de variables
	private JMenuBar menuBar;
	private JMenu mnOpciones;
	private JMenu mnMantenimiento;
	private JMenuItem mntmSalir;
	private JMenuItem mntmBorrarDatos;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;
	private String archivoProducto = "Archivos txt/productos.txt";
	private String archivoCliente = "Archivos txt/cliente.txt";
	private JMenu mnGestion;
	private JMenuItem mntmVentas;
	private JMenuItem mntmAlmacen;
	private JMenuItem mntmReportes;

	//Lanza la aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TIENDA frame = new TIENDA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CREA LA GUI
	public TIENDA() {
		setTitle("Tienda 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(480,297);
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
		
	}
	
	private void iniciarComponentes() {
		
		//inicia componentes
		
		menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);
		
		mnOpciones = new JMenu("Opciones");
		mnOpciones.setForeground(Color.WHITE);
		menuBar.add(mnOpciones);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		
		mntmBorrarDatos = new JMenuItem("Borrar Datos");
		mntmBorrarDatos.addActionListener(this);
		mnOpciones.add(mntmBorrarDatos);
		mnOpciones.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setForeground(Color.WHITE);
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mnMantenimiento.add(mntmProductos);
		
		mnGestion = new JMenu("Gestión");
		mnGestion.setForeground(Color.WHITE);
		menuBar.add(mnGestion);
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.addActionListener(this);
		mnGestion.add(mntmVentas);
		
		mntmAlmacen = new JMenuItem("Almacén");
		mntmAlmacen.addActionListener(this);
		mnGestion.add(mntmAlmacen);
		
		mntmReportes = new JMenuItem("Reportes");
		mntmReportes.addActionListener(this);
		mnGestion.add(mntmReportes);
		getContentPane().setLayout(null);
	}
	
	
	//Direccionando los botones del menu
	public void actionPerformed(ActionEvent e) {
		
		if  (mntmSalir==e.getSource()){
			actionPerfomedMntmSalir(e);
		}
		
		
		if (mntmBorrarDatos==e.getSource()) {
			actionPerfomedMntmBorrarDatos(e);
		}
		
		if (mntmClientes==e.getSource()) {
			actionPerformedMntmClientes(e);
		}
		
		if (mntmProductos==e.getSource()) {
			actionPerformedMntmProductos(e);
		}
		
		if (mntmVentas==e.getSource()) {
			actionPerformedMntmVentas(e);
		}
		
		if (mntmAlmacen==e.getSource()) {
			actionPerformedMntmAlmacen(e);
		}
		
		if (mntmReportes==e.getSource()) {
			actionPerformedMntmReportes(e);
		}
		
	}
	
	
	
	//Direcciona las acciones de los botones
		public void actionPerformedMntmClientes(ActionEvent e) {
			FmrCliente ventana1 = new FmrCliente ();
			ventana1.setVisible(true);
		}
		
		public void actionPerformedMntmProductos(ActionEvent e) {
			FrmProducto ventana2 = new FrmProducto ();
			ventana2.setVisible(true);
		}
		
		public void actionPerformedMntmVentas(ActionEvent e) {
			FmrVentas ventana3 = new FmrVentas();
			ventana3.setVisible(true);
		}
		
		public void actionPerformedMntmAlmacen(ActionEvent e) {
			Almacen ventana4 = new Almacen ();
			ventana4.setVisible(true);
		}
		
		public void actionPerformedMntmReportes(ActionEvent e) {
			Reportes ventana5 = new Reportes ();
			ventana5.setVisible(true);
		}
		
	
		public void actionPerfomedMntmSalir(ActionEvent e) {
			System.exit(0);
		}

		public void actionPerfomedMntmBorrarDatos(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea borrar todos los datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (respuesta == JOptionPane.YES_OPTION) {
		            try (FileWriter fw1 = new FileWriter(archivoCliente);
		            	 FileWriter fw2 = new FileWriter(archivoProducto) ) {
		                // Sobreescribe el archivo con una cadena vacía, borrando todo el contenido
		                fw1.write("");
		                fw2.write("");
		                JOptionPane.showMessageDialog(this, "Todos los datos han sido borrados.");
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
}
