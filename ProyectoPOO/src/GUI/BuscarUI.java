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
public class BuscarUI extends JFrame{
    public JButton btnBuscar;
    public JTextField txtnombre;
    public JTextField txtcodigo;
    public JLabel txtdescripcion;
    
    private JLabel nombre;
    private JLabel codigo;
    public BuscarUI(){
    setSize(500,500);
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Buscar");
    }
    public void contenedor(){
        nombre=new JLabel("NOMBRE:");
        nombre.setBounds(100, 30, 100, 20);
        add(nombre);
        codigo=new JLabel("CODIGO:");
        codigo.setBounds(100, 70, 100, 20);
        add(codigo);
        
        txtnombre=new JTextField("");
        txtnombre.setBounds(250, 30, 100, 20);
        add(txtnombre);
        txtcodigo=new JTextField("");
        txtcodigo.setBounds(250, 70, 100, 20);
        add(txtcodigo);
        
       btnBuscar=new JButton("BUSCAR");
       btnBuscar.setBounds(200, 400, 100, 20);
       add(btnBuscar);
       
       txtdescripcion=new JLabel("");
       txtdescripcion.setBounds(10,100,480,200);
       add(txtdescripcion);
    }
    public static void main(String args[]){
        BuscarUI ui=new BuscarUI();
        ui.contenedor();
        ui.setVisible(true);
    }
}
