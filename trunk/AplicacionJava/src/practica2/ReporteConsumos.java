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
public class ReporteConsumos {

    /**
     * Constructor del reporte cosnumo de un poblacion mensual
     *
     * @param idPoblacion identifador de la poblacion
     * @param Poblacion cadena de texto de la poblacion
     * @param year el año del que se van a tomar los datos
     * @throws JRException puede lanzar esta excepcion en los reportes
     */
    public ReporteConsumos(int idPoblacion, String Poblacion, int year) throws JRException {
        ResultSet resultado = null;

        ConsumoPoblacionDatasource datasource = new ConsumoPoblacionDatasource();
        //realizamos las consultas para obtener lo datos
        try {

            resultado = Principal.cbd.consultaSelect("select sum(t1.kw)/1000 as suma, t1.mes as mes from "
                    + "(select kw, MONTHNAME(FechaHora) as mes, Cliente, FechaHora from mediciones WHERE "
                    + "FechaHora BETWEEN " + new aplicacionjava.Conversion().obtenerYearCualquiera(year) + ")  as t1 "
                    + "inner join (SELECT Codigo FROM clientes WHERE CodigoPoblacion=" + idPoblacion + ") as t2 where "
                    + "t1.Cliente=t2.Codigo  GROUP BY MONTH( t1.FechaHora)");

            while (resultado.next()) {
                ConsumoPoblacionReporte ciudad = new ConsumoPoblacionReporte();

                ciudad.setConsumo(resultado.getDouble(1));
                ciudad.setMes(resultado.getString(2));
                ciudad.setNombre(Poblacion);
                // añadimos el cliente
                datasource.addCiudad(ciudad);
            }
            JasperReport reporte = (JasperReport) JRLoader.loadObject("report_informe_barras.jasper");

            JRExporter exporter = new JRPdfExporter();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, datasource);

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("ConsumoAnual" + Poblacion + year + ".pdf"));
            exporter.exportReport();

        } catch (SQLException ex) {
            Logger.getLogger(ReporteConsumos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
