package Control;
import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author fabri
 */
public class Controlador implements ActionListener{
    IniciodeSesion inicio;
    Administrador user=new Administrador("ADMIN","12345");
    static MenuPrincipal men;
    public Controlador(){
        inicio=new IniciodeSesion();
        inicio.Contenedor();
        inicio.setVisible(true);
        this.inicio.btnLogin.addActionListener(this);
        this.inicio.borrar.addActionListener(this);
        this.inicio.borrar2.addActionListener(this);
        this.inicio.btnIgnore.addActionListener(this);
    }
    public static void main(String args[]){
        Items[] inventario=new Items[50];
        Controlador control=new Controlador();
        men=new MenuPrincipal();
        System.out.println("Ash nazg durbatulûk, ash nazg gimbatul, ash nazg thrakatulûk agh burzum-ishi krimpatul");
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
            }else{
                inicio.error.setText("ERROR AL INICIAR SESION");
            }
        }
        if (evento == inicio.btnIgnore){
            men.Contenedor(0);
            men.setVisible(true);
        }
    }
}
