/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author fabri
 */
public class ModificarUI extends AgregarUI{
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
    Color rojo=new Color(225,50,50);
    Color LionB = new Color(252, 243, 227);

    public ModificarUI(){
        setTitle("Modificar producto");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(460, 400); 
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
    public void modifi(String categoria){
        String[] tallas1 = {"Seleccione talla", "XS", "S", "M", "L", "XL"};
        String[] tallas2 = {"Seleccione talla", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27"};
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
        switch (categoria){
            case "Zapateria":
                add(ltalla);
                for (String talla: tallas2) {
                    comboTalla.addItem(talla);
                }
                add(comboTalla);
                y+=30;
                break;
            case "Ropa":
                add(ltalla);
                for (String talla: tallas1) {
                    comboTalla.addItem(talla);
                }
                add(comboTalla);
                y+=30;
            default:
        }
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
        add(lcantidad);
        add(campoCantidad);
        
        btnmodificar=new JButton("MODIFICAR");
        btnmodificar.setBounds(x+50, y+30, 200, 20);
        add(btnmodificar);
    }
    public static void main(String args[]){
        ModificarUI ui=new ModificarUI();
        ui.contenedormodi();
        ui.modifi("Zapateria");
        ui.setVisible(true);
    }
}
