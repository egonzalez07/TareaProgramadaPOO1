/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Clases.Factura;

/**
 *
 * @author Alcides
 */
public class NodoFactura {
    public NodoFactura next;
    private Factura data;
    //crea un nodo con un puntero directo a otro
    public NodoFactura(Factura element, NodoFactura pNext){
        data=element;
        next=pNext;
    }
    //crea un nodo
    public NodoFactura(Factura element){
        data = element;
    }
    //metodo que regresa la informacion del nodo
    public Factura getData() {
        return data;
    } 
}
