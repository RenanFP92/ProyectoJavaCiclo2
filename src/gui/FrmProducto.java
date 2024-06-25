package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloProductos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.EventQueue;

import Clases.*;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private int ultimoCodigo = 2001;

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

    public FrmProducto() {
        setTitle("Mantenimiento de Productos");
        setBounds(100, 100, 1135, 376);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        {
            lblNewLabel = new JLabel("MANTENIMIENTO DE PRODUCTOS");
            lblNewLabel.setToolTipText("");
            lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblNewLabel.setBounds(25, 11, 437, 14);
            contentPane.add(lblNewLabel);
        }
        {
            lblNewLabel_1 = new JLabel("CÓDIGO :");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblNewLabel_1.setBounds(25, 55, 102, 14);
            contentPane.add(lblNewLabel_1);
        }
        {
            lblNewLabel_2 = new JLabel("NOMBRE");
            lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblNewLabel_2.setBounds(25, 111, 102, 14);
            contentPane.add(lblNewLabel_2);
        }
        {
            lblNewLabel_3 = new JLabel("PRECIO");
            lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblNewLabel_3.setBounds(25, 149, 102, 14);
            contentPane.add(lblNewLabel_3);
        }
        {
            lblStockActual = new JLabel("STOCK ACTUAL");
            lblStockActual.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblStockActual.setBounds(25, 190, 117, 14);
            contentPane.add(lblStockActual);
        }
        {
            txtCodigo = new JTextField();
            txtCodigo.setEditable(false);
            txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
            txtCodigo.setBounds(143, 52, 86, 20);
            contentPane.add(txtCodigo);
            txtCodigo.setColumns(10);
        }
        {
            txtNombre = new JTextField();
            txtNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
            txtNombre.setBounds(143, 108, 86, 20);
            contentPane.add(txtNombre);
            txtNombre.setColumns(10);
        }
        {
            txtPrecio = new JTextField();
            txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
            txtPrecio.setBounds(143, 146, 86, 20);
            contentPane.add(txtPrecio);
            txtPrecio.setColumns(10);
        }
        {
            txtStockActual = new JTextField();
            txtStockActual.setFont(new Font("Tahoma", Font.BOLD, 14));
            txtStockActual.setBounds(143, 187, 86, 20);
            contentPane.add(txtStockActual);
            txtStockActual.setColumns(10);
        }
        {
            btnBuscar = new JButton("Buscar");
            btnBuscar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirBusquedaProducto();
                }
            });
            btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
            btnBuscar.setBounds(990, 266, 119, 23);
            contentPane.add(btnBuscar);
        }
        {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(239, 37, 741, 289);
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
            btnAgregar.setBounds(992, 37, 117, 23);
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
            btnGrabar.setBounds(992, 84, 117, 23);
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
            btnLeer.setBounds(992, 131, 117, 23);
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
            btnModificar.setBounds(992, 178, 117, 23);
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
            btnEliminar.setBounds(992, 225, 117, 23);
            contentPane.add(btnEliminar);
        }
        {
            separator = new JSeparator();
            separator.setBackground(Color.DARK_GRAY);
            separator.setBounds(25, 80, 204, 10);
            contentPane.add(separator);
        }

        lblStockMáximo = new JLabel("STOCK MÁXIMO");
        lblStockMáximo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStockMáximo.setBounds(25, 229, 117, 14);
        contentPane.add(lblStockMáximo);

        txtStockMaximo = new JTextField();
        txtStockMaximo.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtStockMaximo.setColumns(10);
        txtStockMaximo.setBounds(143, 226, 86, 20);
        contentPane.add(txtStockMaximo);

        lblStockMínimo = new JLabel("STOCK MÍNIMO");
        lblStockMínimo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStockMínimo.setBounds(25, 272, 117, 14);
        contentPane.add(lblStockMínimo);

        txtStockMinimo = new JTextField();
        txtStockMinimo.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtStockMinimo.setColumns(10);
        txtStockMinimo.setBounds(143, 269, 86, 20);
        contentPane.add(txtStockMinimo);
        cargarJTable();
        actualizarUltimoCodigo();
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
        actualizarUltimoCodigo();
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
        actualizarUltimoCodigo();
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
        actualizarUltimoCodigo();
    }

    // método para actualizar el último código
    public void actualizarUltimoCodigo() {
        if (lista.tamaño() > 0) {
			ultimoCodigo = lista.obtener(lista.tamaño() - 1).getCodigoProducto() + 1;
		}
		txtCodigo.setText(ultimoCodigo + "");
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
        actualizarUltimoCodigo();
        // Deshabilitar los botones modificar y eliminar
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    // Boton Eliminar
    protected void btnEliminarActionPerformed(ActionEvent e) {
        lista.Suprimir(fila);
        cargarJTable();
        actualizarUltimoCodigo();
        // Deshabilitar los botones modificar y eliminar
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    // Boton Buscar
    protected void abrirBusquedaProducto() {
        buscarProducto busquedaProducto = new buscarProducto(lista);
        busquedaProducto.setVisible(true);
    }
}
