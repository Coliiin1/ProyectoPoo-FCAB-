package MAIN;
import java.util.Scanner;
public class Usuario {
    public String Usuario;
    private String Nombres, APaterno, AMaterno;
    private byte Dia, Mes;
    private short Anio;
    public String Contrasenia;
    
    public void Consultar(Items[] inventario, String nombre){
        for (int i = 0; i < 50; i++) {
            if(inventario[i]!=null && nombre.equals(inventario[i].NombreProd)){
                System.out.println("ENCONTRADO");
            }else{
                System.out.println("NO ENCONTRADO");
            }
        }
    }
    public Items Agregar(){
        Scanner sc=new Scanner(System.in);
        Items articulo=new Items();
        System.out.println("CUAL ES EL NOMBRE DEL PRODUCTO");
        articulo.NombreProd=sc.nextLine();
        return articulo;
    }
}
