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
import net.sf.jasperreports.engine.export.JRPdfExporter;

import net.sf.jasperreports.engine.util.JRLoader;

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
public class ReporteCiudades {

    /**
     * Constructor del reporte de los consumos de todas las ciudades de una provincia.
     *
     * @param idProvincia identificador puede ser el cliente o la ciudad segun TIPO
     * @param Provincia cadena de texto de la provincia

     * @throws JRException puede lanzar esta excepcion en los reportes
     */
    public ReporteCiudades(int idProvincia, String Provincia) throws JRException {
        ResultSet resultado = null;

        CiudadesDatasource datasource = new CiudadesDatasource();
        //realizamos las consultas para obtener lo datos

        try {

            resultado = Principal.cbd.consultaSelect("select sum(t3.total), t6.Poblacion from "
                    + "(select t1.total, t1.Cliente  from ( select sum(KW) as total, Cliente from mediciones Where "
                    + " FechaHora  between " + new aplicacionjava.Conversion().obtenerYear() + "  group by Cliente ) as t1"
                    + " inner join ( Select Codigo from clientes where CodigoProvincia=" + idProvincia + ") as t2"
                    + " where t1.Cliente=t2.Codigo) as t3 inner join"
                    + " (select t4.Codigo, t5.CodigoPoblacion, t5.Poblacion from "
                    + " (select Codigo, CodigoPoblacion from clientes where CodigoProvincia=" + idProvincia + ") as t4"
                    + " inner join ( select CodigoPoblacion, Poblacion from poblaciones where CodigoProvincia="
                    + idProvincia + ") as t5 where t4.CodigoPoblacion = t5.CodigoPoblacion"
                    + " ) as t6 where t3.Cliente=t6.Codigo group by t6.CodigoPoblacion");

            while (resultado.next()) {
                CiudadesReporte ciudad = new CiudadesReporte();

                ciudad.setConsumo(resultado.getDouble(1));
                ciudad.setNombre(resultado.getString(2));
                ciudad.setProvincia(Provincia);
                // añadimos el cliente
                datasource.addCiudad(ciudad);
            }
            JasperReport reporte = (JasperReport) JRLoader.loadObject("report_lista_ciudades.jasper");

            JRExporter exporter = new JRPdfExporter();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, datasource);

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("ListaConsumo" + Provincia + ".pdf"));
            exporter.exportReport();

        } catch (SQLException ex) {
            Logger.getLogger(ReporteCiudades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
