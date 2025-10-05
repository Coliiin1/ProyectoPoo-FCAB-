package Control;
import GUI.*;
import MAIN.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author fabri
 */
public class Controlador implements ActionListener{
    IniciodeSesion inicio;
    Registro reg;
    public Controlador(){
        inicio=new IniciodeSesion();
        inicio.setVisible(true);
        this.inicio.btnSignup.addActionListener(this);
    }
    public static void main(String args[]){
        Items[] inventario=new Items[50];
        Controlador control=new Controlador();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== inicio.btnSignup) {
            reg=new Registro();
            reg.setVisible(true);
            inicio.hide();
        }
    }
}
