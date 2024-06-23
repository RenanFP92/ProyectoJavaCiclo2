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

import CLIENTE.ConsultaCli;
import CLIENTE.EliminacionCli;
import CLIENTE.IngresoCli;
import CLIENTE.ListadoCli;
import CLIENTE.ModificacionCli;

import java.awt.Color;

public class TIENDA extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//Declaración de variables
	private JMenuBar menuBar;
	private JMenu mnOpciones;
	private JMenu mnMantenimiento;
	private JMenu mnAlmacen;
	private JMenu mnReportes;
	private JMenu mnVentas;
	private JMenuItem mntmSalir;
	private JMenuItem mntmBorrarDatos;

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
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mnMantenimiento.add(mntmClientes);
		
		JMenuItem mntmProductos = new JMenuItem("Productos");
		mnMantenimiento.add(mntmProductos);
		
		mnAlmacen = new JMenu("Almacén");
		mnAlmacen.addActionListener(this);
		mnAlmacen.setForeground(Color.WHITE);
		menuBar.add(mnAlmacen);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.addActionListener(this);
		mnReportes.setForeground(Color.WHITE);
		menuBar.add(mnReportes);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.addActionListener(this);
		mnVentas.setForeground(Color.WHITE);
		menuBar.add(mnVentas);
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
	}
	
	
	//Direcciona las acciones de los botones
		public void actionPerfomedMntmSalir(ActionEvent e) {
			System.exit(0);
		}
		
		public void actionPerfomedMntmIngresoCli(ActionEvent e) {
			IngresoCli ventana1 = new IngresoCli ();
			ventana1.setVisible(true);
		}
		
		public void actionPerfomedMntmModificacionCli(ActionEvent e) {
			ModificacionCli ventana2 = new ModificacionCli();
			ventana2.setVisible(true);
		}
		
		public void actionPerfomedMntmConsultaCli(ActionEvent e) {
			ConsultaCli ventana3 = new ConsultaCli();
			ventana3.setVisible(true);
		}
		
		public void actionPerfomedMntmEliminacionCli(ActionEvent e) {
			EliminacionCli ventana4 = new EliminacionCli();
			ventana4.setVisible(true);
		}
		
		public void actionPerfomedMntmListadoCli(ActionEvent e) {
			ListadoCli ventana5 = new ListadoCli();
			ventana5.setVisible(true);
		}
		
		public void actionPerfomedMntmBorrarDatos(ActionEvent e) {
		        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea borrar todos los datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        if (respuesta == JOptionPane.YES_OPTION) {
		            try (FileWriter fw = new FileWriter("productos.txt")) {
		                // Sobreescribe el archivo con una cadena vacía, borrando todo el contenido
		                fw.write("");
		                JOptionPane.showMessageDialog(this, "Todos los datos han sido borrados.");
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
}
