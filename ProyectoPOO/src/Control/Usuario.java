package Control;
import java.util.Scanner;
public abstract class Usuario {
    public String Usuario;
    public String Nombres, APaterno, AMaterno;
    public byte Dia, Mes;
    public short Anio;
    public String Contrasenia;
    
    public Usuario(String usuario,String contrasenia){
        this.Contrasenia=contrasenia;
        this.Usuario=usuario;
    }
    static public Items Consultar(Items[] inventario){
        Items item=new Items();
        Scanner sc=new Scanner(System.in);
        byte encontrado=0;
        if(inventario[0]!=null){
            System.out.println("QUE NOMBRE VAS A BUSCAR");
            String nombre=sc.nextLine();
                for (int i = 0; i < 50; i++) {
                if(inventario[i]!=null && nombre.equals(inventario[i].NombreProd)){
                    System.out.println("ENCONTRADO");
                    inventario[i].MostrarInfo();
                    encontrado++;
                    item=inventario[i];
                    break;
                }
            }
            if(encontrado==0){
                System.out.println("NO HAY REGISTROS");
                item=null;
            }
        }else{
            System.out.println("NO HAY PRODUCTOS");
            item=null;
        }
        return item;
    }
    public Items Agregar(){
        Scanner sc=new Scanner(System.in);
        Items articulo=new Items();
        System.out.println("CUAL ES EL NOMBRE DEL PRODUCTO");
        articulo.NombreProd=sc.nextLine();
        System.out.println("Marca = ");
        articulo.Marca=sc.nextLine();
        System.out.println("Talla = ");
        articulo.Talla=sc.nextLine();
        System.out.println("Precio = ");
        articulo.Precio=sc.nextFloat();
        System.out.println("Cantidad = ");
        articulo.Cantidad=sc.nextShort();
        return articulo;
    }
    public void Eliminar(Items []inventario){
    }
}
