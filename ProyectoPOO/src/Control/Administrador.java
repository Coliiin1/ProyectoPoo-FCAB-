package Control;
import GUI.AgregarUI;
import javax.swing.JOptionPane;

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
        articulo.Precio=Float.parseFloat(agreg.campoPrecio.getText());
        articulo.Talla=talla;
        articulo.Sexo=sex;
        articulo.Precio=Float.parseFloat(agreg.campoPrecio.getText());
        articulo.Marca=agreg.campoMarca.getText();
        articulo.Proveedor=agreg.campoProveedor.getText();
        articulo.Cantidad=Short.parseShort(agreg.campoCantidad.getText());
        return articulo;
    }
    public Items Modificar(Items item){
        return item;
    }
    public boolean Eliminar(Items []inventario,int codigo,byte fin){
        Items encontrado=new Items();
        byte temp;
        boolean eliminado=false;
        encontrado=Consultar(inventario,codigo);
        if(encontrado==null){
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR");
        } else {
            for (byte i = 0; i < fin; i++) {
                if (inventario[i].equals(encontrado)){
                    for (int k = 0; k < inventario.length-1; k++) {
                        inventario[k]=inventario[k+1];
                    }
                    inventario[fin]=null;
                    eliminado=true;
                    JOptionPane.showMessageDialog(null, "ELIMINADO EXITOSAMENTE");
                    break;
                }
            }
        }
        return eliminado;
    }
}
