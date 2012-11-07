package aplicacionjava;

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
public class Poblacion {
    String CodProvincia;
    String CodPoblacion;
    String NombrePob;
    
    /**
     * Constructor del objeto poblacion con los datos de una poblacion recibe por parametros los datos
     * @param CodProvincia
     * @param CodPoblacion
     * @param NombrePob 
     */
    public Poblacion(String CodProvincia, String CodPoblacion, String NombrePob) {
        this.CodProvincia = CodProvincia;
        this.CodPoblacion = CodPoblacion;
        this.NombrePob = NombrePob;
    }

    public void setCodPoblacion(String CodPoblacion) {
        this.CodPoblacion = CodPoblacion;
    }

    public void setCodProvincia(String CodProvincia) {
        this.CodProvincia = CodProvincia;
    }

    public void setNombrePob(String NombrePob) {
        this.NombrePob = NombrePob;
    }

    public String getCodPoblacion() {
        return CodPoblacion;
    }

    public String getCodProvincia() {
        return CodProvincia;
    }

    public String getNombrePob() {
        return NombrePob;
    }
}
