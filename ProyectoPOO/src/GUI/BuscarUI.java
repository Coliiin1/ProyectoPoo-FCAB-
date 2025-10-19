package GUI;

import java.awt.*;
import javax.swing.*;

public class BuscarUI extends JFrame {

    public JButton btnBuscar;
    public JTextField txtnombre;
    public JTextField txtcodigo;
    public JTextArea txtdescripcion;
    public JLabel labelImagen;

    private JLabel nombre;
    private JLabel codigo;
    Color AzulB = new Color(1, 61, 90);
    Color LionB = new Color(252, 243, 227);

    public BuscarUI() {
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Buscar");
        getContentPane().setBackground(LionB);
    }

    public void contenedor() {
        int c = 30;
        nombre = new JLabel("NOMBRE:");
        codigo = new JLabel("CODIGO:");
        JLabel[] Txtos = {nombre, codigo};
        for (JLabel texto : Txtos) {
            texto.setBounds(100, c, 100, 20);
            add(texto);
            c += 40;
            texto.setForeground(AzulB);
            texto.setFont(new Font("Arial", Font.BOLD, 16));
        }

        txtnombre = new JTextField("");
        txtnombre.setBounds(250, 30, 100, 20);
        add(txtnombre);
        txtcodigo = new JTextField("");
        txtcodigo.setBounds(250, 70, 100, 20);
        add(txtcodigo);

        btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBounds(200, 600, 100, 20);
        btnBuscar.setBackground(AzulB);
        btnBuscar.setForeground(LionB);
        add(btnBuscar);

        //Para mostrar la Imagen
        labelImagen = new JLabel();
        labelImagen.setBounds(150, 100, 200, 200); // posición y tamaño donde se mostrará la imagen
        labelImagen.setBackground(Color.GRAY); // opcional, color de fondo si no hay imagen
        labelImagen.setOpaque(true); // para que se vea el fondo
        add(labelImagen);

        txtdescripcion = new JTextArea();
        txtdescripcion.setBounds(150, 310, 200, 200);
        txtdescripcion.setForeground(AzulB);
        txtdescripcion.setFont(new Font("Arial", Font.BOLD, 16));
        txtdescripcion.setBackground(LionB);
        txtdescripcion.setEditable(false);
        add(txtdescripcion);
    }

    public static void main(String args[]) {
        BuscarUI ui = new BuscarUI();
        ui.contenedor();
        ui.setVisible(true);
    }
}
