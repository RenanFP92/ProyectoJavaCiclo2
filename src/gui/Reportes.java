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
import Arreglos.ArregloVentas;
import Clases.Producto;
import Clases.ProductoAcumulado;
import Clases.Ventas;
import java.util.HashMap;
import java.util.Map;

public class Reportes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnImporteTotal;
	private JButton btnUnidadesVendidas;
	private JButton btnListadoStockMinimo;
	private JButton btnListadoVentas;
	private JTextArea txtResultado;
	private JScrollPane scrollPane;
	ArregloProductos listaProductos = new ArregloProductos();
	ArregloVentas listaVentas = new ArregloVentas();

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
				ListadoGeneral(listaVentas);
			}
		});
		btnListadoVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListadoVentas.setBounds(89, 404, 331, 23);
		contentPane.add(btnListadoVentas);
		
		btnListadoStockMinimo = new JButton("PRODUCTOS DEBAJO DEL STOCK MÍNIMO");
		btnListadoStockMinimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeStockMinimo(listaProductos);
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
	
	public void ListadoDeStockMinimo(ArregloProductos listaProductos) {
		listaProductos.limpiar();
		listaProductos.Leer(); // Asegúrate de leer los datos
		boolean hayProductoFueraDeStockMinimo = false;
        StringBuilder obj = new StringBuilder();
        for (int i = 0; i < listaProductos.tamaño(); i++) {
            Producto producto = listaProductos.obtener(i);
            if (producto.getStockActual() < producto.getStockMinimo()) {
                obj.append("Código: " + producto.getCodigoProducto() + 
                           "\nNombre: " + producto.getNombre() +
                           "\nStock Actual: " + producto.getStockActual() + 
                           "\nStock Mínimo: " + producto.getStockMinimo() +
                           "\n-----------------------------------------------------------" + "\n");
                hayProductoFueraDeStockMinimo = true;
            }
        }
        
        if (!hayProductoFueraDeStockMinimo) {
            obj.append("NO HAY PRODUCTO FUERA DE SU STOCK MÍNIMO");
        }
        
        txtResultado.setText(obj.toString());
	}
	
	public void ListadoGeneral(ArregloVentas listaVentas) {
		listaVentas.limpiar();
		listaVentas.cargarVentas();
		StringBuilder obj = new StringBuilder();
        for (int i = 0; i < listaVentas.tamaño(); i++) {
        	Ventas venta = listaVentas.obtenerVenta(i);
        	obj.append("Código de la venta: " + venta.getCodigoVenta() +
        			"\nCódigo del cliente: " + venta.getCodigoCliente() +
        			"\nCódigo del producto: " + venta.getCodigoProducto() +
        			"\nFecha de la venta: " + venta.getFecha() +
        			"\nImporte subtotal: " + venta.getSubTotal() +
        			"\nImporte IGV: " + venta.getIgv() +
        			"\nImporte total: " + venta.getImporteTotal() +
                    "\n-----------------------------------------------------------" + "\n");
        }
        txtResultado.setText(obj.toString());
        
	}
	
	public void UnidadesVendidasPorProducto() {
		//Limpiar txtArea
		listaProductos.limpiar();
		listaVentas.limpiar();
		//llamo al metodo leer 
	    listaProductos.Leer(); 
	     //cargo mis ventas a la nueva ventana	    
	    listaVentas.cargarVentas(); 

	    int numProductos = listaProductos.tamaño();

	    // Arreglos para almacenar los datos
	    String[] codigosProducto = new String[numProductos];
	    String[] nombresProducto = new String[numProductos];
	    int[] unidadesVendidas = new int[numProductos];

	    // Inicializar arreglos con datos de productos
	    for (int i = 0; i < numProductos; i++) {
	        Producto producto = listaProductos.obtener(i);
	        codigosProducto[i] = String.valueOf(producto.getCodigoProducto());
	        nombresProducto[i] = producto.getNombre();
	        unidadesVendidas[i] = 0; // Inicialmente todas las ventas a cero
	    }

	    // calcula unidades vendidas por producto en txt
	    for (int i = 0; i < listaVentas.tamaño(); i++) {
	        Ventas venta = listaVentas.obtenerVenta(i);
	        String codigoProducto = venta.getCodigoProducto();
	        int cantidadVendida = venta.getCantidad();

	        // busca el producto en el arreglo de productos y sumar unidades vendidas
	        for (int j = 0; j < numProductos; j++) {
	            if (codigosProducto[j].equals(codigoProducto)) {
	                unidadesVendidas[j] += cantidadVendida;
	                break; 
	            }
	        }
	    }

	    // el mensaje con los resultados
	    StringBuilder mensaje = new StringBuilder();
	    mensaje.append("Unidades vendidas por producto:\n");

	    for (int i = 0; i < numProductos; i++) {
	        mensaje.append("Código: ").append(codigosProducto[i]).append("\n");
	        mensaje.append("Nombre: ").append(nombresProducto[i]).append("\n");
	        mensaje.append("Unidades Vendidas: ").append(unidadesVendidas[i]).append("\n");
	        mensaje.append("-----------------------------------------------------------\n");
	    }
	    
	    //boto los resutados 

	    txtResultado.setText(mensaje.toString());
	}
	
	public void ImporteTotalPorProducto() {
	    Map<String, ProductoAcumulado> acumulados = new HashMap<>();

	    for (int i = 0; i < listaVentas.tamaño(); i++) {
	        Ventas venta = listaVentas.obtenerVenta(i);
	        String codigoProducto = venta.getCodigoProducto();
	        String nombreProducto = venta.getNombreProducto();
	        double importeTotal = venta.getImporteTotal();

	        if (!acumulados.containsKey(codigoProducto)) {
	            acumulados.put(codigoProducto, new ProductoAcumulado(codigoProducto, nombreProducto, importeTotal));
	        } else {
	            ProductoAcumulado productoAcumulado = acumulados.get(codigoProducto);
	            productoAcumulado.acumularImporte(importeTotal);
	        }
	    }

	    // Mostramos los resultados
	    StringBuilder obj = new StringBuilder();
	    for (ProductoAcumulado producto : acumulados.values()) {
	        obj.append("Código del Producto: " + producto.getCodigoProducto() +
	                   "\nNombre del Producto: " + producto.getNombreProducto() +
	                   "\nImporte Total Acumulado: " + producto.getImporteTotalAcumulado() +
	                   "\n-----------------------------------------------------------" + "\n");
	    }
	    txtResultado.setText(obj.toString());
	}

	
}
