/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.logica;

/**
 *
 * @author Marvin
 */
public class crearTiquete {
    String numeroPlaca;
    String hora;
    String minutos;
    
    public crearTiquete(String numeroPlaca, String hora, String minutos){
        this.numeroPlaca = numeroPlaca;
        this.hora = hora;
        this.minutos = minutos;   
    }
    public String getPlaca(){
        return this.numeroPlaca;    
    }
    
    public String getHora(){
        return this.hora;
    }
    
    public String getMinutos(){
        return this.minutos;
    }
    public String toString(){
        
        String inf = "";
        inf += "Numero placa:"+getPlaca();
        inf += "Hora:"+getHora()+"y :"+getMinutos()+"\n";
        return inf;
    }
}
