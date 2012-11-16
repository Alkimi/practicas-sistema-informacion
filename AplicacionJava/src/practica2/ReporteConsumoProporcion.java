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
public class ReporteConsumoProporcion {

    /**
     * Constructor del reporte de sectores de varias provincias
     *
     * @param idProvincia identificador puede ser el cliente o la ciudad segun TIPO
     * @param Provincia cadena de texto de la provincia
     * @throws JRException puede lanzar esta excepcion en los reportes
     */
    public ReporteConsumoProporcion(int[] idProvincia, String[] Provincia) throws JRException {
        ResultSet resultado = null;

        ProvinciaDatasource datasource = new ProvinciaDatasource();
        //realizamos las consultas para obtener lo datos

        try {
            for (int i = 0; i < idProvincia.length; i++) {
                resultado = Principal.cbd.consultaSelect("select sum(suma), t2.CodigoProvincia from "
                        + "(select sum(kw) as suma,Cliente from mediciones Where FechaHora BETWEEN " + new aplicacionjava.Conversion().obtenerYear()
                        + " group by Cliente) as t1 inner join (Select CodigoProvincia, Codigo from clientes Where CodigoProvincia ="
                        + idProvincia[i] + ") as t2 where t1.Cliente=t2.Codigo group by CodigoProvincia");

                ProvinciaReporte provincia = new ProvinciaReporte();
                if (Principal.cbd.totalFilas() > 0) {
                    resultado.next();
                    provincia.setConsumo(resultado.getDouble(1));

                    provincia.setNombre(Provincia[i]);
                    provincia.setProvincia(resultado.getInt(2));
                } else {
                    provincia.setConsumo(0.0);
                    provincia.setNombre(Provincia[i]);
                    provincia.setProvincia(idProvincia[i]);
                }
                datasource.addProvincia(provincia);
            }
            JasperReport reporte = (JasperReport) JRLoader.loadObject("report_proporcion_provincia.jasper");

            JRExporter exporter = new JRPdfExporter();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, datasource);

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            String cadena = "ConsumoProvincias";
            for (int i = 0; i < idProvincia.length; i++) {
                cadena = cadena + "-" + idProvincia[i];
            }
            cadena = cadena + ".pdf";
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(cadena));
            exporter.exportReport();

        } catch (SQLException ex) {
            Logger.getLogger(ReporteConsumoProporcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
