package experimentoCiclo2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
	private JMenuItem mntmConsultacCli;
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
		setIconImage(new ImageIcon(getClass().getResource("/experimentoCiclo2/flor.png")).getImage());
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
		mnOpciones.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setForeground(Color.WHITE);
		menuBar.add(mnMantenimiento);
		
		mnClientes = new JMenu("Clientes");
		mnMantenimiento.add(mnClientes);
		
		mntmIngresoCli = new JMenuItem("Ingreso");
		mnClientes.add(mntmIngresoCli);
		
		mntmModificacionCli = new JMenuItem("Modificación");
		mnClientes.add(mntmModificacionCli);
		
		mntmConsultacCli = new JMenuItem("Consulta");
		mnClientes.add(mntmConsultacCli);
		
		mntmEliminacionCli = new JMenuItem("Eliminación");
		mnClientes.add(mntmEliminacionCli);
		
		mntmListadoCli = new JMenuItem("Listado");
		mnClientes.add(mntmListadoCli);
		
		mnProductos = new JMenu("Productos");
		mnMantenimiento.add(mnProductos);
		
		mntmIngresoProd = new JMenuItem("Ingreso");
		mnProductos.add(mntmIngresoProd);
		
		mntmModificacionProd = new JMenuItem("Modificación");
		mnProductos.add(mntmModificacionProd);
		
		mntmConsultaProd = new JMenuItem("Consulta");
		mnProductos.add(mntmConsultaProd);
		
		mntmEliminacionProd = new JMenuItem("Eliminación");
		mnProductos.add(mntmEliminacionProd);
		
		mntmListadoProd = new JMenuItem("Listado");
		mnProductos.add(mntmListadoProd);
		
		mnAlmacen = new JMenu("Almacén");
		mnAlmacen.setForeground(Color.WHITE);
		menuBar.add(mnAlmacen);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setForeground(Color.WHITE);
		menuBar.add(mnReportes);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setForeground(Color.WHITE);
		menuBar.add(mnVentas);
		getContentPane().setLayout(null);
	}
	
	//Direccionando los botones del menu
	public void actionPerformed(ActionEvent e) {
		
	}
}
