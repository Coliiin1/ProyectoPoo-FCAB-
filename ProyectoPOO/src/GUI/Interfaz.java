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
    public void iniciarSesion(String usuario,String contrasenia){
        Scanner sc=new Scanner(System.in);
        String variable="";
        while(!usuario.equals(variable)){
            System.out.println("INGERSE EL USUARIO");
            variable=sc.nextLine();
            if(!usuario.equals("ADMIN")){
                System.out.println("USUARIO INCORRECTO");
            }
        }
        variable="";
        while(!contrasenia.equals(variable)){
            System.out.println("INGRESA LA CONTRASEÑA");
            variable=sc.nextLine();
        }
    }
}
