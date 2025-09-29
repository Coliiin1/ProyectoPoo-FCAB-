package MAIN;

/**
 *
 * @author fabri
 */
public class Administrador extends Usuario{ 
    public Administrador(String usuario,String contrasenia){
        super(usuario,contrasenia);
    }
    public void Eliminar(Items []inventario){
        Items encontrado=new Items();
        Items apu=new Items();
        Items apur=new Items();
        encontrado=Consultar(inventario);
        if(encontrado==null){
            
        }
        for(int i = 0; i < inventario.length; i++){
            if(inventario[i].equals(encontrado)){
                
            }
        }
    }
}
