/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Date;


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
public class ClienteReporte {
    /**
     * identificador de cliente
     */
    private int idCliente;
    /**
     * guarda el nombre el cliente
     */
    private String nombre;
    /**
     * guarda el apellido1 del cliente
     */
    private String apellido1;
    /**
     * guarda el apellido2 del cliente
     */
    private String apellido2;
    /**
     * guarda el nombre de la calle del cliente
     */
    private String calle;
    /**
     * guarda el piso del cliente
     */
    private int piso;
    /**
     * guarda el numero del cliente
     */
    private int numero;
    /**
     * guarda el consumo del cliente
     */
    private double consumo;
    /**
     * guarda el codigo postal de cliente
     */
    private int codPostal;
    /**
     * guarda el nombre de la poblacion del cliente
     */
    private String poblacion;
    /**
     * guarda el nombre de la provincia del cliente
     */
    private String provincia;
    /**
     * fecha en la que se genera la factura
     */
    private Date fechaFactura;
    /**
     * nombre del mes a facturar
     */
    private String mesFactura;

    /**
     * constructor por defecto
     */
    public ClienteReporte() {
         this.fechaFactura = new Date();
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
    public ClienteReporte(int cliente, String nombre, String apellido1, String apellido2, String calle, int piso, int numero, double consumo, int codPostal, String poblacion, String provincia) {
        this.idCliente=cliente;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.calle = calle;
        this.piso = piso;
        this.numero = numero;
        this.consumo = consumo;
        this.codPostal = codPostal;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.fechaFactura = new Date();

    }

    public int getIdCliente(){
        return idCliente;
    }
    
    public void setIdCliente(int cliente){
        this.idCliente=cliente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido) {
        this.apellido1 = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido) {
        this.apellido2 = apellido;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public String getMesFactura() {
        return mesFactura;
    }

    public void setMesFactura(String mesFactura) {
        this.mesFactura = mesFactura;
    }
}
