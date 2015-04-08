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
public class NodoCarro {
    public NodoCarro next;
    private Carro data;
    //crea un nodo apuntando a otro de una vez
    public NodoCarro(Carro element, NodoCarro pNext){
        data=element;
        next=pNext;
    }
    //crea un nodo
    public NodoCarro(Carro element){
        data = element;
    }
    //regresa el valor que contiene el nodo
    public Carro getData() {
        return data;
    } 
    //cambia el valor del nodo
    public void setData(Carro pData) {
        data = pData;
    }   
}
