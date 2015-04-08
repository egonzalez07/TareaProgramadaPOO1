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

public class EntradaSalidaEfectivo {
    
    Caja caja;
    String contraseñaAdministrador;
    public EntradaSalidaEfectivo(){}
    
    public void ingresarDinero(int monto,String contraseña){
        if(contraseña.equals(contraseñaAdministrador)){ caja.agregarDinero(monto);} 
        JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
    }
    public void retirarDinero(int monto, String contraseña){
        if(contraseña.equals(contraseñaAdministrador)){
           
            if (caja.getDinero()>=monto){caja.sacarDinero(monto);}
            JOptionPane.showMessageDialog(null,"Fondos insuficientes");
            
        }JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
    }
}
