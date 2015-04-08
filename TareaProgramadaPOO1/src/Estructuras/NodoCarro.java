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
    public NodoCarro(Carro element, NodoCarro pNext){
        data=element;
        next=pNext;
    }
    public NodoCarro(Carro element){
        data = element;
    }
    public Carro getData() {
        return data;
    } 
    public void setData(Carro pData) {
        data = pData;
    }   
}
