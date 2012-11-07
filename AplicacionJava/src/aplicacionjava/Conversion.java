package aplicacionjava;

import java.util.Date;

/**
 *
 * Clase auxiliar para manejar la lista de cliente
 * 
 * <br/><br/>Sistemas de Información -  Grado Ingeniería Informática T.I. 
 * Curso 2012/13
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 * 
 */
public class Conversion {
    private Date fecha;
    private int[] diasPorMes= {0,31,28,31,30,31,30,31,31,30,31,30,31};
    
    /**
     * Constructor que obtiene la fecha actual
     */
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
    public String obtenerMesActual(){
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
    
    /**
     * Devuelve true o false si la cadena es numerica o no
     * @param cadena
     * @return true si es numerica false si no
     */
    public boolean esNumerico(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
}
