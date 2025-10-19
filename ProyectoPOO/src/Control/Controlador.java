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
    byte vac;
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
        vac=0;
        
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
            
            //detecta si es que estan llenos todos los campos de la interfaz
            if(evento==agreg.btnAgregar){
                if("".equals(agreg.txtNombre.getText())||"".equals(agreg.campoCaracteristicas.getText())|| "".equals(agreg.campoCodigo.getText())||"".equals(agreg.campoMarca.getText())
                        ||"".equals(agreg.campoPrecio.getText())||"".equals(agreg.campoProveedor.getText())||"".equals(agreg.campoCantidad.getText())||agreg.comboCategorias.getSelectedItem()=="Seleccione"
                        ||agreg.comboSexo.getSelectedItem()=="Seleccione"|| agreg.comboTalla.getSelectedItem()=="Seleccione talla"){
                    JOptionPane.showMessageDialog(agreg,"DEBES LLENAR EL REGISTRO");
                }else {
                    for (int i = 0; i < 5; i++) {
                        itemtemp=user.Consultar(matriz[i], agreg.txtNombre.getText());
                        if (itemtemp!=null) {
                            break;
                        }
                    }
                    //si es que elk item a agregar ya esta dentor de alguna categoria entonces no deja agregarlo
                    if (itemtemp!=null) {
                        JOptionPane.showMessageDialog(agreg, "NO PUEDES AGREGAR EL ITEM POR QUE YA UNO CON EL MISMO NOMBRE");
                    }else{
                        String cat=(String)agreg.comboCategorias.getSelectedItem();
                        switch(cat){
                            //se podria simplificar en una fncion que reciba unicamente el contador y el vector 
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
                                if(vpb>=50){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    ropa[vpb]=user.Agregar(agreg);
                                    ropa[vpb].Categoria="Ropa";
                                    ropa[vpb].MostrarInfo();
                                    vpb++;
                                    JOptionPane.showMessageDialog(agreg, "AGREGADO EXITOSAMENTE");
                                }
                                break;
                                
                            case "Productos del Hogar":
                                if(vph>=50){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    ropa[vph]=user.Agregar(agreg);
                                    ropa[vph].Categoria="Ropa";
                                    ropa[vph].MostrarInfo();
                                    vph++;
                                    JOptionPane.showMessageDialog(agreg, "AGREGADO EXITOSAMENTE");
                                }
                                break;
                                
                            case "Accesorios":
                                if(vac>=50){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    ropa[vac]=user.Agregar(agreg);
                                    ropa[vac].Categoria="Ropa";
                                    ropa[vac].MostrarInfo();
                                    vac++;
                                    JOptionPane.showMessageDialog(agreg, "AGREGADO EXITOSAMENTE");
                                }
                                break;
                                
                            default: System.out.println("thats great");
                        }
                        System.out.println("ok");
                    }
                }
            }
            //acciones del evento buscar
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
