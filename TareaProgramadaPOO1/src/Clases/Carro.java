/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author alralaos
 */
public class Carro {
    private String placa;
    private String marca;
    private int hora;
    private int minutos;
    private boolean vacio=false;
    //crea un carro pero ficticio para mantener los espacios
    public Carro(boolean pVacio) {
        vacio = pVacio;
    }    
    //creo un carro nuevo
    public Carro(String pPlaca, String pMarca, int pHora, int pMinutos) {
        this.placa = pPlaca;
        this.marca = pMarca;
        this.hora = pHora;
        this.minutos = pMinutos;
    }
    //regresa la placa del carro
    public String getPlaca() {
        return placa;
    }
    //regresa la hora de entrada del carro
    public int getHora() {
        return hora;
    }
    //regresa los minutos que estuvo el carro en el parqueo
    public int getMinutos() {
        return minutos;
    }
    //regresa si el carro es ficticio o no
    public boolean getVacio() {
        return vacio;
    }       
}