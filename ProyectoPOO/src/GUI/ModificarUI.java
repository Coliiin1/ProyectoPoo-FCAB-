/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
/**
 *
 * @author fabri
 */
public class ModificarUI extends JFrame{
    public JButton btnmodificar;
    
    
    Color rojo=new Color(225,50,50);
    Color LionB = new Color(252, 243, 227);
    public ModificarUI(){
        setTitle("Modificar producto");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 800); 
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(rojo);
    }
    public void contenedor(){
        
    }
}
