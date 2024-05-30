package VentanaPrincipal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import CLIENTE.ConsultaCli;
import CLIENTE.EliminacionCli;
import CLIENTE.IngresoCli;
import CLIENTE.ListadoCli;
import CLIENTE.ModificacionCli;
import PRODUCTO.IngresoProd;

import java.awt.Color;

public class TIENDA extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//Declaración de variables
	private JMenuBar menuBar;
	private JMenu mnOpciones;
	private JMenu mnMantenimiento;
	private JMenu mnClientes;
	private JMenuItem mntmIngresoCli;
	private JMenuItem mntmModificacionCli;
	private JMenuItem mntmConsultaCli;
	private JMenuItem mntmEliminacionCli;
	private JMenuItem mntmListadoCli;
	private JMenu mnProductos;
	private JMenuItem mntmIngresoProd;
	private JMenuItem mntmModificacionProd;
	private JMenuItem mntmConsultaProd;
	private JMenuItem mntmEliminacionProd;
	private JMenuItem mntmListadoProd;
	private JMenu mnAlmacen;
	private JMenu mnReportes;
	private JMenu mnVentas;

	private JMenuItem mntmSalir;

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
		mnOpciones.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setForeground(Color.WHITE);
		menuBar.add(mnMantenimiento);
		
		mnClientes = new JMenu("Clientes");
		mnMantenimiento.add(mnClientes);
		
		mntmIngresoCli = new JMenuItem("Ingreso");
		mntmIngresoCli.addActionListener(this);
		mnClientes.add(mntmIngresoCli);
		
		mntmModificacionCli = new JMenuItem("Modificación");
		mntmModificacionCli.addActionListener(this);
		mnClientes.add(mntmModificacionCli);
		
		mntmConsultaCli = new JMenuItem("Consulta");
		mntmConsultaCli.addActionListener(this);
		mnClientes.add(mntmConsultaCli);
		
		mntmEliminacionCli = new JMenuItem("Eliminación");
		mntmEliminacionCli.addActionListener(this);
		mnClientes.add(mntmEliminacionCli);
		
		mntmListadoCli = new JMenuItem("Listado");
		mntmListadoCli.addActionListener(this);
		mnClientes.add(mntmListadoCli);
		
		mnProductos = new JMenu("Productos");
		mnMantenimiento.add(mnProductos);
		
		mntmIngresoProd = new JMenuItem("Ingreso");
		mntmIngresoProd.addActionListener(this);
		mnProductos.add(mntmIngresoProd);
		
		mntmModificacionProd = new JMenuItem("Modificación");
		mntmModificacionProd.addActionListener(this);
		mnProductos.add(mntmModificacionProd);
		
		mntmConsultaProd = new JMenuItem("Consulta");
		mntmConsultaProd.addActionListener(this);
		mnProductos.add(mntmConsultaProd);
		
		mntmEliminacionProd = new JMenuItem("Eliminación");
		mntmEliminacionProd.addActionListener(this);
		mnProductos.add(mntmEliminacionProd);
		
		mntmListadoProd = new JMenuItem("Listado");
		mntmListadoProd.addActionListener(this);
		mnProductos.add(mntmListadoProd);
		
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
		
		if (mntmIngresoCli==e.getSource()) {
			actionPerfomedMntmIngresoCli(e);
		}
		
		if (mntmModificacionCli==e.getSource()) {
			actionPerfomedMntmModificacionCli(e);
		}
		
		if (mntmConsultaCli==e.getSource()) {
			actionPerfomedMntmConsultaCli(e);
		}
		
		if (mntmEliminacionCli==e.getSource()) {
			actionPerfomedMntmEliminacionCli(e);
		}
		
		if (mntmListadoCli==e.getSource()) {
			actionPerfomedMntmListadoCli(e);
		}
		
		if (mntmIngresoProd==e.getSource()) {
			actionPerfomedMntmIngresoProd(e);
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
		
		public void actionPerfomedMntmIngresoProd(ActionEvent e) {
			IngresoProd ventana6 = new IngresoProd();
			ventana6.setVisible(true);
		}
}
