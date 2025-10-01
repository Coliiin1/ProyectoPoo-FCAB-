package GUI;
import javax.swing.*;
import java.util.Scanner;

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
    public static byte menu(){
        byte opc=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("QUE DESEA HACER");
        System.out.println("1: AGREGAR PRODUCTO");
        System.out.println("2: CONSULTAR PRODUCTO");
        System.out.println("3: ELIMINAR");
        System.out.println("4: SALIR");
        opc=sc.nextByte();
        return opc;
    }
}
