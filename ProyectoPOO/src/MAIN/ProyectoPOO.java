package MAIN;
import GUI.Interfaz;
import java.util.Scanner;


public class ProyectoPOO {

    public static void main(String[] args) {
        byte opc=0;
        byte cont=0;
        Scanner in=new Scanner(System.in);
        Interfaz inicio=new Interfaz();
        inicio.iniciarSesion();
        Usuario user=new Administrador();
        Items[] almacen=new Items[50];
        while(opc!=3){
            for (int i = 0; i < 10; i++) {
                System.out.println("");//para limpiar la pantalla xd
            }
            opc=menu();
            switch(opc){
                case 1:
                    almacen[cont]=user.Agregar();
                    cont++;
                    break;
                case 2:
                    System.out.println("QUE NOMBRE VAS A BUSCAR");
                    String nombre=in.nextLine();
                    user.Consultar(almacen, nombre);
                    break;
            }
        }
    }
    public static byte menu(){
        byte opc=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("QUE DESEA HACER");
        System.out.println("1: AGREGAR PRODUCTO");
        System.out.println("2: CONSULTAR PRODUCTO");
        System.out.println("3: SALIR");
        opc=sc.nextByte();
        return opc;
    }
}
