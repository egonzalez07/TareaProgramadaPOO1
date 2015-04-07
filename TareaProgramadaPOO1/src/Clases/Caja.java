/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import javax.swing.JOptionPane;
/**
 *
 * @author Marvin
 */
public class Caja {
    int dinero;
    public Caja(){}
    
    public int getDinero(){
        return this.dinero;
    }
    public void agregarDinero(int dinero){
        this.dinero += dinero;
    }
    public void sacarDinero(int dinero){
        
        if(this.dinero>dinero){this.dinero -= dinero;}   
        JOptionPane.showMessageDialog(null,"No hay dinero");
    }   
}
