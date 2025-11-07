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


    public void mostrarItems(Items[][] matriz){
        // limpiar listas previas
        Paneles.clear();
        Imagenes.clear();
        Descripciones.clear();

        // panel contenedor con filas dinámicas y 5 columnas
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(LionB);
        contentPanel.setLayout(new GridLayout(0, 5, 20, 20));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // JScrollPane que contendrá el contentPanel
        JScrollPane scroll = new JScrollPane(contentPanel,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, 90, 1920, 880);
        scroll.getVerticalScrollBar().setUnitIncrement(16); // velocidad de scroll
        add(scroll);

        // crear cada item (imagen arriba, descripcion abajo)
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null) {
                    // panel individual del item
                    JPanel itemPanel = new JPanel();
                    itemPanel.setBackground(AzulItems);
                    itemPanel.setLayout(new BorderLayout());
                    itemPanel.setPreferredSize(new Dimension(360, 410));

                    // etiqueta para imagen (se posiciona arriba)
                    JLabel imgLabel = new JLabel();
                    imgLabel.setHorizontalAlignment(JLabel.CENTER);
                    imgLabel.setVerticalAlignment(JLabel.CENTER);
                    imgLabel.setPreferredSize(new Dimension(360, 260)); // espacio para la imagen
                    // imgLabel.setIcon(...) // aquí se puede asignar el icono más tarde
                    Imagenes.add(imgLabel);
                    itemPanel.add(imgLabel, BorderLayout.NORTH);

                    // textarea para descripción (debajo de la imagen)
                    JTextArea desc = new JTextArea();
                    desc.setText(matriz[i][j].MostrarInfo());
                    desc.setEditable(false);
                    desc.setLineWrap(true);
                    desc.setWrapStyleWord(true);
                    desc.setBackground(AzulItems);
                    desc.setBorder(new EmptyBorder(8, 8, 8, 8));

                    Descripciones.add(desc);
                    itemPanel.add(desc, BorderLayout.CENTER);

                    // almacenar y agregar al panel contenedor
                    Paneles.add(itemPanel);
                    contentPanel.add(itemPanel);
                }
            }
        }

        // forzar revalidar/repaint para que se actualice la vista
        revalidate();
        repaint();
    }





    public static void main(String args[]) {
        int x = 1;//si es user es 0 y admin es 1
        MenuPrincipal Menu = new MenuPrincipal();
        Menu.Contenedor(x);
        Menu.setVisible(true);
    }
}