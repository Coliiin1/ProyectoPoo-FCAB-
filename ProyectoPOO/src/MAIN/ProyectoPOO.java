package MAIN;
import GUI.Interfaz;
import java.util.Scanner;


public class ProyectoPOO {

    public static void main(String[] args) {
        Usuario user;
        byte opc=0;
        byte cont=0;
        Scanner in=new Scanner(System.in);
        Interfaz inicio=new Interfaz();
        
        System.out.println("DESEA INICIAR SESION? (1/0)");
        opc=in.nextByte();
        if(opc==1){
            user=new Administrador("ADMIN","12345");
            inicio.iniciarSesion(user.Usuario,user.Contrasenia);
            inicio.mensaje();
        }else{
            user=new Cliente(null,null);//es un cliente default
        }
        Items[] almacen=new Items[50];
        while(opc!=3){
            opc=inicio.menu();
            switch(opc){
                case 1:
                    almacen[cont]=user.Agregar();
                    cont++;
                    break;
                case 2:
                    user.Consultar(almacen);
                    break;
            }
        }
    }
    
}
