/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajaregistradora;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author franjbf
 */
public class CajaRegistradora {

    /**
     * @param args the command line arguments
     */
    
    public static void escribir(String cadena) {
        System.out.println(cadena);
    }
    public static void escribir(int entero) {
        System.out.println(entero);
    }
    public static void escribir(double decimal) {
        System.out.println(decimal);
    }
    public static int calcularIVA(int neto) {
        double iva = neto * 0.19;
        return (int)iva;
    }
    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner (System.in);
        int precio = 0;
        int cantidad = 0;
        int neto = 0;
        int iva = 0;
        int total = 0;
        int totalNeto = 0;
        int totalFinal = 0;
        int pago = 0;
        int vuelto = 0;
        
        escribir("Ingrese la cantidad de productos diferentes");
        int prod = leer.nextInt();
        
        int[][] caja = new int[prod][5];
        
        for (int i = 0 ; i < caja.length ; i++) {
            for (int j = 0 ; j < 5 ; j++) {
                switch (j) {
                    case 0: 
                        escribir("Ingrese el precio del producto " + (i+1));
                        caja[i][j] = leer.nextInt();
                        precio = caja[i][j];
                        break;
                    case 1:
                        escribir("Ingrese la cantidad del producto " + (i+1));
                        caja[i][j] = leer.nextInt();
                        cantidad = caja[i][j];
                        break;
                    case 2:
                        caja[i][j] = precio * cantidad;
                        neto = caja[i][j];
                        break;
                    case 3: 
                        caja[i][j] = calcularIVA(neto);
                        iva = caja[i][j];
                        break;
                    case 4:
                        caja[i][j] = neto + iva;
                        total = caja[i][j];
                        break;
                }
            }
        }
        
        for (int i=0 ; i < caja.length ; i++) {
            totalNeto = totalNeto + caja[i][2];
        }
        
        for (int i=0 ; i < caja.length ; i++) {
            totalFinal = totalFinal + caja[i][4];
        }
        
        escribir("El total neto de la compra es " + totalNeto);
        escribir("El total con IVA de la compra es " + totalFinal);
        escribir("¿Con cuánto va a pagar?");
        pago = leer.nextInt();
        
        while (pago < totalFinal) {
            escribir("Ingrese nuevamente con cuánto va a pagar");
            pago = leer.nextInt();
        }
        
        vuelto = pago - totalFinal;
        
        escribir("Su vuelto es de " + vuelto);
        
    }
    
}
