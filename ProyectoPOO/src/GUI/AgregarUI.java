/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import javax.swing.*;
/**
 *
 * @author fabri
 */
public class AgregarUI extends JFrame{
    public JButton btnEnviar;
    public JTextField txtNombre;
    private JLabel lblnombre;
    //esto no lo toques paput :v
    
    public AgregarUI(){
        setTitle("AGREGAR");
        setSize(500,500);
        setLayout(null);
        setResizable(false);
    }
    public void contenedor(){
        btnEnviar=new JButton("enviar");
        btnEnviar.setBounds(WIDTH, WIDTH, 50, 50);
        add(btnEnviar);
        txtNombre=new JTextField("");
        txtNombre.setBounds(250, WIDTH, 200, 20);
        add(txtNombre);
        lblnombre=new JLabel("INGRESA NOMBRE");
        lblnombre.setBounds(WIDTH, 400, 200, 20);
        add(lblnombre);
    }
}
