package practica2;

/**
 * provincias para el report, clase intermedia para guardar los datos de la
 * consulta para el report
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 *
 */
public class ProvinciaReporte {

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
    private int provincia;

    /**
     * constructor por defecto
     */
    public ProvinciaReporte() {
    }

    /**
     * Contructor para los datos de una provincia para los report
     *
     * @param nombre nombre de la provincia
     * @param consumo consumo de la provincia
     * @param provincia identificador de la provincia
     */
    public ProvinciaReporte(String nombre, double consumo, int provincia) {
        this.nombre = nombre;
        this.consumo = consumo;

        this.provincia = provincia;
    }

    /**
     * Devuelve el nombre de la provincia
     *
     * @return el nombre de la provincia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la provincia
     *
     * @param nombre de la provincia
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el consumo de la provincia
     *
     * @return el consumo de la provincia
     */
    public double getConsumo() {
        return consumo;
    }

    /**
     * Establece el consumo de la provincia
     *
     * @param consumo de la provincia
     */
    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    /**
     * Devuelve el nombre de la provincia
     *
     * @return el nombre de la provincia
     */
    public int getProvincia() {
        return provincia;
    }

    /**
     * Establece id de provincia
     *
     * @param provincia establecemos el id de provincia
     */
    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }
}
