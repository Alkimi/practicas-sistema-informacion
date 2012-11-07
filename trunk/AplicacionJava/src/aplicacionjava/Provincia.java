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
public class Provincia {
    private String CodigoProvincia;
    private String Provincia;

    /**
     * Constructor del obejeto provincia, recibe por parametros los datos de la provincia
     * @param CodigoProvincia
     * @param Provincia 
     */
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
