/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salidavehicular;
import java.util.Scanner;
/**
 *
 * @author Marvin
 */
public class Salida {
     public String placa1, hora1, minutos1;
     public String placa2, hora2, minutos2;
     private boolean salida = false;
     
     Scanner sc = new Scanner(System.in);
     public Salida(){
         
     }
     public void crearTiquete(){
         System.out.print("*****Registrando nuevo vehiculo al parqueo*****\n");
         System.out.print("\nIngrese la placa de su vehiculo:");
         placa1 = sc.next();
         System.out.print("Ingrese hora actual:");
         hora1 = sc.next();
         System.out.print("Ingrese minutos:");
         minutos1 = sc.next();
     }
     public String  getPlaca(){
         return this.placa1;
     }
     public String getHora(){
         return this.hora1;
         
     }
     public String getMinutos(){
         return this.minutos1;
         
     }
     public void saliendo(){
         
        System.out.print("\n Escriba el numero de placa de su vehiculo:");
        placa2 = sc.next();
        System.out.print("\nHora actual de salida:");
        hora2 = sc.next();
        System.out.print("\nMinutos actuales de salida");
        minutos2 = sc.next();
     }
     public boolean salir(){
         
         salida = true;
         return salida;
         
     }
     
     public String MostrarTiquete(){
         System.out.print("\n PARQUEOS LADUGO\n");
         System.out.print("TIQUETE DE SU VEHICULO");
         String tiq = "";
         tiq += "\n Numero de placa "+getPlaca();
         tiq+="\n Hora: "+getHora()+"   y "+ getMinutos()+"  minutos\n";
         return tiq;
     }
}
