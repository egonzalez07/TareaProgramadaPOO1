/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Clases.Carro;
import Estructuras.Nodo;
import java.util.Scanner;

/**
 *
 * @author alralaos
 */
public class ListaSimple {
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int size;
    private int tarifa ;
    private int topeNodo;
     Scanner sc = new Scanner(System.in);
    
    public ListaSimple(int pTopeNodo,int tarifa){
        primerNodo=ultimoNodo=null;
        topeNodo=pTopeNodo;
        this.tarifa = tarifa;
        size=0;
    }
    public void sacar(String placa,int horaSalida,int minutoSalida) {
        Nodo nodoActual=primerNodo;
        while(nodoActual.getData().getPlaca()!=placa){
            nodoActual=nodoActual.next;
        }
        int horaEntrada=nodoActual.getData().getHora();
        int minutoEntrada=nodoActual.getData().getMinutos();
        nodoActual=new Nodo(new Carro(true),nodoActual.next);
        size--;
        mostrarCobro(tarifa, horaEntrada, minutoEntrada, horaSalida, minutoSalida);
    }
    public int mostrarCobro(int tarifa, int horaEntrada, int minutoEntrada, int horaSalida, int minutoSalida){
        
        int horas,minutos,cobroHoras,cobroMinutos,montoPagar = 0;
        if ((horaSalida==horaEntrada)&&(minutoSalida==minutoEntrada)){//Un dia entero exacto
            montoPagar = tarifa*24;
            return montoPagar;
        }        
        if((horaSalida<horaEntrada)&&(minutoSalida<minutoEntrada)){//Significa que se ha pasado a un dia siguiente
            //EJ: 9:30-6:20
            
            horas = 24-(horaEntrada-horaSalida)-1;
            minutos = 60-(minutoEntrada-minutoSalida);
            if (0<minutos && minutos<16)     // entre 1 y 15              
                minutos = 15;
        
            if(15<minutos && minutos<31)      //entre 16 y 30
                minutos = 30;
        
            if (30<minutos&& minutos<46)    //entre 31 y 45
                minutos = 45;
            
            else if (minutos>45) //entre 46 y 59
                minutos = 0;
                horas ++;
                
            cobroHoras = horas*tarifa; 
            cobroMinutos = cobrarMinutos(minutos);//Llamada a la funcion que calcula el cobro de minutos
            montoPagar =  cobroHoras + cobroMinutos; 
        }
        
        if((horaSalida<horaEntrada)&&(minutoSalida>minutoEntrada)){     //Significa que se ha pasado a un dia siguiente
            
            horas = 24-(horaEntrada-horaSalida);
            minutos = 60-(minutoEntrada + (60-minutoSalida));
            if (0<minutos && minutos<16)     // entre 1 y 15              
                minutos = 15;
        
            if(15<minutos && minutos<31)      //entre 16 y 30
                minutos = 30;
        
            if (30<minutos&& minutos<46)    //entre 31 y 45
                minutos = 45;
            
            else if (minutos>45) //entre 46 y 59
                minutos = 0;
                horas ++;
                
            cobroHoras = horas*tarifa; 
            cobroMinutos = cobrarMinutos(minutos);//Llamada a la funcion que calcula el cobro de minutos
            montoPagar =  cobroHoras + cobroMinutos; 
        }
        
        
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
                
            cobroHoras = horas*tarifa; 
            cobroMinutos = cobrarMinutos(minutos);//Llamada a la funcion que calcula el cobro de minutos
            montoPagar =  cobroHoras + cobroMinutos;
        }
        if (minutoEntrada == minutoSalida){//EJ: 1:37, 2:37
            horas = (horaSalida-horaEntrada);
            montoPagar = horas * tarifa;
            
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
                horas ++ ;

            cobroHoras = horas * tarifa;
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

            cobroHoras = horas * tarifa;
            cobroMinutos = cobrarMinutos(minutos);//Llamada a la funcion que calcula el cobro de minutos
            montoPagar = cobroHoras+cobroMinutos;
        
        }
        System.out.print("Su deuda es de "+montoPagar);//Imprime el monto en pantalla

        //Esta es la opcion de interfaz que es  para poder pagar el parqueo   
        System.out.print("\nIngreso dinero para cancelar: ");
        int dinero = sc.nextInt();
        return HacerPago(montoPagar, dinero);
        
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
    
    public int  cobrarMinutos(int minutos){
        int precio = 0;
        if (minutos == 0) precio = 0;
        if(minutos == 15) precio = tarifa/4;       
        if(minutos == 30) precio = tarifa/2;
        if (minutos == 45)  precio =  tarifa-(tarifa/4);   
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
            if (aux.getData().equals(dato))
                return true;
            else
                aux = aux.next;
            
            
        }
        return false;
    }

    public void imprimir(){//   Mediante interfaz que muestre el estado del parqueo
      
        Nodo aux = primerNodo;
        while(aux!=null){
            System.out.print(aux.getData()+" ");
            aux = aux.next;
        }
        System.out.print("\n");
    }
    
}
