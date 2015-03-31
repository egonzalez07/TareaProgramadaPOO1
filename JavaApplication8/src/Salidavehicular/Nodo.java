/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salidavehicular;

/**
 *
 * @author Marvin
 */
public class Nodo {
    public Nodo next;
    private Carro  data;
    int size;
    
    public Nodo(Carro element, Nodo pNext){
        
        this.data=element;
        this.next=pNext;
        
    }
    public Nodo(Carro element){
        data = element;
    }
    public void setDato(Carro pData){
        this.data  = pData;
    }
    public Carro  getDato(){
        return this.data;
    }
   
}
