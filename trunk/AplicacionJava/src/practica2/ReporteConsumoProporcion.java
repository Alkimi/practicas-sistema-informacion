/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import gui.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
import net.sf.jasperreports.engine.export.JRHtmlExporter; //html
import net.sf.jasperreports.engine.export.JRCsvExporter; // cvs
import net.sf.jasperreports.engine.export.JRRtfExporter; // rtf
import net.sf.jasperreports.engine.export.JRXlsExporter; // xls
import net.sf.jasperreports.engine.export.JRXmlExporter; //xml
import net.sf.jasperreports.engine.export.JRTextExporter; // txt
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter; // xlsx
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter; // docx
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter; //pptx

/**
 * Genera la factura para un cliente o para todos los clientes de una ciudad
 *  
 * <br/><br/>Sistemas de Información -  Grado Ingeniería Informática T.I. 
 * Curso 2012/13
 * 
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 * 
 */
public class ReporteConsumoProporcion {

    /**
     * Constructor del reporte de facturas de clientes
     * @param id identificador puede ser el cliente o la ciudad segun TIPO
     * @param Provincia cadena de texto de la provincia
     * @param Poblacion cadena de texto de la poblacion
     * @param tipo tipo de entrada, true el id es el cliente, false el id es la poblacion
     * @throws JRException puede lanzar esta excepcion en los reportes
     */
    public ReporteConsumoProporcion(int[] idProvincia, String[] Provincia) throws JRException{
        ResultSet resultado=null;
    
        ProvinciaDatasource datasource = new ProvinciaDatasource(); 
        //realizamos las consultas para obtener lo datos

        try {
            for (int i=0;i<idProvincia.length;i++){
                resultado=Principal.cbd.consultaSelect("select sum(suma), t2.CodigoProvincia from "
                + "(select sum(kw) as suma,Cliente from mediciones Where FechaHora BETWEEN "+ new aplicacionjava.Conversion().obtenerYear() 
                + " group by Cliente) as t1 inner join (Select CodigoProvincia, Codigo from clientes Where CodigoProvincia ="
                + idProvincia[i]+") as t2 where t1.Cliente=t2.Codigo group by CodigoProvincia");
                
                resultado.next();
                ProvinciaReporte provincia= new ProvinciaReporte();
                //////
                provincia.setConsumo(resultado.getDouble(1));
                //////
                provincia.setNombre(Provincia[i]);
                provincia.setProvincia(resultado.getInt(2));
                datasource.addProvincia(provincia);
            }
            

            JasperReport reporte = (JasperReport) JRLoader.loadObject("report_proporcion_provincias.jasper");
            

            JRExporter exporter = new JRPdfExporter();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, datasource);


            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            String cadena = "ConsumoProvincias";
            for (int i=0; i<idProvincia.length;i++){
                cadena=cadena+"-"+idProvincia[i];
            }
            cadena=cadena+".pdf";
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(cadena));
            exporter.exportReport();

        } catch (SQLException ex) {
            Logger.getLogger(ReporteConsumoProporcion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 
}
