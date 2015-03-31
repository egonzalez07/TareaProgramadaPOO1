/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Clases.Carro;

/**
 *
 * @author alralaos
 */
public class Nodo {
    public Nodo next;
    private Carro data;
    public Nodo(Carro element, Nodo pNext){
        data=element;
        next=pNext;
    }
    public Nodo(Carro element){
        data = element;
    }
    public Carro getData() {
        return data;
    } 
    public void setData(Carro pData) {
        data = pData;
    }   
}
