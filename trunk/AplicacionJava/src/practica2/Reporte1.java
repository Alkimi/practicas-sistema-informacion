/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
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
 *
 * @author Alkimi
 */
public class Reporte1 {

    /**
     * @param args argumentos recibidos por la linea de comandos
     */
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/consumoelectrico", "root", "toor");
        JasperReport reporte = (JasperReport) JRLoader.loadObject("informe_barras.jasper");

        Map<String, String> parametros = new HashMap<String, String>();
        parametros.put("NombreProvincia", "Coruña");
        parametros.put("provincia", "36");
        parametros.put("fecha1", "2012-01-01 00:00:00");
        parametros.put("fecha1", "2012-12-31 23:59:59");
    
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
        JRExporter exporter = new JRPdfExporter(); // pdf
        //JRExporter exporter = new JRHtmlExporter() // html
        //JRExporter exporter = new JRCsvExporter(); // csv
        //JRExporter exporter = new JRRtfExporter(); // rtf
        //JRExporter exporter = new JRXlsExporter(); // xls
        //JRExporter exporter = new JRXmlExporter(); // xml
        //JRExporter exporter = new JRTextExporter(); // txt
        //JRExporter exporter = new JRXlsxExporter(); // xlxs
        //JRExporter exporter = new JRDocxExporter(); // docx
        //JRExporter exporter = new JRPptxExporter(); // pptx


        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        // cambiar el nombre de salida segun el tipo
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reportePDF.pdf"));
        exporter.exportReport();
    }
}
