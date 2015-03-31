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
    public Carro(boolean pVacio) {
        vacio = pVacio;
    }    
    public Carro(String pPlaca, String pMarca, int pHora, int pMinutos) {
        this.placa = pPlaca;
        this.marca = pMarca;
        this.hora = pHora;
        this.minutos = pMinutos;
    }
    
    public String getPlaca() {
        return placa;
    }
    public int getHora() {
        return hora;
    }
    public int getMinutos() {
        return minutos;
    }
    public boolean getVacio() {
        return vacio;
    }   
    
}