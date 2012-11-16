package practica2;

/**
 * Ciudades para el report, clase intermedia para guardar los datos de la
 * consulta par el report
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 *
 */
public class CiudadesReporte {

    /**
     * consumo de la poblacion
     */
    private double consumo;
    /**
     * guarda el nombre de la poblacion
     */
    private String nombre;
    /**
     * Nombre de la provincia
     */
    private String provincia;

    /**
     * constructor por defecto
     */
    public CiudadesReporte() {
    }

    /**
     * Genera una ciudad para su uso en el report
     * @param nombre el nombre de la ciudad
     * @param consumo el consumo de la ciudad
     * @param provincia  el nombre de la provincia
     */
    public CiudadesReporte(String nombre, double consumo, String provincia) {
        this.nombre = nombre;
        this.consumo = consumo;
        this.provincia = provincia;
    }

    /**
     * Devuelve el nombre de la ciudad
     *
     * @return el nombre de la ciudad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la ciudad
     *
     * @param nombre de la ciudad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el consumo de una ciudad
     *
     * @return el consumo en kw
     */
    public double getConsumo() {
        return consumo;
    }

    /**
     * Establece el consumo de una ciudad
     *
     * @param consumo de la ciudad
     */
    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    /**
     * Devuevle la provincia de una ciudad
     *
     * @return el nombre de la provincia de la ciudad
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Establece el nombre de la provincia de una ciudad
     *
     * @param provincia el nombre de la provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
