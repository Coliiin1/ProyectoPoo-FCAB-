package Control;
import GUI.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author fabri
 */
public class Controlador implements ActionListener{
    IniciodeSesion inicio;
    Administrador user=new Administrador("ADMIN","12345");
    ControlArchivos con=new ControlArchivos();
    AgregarUI agreg;
    MenuPrincipal men;
    BuscarUI bus;
    controlInterfaz interfaz;
    EliminarUI elim;
    ModificarUI modi;
    
    Items itemtemp;
    Items itemtemp1;
    
    Items[] ropa;
    Items[] calzado;
    Items[] productosB;
    Items[] productosH;
    Items[] accesorios;
    
    Items[][] matriz={ropa,calzado,productosH,productosB,accesorios};
    
    

    int vr;
    int vc;
    int vpb;
    int vph;
    int vac;
    
    
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
        
        interfaz=new controlInterfaz();
        inicio=new IniciodeSesion();
        inicio.Contenedor();
        inicio.setVisible(true);
        men=new MenuPrincipal();
        this.inicio.btnLogin.addActionListener(this);
        this.inicio.borrar.addActionListener(this);
        this.inicio.btnIgnore.addActionListener(this);
    }
    public static void main(String args[]){
        Controlador control=new Controlador();
        //System.out.println("\nAsh nazg durbatulûk, ash nazg gimbatul, ash nazg thrakatulûk agh burzum-ishi krimpatul");
        System.out.println(control.vc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evento= e.getSource();
        
        if (evento == inicio.borrar){
            inicio.txtUser.setText("");
            inicio.txtPass.setText("");
        }
        if (evento == inicio.btnLogin){
            if((user.Usuario).equals(inicio.txtUser.getText()) && (user.Contrasenia).equals(inicio.txtPass.getText())){
                men.Contenedor(1);
                men.mostrarItems(matriz);
                men.setVisible(true);
                //inicio.hide();
                inicio.dispose();
                this.men.Anadir.addActionListener(this);
                this.men.Buscar.addActionListener(this);
                this.men.Eliminar.addActionListener(this);
                this.men.Modificar.addActionListener(this);
                this.men.Guardar.addActionListener(interfaz);
                agreg=new AgregarUI();
                agreg.contenedor();
                
                bus=new BuscarUI();
                bus.contenedor();
                
                elim=new EliminarUI();
                elim.contenedor();
                
                modi=new ModificarUI();
                modi.contenedormodi();
                modi.modifi();
                
                agreg.btnAgregar.addActionListener(interfaz);
                agreg.comboCategorias.addActionListener(interfaz);
                bus.btnBuscar.addActionListener(interfaz);
                elim.btnbuscar.addActionListener(interfaz);
                elim.btneliminar.addActionListener(interfaz);
                modi.btnbuscar.addActionListener(interfaz);
                modi.btnmodificar.addActionListener(interfaz);
            }else{
                inicio.error.setText("ERROR AL INICIAR SESION");
            }
        }
        if (evento == inicio.btnIgnore){
            men.Contenedor(0);
            men.InicioSesion.addActionListener(this);
            men.mostrarItems(matriz);
            inicio.hide();
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
        }
        if (evento==men.Modificar){
            modi.setVisible(true);
        }
        if (evento==men.InicioSesion) {
            inicio.setVisible(true);
            
        }
    }

    public static int validar(Items [] arreglo, int contador, String cat, Administrador admin, AgregarUI agreg){
        arreglo[contador]=admin.Agregar(agreg);
        arreglo[contador].Categoria=cat;
        contador++;
        JOptionPane.showMessageDialog(agreg, "AGREGADO EXITOSAMENTE");
        return contador;
    }
    public static int validarCont(Items [] inventario){
        int num=0;
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i]==null) {
                return num;
            }else{
                num++;
            }
        }
        return num;
    }
    
    private void AdaptarImagen(JLabel label, String ruta) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(newImg));
    }
    
    private class controlInterfaz implements ActionListener{
        String vacio="";
        String catego;
        final String[] tallas1 = {"Seleccione talla", "XS", "S", "M", "L", "XL"};
        final String[] tallas2 = {"Seleccione talla", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27"};
        public controlInterfaz(){
            matriz=con.leerDatos("src/Archivos/DATOS.dat", 5, 50);
            ropa         = matriz[0];
            calzado      = matriz[1];
            productosH   = matriz[2];
            productosB   = matriz[3];
            accesorios   = matriz[4];
            
            vr=validarCont(ropa);
            vc=validarCont(calzado);
            vph=validarCont(productosH);
            vpb=validarCont(productosB);
            vac=validarCont(accesorios);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if(matriz[i][j]!=null){
                        System.out.println(i+j+matriz[i][j].NombreProd);
                    }
                }
            }
            Object evento=e.getSource();
            //detecta si es que estan llenos todos los campos de la interfaz
            if(evento==agreg.btnAgregar){
                if("".equals(agreg.txtNombre.getText())||"".equals(agreg.campoCaracteristicas.getText())|| "".equals(agreg.campoCodigo.getText())||"".equals(agreg.campoMarca.getText())
                        ||"".equals(agreg.campoPrecio.getText())||"".equals(agreg.campoProveedor.getText())||"".equals(agreg.campoCantidad.getText())||agreg.comboCategorias.getSelectedItem()=="Seleccione"
                        ||agreg.comboSexo.getSelectedItem()=="Seleccione"|| agreg.comboTalla.getSelectedItem()=="Seleccione talla"||agreg.rutaImagenSeleccionada==null){
                    JOptionPane.showMessageDialog(agreg,"DEBES LLENAR EL REGISTRO");
                }else {
                    for (int i = 0; i < 5; i++) {
                        itemtemp=user.Consultar(matriz[i], agreg.txtNombre.getText());
                        itemtemp1=user.Consultar(matriz[i], Integer.parseInt(agreg.campoCodigo.getText()));
                        if (itemtemp!=null||itemtemp1!=null) {
                            break; 
                        }
                    }
                    //si es que elk item a agregar ya esta dentor de alguna categoria entonces no deja agregarlo
                    if (itemtemp!=null||itemtemp1!=null) {
                        JOptionPane.showMessageDialog(agreg, "NO PUEDES AGREGAR EL ITEM POR QUE YA UNO CON EL MISMO NOMBRE");
                    }else{
                        boolean added = false;
                        String cat=(String)agreg.comboCategorias.getSelectedItem();
                        ControlArchivos control=new ControlArchivos();
                        agreg.ruta=control.copiarArchivos(agreg.f);
                        switch(cat){
                            case "Zapateria":
                                if(vc>=calzado.length){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    vc=validar(calzado,vc,"Zapateria",user,agreg);
                                    added = true;
                                }
                                break;
                            
                            case "Ropa":
                                if(vr>=ropa.length){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    vr=validar(ropa,vr,"Ropa",user,agreg);
                                    added = true;
                                }
                                break;
                            
                            case "Productos de Belleza":
                                if(vpb>=productosB.length){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    vpb = validar(productosB, vpb, "Prodcutos de Belleza", user, agreg);
                                    added = true;
                                }
                                break;
                                
                            case "Productos del Hogar":
                                if(vph>=productosH.length){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    vph = validar(productosH, vph, "Productos del Hogar", user, agreg);
                                    added = true;
                                }
                                break;
                                
                            case "Accesorios":
                                if(vac>=accesorios.length){
                                    JOptionPane.showMessageDialog(agreg,"YA NO PUEDES AGREGAR MAS ITEMS");
                                }else{
                                    vac = validar(accesorios, vac, "Accesorios", user, agreg);
                                    added = true;
                                }
                                break;
                                
                            default: System.out.println("ESTO NO DEBERIA PASAR JAJAJ SALUDOS DESDE MI casa");
                        }
                        if (added && men != null) {
                            men.mostrarItems(matriz);
                            men.revalidate();
                            men.repaint();
                        }
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
                                AdaptarImagen(bus.labelImagen, itemtemp.DirImagen);
                                break;
                            }
                        }
                    }
                    
                    if (!bus.txtcodigo.getText().equals("")) {
                        for (int i = 0; i < 5; i++) {
                            itemtemp=user.Consultar(matriz[i], bus.txtcodigo.getText());
                            if (itemtemp!=null) {
                                bus.txtdescripcion.setText(itemtemp.MostrarInfo());
                                AdaptarImagen(bus.labelImagen, itemtemp.DirImagen);
                                break;
                            }
                        }
                    }
                }
            }
            //si evento es igual a liminar
            String code;
                elim.txtdescripcion.setText(vacio);
                elim.box.removeAllItems();
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        if(matriz[i][j]!=null){
                            code=matriz[i][j].CodigoProd;
                            elim.box.addItem(code);
                        }
                    }
                }
            if (evento==elim.btnbuscar) {
                
                if (elim.txtcodigo.getText().equals("")){
                    JOptionPane.showMessageDialog(elim, "INGRESE UN CAMPO AL MENOS");
                }else{
                    itemtemp=null;
                    for (int i = 0; i < 5; i++) {
                        itemtemp=user.Consultar(matriz[i], Integer.parseInt(elim.txtcodigo.getText()));
                        if (itemtemp!=null) {
                            elim.txtdescripcion.setText(itemtemp.MostrarInfo());
                            //AdaptarImagen(elim.Img, itemtemp.DirImagen);
                            elim.add(elim.btneliminar);
                            elim.repaint();
                            catego=itemtemp.Categoria;
                            AdaptarImagen(elim.Img, itemtemp.DirImagen);
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
                boolean deleted = false;
                switch(catego){
                    case "Zapateria":
                        if(user.Eliminar(calzado,x,vc)){
                            vc--;
                            deleted = true;
                        }
                        break;
                    case "Ropa":
                        if(user.Eliminar(ropa,x,vr)){
                            vr--;
                            deleted = true;
                        }
                        break;

                    case "Productos de Belleza":
                        if(user.Eliminar(productosB,x,vpb)){
                            vpb--;
                            deleted = true;
                        }
                        break;

                    case "Productos del Hogar":
                        if(user.Eliminar(productosH,x,vph)){
                            vph--;
                            deleted = true;
                        }
                        break;
                    case "Accesorios":
                        if(user.Eliminar(accesorios,x,vac)){
                            vac--;
                            deleted = true;
                        }
                        break;
                    default: System.out.println("thats great");
                }
                if (deleted && men != null) {
                    men.mostrarItems(matriz);
                    men.revalidate();
                    men.repaint();
                }
            }
            //MODIFICA4R
            if (evento==modi.btnbuscar&&!modi.txtcodigo.getText().equals("")) {
                for (int i = 0; i < 5; i++) {
                    itemtemp=user.Consultar(matriz[i], Integer.parseInt(modi.txtcodigo.getText()));
                    if (itemtemp!=null) {
                        if (itemtemp.Categoria.equals("Zapateria") ){
                        //comboCategorias.setSelectedItem(tallas2);
                        modi.comboTalla.removeAllItems();
                            for (String talla : tallas2) {
                                modi.comboTalla.addItem(talla);
                            } 
                        modi.add(modi.comboTalla);
                        } else if(itemtemp.Categoria.equals("Ropa")){
                            modi.comboTalla.removeAllItems();
                            for (String talla : tallas1) {
                                modi.comboTalla.addItem(talla);
                            }
                        } else {
                            modi.comboTalla.removeAllItems();
                        }
                        modi.add(modi.comboTalla);
                        
                        modi.txtNombre.setText(itemtemp.NombreProd);
                        modi.campoPrecio.setText(Float.toString(itemtemp.Precio));
                        modi.campoMarca.setText(itemtemp.Marca);
                        modi.campoProveedor.setText(itemtemp.Proveedor);
                        modi.campoCodigo.setText(itemtemp.CodigoProd);
                        modi.campoCaracteristicas.setText(itemtemp.Caracteristicas);
                        modi.campoCantidad.setText(Short.toString(itemtemp.Cantidad));
                        modi.txtdescripcion.setText(itemtemp.MostrarInfo());

//                        modi.limpiarCampos();
                        modi.revalidate();
                        modi.repaint();
                        break;
                    }
                }
                if (itemtemp==null) {
                    modi.limpiarCampos();
                    JOptionPane.showMessageDialog(modi, "NO SE ENCONTRO UN ITEM CON EL CODIGO "+modi.txtcodigo.getText(), "NO SE ENCONTRO", 3);
                }
            }
            String categoria="";
            String direccion="";
            if (evento==modi.btnmodificar) {
                if (modi.comboSexo.getSelectedItem()!="Seleccione" && modi.comboTalla.getSelectedItem()!="Seleccione talla") {
                    for (int i = 0; i < matriz.length; i++) {
                    itemtemp=user.Consultar(matriz[i], Integer.parseInt(modi.txtcodigo.getText()));
                    if (itemtemp!=null) {
                        direccion=itemtemp.DirImagen; 
                        categoria=itemtemp.Categoria;
                    }
                }
                user.Modificar(matriz, modi, direccion,categoria);
                modi.limpiarCampos();
                if (men != null) {
                    men.mostrarItems(matriz);
                    men.revalidate();
                    men.repaint();
                    }
                }else{
                    JOptionPane.showMessageDialog(inicio, "DEBES AGREVARLE LA TALLA Y EL SEXO", "NO SELECCIONADO", 2);
                }
            }
            if (evento==men.Guardar) {
                con.guardarDatos("src\\Archivos\\DATOS.dat", matriz);
            }
        }
    }
}
