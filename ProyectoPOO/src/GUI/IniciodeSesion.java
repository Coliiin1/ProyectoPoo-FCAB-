import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IniciodeSesion extends JFrame implements ActionListener{
    Color AzulB = new Color(1, 61, 90);
    Color LionB = new Color(252, 243, 227);
    JButton btnLogin;
    JTextField txtUser;
    JTextField txtPass;
    public IniciodeSesion() {
        setTitle("Inicio de Sesión");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(1, 2)); // dos paneles lado a lado

        // Panel Izquierdo (Login)
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(LionB);

        JLabel lblLogin = new JLabel("Inicio de Sesion");
        lblLogin.setForeground(AzulB);
        lblLogin.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogin.setBounds(60, 30, 200, 30);
        loginPanel.add(lblLogin);

        txtUser = new JTextField("Ingresa tu Usuario");
        txtUser.setBounds(60, 80, 250, 35);
        loginPanel.add(txtUser);

        txtPass = new JTextField("Ingresa la Contraseña");
        txtPass.setBounds(60, 130, 250, 35);
        loginPanel.add(txtPass);

        JCheckBox chkRemember = new JCheckBox("Recuerdame");
        chkRemember.setForeground(AzulB);
        chkRemember.setBounds(60, 180, 120, 30);
        chkRemember.setBackground(LionB);
        loginPanel.add(chkRemember);
/*
 * JButton btnForgot = new JButton("Forgot Password?");
        btnForgot.setBounds(200, 180, 140, 30);
        btnForgot.setBorderPainted(false);
        btnForgot.setContentAreaFilled(false);
        btnForgot.setForeground(Color.GRAY);
        loginPanel.add(btnForgot);
 */
        

        btnLogin = new JButton("Iniciar Sesion");
        btnLogin.setBounds(110, 230, 150, 40);
        btnLogin.setBackground(AzulB);
        btnLogin.setForeground(LionB);
        loginPanel.add(btnLogin);
        btnLogin.addActionListener(this);

        // Panel Derecho (Bienvenida)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(AzulB);
        rightPanel.setLayout(new GridBagLayout());

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setBackground(AzulB);

        JLabel lblWelcome = new JLabel("Bienvenido!");
        lblWelcome.setForeground(LionB);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 22));
        lblWelcome.setBackground(AzulB);
        lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblText = new JLabel("Ingresa tus datos para comenzar");
        lblText.setForeground(LionB);
        lblText.setFont(new Font("Arial", Font.PLAIN, 14));
        lblText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnSignup = new JButton("REGISTRARSE");
        btnSignup.setBackground(LionB);
        btnSignup.setForeground(AzulB);
        btnSignup.setAlignmentX(Component.CENTER_ALIGNMENT);

        innerPanel.add(lblWelcome);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        innerPanel.add(lblText);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        innerPanel.add(btnSignup);

        rightPanel.add(innerPanel);

        // Agregar paneles al frame
        add(loginPanel);
        add(rightPanel);
    }

    public void actionPerformed(ActionEvent Eventos){
        if (Eventos.getSource() == btnLogin){
            String User = txtUser.getText();
            System.out.println(User);
            String Psw = txtPass.getText();
            System.out.println(Psw);
        }
    }

    public static void main(String[] args) {
       new IniciodeSesion().setVisible(true);
    }
}