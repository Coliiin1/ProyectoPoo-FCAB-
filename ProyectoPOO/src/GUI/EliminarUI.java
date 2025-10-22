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
    
    private JLabel labelcodigo;
    public JTextArea txtdescripcion;
    
    Color rojo=new Color(205,50,50);
    public EliminarUI(){
        setTitle("Eliminar Producto");
        setLayout(null);
        setSize(520, 800); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(rojo);
    }
    public void contenedor(){
        labelcodigo=new JLabel("CODIGO:");
        labelcodigo.setBounds(20, 20, 100, 20);
        add(labelcodigo);
        
        txtcodigo=new JTextField("");
        txtcodigo.setBounds(140, 20, 100, 20);
        add(txtcodigo);
        
        txtdescripcion = new JTextArea();
        txtdescripcion.setBounds(150, 310, 200, 200);
        txtdescripcion.setFont(new Font("Arial", Font.BOLD, 16));
        txtdescripcion.setEditable(false);
        add(txtdescripcion);
        
        btnbuscar=new JButton("Buscar");
        btnbuscar.setBounds(260, 20, 100, 20);
        add(btnbuscar);
        
        
        btneliminar=new JButton("Eliminar");
        btneliminar.setBounds(110, 700, 300, 20);
        
    }
    public static void main(String args[]){
        EliminarUI ui=new EliminarUI();
        ui.contenedor();
        ui.setVisible(true);
    }
}
