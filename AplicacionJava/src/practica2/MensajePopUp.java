package practica2;

import javax.swing.JOptionPane;


public class MensajePopUp  extends Thread {
    private String mensaje;
    
    public MensajePopUp(String mensaje){
        this.mensaje=mensaje;
    }

    @Override
    public void run () {
        JOptionPane.showMessageDialog (null, mensaje);
        try {
            this.sleep(500);
        } catch (InterruptedException ex) {
        }


    }

} 