/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author carranza
 */
public class Cliente {
    String codigo;
    String nombre;
    String apellido;
    String apellido2;
    String calle;
    String numero;
    String piso;
    String metros;
    String codigoPoblacion;
    String codigoProvincia;

    public Cliente(String codigo, String nombre, String apellido, String apellido2, String calle, String numero, String piso, String metros, String codigoPoblacion, String codigoProvincia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.metros = metros;
        this.codigoPoblacion = codigoPoblacion;
        this.codigoProvincia = codigoProvincia;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCalle() {
        return calle;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCodigoPoblacion() {
        return codigoPoblacion;
    }

    public String getCodigoProvincia() {
        return codigoProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMetros() {
        return metros;
    }

    public String getNumero() {
        return numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCodigoPoblacion(String codigoPoblacion) {
        this.codigoPoblacion = codigoPoblacion;
    }

    public void setCodigoProvincia(String codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public void setMetros(String metros) {
        this.metros = metros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
    
    
}
