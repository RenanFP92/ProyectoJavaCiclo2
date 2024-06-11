package PRODUCTO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConsultaProd extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodigo;
    private JLabel lblCodigo;
    private JButton btnBuscar;
    private JScrollPane scrollPane;
    private JTextArea txtResultado;

    // Crea la ventana
    public ConsultaProd() {
        setTitle("Consulta de Producto");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 15, 46, 14);
        contentPane.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setText("Ingrese el Código");
        txtCodigo.setColumns(10);
        txtCodigo.setBounds(66, 12, 194, 20);
        contentPane.add(txtCodigo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(335, 11, 89, 23);
        btnBuscar.addActionListener(this);
        contentPane.add(btnBuscar);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 414, 210);
        contentPane.add(scrollPane);

        txtResultado = new JTextArea();
        scrollPane.setViewportView(txtResultado);
    }

    // Redireccionando el botón buscar
    public void actionPerformed(ActionEvent e) {
        if (btnBuscar == e.getSource()) {
            Buscar(e);
        }
    }

    // Proceso del botón buscar
    public void Buscar(ActionEvent e) {
        String codigoBuscado = txtCodigo.getText().trim();
        if (!codigoBuscado.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader("productos.txt"))) {
                ArrayList<String> lineas = new ArrayList<>();
                String linea;
                while ((linea = br.readLine()) != null) {
                    lineas.add(linea);
                }

                String[] lineasArray = lineas.toArray(new String[0]);
                for (int i = 0; i < lineasArray.length; i++) {
                    if (lineasArray[i].contains("Código: " + codigoBuscado)) {
                        StringBuilder productoEncontrado = new StringBuilder();
                        for (int j = 0; j < 6; j++) {
                            if (i + j < lineasArray.length) {
                                productoEncontrado.append(lineasArray[i + j]).append("\n");
                            }
                        }
                        txtResultado.setText(productoEncontrado.toString());
                        return; // Terminamos la búsqueda
                    }
                }
                txtResultado.setText("No se encontraron productos con el código: " + codigoBuscado);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            txtResultado.setText("Por favor ingrese un código.");
        }
    }
}
