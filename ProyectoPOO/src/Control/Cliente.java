/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import GUI.BuscarUI;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author fabri
 */
public class Cliente extends Usuario implements ActionListener{
    BuscarUI ui;
    Items[][] matriz;
    public Cliente(String nombre,String contrasenia){
        super(nombre,contrasenia);
        
    }
    public void iniciar(BuscarUI uis,Items[][] matrizs){
        ui=uis;
        matriz=matrizs;
    }
    private void AdaptarImagen(JLabel label, String ruta) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(newImg));
    }
    public Items Agregar(){
        JOptionPane.showMessageDialog(null, "NO PUEDES AGREGAR", "ERROR", 2);
        return null;
    }
    public void Eliminar(Items []inventario){
        JOptionPane.showMessageDialog(null, "NO PUEDES ELIMINAR", "ERROR", 2);
    }
    public void Modificar(Items []inventario){
        JOptionPane.showMessageDialog(null, "NO PUEDES MODIFICAR", "ERROR", 2);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Items itemtemp=new Items();
        Items temp=new Items();
        if (e.getSource()==ui.btnBuscar) {
            if (!ui.txtcodigo.getText().equals("")&&ui.txtnombre.getText().equals("")) {
                for (int i = 0; i < matriz.length; i++) {
                   itemtemp=Consultar(matriz[i],Integer.parseInt(ui.txtcodigo.getText()));
                   if (itemtemp!=null) {
                        ui.txtdescripcion.setText(itemtemp.MostrarInfo());
                        AdaptarImagen(ui.labelImagen, itemtemp.DirImagen);
                        break;
                    }
                }
                if (itemtemp==null) {
                    JOptionPane.showMessageDialog(ui, "NO SE ENCONTRO UN ITEM CON EL CODIGO "+ui.txtcodigo.getText(), "ERROR", 2);
                }
            }
            if (ui.txtcodigo.getText().equals("")&&!ui.txtnombre.getText().equals("")) {
                for (int i = 0; i < matriz.length; i++) {
                   itemtemp=Consultar(matriz[i],ui.txtnombre.getText());
                   if (itemtemp!=null) {
                        ui.txtdescripcion.setText(itemtemp.MostrarInfo());
                        AdaptarImagen(ui.labelImagen, itemtemp.DirImagen);
                        break;
                    }
                }
                if (itemtemp==null) {
                    JOptionPane.showMessageDialog(ui, "NO SE ENCONTRO UN ITEM CON EL NOMBRE "+ui.txtnombre.getText(), "ERROR", 2);
                }
            }
            if (!ui.txtcodigo.getText().equals("")&&!ui.txtnombre.getText().equals("")) {
                for (int i = 0; i < matriz.length; i++) {
                   itemtemp=Consultar(matriz[i],Integer.parseInt(ui.txtcodigo.getText()));
                   temp=Consultar(matriz[i],ui.txtnombre.getText());
                   if (itemtemp!=null&&itemtemp==temp) {
                        ui.txtdescripcion.setText(itemtemp.MostrarInfo());
                        AdaptarImagen(ui.labelImagen, itemtemp.DirImagen);
                        System.out.println("si paso");
                        break;
                    }
                    if (itemtemp!=temp) {
                        JOptionPane.showMessageDialog(ui, "NO SE ENCONTRO UN ITEM CON CODIGO "+ui.txtcodigo.getText()+" Y EL NOMBRE "+ui.txtnombre.getText(), "ERROR", 2);
                    }
                }
            }
        }
    }


}
