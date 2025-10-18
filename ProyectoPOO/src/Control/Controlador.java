package Control;
import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author fabri
 */
public class Controlador implements ActionListener{
    IniciodeSesion inicio;
    Administrador user=new Administrador("ADMIN","12345");
    AgregarUI agreg;
    MenuPrincipal men;
    BuscarUI bus;
    controlInterfaz interfaz;
    
    Items itemtemp;
    
    Items[] ropa;
    Items[] calzado;
    Items[] productosB;
    Items[] productosH;
    Items[] accesorios;
    
    byte vr;
    byte vc;
    byte vpb;
    byte vph;
    byte va;
    public Controlador(){
        ropa=new Items[50];
        calzado=new Items[50];
        productosB=new Items[50];
        productosH=new Items[50];
        accesorios =new Items[50];
        
        vr=0;
        vc=0;
        vpb=0;
        vph=0;
        va=0;
        
        inicio=new IniciodeSesion();
        inicio.Contenedor();
        inicio.setVisible(true);
        men=new MenuPrincipal();
        this.inicio.btnLogin.addActionListener(this);
        this.inicio.borrar.addActionListener(this);
        this.inicio.borrar2.addActionListener(this);
        this.inicio.btnIgnore.addActionListener(this);
        interfaz=new controlInterfaz();
    }
    public static void main(String args[]){
        Controlador control=new Controlador();
        
        System.out.println("\nAsh nazg durbatulûk, ash nazg gimbatul, ash nazg thrakatulûk agh burzum-ishi krimpatul");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evento= e.getSource();
        
        if (evento == inicio.borrar){
            inicio.txtUser.setText("");
        }
        if (evento == inicio.borrar2){
            inicio.txtPass.setText("");
        }
        if (evento == inicio.btnLogin){
            if((user.Usuario).equals(inicio.txtUser.getText()) && (user.Contrasenia).equals(inicio.txtPass.getText())){
                men.Contenedor(1);
                men.setVisible(true);
                inicio.hide();
                this.men.Anadir.addActionListener(this);
                this.men.Buscar.addActionListener(this);
                agreg=new AgregarUI();
                agreg.contenedor();
                bus=new BuscarUI();
                bus.contenedor();
                agreg.btnAgregar.addActionListener(interfaz);
                agreg.comboCategorias.addActionListener(interfaz);
                bus.btnBuscar.addActionListener(interfaz);
            }else{
                inicio.error.setText("ERROR AL INICIAR SESION");
            }
        }
        if (evento == inicio.btnIgnore){
            men.Contenedor(0);
            men.setVisible(true);
        }
        if (evento == men.Anadir) {
            agreg.setVisible(true);
        }
        if (evento==men.Buscar) {
            bus.setVisible(true); 
        }
    }
    private class controlInterfaz implements ActionListener{
        Items[][] matriz={ropa,calzado,productosH,productosB,accesorios};
        @Override
        public void actionPerformed(ActionEvent e){
            Object evento=e.getSource();
            if(evento==agreg.btnAgregar){
                if("".equals(agreg.txtNombre.getText())||"".equals(agreg.campoCaracteristicas.getText())|| "".equals(agreg.campoCodigo.getText())||"".equals(agreg.campoMarca.getText())
                        ||"".equals(agreg.campoPrecio.getText())||"".equals(agreg.campoProveedor.getText())||agreg.comboCategorias.getSelectedItem()=="Seleccione"
                        ||agreg.comboSexo.getSelectedItem()=="Seleccione"|| agreg.comboTalla.getSelectedItem()=="Seleccione talla"){
                    JOptionPane.showMessageDialog(agreg,"DEBES LLENAR EL REGISTRO");
                }else {
                    for (int i = 0; i < 5; i++) {
                        itemtemp=user.Consultar(matriz[i], agreg.txtNombre.getText());
                        if (itemtemp!=null) {
                            break;
                        }
                    }
                    if (itemtemp!=null) {
                        JOptionPane.showMessageDialog(agreg, "NO PUEDES AGREGAR EL ITEM POR QUE YA UNO CON EL MISMO NOMBRE");
                    }else{
                        String cat=(String)agreg.comboCategorias.getSelectedItem();
                        switch(cat){
                            case "Zapateria":
                                if(vc>=50){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    calzado[vc]=user.Agregar(agreg);
                                    calzado[vc].Categoria="Zapateria";
                                    calzado[vc].MostrarInfo();
                                    vc++;
                                    JOptionPane.showMessageDialog(agreg, "AGREGADO EXITOSAMENTE");
                                }
                                break;
                            
                            case "Ropa":
                                if(vr>=50){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    ropa[vr]=user.Agregar(agreg);
                                    ropa[vr].Categoria="Ropa";
                                    ropa[vr].MostrarInfo();
                                    vr++;
                                    JOptionPane.showMessageDialog(agreg, "AGREGADO EXITOSAMENTE");
                                }
                                break;
                            
                            case "Productos de Belleza":
                            case "Productos del Hogar":
                            case "Accesorios":
                            default: System.out.println("thats great");
                        }
                        System.out.println("ok");
                    }
                }
            }
            if (evento==bus.btnBuscar) {
                if (bus.txtnombre.getText().equals("")&&bus.txtnombre.getText().equals("")) {
                    JOptionPane.showMessageDialog(bus, "INGTRESE UN CAMPO AL MENOS");
                }else{
                    if (!bus.txtnombre.getText().equals("")) {
                        for (int i = 0; i < 5; i++) {
                            itemtemp=user.Consultar(matriz[i], bus.txtnombre.getText());
                            if (itemtemp!=null) {
                                bus.txtdescripcion.setText(itemtemp.MostrarInfo());
                                break;
                            }
                        }
                    }
                    
                    if (!bus.txtcodigo.getText().equals("")) {
                        for (int i = 0; i < 5; i++) {
                            itemtemp=user.Consultar(matriz[i], bus.txtcodigo.getText());
                            if (itemtemp!=null) {
                                bus.txtdescripcion.setText(itemtemp.MostrarInfo());
                                break;
                            }
                        }
                    }
                }
            }
    
        }
    }
}
