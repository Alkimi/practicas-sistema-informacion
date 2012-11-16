package practica2;

import gui.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.util.JRLoader;

import net.sf.jasperreports.engine.export.JRPdfExporter; // pdf

/**
 * Genera la factura para un cliente o para todos los clientes de una ciudad
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 *
 */
public class ReporteFactura {

    /**
     * Constructor del reporte de facturas de clientes
     *
     * @param id identificador puede ser el cliente o la ciudad segun TIPO
     * @param Provincia cadena de texto de la provincia
     * @param Poblacion cadena de texto de la poblacion
     * @param tipo tipo de entrada, true el id es el cliente, false el id es la
     * poblacion
     * @throws JRException puede lanzar esta excepcion en los reportes
     */
    public ReporteFactura(int id, String Provincia, String Poblacion, boolean tipo) throws JRException {
        if (tipo) {
            UnCliente(id, Provincia, Poblacion);
        } else {
            MuchosClientes(id, Provincia, Poblacion);
        }
    }

    /**
     * Realiza las opereciones necesarias para generar todos los clientes de una
     * poblacion
     *
     * @param idPoblacion identificador de poblacion
     * @param Provincia cadena de texto de la provincia
     * @param Poblacion cadena de texto de la poblacion
     * @throws JRException puede lanzar esta excepcion en los reportes
     */
    private void MuchosClientes(int idPoblacion, String Provincia, String Poblacion) throws JRException {
        ResultSet resultado = null;
        ClienteDatasource datasource = new ClienteDatasource();
        //realizamos las consultas para obtener lo datos
        try {

            resultado = Principal.cbd.consultaSelect("Select t3.Codigo, t3.Nombre, t3.apellido, t3.apellido2, t3.Calle, t3.numero, t3.piso, t3.CodPostal,t4.KW, t4.mes"
                    + " from (Select t1.Codigo, t1.Nombre, t1.apellido, t1.apellido2, t2.Nombre as Calle, t1.numero, t1.piso, t2.CodPostal"
                    + " From (Select * from clientes where CodigoPoblacion =" + idPoblacion + ") as t1 inner join"
                    + " (select * from callespoblaciones where CodPoblacion=" + idPoblacion + ") as t2 where t1.calle=t2.idCalle"
                    + " ) as t3 inner join ( select KW, Monthname(max(FechaHora)) as mes, Cliente from mediciones group by Cliente) "
                    + "as t4 where t3.Codigo=t4.Cliente");
            while (resultado.next()) {
                ClienteReporte cliente = new ClienteReporte();

                cliente.setIdCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setApellido1(resultado.getString(3));
                cliente.setApellido2(resultado.getString(4));
                cliente.setCalle(resultado.getString(5));
                cliente.setPiso(resultado.getInt(7));
                cliente.setNumero(resultado.getInt(6));
                cliente.setCodPostal(resultado.getInt(8));
                cliente.setConsumo(resultado.getDouble(9));
                cliente.setMesFactura(resultado.getString(10));
                cliente.setPoblacion(Poblacion);
                cliente.setProvincia(Provincia);

                // añadimos el cliente
                datasource.addCliente(cliente);
            }
            JasperReport reporte = (JasperReport) JRLoader.loadObject("report_cliente.jasper");

            JRExporter exporter = new JRPdfExporter();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, datasource);

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Fac" + idPoblacion + ".pdf"));
            exporter.exportReport();

        } catch (SQLException ex) {
            Logger.getLogger(ReporteFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Realiza la generacion de una factura de un solo cliente
     *
     * @param idCliente identificador de cliente a generar la factura
     * @param Provincia cadena de texto de la provincia
     * @param Poblacion cadena de texto de la poblacion
     * @throws JRException puede lanzar esta excepcion en los reportes
     */
    private void UnCliente(int idCliente, String Provincia, String Poblacion) throws JRException {
        ResultSet resultado = null;
        int aux;

        ClienteDatasource datasource = new ClienteDatasource();
        //realizamos las consultas para obtener lo datos
        ClienteReporte cliente = new ClienteReporte();
        try {
            resultado = Principal.cbd.consultaSelect("Select Nombre, Apellido, Apellido2, Calle, Numero, Piso From clientes "
                    + "Where Codigo=" + idCliente);
            resultado.next();
            cliente.setIdCliente(idCliente);
            cliente.setNombre(resultado.getString(1));
            cliente.setApellido1(resultado.getString(2));
            cliente.setApellido2(resultado.getString(3));
            aux = resultado.getInt(4);
            cliente.setPiso(resultado.getInt(5));
            cliente.setNumero(resultado.getInt(6));

            cliente.setPoblacion(Poblacion);
            cliente.setProvincia(Provincia);

            //consulta a calle
            resultado = Principal.cbd.consultaSelect("Select Nombre, CodPostal From callespoblaciones where idCalle=" + aux);
            resultado.next();
            cliente.setCalle(resultado.getString(1));
            cliente.setCodPostal(resultado.getInt(2));

            //consulta a mediciones
            resultado = Principal.cbd.consultaSelect("Select KW, Monthname(max(FechaHora)) From mediciones where Cliente=" + idCliente);
            resultado.next();
            cliente.setConsumo(resultado.getDouble(1));
            cliente.setMesFactura(resultado.getString(2));

        } catch (SQLException ex) {
            Logger.getLogger(ReporteFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        // añadimos el cliente
        datasource.addCliente(cliente);

        JasperReport reporte = (JasperReport) JRLoader.loadObject("report_cliente.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, datasource);

        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Fac" + idCliente + cliente.getMesFactura() + ".pdf"));
        exporter.exportReport();
    }
}
