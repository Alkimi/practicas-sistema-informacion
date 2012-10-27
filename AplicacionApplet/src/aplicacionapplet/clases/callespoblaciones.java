/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionapplet.clases;

/**
 *
 * @author carranza
 */
public class callespoblaciones {
    String idCalle;
    String Nombre;

    public callespoblaciones(String idCalle,String Nombre) {
        this.idCalle = idCalle;
        this.Nombre = Nombre;
    }


    public String getIdCalle() {
        return idCalle;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setIdCalle(String idCalle) {
        this.idCalle = idCalle;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
