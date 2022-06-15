/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Melmelada
 */
@WebService(serviceName = "CalculatorWS")
public class CalculatorWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        //TODO write your implementation code here:
        int k=i+j;
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Pagar")
    public boolean Pagar(@WebParam(name = "numero_tarjeta") int numero_tarjeta, @WebParam(name = "monto") float monto, @WebParam(name = "nombre") String nombre, @WebParam(name = "codigo_CVV") int codigo_CVV) {
        //TODO write your implementation code here:
        
        float credito [] = {150,1500,25000,48762,99};
        int num_tj[]={123456789,987654321,432156789,123498765,789123456};
        String name[]={"Juan","Melissa","Petronila","Nami","Javier"};
        int c_CVV[]= {1256, 152,564,456,321};
        
        
        for(int i=0; i<5;i++){
            Boolean pago = monto <= credito[i];
            Boolean CVV = c_CVV[i] == codigo_CVV;
            Boolean Tarjeta =  num_tj[i] == numero_tarjeta;
            Boolean nom_Tarjeta =  name[i] == nombre;
            if (pago == CVV == Tarjeta == nom_Tarjeta)
                return true;
        }
        
        return false;
      
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Comprar")
    public Boolean Comprar(@WebParam(name = "id_producto") int id_producto, @WebParam(name = "precio") float precio, @WebParam(name = "numero_productos") int numero_productos, @WebParam(name = "total") float total) {
        //TODO write your implementation code here:
        
        int ids[]={12567,52478,12549,12578,56314};
        for(int i=0; i<5;i++){
            Boolean id = id_producto == ids[i];
            if (id)
                return true;
        }
        
        return false;
    }

}
