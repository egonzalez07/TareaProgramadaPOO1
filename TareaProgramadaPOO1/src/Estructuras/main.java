/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Clases.Caja;
import org.jespxml.JespXML;

/**
 *
 * @author Alcides
 */
public class main {
    public static void main(String args[]) {
        Caja caja=new Caja(10000);
        ListaCarros lista=new ListaCarros(10,1500,caja);
        lista.ingresoVehiculo(21,52,"Toyota","958741");
        lista.sacar("958741",22,00);
    }
}
