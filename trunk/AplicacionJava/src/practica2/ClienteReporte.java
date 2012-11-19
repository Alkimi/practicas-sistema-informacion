package practica2;

import java.util.Date;

/**
 * Clientes para el report, clase intermedia para guardar los datos de la
 * consulta par el report
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 2.0
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
     *
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
        this.idCliente = cliente;
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

    /**
     * Devuelve el identificador del cliente
     *
     * @return el identificador del cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente
     *
     * @param cliente identificador del cliente
     */
    public void setIdCliente(int cliente) {
        this.idCliente = cliente;
    }

    /**
     * Devuelve el nombre del cliente
     *
     * @return el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente
     *
     * @param nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido1 del cliente
     *
     * @return el primer apellido
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Establece el apellido1 del cliente
     *
     * @param apellido el primer apellido
     */
    public void setApellido1(String apellido) {
        this.apellido1 = apellido;
    }

    /**
     * Devuelve el apellido2 del cliente
     *
     * @return el apellido2 del cliente
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Establece el apellido2 del cliente
     *
     * @param apellido del cliente
     */
    public void setApellido2(String apellido) {
        this.apellido2 = apellido;
    }

    /**
     * Devuelve el nombre de la calle del cliente
     *
     * @return el nombre de la calle del cliente
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle del cliente
     *
     * @param calle de la calle del cliente
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Devuelve numero del piso del cliente
     *
     * @return el numero del piso del cliente
     */
    public int getPiso() {
        return piso;
    }

    /**
     * Establece el numero del piso del cliente
     *
     * @param piso el numero del piso del cliente
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    /**
     * Devuelve el numero de la calle del cliente
     *
     * @return el numero de la calle del cliente
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el numero de la calle del cliente
     *
     * @param numero de la calle del cliente
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el consumo de un cliente
     *
     * @return el consumo de un cliente
     */
    public double getConsumo() {
        return consumo;
    }

    /**
     * Establece el consumo de un cliente
     *
     * @param consumo de un cliente
     */
    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    /**
     * Devuelve el codigo postal de un cliente
     *
     * @return el codigo postal del cliente
     */
    public int getCodPostal() {
        return codPostal;
    }

    /**
     * Establece el codigo postal del cliente
     *
     * @param codPostal del cliente
     */
    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * Devuelve el nombre de la poblacion del cliente
     *
     * @return el nombre de la poblacion del cliente
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * Establece el nombre de la poblacion del cliente
     *
     * @param poblacion de la poblacion del cliente
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Devuelve el nombre de la provincia del cliente
     *
     * @return el nombre de la provincia del cliente
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Establece el nombre de la provincia del cliente
     *
     * @param provincia de la provincia del cliente
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Devuelve la fecha de cuando se genera la factura
     *
     * @return la fecha en la que se genera la factura
     */
    public Date getFechaFactura() {
        return fechaFactura;
    }

    /**
     * Devuelve el nombre del mes en que se genera la factura
     *
     * @return el nombre del mes de la factura
     */
    public String getMesFactura() {
        return mesFactura;
    }

    /**
     * Establece el nombre del mes de la factura
     *
     * @param mesFactura nombre del mes de la factura
     */
    public void setMesFactura(String mesFactura) {
        this.mesFactura = mesFactura;
    }
}
