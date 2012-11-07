package utilidades;

/**
 *
 * Clase auxiliar para manejar la lista de poblaciones
 * 
 * <br/><br/>Sistemas de Información -  Grado Ingeniería Informática T.I. -
 * Curso 2012/13
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 */
public class Poblacion {
    
    private String CodPoblacion;
    private String NombrePob;

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
