/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.util.Scanner;
/**
 *
 * @author fabri
 */
public class Interfaz {
    public void iniciarSesion(){
        Scanner sc=new Scanner(System.in);
        String usuario="";
        String contrasena="";
        while(!usuario.equals("ADMIN")){
            System.out.println("INGERSE EL USUARIO");
            usuario=sc.nextLine();
            if(!usuario.equals("ADMIN")){
                System.out.println("USUARIO INCORRECTO");
            }
        }
        while(!contrasena.equals("12345")){
            System.out.println("INGRESA LA CONTRASEÑA");
            contrasena=sc.nextLine();
        }
    }
}
