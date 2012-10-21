/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Date;

/**
 *
 * @author Alkimi
 */
public class Conversion {
    private Date fecha;
    private int[] diasPorMes= {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public Conversion(){
      fecha = new Date();
    }
    
    /**
     * Devuelve la cadena apropiada para realizar una consulta sql con los datos
     * de inicio y fin del año actual
     * 
     * @return cadena del tipo "'2012-01-01 00:00:00' AND '2012-12-31 23:59:59'" 
     */
    public String obtenerYear(){
        return ("'"+(1900+fecha.getYear())+"-01-01 00:00:00' AND '"+(1900+fecha.getYear())+"-12-31 23:59:59'");
    }
    
     /**
     * Devuelve la cadena apropiada para realizar una consulta sql con los datos
     * de inicio y fin del año pasado por parametro
     * 
     * @param year el año que se quiere devolver con cuatro digitos de la forma 2012
     * @return cadena del tipo "'2012-01-01 00:00:00' AND '2012-12-31 23:59:59'" 
     */
    public String obtenerYearCualquiera(int year){
        return ("'"+year+"-01-01 00:00:00' AND '"+year+"-12-31 23:59:59'");
    }
    
     /**
     * Devuelve la cadena apropiada para realizar una consulta sql con los datos
     * de inicio y fin del mes actual
     * 
     * @return cadena del tipo "'2012-05-01 00:00:00' AND '2012-05-31 23:59:59'" 
     */
    public String obetenerMesActual(){
        return ("'"+(1900+fecha.getYear())+"-"+rellena(fecha.getMonth()+1)+"-01 00:00:00' AND '"
                +(1900+fecha.getYear())+"-"+rellena(fecha.getMonth()+1)+"-"+diasPorMes[fecha.getMonth()+1]+" 23:59:59'");
    }
  
     /**
     * Devuelve la cadena apropiada para realizar una consulta sql con los datos
     * de inicio y fin del mes pasado por parametro del año actual
     * 
     * @param mes que se quiere devolver
     * @return cadena del tipo "'2012-05-01 00:00:00' AND '2012-05-31 23:59:59'" 
     */
    public String obtenerMesCualquiera(int mes){
        if (mes<1) {
            mes=1;
        }
        if (mes>12) {
            mes=12;
        }
        return ("'"+(1900+fecha.getYear())+"-"+rellena(mes)+"-01 00:00:00' AND '"
                +(1900+fecha.getYear())+"-"+rellena(mes)+"-"+diasPorMes[mes]+" 23:59:59'"); 
    }
    
     /**
     * Devuelve la cadena apropiada para realizar una consulta sql con los datos
     * de inicio y fin del mes pasado por parametro de un año cualquiera
     * 
     * @param mes que se quiere devolver
     * @param year que se quire devolver con cuatro dijitos de la forma 2012
     * @return cadena del tipo "'2012-05-01 00:00:00' AND '2012-05-31 23:59:59'" 
     */
    public String obtenerMesCualquiera(int mes,int year){
        if (mes<1) {
            mes=1;
        }
        if (mes>12) {
            mes=12;
        }
        return ("'"+year+"-"+rellena(mes)+"-01 00:00:00' AND '"
                +year+"-"+rellena(mes)+"-"+diasPorMes[mes]+" 23:59:59'"); 
    }
    
    /**
     * Rellena la cadena de salida con un cero si la entrada es menor que 10
     * @param entrada el numero a convertir en cadena 
     * @return la cadena del numero de entrada mas el 0 si es menor que 10
     */
    private String rellena(int entrada){
        if (entrada<10) {
            return ("0"+entrada);
        }
        else {
            return String.valueOf(entrada);
        }
    }
}
