/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;
/**
 *
 * @author Marvin
 */

public class EntradaSalidaEfectivo {
    
    Caja caja;        
    XML xml=new XML();
    String contraseñaAdministrador = xml.leerContraseña();
    
    public EntradaSalidaEfectivo(Caja caja){this.caja = caja;}
      
    /*Entradas: un monto, una contraseña
    Salida Se hace un ingreso de dinero
    Restricciones: Las contraseñas deben ser iguales*/
    public void ingresarDinero(int monto,String contraseña){
        if(contraseña.equals(contraseñaAdministrador)){ caja.agregarDinero(monto);} 
        JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
    }
    /*Entradas: un monto, una contraseña
    Salida Se hace u retiro de dinero
    Restricciones: Las contraseñas deben ser iguales*/
    public void retirarDinero(int monto, String contraseña){
        if(contraseña.equals(contraseñaAdministrador)){
           
            if (caja.getDinero()>=monto){caja.sacarDinero(monto);}
            JOptionPane.showMessageDialog(null,"Fondos insuficientes");
            
        }JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden");
    }
}
