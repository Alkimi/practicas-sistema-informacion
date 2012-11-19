package practica2;

import gui.InformeClientesPoblacion;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import practica2.ReporteFactura;

/**
 * Clase auxiliar que genera un hilo de ejecucion para poder mostrar mensaje de
 * espera
 *
 * Hilo que llama al metodo que realiza la consulta encargada
 * de generar todas las facturas de los clientes de una población.
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
public class HiloConsultasClientesPoblacion extends Thread {

    /**
     * Lanza el nuevo hilo llamando a la consulta
     */
    public void run() {
        InformeClientesPoblacion.consultas();
    }
};
