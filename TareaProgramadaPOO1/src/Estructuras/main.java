/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Clases.Caja;

/**
 *
 * @author Alcides
 */

public class main {
     public static void main(String args[]) {
         Caja caja=new Caja(10000);
         ListaCarros lista=new ListaCarros(10,1500,caja);
         lista.ingresoVehiculo(9, 30, "Toyota", "979887");
         lista.sacar("979887", 11,30);
     }
}
