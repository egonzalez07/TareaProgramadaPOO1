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
    private int monto;
    private int consecutivo;
    public Factura(int pMonto, int pConsecutivo) {
        this.monto = pMonto;
        this.consecutivo=pConsecutivo;
    }
    public int getMonto() {
        return monto;
    }    
    public int getConsecutivo() {
        return consecutivo;
    }    
}
