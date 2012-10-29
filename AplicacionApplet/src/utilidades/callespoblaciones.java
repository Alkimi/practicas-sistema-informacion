package utilidades;

/**
 *
 * Clase auxiliar para manejar la lista de calles
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
    private String Nombre;

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
