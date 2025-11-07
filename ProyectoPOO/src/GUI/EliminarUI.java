/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class EliminarUI extends JFrame{
    public JButton btneliminar;
    public JButton btnbuscar;
    public JTextField txtcodigo;
    public JComboBox box;
    
    private JLabel labelcodigo;
    private JLabel labelbcodigo;
    public JTextArea txtdescripcion;
    
    Color rojo=new Color(114,47,55);
    Color RWhite = new Color(239, 223, 187);
    public EliminarUI(){
        setTitle("Eliminar Producto");
        setLayout(null);
        setSize(520, 800); 
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(RWhite);
    }
    public void contenedor(){
        labelcodigo=new JLabel("INGRESAR CODIGO:");
        labelcodigo.setForeground(rojo);
        labelcodigo.setBounds(20, 20, 150, 20);
        add(labelcodigo);
        
        txtcodigo=new JTextField("");
        txtcodigo.setBounds(160, 20, 100, 20);
        add(txtcodigo);
        
        txtdescripcion = new JTextArea();
        txtdescripcion.setBounds(150, 310, 200, 200);
        txtdescripcion.setBackground(RWhite);
        txtdescripcion.setForeground(rojo);
        txtdescripcion.setFont(new Font("Arial", Font.BOLD, 16));
        txtdescripcion.setEditable(false);
        add(txtdescripcion);
        
        btnbuscar=new JButton("Buscar");
        btnbuscar.setBounds(300, 20, 100, 20);
        btnbuscar.setBackground(rojo);
        btnbuscar.setForeground(RWhite);
        add(btnbuscar);
        
        
        labelbcodigo=new JLabel("CATALOGO DE CODIGOS");
        labelbcodigo.setForeground(rojo);
        labelbcodigo.setBounds(20, 100, 150, 20);
        add(labelbcodigo);
        
        box=new JComboBox();
        box.setBounds(160, 100, 100, 20);
        add(box); 
        
        btneliminar=new JButton("Eliminar");
        btneliminar.setBackground(rojo);
        btneliminar.setForeground(RWhite);
        btneliminar.setBounds(110, 700, 300, 20);
        
    }
    public static void main(String args[]){
        EliminarUI ui=new EliminarUI();
        ui.contenedor();
        ui.setVisible(true);
    }
}
