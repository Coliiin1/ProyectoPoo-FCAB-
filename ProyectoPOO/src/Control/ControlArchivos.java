/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author fabri
 */
public class ControlArchivos {
    public static void crearArchivo(String dir){
        PrintWriter bsalida=null;
        try {
            File arch=new File(dir);
            bsalida = new PrintWriter(arch);
            JOptionPane.showMessageDialog(null, "SE CREO EL ARCHIVO");
            bsalida.close();
        } catch (FileNotFoundException ex) {
            System.getLogger(ControlArchivos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    public static void main(String args[]){
        crearArchivo("src\\Archivos\\DATOS.txt");
    }
}
