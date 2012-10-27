/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionapplet.clases;

/**
 *
 * @author carranza
 */
public class Cliente {
    String codigo;
    String nombre;
    String apellido;
    String apellido2;
    String numero;
    String piso;

    public Cliente(String codigo, String nombre, String apellido, String apellido2, String numero, String piso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.numero = numero;
        this.piso = piso;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApellido2() {
        return apellido2;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
