package Control;
import GUI.AgregarUI;

/**
 *
 * @author fabri
 */
public class Administrador extends Usuario{ 
    public Administrador(String usuario,String contrasenia){
        super(usuario,contrasenia);
    }
    public Items Agregar(AgregarUI agreg){
        Items articulo=new Items();
        String talla=(String)agreg.comboTalla.getSelectedItem();
        String sex=(String)agreg.comboSexo.getSelectedItem();
        articulo.NombreProd=agreg.txtNombre.getText();
        articulo.CodigoProd=agreg.campoCodigo.getText();
        articulo.Talla=talla;
        articulo.Sexo=sex;
        return articulo;
    }
    public Items Modificar(Items item){
        return item;
    }
    public void Eliminar(Items []inventario){
        Items encontrado=new Items();
        Items apu=new Items();
        encontrado=Consultar(inventario);
        if(encontrado==null){
            System.out.println("No se pudo eliminar");
        } else {
            for (int i = 0; i < inventario.length; i++) {
                if (inventario[i].equals(encontrado)){
                    for (int j = i; j < inventario.length-1; j++) {
                        apu = inventario[j+i];
                        inventario[j] = apu;
                    }
                break;
                }
            }
            System.out.println("Se borro correctamente :)");
        }
    }
}
