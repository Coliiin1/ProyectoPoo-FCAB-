package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Registro extends JFrame implements ActionListener{
    Color AzulB = new Color(1, 61, 90);
    Color LionB = new Color(252, 243, 227);
    JButton btnLogin;
    JButton btnSignup;
    JTextField txtUser;
    JTextField txtPass;
    JTextField txtName;
    public Registro() {
        setTitle("Registro");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(1, 2)); // dos paneles lado a lado
    }
    
    public void Contenedor(){
        // Panel Izquierdo (Login)
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(AzulB);

        JLabel lblLogin = new JLabel("Registro");
        lblLogin.setForeground(LionB);
        lblLogin.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogin.setBounds(60, 30, 200, 30);
        loginPanel.add(lblLogin);

        txtName = new JTextField("Ingresa tu(s) nombre(s)");
        txtName.setBounds(60, 80, 250, 35);
        loginPanel.add(txtName);

        txtUser = new JTextField("Ingresa tu Usuario");
        txtUser.setBounds(60, 130, 250, 35);
        loginPanel.add(txtUser);

        txtPass = new JTextField("Ingresa la Contraseña");
        txtPass.setBounds(60, 180, 250, 35);
        loginPanel.add(txtPass);

        btnLogin = new JButton("Registrarse");
        btnLogin.setBounds(110, 230, 150, 40);
        btnLogin.setBackground(LionB);
        btnLogin.setForeground(AzulB);
        loginPanel.add(btnLogin);
        btnLogin.addActionListener(this);

        // Panel Derecho (Bienvenida)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(LionB);
        rightPanel.setLayout(new GridBagLayout());

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setBackground(LionB);

        JLabel lblWelcome = new JLabel("¿Ya tienes cuenta?");
        lblWelcome.setForeground(AzulB);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 22));
        lblWelcome.setBackground(LionB);
        lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblText = new JLabel("Continuar con tu cuenta");
        lblText.setForeground(AzulB);
        lblText.setFont(new Font("Arial", Font.PLAIN, 14));
        lblText.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnSignup = new JButton("Iniciar Sesion");
        btnSignup.setBackground(AzulB);
        btnSignup.setForeground(LionB);
        btnSignup.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        innerPanel.add(lblWelcome);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        innerPanel.add(lblText);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        innerPanel.add(btnSignup);
        rightPanel.add(innerPanel);

        add(loginPanel);
        add(rightPanel);
    }

    public void actionPerformed(ActionEvent Eventos){
        if (Eventos.getSource() == btnLogin){
            String User = txtUser.getText();
            System.out.println(User);
            String Psw = txtPass.getText();
            System.out.println(Psw);
            String Names = txtName.getText();
            System.out.println(Names);
        }
        if(Eventos.getSource()==btnSignup){
            IniciodeSesion ini=new IniciodeSesion();
            ini.setVisible(rootPaneCheckingEnabled);
        }
    }

    public static void main(String[] args) {
        Registro Reg = new Registro();
        Reg.Contenedor();
        Reg.setVisible(true);
    }
}