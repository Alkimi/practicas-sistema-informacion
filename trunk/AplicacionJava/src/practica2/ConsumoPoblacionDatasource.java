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
public class ConsumoPoblacionDatasource implements JRDataSource {

    private List<ConsumoPoblacionReporte> listaConsumos = new ArrayList<ConsumoPoblacionReporte>();
    private int indiceClientesActual = -1;

    @Override
    public boolean next() throws JRException {
        return ++indiceClientesActual < listaConsumos.size();
    }

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

    public void addCliente(ConsumoPoblacionReporte ciudad) {
        this.listaConsumos.add(ciudad);
    }
}
