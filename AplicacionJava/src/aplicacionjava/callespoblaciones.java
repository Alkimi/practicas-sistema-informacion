/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionjava;

/**
 *
 * @author carranza
 */
public class callespoblaciones {
    String idCalle;
    String CodPoblacion;
    String Nombre;

    public callespoblaciones(String idCalle, String CodPoblacion, String Nombre) {
        this.idCalle = idCalle;
        this.CodPoblacion = CodPoblacion;
        this.Nombre = Nombre;
    }

    public String getCodPoblacion() {
        return CodPoblacion;
    }

    public String getIdCalle() {
        return idCalle;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setCodPoblacion(String CodPoblacion) {
        this.CodPoblacion = CodPoblacion;
    }

    public void setIdCalle(String idCalle) {
        this.idCalle = idCalle;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
