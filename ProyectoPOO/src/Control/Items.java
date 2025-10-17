package Control;
import java.io.*;

public class Items {
    public String NombreProd, Marca;
    public String Categoria;
    public float Precio;
    public short Cantidad;
    public String Talla;
    public String Sexo;
    public String Proveedor;
    public String CodigoProd;
    public float Oferta;
    public File DirImagen;
    public void MostrarInfo(){
        System.out.println("NombreProd = " + NombreProd);
        System.out.println("Categoria = " + Categoria);
        System.out.println("Talla = " + Talla);
        System.out.println("Sexo = " + Sexo);
        System.out.println("Precio = " + Precio);
        System.out.println("Marca = " + Marca);
        System.out.println("Proveedor = " + Proveedor);
        System.out.println("CodigoProd = " + CodigoProd);
        System.out.println("Cantidad = " + Cantidad);
        
    }
}
