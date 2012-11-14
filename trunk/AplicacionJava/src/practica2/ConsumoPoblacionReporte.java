/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;



/**
 * Cliente reporte
 *  
 * <br/><br/>Sistemas de Información -  Grado Ingeniería Informática T.I. 
 * Curso 2012/13
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 * 
 */
public class ConsumoPoblacionReporte {
    /**
     * consumo de la poblacion
     */
    private double consumo;
    /**
     * guarda el nombre de la poblacion
     */
    private String nombre;
    /**
     * Nombre de la provincia
     */
    private String mes;
 
    /**
     * constructor por defecto
     */
    public ConsumoPoblacionReporte() {
    }

    /**
     * consturctor parametrizado
     * @param nombre el nombre del cliente
     * @param apellido1 el primer apellido del cliente
     * @param apellido2 el segundo apellido del cliente
     * @param calle el nombre de la calle del cliente
     * @param piso el piso del cliente
     * @param numero el numero del cliente
     * @param consumo los kw consumidos el cliente
     * @param codPostal el codigo postal del cliente
     * @param poblacion el nombre de la poblacion del cliente
     * @param provincia el nombre de la provincia del cliente
     */
    public ConsumoPoblacionReporte(String nombre, double consumo, String mes) {
        this.nombre = nombre;
        this.consumo = consumo;

        this.mes = mes;
  }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

      public double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

  
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}