/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import gui.InformeProvincias;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import practica2.ReporteFactura;

/**
 *
 * @author carranza
 */
public class HiloConsultasProvincias extends Thread 
{ 
    public void run() 
   { 
      InformeProvincias.consultas();
   } 
};

