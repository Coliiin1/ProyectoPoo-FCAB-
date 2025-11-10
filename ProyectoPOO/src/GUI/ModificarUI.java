/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.io.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author fabri
 */
public class ModificarUI extends AgregarUI{
    public File f;
    public String rutamodi;
    public JButton btnbuscar;
    public JButton btnmodificar;
    
    private JLabel codigo;
    public JTextField txtcodigo;
    public JTextArea txtdescripcion;
    
    private JLabel lnombre;
    private JLabel ltalla;
    private JLabel lsexo;
    private JLabel lprecio;
    private JLabel lmarca;
    private JLabel lproveedor;
    private JLabel lcodigo;
    private JLabel lcaracteristicas;
    private JLabel lcantidad;
    Color rojo= new Color(102, 136, 255); 
    Color LionB = new Color(245, 243, 243); // Updated white color

    public ModificarUI(){
        btnmodificar=new JButton();
        setTitle("Modificar producto");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(460, 700); 
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(LionB);
    }
    
    public void contenedormodi(){
        
        codigo= new JLabel("CODIGO:");
        codigo.setBounds(20, 20, 80, 20);
        add(codigo);
        
        txtcodigo=new JTextField("");
        txtcodigo.setBounds(100, 20, 100, 20);
        add(txtcodigo);
        
        btnbuscar=new JButton("Buscar");
        btnbuscar.setBounds(210, 20, 100, 20);
        add(btnbuscar);
        
        txtdescripcion=new JTextArea();
        txtdescripcion.setBounds(210, 50, 260, 200);
        txtdescripcion.setBackground(LionB);
        txtdescripcion.setFont(new Font("Arial", Font.BOLD, 16));
        add(txtdescripcion);
    }
    public void modifi(){
        int x=20;
        lnombre=new JLabel("NOMBRE");
        lnombre.setBounds(x, 50, 80, 20);
        txtNombre=new JTextField();
        txtNombre.setBounds(x+100, 50, 80, 20);
        add(lnombre);
        add(txtNombre);
        int y=80;
        ltalla=new JLabel("TALLA");
        ltalla.setBounds(x, y, 80, 20);
        comboTalla=new JComboBox();
        comboTalla.setBounds(x+100, y, 80, 20);
//        switch (categoria){
//            case "Zapateria":
//                add(ltalla);
//                for (String talla: tallas2) {
//                    comboTalla.addItem(talla);
//                }
//                add(comboTalla);
//                y+=30;
//                break;
//            case "Ropa":
//                add(ltalla);
//                for (String talla: tallas1) {
//                    comboTalla.addItem(talla);
//                }
//                add(comboTalla);
//                y+=30;
//            default:
//        }
        add(ltalla);
        add(comboTalla);
        y+=30;
        lsexo=new JLabel("SEXO");
        lsexo.setBounds(x, y, 80, 20);
        
        comboSexo = new JComboBox<>();
        String[] sexos = {"Seleccione", "Masculino", "Femenino", "Unisex"};
        for (String sexo : sexos) {
            comboSexo.addItem(sexo);
        }
        comboSexo.setBounds(x+100, y, 80, 20);
        y+=30;
        add(lsexo);
        add(comboSexo);
        
        lprecio=new JLabel("PRECIO");
        lprecio.setBounds(x, y, 80, 20);
        campoPrecio=new JTextField("");
        campoPrecio.setBounds(x+100, y, 80, 20);
        y+=30;
        add(lprecio);
        add(campoPrecio);
        
        lmarca=new JLabel("MARCA");
        lmarca.setBounds(x, y, 80, 20);
        campoMarca=new JTextField();
        campoMarca.setBounds(x+100, y, 80, 20);
        y+=30;
        add(lmarca);
        add(campoMarca);
        
        lproveedor=new JLabel("PROVEEDOR");
        lproveedor.setBounds(x, y, 80, 20);
        campoProveedor=new JTextField();
        campoProveedor.setBounds(x+100, y, 80, 20);
        y+=30;
        add(lproveedor);
        add(campoProveedor);
        
        lcodigo=new JLabel("CODIGO");
        lcodigo.setBounds(x, y, 80, 20);
        campoCodigo=new JTextField();
        campoCodigo.setBounds(x+100, y, 80, 20);
        y+=30;
        add(lcodigo);
        add(campoCodigo);
        
        lcaracteristicas=new JLabel("CARACTERISTICAS");
        lcaracteristicas.setBounds(x, y, 80, 20);
        campoCaracteristicas=new JTextField();
        campoCaracteristicas.setBounds(x+100, y, 80, 20);
        y+=30;
        add(lcaracteristicas);
        add(campoCaracteristicas);
        
        lcantidad=new JLabel("CANTIDAD");
        lcantidad.setBounds(x, y, 80, 20);
        campoCantidad=new JTextField();
        campoCantidad.setBounds(x+100, y, 80, 20);
        y+=30;
        add(lcantidad);
        add(campoCantidad);
        
        
        //colin si llegaste aqui mo cambies esto es que no nos va a dar tiempo hacer esta madre de cambiar la imagen jajaja mañana lo hacemos 
        
//        etiquetaVistaPrevia = new JLabel();
//        etiquetaVistaPrevia.setBounds(x, y + 36, 150, 150);
//        etiquetaVistaPrevia.setForeground(AzulB);
//        etiquetaVistaPrevia.setFont(new Font("Arial", Font.BOLD, 16));
//        etiquetaVistaPrevia.setBorder(BorderFactory.createLineBorder(Color.GRAY));
//        add(etiquetaVistaPrevia);
//        
//        btnSeleccionarArchivo = new JButton("Seleccionar archivo...");
//        btnSeleccionarArchivo.setBounds(x, y, 100, 20);
//        add(btnSeleccionarArchivo);
//        btnSeleccionarArchivo.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                selector = new JFileChooser();
//                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (jpg, jpeg, png, gif, bmp)", "jpg", "jpeg", "png", "gif", "bmp");
//                selector.setFileFilter(filtro);
//                int resultado = selector.showOpenDialog(ModificarUI.this);
//                if (resultado == JFileChooser.APPROVE_OPTION) {
//                    f = selector.getSelectedFile();
//                    String name = f.getName().toLowerCase();
//                    if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".bmp")) {
//                        rutaImagenSeleccionada = f.getAbsolutePath(); //Guarda la ruta seleccionada
//                        ImageIcon ico = new ImageIcon(f.getAbsolutePath());
//                        Image img = ico.getImage().getScaledInstance(etiquetaVistaPrevia.getWidth(), etiquetaVistaPrevia.getHeight(), Image.SCALE_SMOOTH);
//                        etiquetaVistaPrevia.setIcon(new ImageIcon(img));
//                    } else {
//                        JOptionPane.showMessageDialog(ModificarUI.this, "Formato no válido. Elija jpg, png, gif o bmp.", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
//            }
//        });
//        y+=180;
        btnmodificar.setText("MODIFICAR");
        btnmodificar.setBounds(x+50, y+30, 200, 20);
        add(btnmodificar);
    }
    public void limpiarCampos(){
        campoCantidad.setText("");
        campoCaracteristicas.setText("");
        campoCodigo.setText("");
        campoProveedor.setText("");
        campoMarca.setText("");
        campoPrecio.setText("");
        comboSexo.setSelectedIndex(0);
        comboTalla.setSelectedIndex(0);
        txtNombre.setText("");
        txtcodigo.setText("");
    }
    public static void main(String args[]){
        ModificarUI ui=new ModificarUI();
        ui.contenedormodi();
        ui.modifi();
        ui.setVisible(true);
    }
}
