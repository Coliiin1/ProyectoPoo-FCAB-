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
    public Items[] Eliminar(Items []inventario,int codigo,byte fin){
        Items encontrado=new Items();
        encontrado=Consultar(inventario,codigo);
        if(encontrado==null){
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR");
        } else {
            for (int i = 0; i < fin; i++) {
                if (inventario[i].CodigoProd==encontrado.CodigoProd){
                    for (int j = i; j < inventario.length-1; j++) {
                        inventario[j] = inventario[j+i];
                        System.out.println("j = " + j);
                    }
                    inventario[fin]=null;
                break;
                }
            }
            JOptionPane.showMessageDialog(null, "ELIMINADO EXITOSAMENTE");
        }
        return inventario;
    }
    
}
