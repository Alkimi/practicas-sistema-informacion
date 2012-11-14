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
public class ClienteDatasource implements JRDataSource {

    private List<ClienteReporte> listaClientes = new ArrayList<ClienteReporte>();
    private int indiceClientesActual = -1;

    @Override
    public boolean next() throws JRException {
        return ++indiceClientesActual < listaClientes.size();
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object valor = null;
        
        switch (jrField.getName()) {
            case "idCliente":
                valor = listaClientes.get(indiceClientesActual).getIdCliente();
                break;
            case "nombre":
                valor = listaClientes.get(indiceClientesActual).getNombre();
                break;
            case "apellido1":
                valor = listaClientes.get(indiceClientesActual).getApellido1();
                break;
            case "apellido2":
                valor =listaClientes.get(indiceClientesActual).getApellido2();
                break;
            case "calle":
                valor = listaClientes.get(indiceClientesActual).getCalle();
                break;
            case "piso":
                valor = listaClientes.get(indiceClientesActual).getPiso();
                break;
            case "numero":
                valor = listaClientes.get(indiceClientesActual).getNumero();
                break;
            case "consumo":
                valor = listaClientes.get(indiceClientesActual).getConsumo();
                break;
            case "codPostal":
                valor = listaClientes.get(indiceClientesActual).getCodPostal();
                break;
            case "poblacion":
                valor = listaClientes.get(indiceClientesActual).getPoblacion();
                break;
            case "provincia":
                valor = listaClientes.get(indiceClientesActual).getProvincia();
                break;
            case "fechaFactura":
                valor = listaClientes.get(indiceClientesActual).getFechaFactura();
                break;
            case "mesFactura":
                valor = listaClientes.get(indiceClientesActual).getMesFactura();
                break;
        }
        
        /* if ("idCliente".equals(jrField.getName())){
            valor = listaClientes.get(indiceClientesActual).getIdCliente();
         } else if ("nombre".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getNombre();
        } else if ("apellido1".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getApellido1();
        } else if ("apellido2".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getApellido2();
        } else if ("calle".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getCalle();
        } else if ("piso".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getPiso();
        } else if ("numero".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getNumero();
        } else if ("consumo".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getConsumo();
        } else if ("codPostal".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getCodPostal();
        } else if ("poblacion".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getPoblacion();
        } else if ("provincia".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getProvincia();
        } else if ("fechaFactura".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getFechaFactura();
        } else if ("mesFactura".equals(jrField.getName())) {
            valor = listaClientes.get(indiceClientesActual).getMesFactura();
        }
         */

        return valor;
    }

    public void addCliente(ClienteReporte cliente) {
        this.listaClientes.add(cliente);
    }
}
