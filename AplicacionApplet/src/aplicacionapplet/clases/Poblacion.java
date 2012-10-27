/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionapplet.clases;

/**
 *
 * @author carranza
 */
public class Poblacion {
    
    String CodPoblacion;
    String NombrePob;

    public Poblacion(String CodPoblacion, String NombrePob) {
        this.CodPoblacion = CodPoblacion;
        this.NombrePob = NombrePob;
    }

    public void setCodPoblacion(String CodPoblacion) {
        this.CodPoblacion = CodPoblacion;
    }

 

    public void setNombrePob(String NombrePob) {
        this.NombrePob = NombrePob;
    }

    public String getCodPoblacion() {
        return CodPoblacion;
    }


    public String getNombrePob() {
        return NombrePob;
    }
    
    
    
}
