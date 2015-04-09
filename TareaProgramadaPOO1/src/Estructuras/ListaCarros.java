/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Clases.Caja;
import Clases.Carro;
import Clases.XML;
import Estructuras.NodoCarro;
import Grafica.SolicitarDinero;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;

/**
 *
 * @author alralaos
 */
public class ListaCarros {
    private NodoCarro primerNodo;
    private NodoCarro ultimoNodo;
    private int size;
    private final int tarifa ;
    private final int topeNodo;
    private Caja caja; 
    private ListaFactura lista;
    //creo una nueva lista. ingresa la capacidad maxima de carros, la tarifa por hora y una caja
    public ListaCarros(int pTopeNodo,int tarifa, Caja caja){
        primerNodo=ultimoNodo=null;
        topeNodo=pTopeNodo;
        this.tarifa = tarifa;
        size=0;
        this.caja=caja;
    }
    //elimina un carro de la lista
    public void sacar(String placa,int horaSalida,int minutoSalida) {
        NodoCarro nodoActual=primerNodo;
        while(nodoActual.getData().getPlaca()!=placa){
            nodoActual=nodoActual.next;
        }
        int horaEntrada=nodoActual.getData().getHora();
        int minutoEntrada=nodoActual.getData().getMinutos();
        nodoActual=new NodoCarro(new Carro(true),nodoActual.next);
        size--;
        mostrarCobro(horaEntrada, minutoEntrada, horaSalida, minutoSalida);    
    }
    //ingreso un nuevo vehiculo a la lista
    public void ingresoVehiculo(int horaEntrada, int minutoEntrada, String marca, String placa){
        if(size<topeNodo){
            if(size==0){
                primerNodo=ultimoNodo=new NodoCarro(new Carro(placa,marca,horaEntrada,minutoEntrada));
                size++;
            }
        }else{
            NodoCarro nodoActual=primerNodo;
            while(nodoActual.getData().getVacio()!=true){
                if(nodoActual.next==null){
                    nodoActual.next=new NodoCarro(new Carro(placa,marca,horaEntrada,minutoEntrada));
                    size++;
                }else{
                    nodoActual=nodoActual.next;
                }
            }
            nodoActual=new NodoCarro(new Carro(placa,marca,horaEntrada,minutoEntrada));
            size++;
        }    
    }
    //realiza el calculo de cuanto tiempo estuvo en el parqueo el vehiculo
     public void mostrarCobro(int horaEntrada, int minutoEntrada, int horaSalida, int minutoSalida){        
        int horas,minutos,cobroHoras,cobroMinutos,montoPagar = 0;
        if(horaEntrada == horaSalida){//EJ:12:3 , 12:51
            horas = 0;
            minutos = minutoSalida-minutoEntrada;
            
            if (0<minutos && minutos<16){     // entre 1 y 15              
                minutos = 15;
            }
            if(15<minutos && minutos<31){      //entre 16 y 30
                minutos = 30;
            }        
            if (30<minutos&& minutos<46){    //entre 31 y 45
                minutos = 45;
            }
            else if (minutos>45){ //entre 46 y 59
                minutos = 0;
                horas ++;
            }                
            cobroHoras = horas*tarifa; 
            cobroMinutos = cobrarMinutos(minutos);//Llamada a la funcion que calcula el cobro de minutos
            montoPagar =  cobroHoras + cobroMinutos;            
        }if (minutoEntrada == minutoSalida){//EJ: 1:37, 2:37            
            horas = (horaSalida-horaEntrada);
            montoPagar = horas * tarifa;            
        }if(minutoEntrada>minutoSalida){//EJ: 1:45, 4:23
            horas = (horaSalida-horaEntrada)-1;
            minutos = (60-minutoEntrada)+minutoSalida;
            if (0<minutos && minutos<16){     // entre 1 y 15           
                minutos = 15;
            }
            if(15<minutos && minutos<31) {       //entre 16 y 30
                minutos = 30;
            }
            if (30<minutos&& minutos<46){    //entre 31 y 45
                minutos = 45;
            }
            else if (minutos > 45){  //entre 46 y 59
                minutos = 0;
                horas ++ ;
            }   
            cobroHoras = horas * tarifa;
            cobroMinutos = cobrarMinutos(minutos);
            montoPagar = cobroHoras+cobroMinutos;        
        }else if (minutoSalida>minutoEntrada){//EJ: 1:20, 2:45
            horas = (horaSalida-horaEntrada);
            minutos = minutoSalida-minutoEntrada;
            
            if (0<minutos && minutos<16){    // entre 1 y 15
                minutos = 15;    
            }
            if(15<minutos && minutos<31){     //entre 16 y 30
                minutos = 30; 
            }
            if (30<minutos&& minutos<46){    //entre 31 y 45
                minutos = 45;
            }
            else if (minutos > 45){ //entre 46 y 59
                minutos = 0;
               horas ++;
            }            
            cobroHoras = horas * tarifa;  
            cobroMinutos = cobrarMinutos(minutos);//Llamada a la funcion que calcula el cobro de minutos
            montoPagar = cobroHoras+cobroMinutos;
        }
        System.out.print("Su deuda es de "+montoPagar);
        HacerPago(montoPagar);        
    }
    public void HacerPago(final int deuda){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitarDinero().setVisible(true);
                SolicitarDinero dinero=new SolicitarDinero();
                dinero.setDeuda(deuda);
            }
        });
    }
    //realiza el calculo de cuanto se paga por la cantidad de minutos
    public int  cobrarMinutos(int minutos){
        int precio = 0;
        if (minutos == 0) precio = 0;
        if(minutos == 15) precio = tarifa/4;       
        if(minutos == 30) precio = tarifa/2;
        if (minutos == 45)  precio =  tarifa-(tarifa/4);   
        return precio;
    }    
    //metodo booleano que busca carros    
    public boolean encontrado(Carro dato){        
        NodoCarro aux = primerNodo;
        while(aux!=null){
            if (aux.getData().equals(dato))
                return true;
            else
                aux = aux.next;
        }
        return false;
    }
    public void imprimir(){//   Mediante interfaz que muestre el estado del parqueo
      
        NodoCarro aux = primerNodo;
        while(aux!=null){
            System.out.print(aux.getData()+" ");
            aux = aux.next;
        }
        System.out.print("\n");
    }
    //metodo que cierra el parqueo
    public String cerrarParqueo(){
        if(size==0){
            int pMonto=0;
            try {
                JespXML archivo = new JespXML("info.xml");
                Tag raiz = archivo.leerXML();
                Tag monto = raiz.getTagHijoByName("empresa").getTagHijoByName("monto");
                pMonto=Integer.parseInt(monto.getContenido());
            } catch (ParserConfigurationException | SAXException | IOException | TagHijoNotFoundException ex) {
                Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
            }
            String val= Integer.toString(caja.getDinero()-pMonto);
            XML xml=new XML();
            //sobreescribe el valor del consecutivo del xml
            xml.escribirEmpresa(xml.leerNombre(),xml.leerCedula(),Integer.toString(Integer.parseInt(xml.leerConsecutivo())+lista.getSize()),xml.leerTelefono(),xml.leerTarifa(),xml.leerContraseña(),xml.leerHorario(),xml.leerTopeMax());
            return "el monto que se gano el dia de hoy es: "+val;
        }else{
            return "El parqueo no se puede cerrar";
        }
    }
}