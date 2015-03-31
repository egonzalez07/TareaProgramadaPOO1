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
public class Carro {
    private String marca, placa;
    private int hora, minutos;
    private boolean vacio;
    
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
    public boolean Vacio(){
        return vacio = true;
    }
}
