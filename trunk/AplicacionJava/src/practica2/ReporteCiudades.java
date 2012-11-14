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
public class ReporteCiudades {

    /**
     * Constructor del reporte de facturas de clientes
     * @param id identificador puede ser el cliente o la ciudad segun TIPO
     * @param Provincia cadena de texto de la provincia
     * @param Poblacion cadena de texto de la poblacion
     * @param tipo tipo de entrada, true el id es el cliente, false el id es la poblacion
     * @throws JRException puede lanzar esta excepcion en los reportes
     */
    public ReporteCiudades(int idProvincia, String Provincia) throws JRException{
        ResultSet resultado=null;
    
        CiudadesDatasource datasource = new CiudadesDatasource(); 
        //realizamos las consultas para obtener lo datos

        try {
           
            resultado=Principal.cbd.consultaSelect("select sum(t3.total), t6.Poblacion from " +
                "(select t1.total, t1.Cliente  from ( select sum(KW) as total, Cliente from mediciones Where " +
                " FechaHora  between "+new aplicacionjava.Conversion().obtenerYear()+"  group by Cliente ) as t1" +
                " inner join ( Select Codigo from clientes where CodigoProvincia="+idProvincia+") as t2" +
                " where t1.Cliente=t2.Codigo) as t3 inner join" +
                " (select t4.Codigo, t5.CodigoPoblacion, t5.Poblacion from " +
                " (select Codigo, CodigoPoblacion from clientes where CodigoProvincia="+idProvincia+") as t4" +
                " inner join ( select CodigoPoblacion, Poblacion from poblaciones where CodigoProvincia="+
                idProvincia+ ") as t5 where t4.CodigoPoblacion = t5.CodigoPoblacion" +
                " ) as t6 where t3.Cliente=t6.Codigo group by t6.CodigoPoblacion");
                        
            
            /*
             *  Select t1.Codigo, t1.Nombre, t1.apellido, t1.apellido2, t2.Nombre as Calle, t1.numero, t1.piso, t2.CodPostal 
            From (Select * from clientes where CodigoPoblacion = 36013 ) as t1 inner join (select * from callespoblaciones where CodPoblacion= 36013 ) as t2 
            where t1.calle=t2.idCalle 
            *  2 seg.
             */
            
            /*
            * 
            * Select t2.KW, t2.Mes, t2.Cliente  from (Select Codigo  From clientes where CodigoPoblacion = 36013) as t1 inner join ( select KW, Monthname(max(FechaHora) as mes from mediciones group by Clientes) as t2 where t1.Codigo=t2.Cliente 
            * 3 seg
             */
            while (resultado.next()){
                CiudadesReporte ciudad= new CiudadesReporte();
                
                ciudad.setConsumo(resultado.getDouble(1));
                ciudad.setNombre(resultado.getString(2));
                ciudad.setProvincia(Provincia);
                // añadimos el cliente
                datasource.addCliente(ciudad);                


            }
            JasperReport reporte = (JasperReport) JRLoader.loadObject("report_lista_ciudades.jasper");
            

            JRExporter exporter = new JRPdfExporter();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, datasource);


            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("ListaConsumo" + Provincia+ ".pdf"));
            exporter.exportReport();

        } catch (SQLException ex) {
            Logger.getLogger(ReporteCiudades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 
}
