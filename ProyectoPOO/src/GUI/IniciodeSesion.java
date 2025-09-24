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
public class IniciodeSesion extends JFrame{
    JLabel field1;
    public IniciodeSesion(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
    }
    public void contenedor(){
        field1=new JLabel("Usuario");
        field1.setBounds(20, 20, 50, 20);
        add(field1);
    }
    public static void main(String args[]){
        IniciodeSesion uno=new IniciodeSesion();
        uno.contenedor();
        uno.setVisible(true);
    }
}
