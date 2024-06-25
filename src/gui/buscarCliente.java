package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Clases.Cliente;
import Arreglos.ArregloCliente;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class buscarCliente extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField txtCodigo;
    private JTextArea txtArea;
    private ArregloCliente arregloCliente;
	private JButton btnBuscar;
	private JLabel lblCodigo;

    public buscarCliente(ArregloCliente arregloCliente) {
        this.arregloCliente = arregloCliente;
        setTitle("Buscar Cliente");
        setSize(457, 286);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        lblCodigo = new JLabel("CÓDIGO DE CLIENTE :");
        lblCodigo.setBounds(20, 20, 150, 25);
        getContentPane().add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(147, 20, 150, 25);
        getContentPane().add(txtCodigo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(330, 20, 100, 25);
        getContentPane().add(btnBuscar);

        txtArea = new JTextArea();
        txtArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        txtArea.setBorder(new LineBorder(new Color(0, 0, 0)));
        txtArea.setBounds(10, 60, 420, 180);
        txtArea.setEditable(false);
        getContentPane().add(txtArea);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
    }

    private void buscar() {
        int codigo = Integer.parseInt(txtCodigo.getText());
        int index = arregloCliente.buscar(codigo);
        if (index != -1) {
            Cliente cliente = arregloCliente.obtener(index);
            txtArea.setText("Código: " + cliente.getCodigoCliente() + "\n" +
                            "Nombres: " + cliente.getNombres() + "\n" +
                            "Apellidos: " + cliente.getApellidos() + "\n" +
                            "Dirección: " + cliente.getDireccion() + "\n" +
                            "Teléfono: " + cliente.getTelefono() + "\n" +
                            "DNI: " + cliente.getDni());
        } else {
        	JOptionPane.showMessageDialog(null, "NO EXISTE EL CODIGO");
        }
    }
}
