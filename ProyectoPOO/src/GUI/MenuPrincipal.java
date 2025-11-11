package GUI;
import Control.Items;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {
    Color AzulB = new Color(102, 136, 255); 
    Color LionB = new Color(245, 243, 243);
    Color AzulItems = new Color(102, 136, 255);
    public JButton Inicio;
    public JButton Anadir;
    public JButton Buscar;
    public JButton Eliminar;
    public JButton Modificar;
    public JButton Guardar;
    public JButton InicioSesion;
    
    public JButton itemRopaH = new JButton("Ropa");
    public JButton itemCalzadoH = new JButton("Calzado");
    public JButton itemBellezaH = new JButton("Productos de belleza");
    public JButton itemHogarH = new JButton("Productos para el hogar");
    public JButton itemAccesoriosH = new JButton("Accesorios");
    
    public ArrayList<JPanel> Paneles = new ArrayList<>();
    public ArrayList<JLabel> Imagenes = new ArrayList<>();
    public ArrayList<JTextArea> Descripciones = new ArrayList<>();

    private JPanel ABotones;
    private JPanel contentPanel;
    private Items[][] matrizActual;

        int anchoVentana=0;
        int anchoItem = 360; // ancho de cada item con margen
        int cols; // cuantos items caben por fila
        int countInRow = 0;
        ImageIcon icon;
        Image img;
        Image newImg;
        JTextArea desc;
        String descan;
    
    private JScrollPane scroll;
    public MenuPrincipal() {
        setExtendedState(JFrame.MAXIMIZED_BOTH); // inicia maximizada
        //SI GUSTA QUE SE REACOMODEN DELE CLICK EN EL BOTON YA Q NO NOS AYUDO Y NO PUDIMOS :)
        setTitle("Inicio");
        setLayout(new BorderLayout()); // layout para redimensionar los items si se hace mas grande o pequeña la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920,1080);
        getContentPane().setBackground(LionB);
        setMinimumSize(new Dimension(820, 700));
    }

    public void Contenedor(int x) {
        ABotones = new JPanel();
        ABotones.setBackground(AzulB);
        ABotones.setLayout(new GridLayout(1, 0, 10, 10)); 

        // Crear botones
        
        Inicio = new JButton("Inicio");
        Anadir = new JButton("Añadir");
        Buscar = new JButton("Buscar");
        Eliminar = new JButton("Eliminar");
        Modificar = new JButton("Modificar");
        Guardar = new JButton("Guardar");
        InicioSesion = new JButton("Iniciar Sesión");

        JButton[] itemsUser = {Inicio, itemRopaH, itemCalzadoH, itemBellezaH, itemHogarH, itemAccesoriosH, Buscar, InicioSesion};
        JButton[] itemsAdmin = {Inicio, itemRopaH, itemCalzadoH, itemBellezaH, itemHogarH, itemAccesoriosH, Anadir, Buscar, Eliminar, Modificar, Guardar};

        if (x == 1) {
            for (JButton item : itemsAdmin) {
                estiloBoton(item);
                ABotones.add(item);
            }
        } else {
            for (JButton item : itemsUser) {
                estiloBoton(item);
                ABotones.add(item);
            }
        }
        add(ABotones, BorderLayout.NORTH); // Arriba, se adapta
    }

    private void estiloBoton(JButton boton) {
        boton.setBackground(AzulB);
        boton.setForeground(LionB);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private void ajustarBotones() {
        if (ABotones == null) return;
        int ancho = getWidth();

        // Cambiar tamaño de letra y márgenes según ancho
        for (Component c : ABotones.getComponents()) {
            if (c instanceof JButton boton) {
                if (ancho < 1000) {
                    boton.setFont(new Font("Arial", Font.PLAIN, 12));
                    boton.setMargin(new Insets(3, 6, 3, 6));
                } else if (ancho < 1400) {
                    boton.setFont(new Font("Arial", Font.BOLD, 13));
                    boton.setMargin(new Insets(5, 8, 5, 8));
                } else {
                    boton.setFont(new Font("Arial", Font.BOLD, 14));
                    boton.setMargin(new Insets(8, 12, 8, 12));
                }
            }
        }
        ABotones.revalidate();
        ABotones.repaint();
    }

    public void mostrarItems(Items[][] matriz) {
        
        matrizActual = matriz; // guardamos referencia para recalcular

        // limpiar listas previas
        Paneles.clear();
        Imagenes.clear();
        Descripciones.clear();

        if (scroll != null) {
            remove(scroll);
        }

        // Panel contenedor principal
        contentPanel = new JPanel();
        contentPanel.setBackground(LionB);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        scroll = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);

        anchoVentana = getWidth();
        //int anchoItem = 400; // ?ancho de cada item con margen
        cols = Math.max(0, anchoVentana / anchoItem); // cuantos items caben por fila
        countInRow = 0;

        JPanel rowPanel = crearFila();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != null) {
                    JPanel itemPanel = crearItem(matriz[i][j]);
                    rowPanel.add(itemPanel);
                    countInRow++;

                    if (countInRow >= cols) {
                        contentPanel.add(rowPanel);
                        rowPanel = crearFila();
                        countInRow = 0;
                    }
                }
            }
        }

        if (countInRow > 0) contentPanel.add(rowPanel);

        revalidate();
        repaint();
    }

    public void mostrarItems(Items[][] matriz,int i) {
        matrizActual = matriz; // guardamos referencia para recalcular

        // limpiar listas previas
        Paneles.clear();
        Imagenes.clear();
        Descripciones.clear();

        if (scroll != null) {
            remove(scroll);
        }

        // Panel contenedor principal
        contentPanel = new JPanel();
        contentPanel.setBackground(LionB);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        scroll = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);

        //int anchoVentana = getWidth();
        anchoVentana=getWidth();
        //int anchoItem = 400; // ?ancho de cada item con margen
        cols = Math.max(1, anchoVentana / anchoItem); // cuantos items caben por fila, lo puso netbeans
        
        countInRow = 0;
 
        JPanel rowPanel = crearFila();

        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] != null) {
                JPanel itemPanel = crearItem(matriz[i][j]);
                rowPanel.add(itemPanel);
                countInRow++;

                if (countInRow >= cols) {
                    contentPanel.add(rowPanel);
                    rowPanel = crearFila();
                    countInRow = 0;
                }
            }
        }

        if (countInRow > 0) contentPanel.add(rowPanel);

        revalidate();
        repaint();
    }
    
    private JPanel crearFila() {
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        fila.setBackground(LionB);
        return fila;
    }
    
    private void AdaptarImagen(JLabel label, String ruta) {
        icon = new ImageIcon(ruta);
        img = icon.getImage();
        newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(newImg));
    }
    
    private JPanel crearItem(Items item) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(AzulItems);
        Dimension itemSize = new Dimension(345, 410);//SETEA LAS DIMENSIONES DE LS ITEMS
        itemPanel.setPreferredSize(itemSize);
        itemPanel.setMaximumSize(itemSize);

        // Imagen
        JLabel imgLabel = new JLabel();
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setSize(new Dimension(360, 260));
        itemPanel.add(imgLabel, BorderLayout.NORTH);
        AdaptarImagen(imgLabel, item.DirImagen);
        Imagenes.add(imgLabel);

        // Descripción
        desc = new JTextArea();
        desc.setFont(new Font("Arial", Font.BOLD, 16));
        descan = item.NombreProd + "\n" + item.Marca + "\n$" + item.Precio;
        if (item.Categoria.equals("Zapateria") || item.Categoria.equals("Ropa")) {
            descan += "\nTalla: " + item.Talla;
        }
        desc.setText(descan);
        desc.setEditable(false);
        desc.setBackground(AzulItems);
        desc.setBorder(new EmptyBorder(8, 8, 8, 8));
        desc.setPreferredSize(new Dimension(360, 120));
        desc.setForeground(LionB);
        Descripciones.add(desc);
        itemPanel.add(desc, BorderLayout.CENTER);

        Paneles.add(itemPanel);
        return itemPanel;
    }
}
