package practica2;

/**
 * Consumo poblaciones para el report, clase intermedia para guardar los datos
 * de la consulta par el report
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 *
 */
public class ConsumoPoblacionReporte {

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
    private String mes;

    /**
     * constructor por defecto
     */
    public ConsumoPoblacionReporte() {
    }

    /**
     * Crea un objeto auxiliar con el consumo de una poblacion en un mes concreto
     * @param nombre nombre de la poblacion
     * @param consumo consumo de la poablacion
     * @param mes  nombre del mes del consumo
     */
    public ConsumoPoblacionReporte(String nombre, double consumo, String mes) {
        this.nombre = nombre;
        this.consumo = consumo;

        this.mes = mes;
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
     * @return el consumo de la ciudad
     */
    public double getConsumo() {
        return consumo;
    }

    /**
     * Establece el consumo de la ciudad
     *
     * @param consumo de la ciudad
     */
    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    /**
     * Devuelve el mes del consumo de la ciudad
     *
     * @return el nombre del mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * Establece el nombre del mes del consumo de la ciudad
     *
     * @param mes nombre del mes
     *
     */
    public void setMes(String mes) {
        this.mes = mes;
    }
}
