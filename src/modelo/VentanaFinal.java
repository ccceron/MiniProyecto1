/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Modelo.PanelFondo;


public class VentanaFinal extends PanelFondo {
    
     public PanelFondo jpFondoFinal;
    
    public VentanaFinal(String nombre) {
        super(nombre);
        
    }
       
        


public void componentes(){
    
        jpFondoFinal = new PanelFondo("/modelo/fondo2.png"); 
        jpFondoFinal.setSize(700,500);     
        jpFondoFinal.setLayout(null);
        add(jpFondoFinal);
        
}

}