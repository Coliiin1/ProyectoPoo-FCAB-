package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter; 

public class AgregarUI extends JFrame{
    public JButton btnEnviar;
    public JTextField txtNombre;
    public JButton btnAgregar;
    //esto no lo toques paput :v
    JComboBox<String> comboCategorias;
    private JLabel etiquetaRutaImagen;
    private JLabel etiquetaVistaPrevia;
    public AgregarUI(){
        setTitle("Agregar");
        // Usamos BorderLayout y paneles internos para centrar el formulario
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 750);
        setResizable(true);
        setLocationRelativeTo(null);
    }
    public void contenedor(){
        // Creamos un panel central que contendrá el formulario y lo centraremos
        JPanel panelContenedor = new JPanel(new GridBagLayout());
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints restricciones = new GridBagConstraints();
        restricciones.insets = new Insets(6, 6, 6, 6);
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        restricciones.gridx = 0; restricciones.gridy = 0;

        // Nombre
        JLabel etiquetaNombre = new JLabel("Nombre:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaNombre, restricciones);
        JComboBox<String> comboNombre = new JComboBox<>();
        comboNombre.addItem("--Seleccione nombre--");
        comboNombre.addItem("Camisa");
        comboNombre.addItem("Zapatos");
        comboNombre.addItem("Crema");
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(comboNombre, restricciones);

        // Categoria
        restricciones.gridy++;
        JLabel etiquetaCategoria = new JLabel("Categoria:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaCategoria, restricciones);
        comboCategorias = new JComboBox<>();
        comboCategorias.addItem("Seleccione");
        comboCategorias.addItem("Zapateria");
        comboCategorias.addItem("Ropa");
        comboCategorias.addItem("Productos de Belleza");
        comboCategorias.addItem("Productos del Hogar");
        comboCategorias.addItem("Accesorios");
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(comboCategorias, restricciones);

        // Talla
        restricciones.gridy++;
        JLabel etiquetaTalla = new JLabel("Talla:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaTalla, restricciones);
        JComboBox<String> comboTalla = new JComboBox<>();
        comboTalla.addItem("--Seleccione talla--");
        comboTalla.addItem("XS");
        comboTalla.addItem("S");
        comboTalla.addItem("M");
        comboTalla.addItem("L");
        comboTalla.addItem("XL");
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(comboTalla, restricciones);

        // Sexo
        restricciones.gridy++;
        JLabel etiquetaSexo = new JLabel("Sexo:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaSexo, restricciones);
        JComboBox<String> comboSexo = new JComboBox<>();
        comboSexo.addItem("--Seleccione--");
        comboSexo.addItem("Masculino");
        comboSexo.addItem("Femenino");
        comboSexo.addItem("Unisex");
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(comboSexo, restricciones);

        // Precio
        restricciones.gridy++;
        JLabel etiquetaPrecio = new JLabel("Precio:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaPrecio, restricciones);
        JComboBox<String> comboPrecio = new JComboBox<>();
        comboPrecio.addItem("--Rango de precio--");
        comboPrecio.addItem("< $10");
        comboPrecio.addItem("$10 - $50");
        comboPrecio.addItem("$50 - $100");
        comboPrecio.addItem("> $100");
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(comboPrecio, restricciones);

        // Marca (campo de texto)
        restricciones.gridy++;
        JLabel etiquetaMarca = new JLabel("Marca:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaMarca, restricciones);
        JTextField campoMarca = new JTextField();
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(campoMarca, restricciones);

        // Proveedor (campo de texto)
        restricciones.gridy++;
        JLabel etiquetaProveedor = new JLabel("Proveedor:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaProveedor, restricciones);
        JTextField campoProveedor = new JTextField();
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(campoProveedor, restricciones);

        // Codigo del producto (campo de texto)
        restricciones.gridy++;
        JLabel etiquetaCodigoProducto = new JLabel("Codigo del Producto:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaCodigoProducto, restricciones);
        JTextField campoCodigo = new JTextField();
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(campoCodigo, restricciones);

        // Caracteristicas (campo de texto)
        restricciones.gridy++;
        JLabel etiquetaCaracteristicas = new JLabel("Caracteristicas del Producto:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaCaracteristicas, restricciones);
        JTextField campoCaracteristicas = new JTextField();
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(campoCaracteristicas, restricciones);

        // Imagen: botón para seleccionar archivo + label con nombre + preview
        restricciones.gridy++;
        JLabel etiquetaImagen = new JLabel("Imagen del Producto:");
        restricciones.gridx = 0; restricciones.weightx = 0.0;
        panelFormulario.add(etiquetaImagen, restricciones);

        JPanel panelImagen = new JPanel(new BorderLayout(6,6));
        JPanel panelTopImagen = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        JButton btnSeleccionarArchivo = new JButton("Seleccionar archivo...");
        etiquetaRutaImagen = new JLabel("Ninguno");
        panelTopImagen.add(btnSeleccionarArchivo);
        panelTopImagen.add(etiquetaRutaImagen);
        etiquetaVistaPrevia = new JLabel();
        etiquetaVistaPrevia.setPreferredSize(new Dimension(150,150));
        etiquetaVistaPrevia.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelImagen.add(panelTopImagen, BorderLayout.NORTH);
        panelImagen.add(etiquetaVistaPrevia, BorderLayout.CENTER);
        restricciones.gridx = 1; restricciones.weightx = 1.0;
        panelFormulario.add(panelImagen, restricciones);

        // Acción del botón: abrir JFileChooser y validar extensiones
        btnSeleccionarArchivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser selector = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (jpg, jpeg, png, gif, bmp)", "jpg", "jpeg", "png", "gif", "bmp");
                selector.setFileFilter(filtro);
                int resultado = selector.showOpenDialog(AgregarUI.this);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File f = selector.getSelectedFile();
                    String name = f.getName().toLowerCase();
                    if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".bmp")) {
                        etiquetaRutaImagen.setText(f.getName());
                        ImageIcon ico = new ImageIcon(f.getAbsolutePath());
                        Image img = ico.getImage().getScaledInstance(etiquetaVistaPrevia.getWidth(), etiquetaVistaPrevia.getHeight(), Image.SCALE_SMOOTH);
                        etiquetaVistaPrevia.setIcon(new ImageIcon(img));
                    } else {
                        JOptionPane.showMessageDialog(AgregarUI.this, "Formato no válido. Elija jpg, png, gif o bmp.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Botón agregar al final
        restricciones.gridy++;
        restricciones.gridx = 0; restricciones.gridwidth = 2; restricciones.anchor = GridBagConstraints.CENTER;
        btnAgregar = new JButton("Agregar");
        panelFormulario.add(btnAgregar, restricciones);

        // Añadimos panelFormulario al panelContenedor para centrar y luego al centro del frame
        panelContenedor.add(panelFormulario);
        add(panelContenedor, BorderLayout.CENTER);

        // Empaquetar y mantener tamaño mínimo
        pack();
        setSize(520, 780);
    }
    
    public static void main(String[] args) {
        AgregarUI Buscar = new AgregarUI();
        Buscar.contenedor();
        Buscar.setVisible(true);
    }
}
