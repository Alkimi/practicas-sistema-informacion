/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * Cliente Datasource para el report
 *
 * <br/><br/>Sistemas de Información - Grado Ingeniería Informática T.I. Curso
 * 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 *
 */
public class CiudadesDatasource implements JRDataSource {

    private List<CiudadesReporte> listaCiudades = new ArrayList<CiudadesReporte>();
    private int indiceClientesActual = -1;

    @Override
    public boolean next() throws JRException {
        return ++indiceClientesActual < listaCiudades.size();
    }

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

    public void addCliente(CiudadesReporte ciudad) {
        this.listaCiudades.add(ciudad);
    }
}
