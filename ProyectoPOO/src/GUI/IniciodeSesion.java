package GUI;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author fabri
 */
public class IniciodeSesion extends JFrame implements ActionListener{
    JLabel field1;
    JButton InSesion;
    JTextField IUser;
    public IniciodeSesion(){
        setTitle("Inicio de Sesion");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,450);
        setResizable(false);
        setLayout(null);
    }
    public void contenedor(){
        JLabel User = new JLabel("Usuario:");
        User.setBounds(20, 20, 50, 20);
        add(User);
        
        IUser = new JTextField();
        IUser.setBounds(20, 45, 200, 30);
        add(IUser);
        
        JLabel Password = new JLabel("Contraseña:");
        Password.setBounds(20, 80, 200, 20);
        add(Password);
        
        JTextField IPassword = new JTextField();
        IPassword.setBounds(20, 105, 200, 30);
        add(IPassword);
        
        InSesion = new JButton("Iniciar Sesion");
        InSesion.setBounds(100, 350, 150, 30);
        add(InSesion);      
        InSesion.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource()== InSesion){
            String user=IUser.getText();
            System.out.println(user);
        }
    }
    public static void main(String args[]){
        IniciodeSesion uno = new IniciodeSesion();
        uno.contenedor();
        uno.setVisible(true);
    }
}
