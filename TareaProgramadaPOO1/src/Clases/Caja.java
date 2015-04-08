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
    //crea una caja con un monto especifico
    public Caja(int monto){
    }
    //regresa el monto que se tiene
    public int getDinero(){
        return this.dinero;
    }
    //se agrega el dinero al monto existente
    public void agregarDinero(int dinero){
        this.dinero += dinero;
    }
    //retirar dinero de la caja
    public void sacarDinero(int dinero){
        
        if(this.dinero>dinero){this.dinero -= dinero;}   
        JOptionPane.showMessageDialog(null,"No hay dinero");
    }   
}
