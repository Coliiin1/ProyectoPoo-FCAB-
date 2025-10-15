package Control;
import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author fabri
 */
public class Controlador implements ActionListener{
    IniciodeSesion inicio;
    Administrador user=new Administrador("ADMIN","12345");
    AgregarUI agreg;
    MenuPrincipal men;
    controlInterfaz interfaz;
    
    Items[] ropa;
    Items[] calzado;
    Items[] productosB;
    Items[] productosH;
    Items[] accesorios;
    
    byte vr;
    byte vc;
    byte vpb;
    byte vph;
    byte va;
    public Controlador(){
        ropa=new Items[50];
        calzado=new Items[50];
        productosB=new Items[50];
        productosH=new Items[50];
        accesorios =new Items[50];
        
        vr=0;
        vc=0;
        vpb=0;
        vph=0;
        va=0;
        
        inicio=new IniciodeSesion();
        inicio.Contenedor();
        inicio.setVisible(true);
        men=new MenuPrincipal();
        this.inicio.btnLogin.addActionListener(this);
        this.inicio.borrar.addActionListener(this);
        this.inicio.borrar2.addActionListener(this);
        this.inicio.btnIgnore.addActionListener(this);
        interfaz=new controlInterfaz();
    }
    public static void main(String args[]){
        Controlador control=new Controlador();
        
        System.out.println("\nAsh nazg durbatulûk, ash nazg gimbatul, ash nazg thrakatulûk agh burzum-ishi krimpatul");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evento= e.getSource();
        
        if (evento == inicio.borrar){
            inicio.txtUser.setText("");
        }
        if (evento == inicio.borrar2){
            inicio.txtPass.setText("");
        }
        if (evento == inicio.btnLogin){
            if((user.Usuario).equals(inicio.txtUser.getText()) && (user.Contrasenia).equals(inicio.txtPass.getText())){
                men.Contenedor(1);
                men.setVisible(true);
                inicio.hide();
                this.men.Anadir.addActionListener(this);
            }else{
                inicio.error.setText("ERROR AL INICIAR SESION");
            }
        }
        if (evento == inicio.btnIgnore){
            men.Contenedor(0);
            men.setVisible(true);
        }
        if (evento == men.Anadir) {
            agreg=new AgregarUI();
            agreg.contenedor();
            agreg.setVisible(true);
            agreg.btnAgregar.addActionListener(interfaz);
            agreg.comboCategorias.addActionListener(interfaz);
        }
    }
    private class controlInterfaz implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Object evento=e.getSource();
            if(evento==agreg.btnAgregar){
                if("".equals(agreg.campoCaracteristicas.getText())|| "".equals(agreg.campoCodigo.getText())||"".equals(agreg.campoMarca.getText())
                        ||"".equals(agreg.campoPrecio.getText())||"".equals(agreg.campoProveedor.getText())||agreg.comboCategorias.getSelectedItem()=="Seleccione"
                        ||agreg.comboSexo.getSelectedItem()=="Seleccione"|| agreg.comboTalla.getSelectedItem()=="Seleccione talla"){
                    JOptionPane.showMessageDialog(agreg,"DEBES LLENAR EL REGISTRO");
                }else{
                    System.out.println("ok");
                }
            }
        }
    }
}
