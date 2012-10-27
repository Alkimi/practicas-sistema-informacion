/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionapplet.clases;

/**
 *
 * @author carranza
 */
public class Provincia {
    String CodigoProvincia;
    String Provincia;

    public Provincia(String CodigoProvincia, String Provincia) {
        this.CodigoProvincia = CodigoProvincia;
        this.Provincia = Provincia;
    }
    
    public String getCodigoProvincia() {
        return CodigoProvincia;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setCodigoProvincia(String CodigoProvincia) {
        this.CodigoProvincia = CodigoProvincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
