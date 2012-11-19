package practica2;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * Ciudades Datasource para el report
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 2.0
 *
 */
public class CiudadesDatasource implements JRDataSource {

    /**
     * Lista interna para guardar las ciudades a utilizar en el report
     */
    private List<CiudadesReporte> listaCiudades = new ArrayList<CiudadesReporte>();
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
        return ++indiceClientesActual < listaCiudades.size();
    }

    /**
     * nexo de union entre el repot y la los datos de los clientes.
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
                valor = listaCiudades.get(indiceClientesActual).getNombre();
                break;
            case "consumo":
                valor = listaCiudades.get(indiceClientesActual).getConsumo();
                break;
            case "provincia":
                valor = listaCiudades.get(indiceClientesActual).getProvincia();
                break;
        }

        /* if ("nombre".equals(jrField.getName())) {
         valor = listaCiudades.get(indiceClientesActual).getNombre();
         } else if ("consumo".equals(jrField.getName())) {
         valor = listaCiudades.get(indiceClientesActual).getConsumo();
         } else if ("provincia".equals(jrField.getName())) {
         valor = listaCiudades.get(indiceClientesActual).getProvincia();
         } 
         */

        return valor;
    }

    /**
     * Añade una nueva Ciudad a la lista de ciudades
     *
     * @param ciudad la ciudad a añadir
     */
    public void addCiudad(CiudadesReporte ciudad) {
        this.listaCiudades.add(ciudad);
    }
}
