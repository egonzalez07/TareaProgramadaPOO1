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
    public NodoFactura(Factura element, NodoFactura pNext){
        data=element;
        next=pNext;
    }
    public NodoFactura(Factura element){
        data = element;
    }
    public Factura getData() {
        return data;
    } 
}
