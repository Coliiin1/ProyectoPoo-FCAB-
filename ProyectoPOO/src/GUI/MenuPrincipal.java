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
    public JButton Inicio;
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
        Inicio = new JButton("Inicio");
        Anadir = new JButton("Añadir");
        Buscar = new JButton("Buscar");
        Eliminar=new JButton("Eliminar");
        Modificar=new JButton("Modificar");
        Guardar=new JButton("Guardar");
        InicioSesion = new JButton("Iniciar Sesion");
        JButton Admin = new JButton("Admin");
        JButton[] itemsuuser = {Inicio, itemRopaH, itemCalzadoH, itemBellezaH, itemHogarH, itemAccesoriosH, InicioSesion};
        JButton[] itemsadmin = {Inicio, itemRopaH, itemCalzadoH, itemBellezaH, itemHogarH, itemAccesoriosH, Anadir, Buscar, Eliminar, Modificar, Guardar};
        // Panel que contendrá los botones
        JPanel ABotones = new JPanel();
        ABotones.setBounds(0, 0, 1920, 60);
        ABotones.setBackground(AzulB);
        if(x == 1){//si es admin agrega los botones respectivos
            ABotones.setLayout(new GridLayout(1, 8));
            for (JButton item : itemsadmin) {
                item.setBackground(AzulB);
                item.setForeground(LionB);
                ABotones.add(item);
            }
            add(ABotones);
        } else {//si el user es comun solo agrega los principales
            ABotones.setLayout(new GridLayout(1, 7));
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
        String descan;
        // panel contenedor: filas con FlowLayout para mantener tamaño fijo por item (360x410)
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(LionB);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // JScrollPane que contendrá el contentPanel
        JScrollPane scroll = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, 90, 1920, 880);
        scroll.getVerticalScrollBar().setUnitIncrement(16); // velocidad de scroll
        add(scroll);

        // crear cada item (imagen arriba, descripcion abajo)
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        rowPanel.setBackground(LionB);
        int cols = 5;
        int countInRow = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null) {
                    // panel individual del item
                    JPanel itemPanel = new JPanel();
                    itemPanel.setBackground(AzulItems);
                    itemPanel.setLayout(new BorderLayout());
                    Dimension itemSize = new Dimension(360, 410);
                    itemPanel.setPreferredSize(itemSize);
                    itemPanel.setMaximumSize(itemSize);

                    // etiqueta para imagen (se posiciona arriba)
                    ImageIcon Imagen = new ImageIcon(matriz[i][j].DirImagen);
                    JLabel imgLabel = new JLabel(Imagen);
                    imgLabel.setHorizontalAlignment(JLabel.CENTER);
                    imgLabel.setVerticalAlignment(JLabel.CENTER);
                    imgLabel.setPreferredSize(new Dimension(360, 260)); // espacio para la imagen
                    //imgLabel.setIcon();
                    Imagenes.add(imgLabel);
                    itemPanel.add(imgLabel, BorderLayout.NORTH);

                    // textarea para descripción (debajo de la imagen)
                    JTextArea desc = new JTextArea();
                    desc.setFont(new Font("Arial", Font.BOLD, 16));
                    descan = (matriz[i][j].NombreProd + "\n" + matriz[i][j].Marca + "\n$" + matriz[i][j].Precio);
                    desc.setText(descan); //Solo muestra datos necesarios para el usuario
                    if (matriz[i][j].Categoria.equals("Zapateria") || matriz[i][j].Categoria.equals("Ropa")) {
                        descan = descan+ "\nTalla: " + matriz[i][j].Talla;
                        desc.setText(descan); //Solo muestra datos necesarios para el usuario
                    }
                    
                    desc.setEditable(false);
                    desc.setBackground(AzulItems);
                    desc.setBorder(new EmptyBorder(8, 8, 8, 8));
                    desc.setPreferredSize(new Dimension(360, 120));

                    Descripciones.add(desc);
                    itemPanel.add(desc, BorderLayout.CENTER);

                    // almacenar y agregar al panel de la fila
                    Paneles.add(itemPanel);
                    rowPanel.add(itemPanel);
                    countInRow++;

                    // si la fila está completa, agregarla al contenedor y crear una nueva fila
                    if (countInRow >= cols) {
                        contentPanel.add(rowPanel);
                        rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
                        rowPanel.setBackground(LionB);
                        countInRow = 0;
                    }
                }
            }
        }

        // agregar la última fila si tiene elementos
        if (countInRow > 0) {
            contentPanel.add(rowPanel);
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