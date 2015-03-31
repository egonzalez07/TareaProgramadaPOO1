/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salidavehicular;

import java.util.Scanner;

/**
 *
 * @author Marvin
 */
public class ListaSimple {
    public Nodo primerNodo;
    public Nodo ultimoNodo;
    int size;
    private  final int  topeNodo;
    Scanner sc = new Scanner(System.in);
    
    public ListaSimple(int pTopeNodo){
        primerNodo=ultimoNodo=null;
        topeNodo=pTopeNodo;
        size=0;
    }
    
    public void sacarCarro(String placa, int horaSalida, int minutoSalida) {
        Nodo nodoActual=primerNodo;
        while(!nodoActual.getDato().getPlaca().equals(placa)){
        //while(nodoActual.getDato().getPlaca()!=placa){
            nodoActual=nodoActual.next;
        }
        int horaEntrada=nodoActual.getDato().getHora();
        int minutoEntrada=nodoActual.getDato().getMinutos();
        nodoActual=new Nodo(new Carro(true),nodoActual.next);
        size--;
        mostrarCobro(horaEntrada, minutoEntrada, horaSalida, minutoSalida);   
    }
    
    //Funcion que realiza el pago del parqueo
    
    public int HacerPago(int deuda, int dinero){
        int vuelto=0 ;
        if(dinero>=deuda){
            vuelto = dinero-deuda;
            //System.out.print("Cancelado"+vuelto);//JOption pane
        }else{
            System.out.print("Dinero insuficiente");
        }
        return vuelto;
    }
    
    //Funcion que determina la deuda en el parqueo
    
    public int mostrarCobro(int horaEntrada, int minutoEntrada, int horaSalida, int minutoSalida){
        
        int horas,minutos,cobroHoras,cobroMinutos,montoPagar = 0;
                if(horaEntrada == horaSalida){//EJ:12:3 , 12:51

            horas = 0;
            minutos = minutoSalida-minutoEntrada;
            if (0<minutos && minutos<16)     // entre 1 y 15              
                minutos = 15;
        
            if(15<minutos && minutos<31)      //entre 16 y 30
                minutos = 30;
        
            if (30<minutos&& minutos<46)    //entre 31 y 45
                minutos = 45;
            
            else if (minutos>45) //entre 46 y 59
                minutos = 0;
                horas ++;
                
            cobroHoras = horas*1500; 
            cobroMinutos = cobrarMinutos(minutos);//Llamada a la funcion que calcula el cobro de minutos
            montoPagar =  cobroHoras + cobroMinutos;
        }
        if (minutoEntrada == minutoSalida){//EJ: 1:37, 2:37
            horas = (horaSalida-horaEntrada);
            montoPagar = horas * 1500;
            
        }if(minutoEntrada>minutoSalida){//EJ: 1:45, 4:23
            horas = (horaSalida-horaEntrada)-1;
            minutos = (60-minutoEntrada)+minutoSalida;
            if (0<minutos && minutos<16)     // entre 1 y 15           
                minutos = 15;
        
            if(15<minutos && minutos<31)        //entre 16 y 30
                minutos = 30;
        
            if (30<minutos&& minutos<46)    //entre 31 y 45
                minutos = 45;
            
            else if (minutos > 45)  //entre 46 y 59
                minutos = 0;
                horas ++;

            cobroHoras = horas * 1500;
            cobroMinutos = cobrarMinutos(minutos);
            montoPagar = cobroHoras+cobroMinutos;
        
        }else if (minutoSalida>minutoEntrada){//EJ: 1:20, 2:45
            horas = (horaSalida-horaEntrada);
            minutos = minutoSalida-minutoEntrada;
            if (0<minutos && minutos<16)    // entre 1 y 15
                minutos = 15;    
        
            if(15<minutos && minutos<31)     //entre 16 y 30
                minutos = 30; 
        
            if (30<minutos&& minutos<46)    //entre 31 y 45
                minutos = 45;
            
            else if (minutos > 45) //entre 46 y 59
                minutos = 0;
                horas ++;

            cobroHoras = horas * 1500;
            cobroMinutos = cobrarMinutos(minutos);//Llamada a la funcion que calcula el cobro de minutos
            montoPagar = cobroHoras+cobroMinutos;
        
        }
        System.out.print("Su deuda es de "+montoPagar);//Imprime el monto en pantalla

        //Esta es la opcion de interfaz que es  para poder pagar el parqueo   
        System.out.print("\nIngreso dinero para cancelar: ");
        int dinero = sc.nextInt();
        return HacerPago(montoPagar, dinero);
        
    }
    public int  cobrarMinutos(int minutos){
        int precio = 0;
        if (minutos == 0) precio = 0;
        if(minutos == 15) precio = 375;       
        if(minutos == 30) precio = 750;
        if (minutos==45)  precio =  1125;   
        return precio;
    }

    public void AgregarCarro(Carro info){ //elka
        Nodo nuevo = new Nodo(info);
        if (size == 0){
            primerNodo = ultimoNodo = nuevo ;
            size ++;
        }
        else{//recorrerlo y donde este un carro vacio colocarlo alli
            ultimoNodo.next = nuevo;
            ultimoNodo = ultimoNodo.next;
            size++;
        }
    }
    //metodo booleano que busca carros
    
    public boolean encontrado(Carro dato){
        
        Nodo aux = primerNodo;
        while(aux!=null){
            if (aux.getDato().equals(dato))
                return true;
            else
                aux = aux.next;
            
            
        }
        return false;
    }

    public void imprimir(){//   Mediante interfaz que muestre el estado del parqueo
      
        Nodo aux = primerNodo;
        while(aux!=null){
            System.out.print(aux.getDato()+" ");
            aux = aux.next;
        }
        System.out.print("\n");
    }
}
