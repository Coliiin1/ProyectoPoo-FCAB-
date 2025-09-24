package GUI;
import javax.swing.*;

public class MenuPrincipal extends JFrame{
    public MenuPrincipal(){
        setTitle("Inicio");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920,1080);
        setResizable(true);
        setLayout(null);
    }
    public void Contenedor (){
        JMenuBar menuBar = new JMenuBar();

        JMenu MenuHombre = new JMenu("Hombre");//todas las subcats de hombre
        JMenuItem itemRopaH = new JMenuItem("Ropa");
        JMenuItem itemCalzadoH = new JMenuItem("Calzado");
        JMenuItem itemBellezaH = new JMenuItem("Productos de belleza");
        JMenuItem itemHogarH = new JMenuItem("Productos para el hogar");
        JMenuItem itemAccesoriosH = new JMenuItem("Accesorios");

        MenuHombre.add(itemRopaH);
        MenuHombre.add(itemCalzadoH);
        MenuHombre.add(itemBellezaH);
        MenuHombre.add(itemHogarH);
        MenuHombre.add(itemAccesoriosH);

        JMenu MenuMujer = new JMenu("Mujer"); //todas las subcats de mujer
        JMenuItem itemRopaM = new JMenuItem("Ropa");
        JMenuItem itemCalzadoM = new JMenuItem("Calzado");
        JMenuItem itemBellezaM = new JMenuItem("Productos de belleza");
        JMenuItem itemHogarM = new JMenuItem("Productos para el hogar");
        JMenuItem itemAccesoriosM = new JMenuItem("Accesorios");

        MenuMujer.add(itemRopaM);
        MenuMujer.add(itemCalzadoM);
        MenuMujer.add(itemBellezaM);
        MenuMujer.add(itemHogarM);
        MenuMujer.add(itemAccesoriosM);

        JMenu MenuNino = new JMenu("Niño");//todas las subcats de niños
        JMenuItem itemRopaN = new JMenuItem("Ropa");
        JMenuItem itemCalzadoN = new JMenuItem("Calzado");
        JMenuItem itemBellezaN = new JMenuItem("Productos de belleza");
        JMenuItem itemHogarN = new JMenuItem("Productos para el hogar");
        JMenuItem itemAccesoriosN = new JMenuItem("Accesorios");

        MenuNino.add(itemRopaN);
        MenuNino.add(itemCalzadoN);
        MenuNino.add(itemBellezaN);
        MenuNino.add(itemHogarN);
        MenuNino.add(itemAccesoriosN);

        menuBar.add(MenuHombre);//agrego todos los submenus a la barra de arriba
        menuBar.add(MenuMujer);
        menuBar.add(MenuNino);

        menuBar.setBounds(0, 0, 1920, 40);
        add(menuBar);
    }
    public static void main(String args[]){
        MenuPrincipal Menu = new MenuPrincipal();
        Menu.Contenedor();
        Menu.setVisible(true);
    }
}
