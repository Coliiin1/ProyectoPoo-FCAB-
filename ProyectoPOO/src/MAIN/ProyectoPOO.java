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
        }else{
            user=new Cliente(null,null);//es un cliente default
        }
        Items[] almacen=new Items[50];
        Items item=new Items();
        
        while(opc!=4){
            opc=inicio.menu();
            switch(opc){
                case 1:
                    almacen[cont]=user.Agregar();
                    cont++;
                    break;
                case 2:
                    item=user.Consultar(almacen);
                    item=null;
                    break;
                case 3:    
                    user.Eliminar(almacen);
            }
        }
    }
    
}
