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
    EliminarUI elim;
    
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
        
        if (evento == inicio.borrar||evento==inicio.borrar2){
            inicio.txtUser.setText("");
            inicio.txtPass.setText("");
        }
        if (evento == inicio.btnLogin){
            if((user.Usuario).equals(inicio.txtUser.getText()) && (user.Contrasenia).equals(inicio.txtPass.getText())){
                men.Contenedor(1);
                men.setVisible(true);
                inicio.hide();
                this.men.Anadir.addActionListener(this);
                this.men.Buscar.addActionListener(this);
                this.men.Eliminar.addActionListener(this);
                agreg=new AgregarUI();
                agreg.contenedor();
                
                bus=new BuscarUI();
                bus.contenedor();
                
                elim=new EliminarUI();
                elim.contenedor();
                
                agreg.btnAgregar.addActionListener(interfaz);
                agreg.comboCategorias.addActionListener(interfaz);
                bus.btnBuscar.addActionListener(interfaz);
                elim.btnbuscar.addActionListener(interfaz);
                elim.btneliminar.addActionListener(interfaz);
                
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
        if (evento==men.Eliminar){
            elim.setVisible(true);
            System.out.println("HOLA");
        }
    }

    public static byte validar(Items [] arreglo, byte contador, String cat, Administrador admin, AgregarUI agreg){
        arreglo[contador]=admin.Agregar(agreg);
        arreglo[contador].Categoria=cat;
        contador++;
        JOptionPane.showMessageDialog(agreg, "AGREGADO EXITOSAMENTE");
        return contador;
    }
    private class controlInterfaz implements ActionListener{
        Items[][] matriz={ropa,calzado,productosH,productosB,accesorios};
        String vacio="";
        String catego;
        
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
                                    vc=validar(calzado,vc,"Zapateria",user,agreg);
                                }
                                break;
                            
                            case "Ropa":
                                if(vr>=50){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    vr=validar(ropa,vr,"Ropa",user,agreg);
                                }
                                break;
                            
                            case "Productos de Belleza":
                                if(vpb>=50){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    vpb = validar(productosB, vpb, "Prodcutos de Belleza", user, agreg);
                                }
                                break;
                                
                            case "Productos del Hogar":
                                if(vph>=50){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    vph = validar(productosH, vph, "Productos del Hogar", user, agreg);
                                }
                                break;
                                
                            case "Accesorios":
                                if(vac>=50){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    vac = validar(accesorios, vac, "Accesorios", user, agreg);
                                }
                                break;
                                
                            default: System.out.println("thats great");
                        }
//                        agreg.txtNombre.setText("");
//                        agreg.campoPrecio.setText("");
//                        agreg.campoMarca.setText("");
//                        agreg.campoProveedor.setText("");
//                        agreg.campoCodigo.setText("");
//                        agreg.campoCaracteristicas.setText("");
//                        agreg.campoCantidad.setText("");
                        System.out.println("ok");
                    }
                }
            }
            //acciones del evento buscar
            if (evento==bus.btnBuscar) {
                bus.txtdescripcion.setText(vacio);
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
            //si evento es igual a liminar
            if (evento==elim.btnbuscar) {
                elim.txtdescripcion.setText(vacio);
                if (elim.txtcodigo.getText().equals("")){
                    JOptionPane.showMessageDialog(elim, "INGRESE UN CAMPO AL MENOS");
                }else{
                    itemtemp=null;
                    for (int i = 0; i < 5; i++) {
                        itemtemp=user.Consultar(matriz[i], Integer.parseInt(elim.txtcodigo.getText()));
                        if (itemtemp!=null) {
                            elim.txtdescripcion.setText(itemtemp.MostrarInfo());
                            elim.add(elim.btneliminar);
                            elim.repaint();
                            catego=itemtemp.Categoria;
                            break;
                        }
                    }
                    if (itemtemp==null) {
                        JOptionPane.showMessageDialog(elim, "NO SE ENCONTRO EL ITEM");
                    }
                }
            }
            if (evento==elim.btneliminar) {
                int x=Integer.parseInt(elim.txtcodigo.getText());
                switch(catego){
                    case "Zapateria":
                        if(user.Eliminar(calzado,x,vc)){
                            vc--;
                        }
                        break;

                    case "Ropa":
                        //ropa=user.Eliminar(ropa,x,vr);
                        vr--;
                        break;

                    case "Productos de Belleza":
                        //productosB=user.Eliminar(productosB,x,vpb);
                        vpb--;
                        break;

                    case "Productos del Hogar":
                        //productosH=user.Eliminar(productosH,x,vph);
                        vph--;
                        break;

                    case "Accesorios":
                        //accesorios=user.Eliminar(accesorios,x,vac);
                        vac--;
                        break;
                    default: System.out.println("thats great");
                }
            }
        }
    }
}
