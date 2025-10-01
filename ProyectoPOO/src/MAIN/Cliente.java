/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MAIN;

/**
 *
 * @author fabri
 */
public class Cliente extends Usuario{
    public Cliente(String nombre,String contrasenia){
        super(nombre,contrasenia);
    }
    
    public Items Agregar(){
        System.out.println("NO PUEDES AGREGAR");
        return null;
    }
    public void Eliminar(Items []inventario){
        System.out.println("NO PUEDES ELIMINAR");
    }
}
