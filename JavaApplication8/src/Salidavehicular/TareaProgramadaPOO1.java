/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salidavehicular;

/**
 *
 * @author Marvin
 */

public class TareaProgramadaPOO1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        ListaSimple parqueo = new ListaSimple(10);//minimo carros variable que agarramos del input del cliente
        parqueo.AgregarCarro(new Carro("213422","hiunday",12,20));
        parqueo.imprimir();
        parqueo.sacarCarro("213422", 12, 35);
        parqueo.imprimir();
      
        
//        Salida carro = new Salida();
//        carro.crearTiquete();//metodo creado en la clase de ingreso
//        
//        if(carro.salir()){
//            System.out.print(carro.MostrarTiquete());
//            carro.saliendo();
//        }
//        
        //System.out.print(carro.crearTiquete());
        
    }
    
}
