import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {
    Color AzulB = new Color(64, 79, 104);
    Color LionB = new Color(252, 243, 227);
    Color Blanco = new Color(242, 242, 242);
    Color Gris = new Color(196, 196, 196);
    Color AzulItems = new Color(122, 133, 157);

    public MenuPrincipal() {
        setTitle("Inicio");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setResizable(true);
        getContentPane().setBackground(Blanco); // Aplica el color de fondo
    }

    public void Contenedor(int x) {
        
        // Creación de botones
        JButton itemRopaH = new JButton("Ropa");
        JButton itemCalzadoH = new JButton("Calzado");
        JButton itemBellezaH = new JButton("Productos de belleza");
        JButton itemHogarH = new JButton("Productos para el hogar");
        JButton itemAccesoriosH = new JButton("Accesorios");
        JButton Anadir = new JButton("Añadir");
        JButton Admin = new JButton("Admin");
        JButton[] itemsuuser = {itemRopaH, itemCalzadoH, itemBellezaH, itemHogarH, itemAccesoriosH};
        JButton[] itemsadmin = {itemRopaH, itemCalzadoH, itemBellezaH, itemHogarH, itemAccesoriosH, Anadir, Admin};
        // Panel que contendrá los botones
        JPanel ABotones = new JPanel();
        ABotones.setBounds(0, 5, 1920, 60);
        ABotones.setBackground(AzulB);
        if(x == 1){//si es admin agrega los botones respectivos
            ABotones.setLayout(new GridLayout(1, 7));
            for (JButton item : itemsadmin) {
                item.setBackground(LionB);
                item.setForeground(AzulB);
                ABotones.add(item);
            }
            add(ABotones);
        } else {//si el user es comun solo agrega los principales
            ABotones.setLayout(new GridLayout(1, 5));
            for (JButton item : itemsuuser) {
                item.setBackground(LionB);
                item.setForeground(AzulB);
                ABotones.add(item);
            }
            add(ABotones);
        } 

        JPanel PanelP = new JPanel();
        PanelP.setBounds(0, 70, 1920, 880);
        PanelP.setBackground(Gris);
        PanelP.setLayout(new GridLayout(2, 5, 20, 20)); // 20px de separación entre items
        PanelP.setBorder(new EmptyBorder(20, 20, 20, 20)); // <-- 20px de separación interna en todos los lados
        add(PanelP);
        int ejex = 20, ejey = 90, contador = 0;
        JPanel Item1 = new JPanel();
        JPanel Item2 = new JPanel();
        JPanel Item3 = new JPanel();
        JPanel Item4 = new JPanel();
        JPanel Item5 = new JPanel();

        JPanel Item6 = new JPanel();
        JPanel Item7 = new JPanel();
        JPanel Item8 = new JPanel();
        JPanel Item9 = new JPanel();
        JPanel Item10 = new JPanel();
        
        JPanel[] Items= {Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10};
        for (JPanel item : Items) {
            PanelP.add(item);
            item.setBackground(AzulItems);
            Item1.setBounds(ejex, ejey, 360, 410);
            ejex += 380;
            contador++;
            if (contador == 5) {
                contador = 0;
                ejex = 20;
                ejey = 520;
            }
        }
    }

    public static void main(String args[]) {
        int x = 1;//si es user es 0 y admin es 1
        MenuPrincipal Menu = new MenuPrincipal();
        Menu.Contenedor(x);
        Menu.setVisible(true);
    }
}
