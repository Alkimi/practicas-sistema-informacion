package aplicacionjava;
/**
 *
 * Clase auxiliar para manejar la lista de cliente
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 * 
 * Sistemas de Información -  Grado Ingeniería Informática T.I. 
 * Curso 2012/13
 * 
 */

public class callespoblaciones {
    private String idCalle;
    private String CodPoblacion;
    private String Nombre;

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
