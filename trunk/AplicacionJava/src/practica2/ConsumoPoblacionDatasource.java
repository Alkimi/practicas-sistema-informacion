package practica2;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * Consumo poblaciones Datasource para el report
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 *
 */
public class ConsumoPoblacionDatasource implements JRDataSource {

    /**
     * Lista interna para guardar los consumos a utilizar en el report
     */
    private List<ConsumoPoblacionReporte> listaConsumos = new ArrayList<ConsumoPoblacionReporte>();
    /**
     * Indice de la lista
     */
    private int indiceClientesActual = -1;

    /**
     * Funcion que avanza uno el indice y comprueba si hay mas elementos
     *
     * @return true si hay mas elementos
     * @throws JRException puede lanzar JRException si hay un error en el report
     */
    @Override
    public boolean next() throws JRException {
        return ++indiceClientesActual < listaConsumos.size();
    }

    /**
     * nexo de union entre el repot y la los datos de los consumos
     *
     * @param jrField selecciona el campo a delvolver del report
     * @return el Obejeto correspondiente al campo seleccionado
     * @throws JRException
     */
    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object valor = null;

        switch (jrField.getName()) {
            case "nombre":
                valor = listaConsumos.get(indiceClientesActual).getNombre();
                break;
            case "consumo":
                valor = listaConsumos.get(indiceClientesActual).getConsumo();
                break;
            case "mes":
                valor = listaConsumos.get(indiceClientesActual).getMes();
                break;
        }

        /* if ("nombre".equals(jrField.getName())) {
         valor = listaConsumos.get(indiceClientesActual).getNombre();
         } else if ("consumo".equals(jrField.getName())) {
         valor = listaConsumos.get(indiceClientesActual).getConsumo();
         } else if ("provincia".equals(jrField.getName())) {
         valor = listaConsumos.get(indiceClientesActual).getMes();
         } 
         */

        return valor;
    }

    /**
     * Añade unn consumo poblacion a la lista de ciudades
     *
     * @param ciudad la ciudad a añadir
     */
    public void addCiudad(ConsumoPoblacionReporte ciudad) {
        this.listaConsumos.add(ciudad);
    }
}
