/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Clases.Carro;
import Estructuras.Nodo;

/**
 *
 * @author alralaos
 */
public class ListaSimple {
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int size;
    private int topeNodo;
    public ListaSimple(int pTopeNodo){
        primerNodo=ultimoNodo=null;
        topeNodo=pTopeNodo;
        size=0;
    }
    public void sacar(String placa,int horaSalida,int minutoSalida) {
        Nodo nodoactual=primerNodo;
        while(nodoactual.getData().getPlaca()!=placa){
            nodoactual=nodoactual.next;
        }
        int horaEntrada=nodoactual.getData().getHora();
        int minutoEntrada=nodoactual.getData().getMinutos();
        nodoactual=new Nodo(new Carro(true),nodoactual.next);
        size--;
    }
}
