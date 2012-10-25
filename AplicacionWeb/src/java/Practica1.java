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
        String provincia;
        String ciudad;
        String calle;
        
         try{
            if (Boolean.parseBoolean(request.getParameter("PeticionInicio"))){
                //llamamos a la bd para obtener las provincias y enviarlas
                cadena = consultaProvincias();
            }
            if (request.getParameter("PeticionCiudad")!=null){
                provincia=request.getParameter("PeticionCiudad");
                cadena = consultaCiudades(provincia);
            }    
            if (request.getParameter("PeticionCalle")!=null){
                ciudad=request.getParameter("PeticionCalle");
                cadena= consultaCalles(ciudad);
            }
            
            if (request.getParameter("PeticionCliente")!=null){
                calle=request.getParameter("PeticionCliente");
                cadena=consultaClientes(calle);
            }
            
            if (Boolean.parseBoolean(request.getParameter("InsertaMedicion"))){
                int cliente;
                String fecha;
                float kw;
                cliente=Integer.parseInt(request.getParameter("Cliente"));
                fecha=request.getParameter("Fecha");
                kw=Float.parseFloat(request.getParameter("KW"));
                realizaMedicion(cliente, fecha, kw);
                cadena="Insercion realizada";
            }
            if (cadena!=null){
                out.println(cadena);
            }
         } 
         catch(Exception e){
            out.println("Error en cálculo de factorial. "+e.getMessage());
        }  finally {            
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
        try {
            return convierte( conexion.consultaSelect("Select * from provincias"));
        } catch (SQLException ex) {
            return null;
        }
        
    }
    
    private String consultaCiudades(String provincia){
        try {
            return convierte( conexion.consultaSelect("Select CodigoPoblacion, Poblacion from poblaciones where CodigoProvincia="
                    +provincia));
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private String consultaCalles(String ciudad){
         try {
            return convierte( conexion.consultaSelect("Select idCalle, Nombre from callespoblaciones where CodPoblacion='"
                    +ciudad+"'"));
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private String consultaClientes(String calle){
        try {
            return convierte( conexion.consultaSelect("Select Codigo, Nombre, Apellido, Apellido2, Numero, Piso from clientes "
                    +"where Calle="+calle));
        } catch (SQLException ex) {
            return null;
        }
    }
    
    private void realizaMedicion(int cliente,String fecha, float kw){
        try {
            conexion.consultaUpdate("insert into mediciones (Cliente,FechaHora,KW) values("+cliente+",'"+fecha+"',"+kw+");");
        } catch (SQLException ex) {
            //Logger.getLogger(Practica1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String convierte(ResultSet consulta){
          String cadena="";
    
        int columnas;
        try {
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
