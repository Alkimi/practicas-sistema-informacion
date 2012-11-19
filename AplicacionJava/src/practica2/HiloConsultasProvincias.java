package practica2;

import gui.InformeProvincias;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import practica2.ReporteFactura;

/**
 * Clase auxiliar que genera un hilo de ejecucion para poder mostrar mensaje de
 * espera
 *
 * Hilo que llama al metodo que realiza la consulta encargada
 * de generar un informe que muestra los consumos de las poblaciones
 * de una determinada provincia.
 * Se genera de esta forma para generar la consulta en segun plano y
 * poder mostrar contenidos en los formularios mientras tanto.
 *
 * <br/><br/>Sistemas de Información <br/> Practica 2<br/> Grado Ingeniería
 * Informática T.I. <br/> Curso 2012/13
 *
 * @author Enrique José Miguel Calvo, Saúl Carranza Gallardo
 * @version 2.0
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
