/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import gui.InformeClientesPoblacion;
import gui.InformeTartaProvincias;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import practica2.ReporteFactura;

/**
 *
 * @author carranza
 */
public class HiloInformeTartaProvincias extends Thread 
{ 
    public void run() 
   { 
      InformeTartaProvincias.consultas();
   } 
};

