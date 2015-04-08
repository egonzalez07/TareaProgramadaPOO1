/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Alcides
 */
public class Factura {
    private final int monto;
    private final int consecutivo;
    //crea una factura
    // recive el monto de la factura y el consecutivo
    public Factura(int pMonto, int pConsecutivo) {
        this.monto = pMonto;
        this.consecutivo=pConsecutivo;
    }
    //metodo que regresa el monto
    public int getMonto() {
        return monto;
    }    
    //metodo que regresa el consecutivo
    public int getConsecutivo() {
        return consecutivo;
    }    
}
