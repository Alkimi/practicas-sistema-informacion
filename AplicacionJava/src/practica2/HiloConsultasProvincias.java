package practica2;

import gui.InformeProvincias;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import practica2.ReporteFactura;

/**
 * Clase auxiliar que genera un hilo de ejecucion para poder mostrar mensaje de
 * espera
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 1.0
 *
 */
public class HiloConsultasProvincias extends Thread {

    /**
     * Lanza el nuevo hilo llamando a la consulta
     */
    public void run() {
        InformeProvincias.consultas();
    }
};
