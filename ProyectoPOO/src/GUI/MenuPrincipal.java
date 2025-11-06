//menu

package GUI;
import Control.Items;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame{
    Color AzulB = new Color(64, 79, 104);
    Color LionB = new Color(252, 243, 227);
    Color AzulItems = new Color(122, 133, 157);
    public JButton Anadir;
    public JButton Buscar;
    public JButton Eliminar;
    public JButton Modificar;
    public JButton Guardar;
    public JButton InicioSesion;
    public ArrayList <JPanel> Paneles = new ArrayList();
    public ArrayList <JLabel> Imagenes = new ArrayList();
    public ArrayList <JTextArea> Descripciones = new ArrayList();


    public MenuPrincipal() {
        setTitle("Inicio");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setResizable(true);
        getContentPane().setBackground(LionB); // Aplica el color de fondo
    }

    public void Contenedor(int x) {

        // Creación de botones
        JButton itemRopaH = new JButton("Ropa");
        JButton itemCalzadoH = new JButton("Calzado");
        JButton itemBellezaH = new JButton("Productos de belleza");
        JButton itemHogarH = new JButton("Productos para el hogar");
        JButton itemAccesoriosH = new JButton("Accesorios");
        Anadir = new JButton("Añadir");
        Buscar = new JButton("Buscar");
        Eliminar=new JButton("Eliminar");
        Modificar=new JButton("Modificar");
        Guardar=new JButton("Guardar");
        InicioSesion = new JButton("Iniciar Sesion");
        JButton Admin = new JButton("Admin");
        JButton[] itemsuuser = {itemRopaH, itemCalzadoH, itemBellezaH, itemHogarH, itemAccesoriosH, InicioSesion};
        JButton[] itemsadmin = {itemRopaH, itemCalzadoH, itemBellezaH, itemHogarH, itemAccesoriosH, Anadir, Buscar, Eliminar, Modificar, Guardar};
        // Panel que contendrá los botones
        JPanel ABotones = new JPanel();
        ABotones.setBounds(0, 0, 1920, 60);
        ABotones.setBackground(AzulB);
        if(x == 1){//si es admin agrega los botones respectivos
            ABotones.setLayout(new GridLayout(1, 7));
            for (JButton item : itemsadmin) {
                item.setBackground(AzulB);
                item.setForeground(LionB);
                ABotones.add(item);
            }
            add(ABotones);
        } else {//si el user es comun solo agrega los principales
            ABotones.setLayout(new GridLayout(1, 6));
            for (JButton item : itemsuuser) {
                item.setBackground(AzulB);
                item.setForeground(LionB);
                ABotones.add(item);
            }
            add(ABotones);
        }
    }
        /*JPanel Item1 = new JPanel();
        JPanel Item2 = new JPanel();
        JPanel Item3 = new JPanel();
        JPanel Item4 = new JPanel();
        JPanel Item5 = new JPanel();

        JPanel Item6 = new JPanel();
        JPanel Item7 = new JPanel();
        JPanel Item8 = new JPanel();
        JPanel Item9 = new JPanel();
        JPanel Item10 = new JPanel();
        
        JPanel[] Items= {Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10};*/

    public void mostrarItems(Items[][] matriz){
        int ContItems = 0;
        JPanel PanelP = new JPanel();
        PanelP.setBounds(0, 90, 1920, 880);
        PanelP.setBackground(LionB);
        PanelP.setLayout(new GridLayout(2, 5, 20, 20)); // 20px de separación entre items
        PanelP.setBorder(new EmptyBorder(20, 20, 20, 20)); // 20px de separación interna en todos los lados
        add(PanelP);
        int ejex = 20, ejey = 90, contador = 0;
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j] != null){
                    Paneles.add(new JPanel());
                    Paneles.get(ContItems).setBackground(AzulItems);
                    Paneles.get(ContItems).setBounds(ejex, ejey, 360, 410);
                    Descripciones.add(new JTextArea());
                    Descripciones.get(ContItems).setBounds(ejex, ejey, 360, 410);
                    ejex += 380;
                    contador++;
                    ContItems++;
                    PanelP.add(Paneles.get(ContItems-1));
                    if (contador == 5) {
                        contador = 0;
                        ejex = 20;
                        ejey = 520;
                    }
                }
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