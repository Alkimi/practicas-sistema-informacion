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
public class ReporteConsumos {

    /**
     * Constructor del reporte de facturas de clientes
     * @param id identificador puede ser el cliente o la ciudad segun TIPO
     * @param Provincia cadena de texto de la provincia
     * @param Poblacion cadena de texto de la poblacion
     * @param tipo tipo de entrada, true el id es el cliente, false el id es la poblacion
     * @throws JRException puede lanzar esta excepcion en los reportes
     */
    public ReporteConsumos(int idPoblacion, String Poblacion,int year) throws JRException{
        ResultSet resultado=null;
    
       ConsumoPoblacionDatasource datasource = new ConsumoPoblacionDatasource();
        //realizamos las consultas para obtener lo datos
        try {
           
            resultado=Principal.cbd.consultaSelect("select sum(t1.kw) as suma, t1.mes as mes from "
                    +"(select kw, MONTHNAME(FechaHora) as mes, Cliente, FechaHora from mediciones WHERE "
                    +"FechaHora BETWEEN "+ new aplicacionjava.Conversion().obtenerYearCualquiera(year) +")  as t1 "
                    +"inner join (SELECT Codigo FROM Clientes WHERE CodigoPoblacion="+idPoblacion+") as t2 where "
                    +"t1.Cliente=t2.Codigo  GROUP BY MONTH( t1.FechaHora)");
                        
            

            while (resultado.next()){
                ConsumoPoblacionReporte ciudad= new ConsumoPoblacionReporte();
                
                ciudad.setConsumo(resultado.getDouble(1));
                ciudad.setMes(resultado.getString(2));
                ciudad.setNombre(Poblacion);
                // añadimos el cliente
                datasource.addCliente(ciudad);                


            }
            JasperReport reporte = (JasperReport) JRLoader.loadObject("report_informe_barras.jasper");
            

            JRExporter exporter = new JRPdfExporter();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, datasource);


            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("ConsumoAnual" + Poblacion+year+ ".pdf"));
            exporter.exportReport();

        } catch (SQLException ex) {
            Logger.getLogger(ReporteConsumos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 
}
