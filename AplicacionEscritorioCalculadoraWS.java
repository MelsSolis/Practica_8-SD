/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionescritoriocalculadoraws;

import java.util.Scanner;
import static oracle.jrockit.jfr.events.Bits.floatValue;

/**
 *
 * @author Melmelada
 */
public class AplicacionEscritorioCalculadoraWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner datos=new Scanner(System.in);
        System.out.println("Ingresa id_Producto: " );
        int id_Producto=datos.nextInt();
        System.out.println("Ingresa precio: " );
        float precio=datos.nextFloat();
        System.out.println("Ingresa numeroProductos: " );
       int numeroProductos=datos.nextInt();
        
        float total; 
                total=precio*numeroProductos;
        System.out.println("Total a pagar: " + total);
        boolean respuesta_producto = comprar(id_Producto, precio, numeroProductos, total);
        
        if(respuesta_producto){
            System.out.println("Ingresa numeroTarjeta: " );
            int numeroTarjeta=datos.nextInt();
            System.out.println("Ingresa Nombre: " );
            String nombre=datos.next();
            System.out.println("Ingresa codigoCVV: " );
            int codigoCVV=datos.nextInt();
            boolean respuesta_pagar=pagar(numeroTarjeta,total,nombre,codigoCVV);
            if(respuesta_pagar==true)
                System.out.println("Procede transacción");
            else
                System.out.println("Transacción Rechazada");
        }
        else
            System.out.println("Producto no existe");
        
    }

    private static boolean pagar(int numeroTarjeta, float monto, java.lang.String nombre, int codigoCVV) {
        org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.pagar(numeroTarjeta, monto, nombre, codigoCVV);
    }

    private static Boolean comprar(int idProducto, float precio, int numeroProductos, float total) {
        org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.comprar(idProducto, precio, numeroProductos, total);
    }
    
    
}
