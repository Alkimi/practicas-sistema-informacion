/*
 * Calculo.java
 *
 * Created on 15 de mayo de 2008, 13:30
 */

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author francisco
 * @version
 */
public class Calculo extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int factorial;
        double resultado=1;
        try{
            factorial = Integer.parseInt(request.getParameter("factorial"));
            if (factorial < 0) out.println("No existe el factorial de un número negativo");
            else if (factorial == 0) resultado = 1;
            else{
                resultado=1;
                while ( factorial!=0) {
                    resultado=resultado*factorial;
                    factorial--;
                }
                String title = "Calculo de Factorial de un número";
                out.println(//<title> + title + </title> +
                        "<BODY>\n" +
                        "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                        "<UL>\n" +
                        "   <LI>Factorial: " +
                        request.getParameter("factorial") + "\n" +
                        "   <LI>Resultado: " +
                        resultado +
                        "</UL>\n" +
                        "</BODY></HTML>");
            }
        } catch(Exception e){
            out.println("Error en cálculo de factorial. "+e.getMessage());
        }        
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
