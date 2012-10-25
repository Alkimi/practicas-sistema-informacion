/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alkimi
 */
public class Practica1 extends HttpServlet {

     ConexionBD conexion = null;
     
     /**
      * Funcion principal que se inica cuando se incia el servidor
      * @param config contiene la configuracion local del servidor
      */
    @Override
     public void init (ServletConfig config){
        try {
            conexion = new  ConexionBD("root","toor","consumoelectrico");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Practica1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Practica1.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     /**
      * Destructor del servidor
      */
    @Override
     public void destroy(){
         conexion.cerrarBaseDatos();
     }
    
 
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cadena =null;
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try{
            if (Boolean.parseBoolean(request.getParameter("PeticionInicio"))){

                cadena = consultaProvincias();
            //llamamos a la bd para obtener las provincias y enviarlas
            }
          } catch(Exception e){
            out.println("Error en cálculo de factorial. "+e.getMessage());
        }  
                
        try {
             out.println(cadena);
         } finally {            
            out.close();
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String consultaProvincias(){
        String cadena="";
        ResultSet consulta;    
        int columnas;
        try {

            consulta=  conexion.consultaSelect("Select * from provincias");


        columnas=consulta.getMetaData().getColumnCount();
        while(consulta.next()){
            for (int i=1;i<=columnas;i++){
                cadena=cadena+consulta.getObject(i).toString();
                if (i==columnas){
                    cadena=cadena+"\n";
                    
                }
                else {
                    cadena=cadena+";";
                }
            }
        }
        } catch (SQLException ex) {
           // Logger.getLogger(Practica1.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return cadena;
    }
}
